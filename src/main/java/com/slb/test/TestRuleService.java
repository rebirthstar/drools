package com.slb.test;

import com.alibaba.fastjson.JSON;
import com.slb.version.domain.RegisterMqDTO;
import com.slb.version.domain.RuleExecuteGlobal;
import com.slb.version.domain.RuleExecutorResult;
import com.slb.version.domain.fact.BaseFact;
import lombok.extern.slf4j.Slf4j;
import org.drools.template.ObjectDataCompiler;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.builder.model.KieBaseModel;
import org.kie.api.builder.model.KieModuleModel;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static com.slb.version.executor.RuleExecutor.getKieBase;

/**
 * @author LT
 * @version 1.0
 * @description com.slb.test
 * @date 2020/11/29
 */
@Service
@Slf4j
public class TestRuleService {

    private final ConcurrentMap<String, KieContainer> kieContainerMap = new ConcurrentHashMap<>();


    @Autowired
    private TbRuleMapper ruleMapper;

    /**
     * 触发规则
     */
    public GlobalParm useRule(BaseFactEntity baseFactEntity) {
        KieContainer kieContainer = kieContainerMap.get("kcontainer_"+baseFactEntity.getProductCode() + baseFactEntity.getChannel());
        KieSession kieSession = kieContainer.getKieBase().newKieSession();
        GlobalParm globalParm = new GlobalParm();
        globalParm.setMsgList(new ArrayList<>());
        globalParm.setCount(0);
        kieSession.getGlobals().set("globalParams", globalParm);
        kieSession.insert(baseFactEntity);
        kieSession.fireAllRules();
        kieSession.dispose();
        return globalParm;

    }

    /**
     * 加载规则
     */
    public void loadRule() {

        List<TbRule> tbRules = getActivityRuleList();
        log.info("{}条加入规则引擎", tbRules.size());
        List<String> ruleDrls = new ArrayList<>();
        KieServices kieServices = KieServices.get();
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        KieModuleModel kieModuleModel = kieServices.newKieModuleModel();
        KieBaseModel kieBaseModel = kieModuleModel.newKieBaseModel("kieBase" + "productCode" + "channel");
        kieBaseModel.setDefault(true);
        kieBaseModel.addPackage(MessageFormat.format("rules.scene_{0}", "productCode" + "channel"));
        kieBaseModel.newKieSessionModel("kieSession" + "productCode" + "channel");
        if (!tbRules.isEmpty()) {
            for (TbRule tbRule : tbRules) {
                String calContent = tbRule.getCalContent();
                log.info(tbRule.getCalContent());
                String fullPath = MessageFormat.format("src/main/resources/rules/scene_{0}/rule_{1}.drl", "productCode" + "channel", tbRule.getId());
                kieFileSystem.write(fullPath, calContent);
            }
            kieFileSystem.writeKModuleXML(kieModuleModel.toXML());
            KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem).buildAll();
            Results results = kieBuilder.getResults();
            if (results.hasMessages(Message.Level.ERROR)) {
                System.out.println(results.getMessages());
                throw new IllegalStateException("rule error");
            }
            KieContainer kieContainer = kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId());
            kieContainerMap.put("kcontainer_" + "productCode" + "channel", kieContainer);

        }
    }

    /**
     * 从数据库里面取规则
     */
    public List<TbRule> getActivityRuleList() {
        List<TbRule> tbRules = ruleMapper.selectAll();
        return tbRules;
//        List<ActivityRule> list = testService.selectAll();
//        List<RuleDTO> ruleDTOList = new ArrayList<>();
//        for (ActivityRule dto : list) {
//            RuleDTO ruleDTO = new RuleDTO();
//            ruleDTO.setBeginTime(begin);
//            ruleDTO.setEndTime(end);
//            ruleDTO.setRule(dto);
//            ruleDTOList.add(ruleDTO);
//        }
//        return ruleDTOList;
    }
}

