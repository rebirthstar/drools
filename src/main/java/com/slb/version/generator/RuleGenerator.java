package com.slb.version.generator;

import com.slb.version.domain.ActivityRule;
import com.slb.version.domain.RuleDTO;
import com.slb.version.executor.RuleExecutor;
import com.slb.version.manager.FactManager;
import com.slb.version.util.DateUtil;
import org.drools.template.ObjectDataCompiler;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @AUTHOR lgp
 * @DATE 2018/9/3 15:58
 * @DESCRIPTION 规则生成器
 **/
public class RuleGenerator {
    private static final Logger log = LoggerFactory.getLogger(RuleGenerator.class);

    /**
     * 根据传递进来的参数对象生规则
     *
     * @param ruleDTOs
     */
    public void generateRules(List<RuleDTO> ruleDTOs) {
        List<String> ruleDrls = new ArrayList<>();
        for (int i = 0; i < ruleDTOs.size(); i++) {
            //规则的生成
            String drlString = applyRuleTemplate(ruleDTOs.get(i));
            ruleDrls.add(drlString);
            log.info("规则引擎加载规则,id={}", ruleDTOs.get(i).getRule().getId());
        }
        //规则的加载
        createOrRefreshDrlInMemory(ruleDrls);
    }

    /**
     * 根据Rule生成drl的String
     */
    private String applyRuleTemplate(RuleDTO ruleDTO) {
        Map<String, Object> data = prepareData(ruleDTO);
//        log.info("rule={}", JSON.toJSON(ruleDTO));
        ObjectDataCompiler objectDataCompiler = new ObjectDataCompiler();
//        模板文件生成drl String
        return objectDataCompiler.compile(Arrays.asList(data), Thread.currentThread().getContextClassLoader().getResourceAsStream("rules/give-reward-rule-template.drt"));
    }

    /**
     * 根据Rule生成drl的map data
     */
    protected Map<String, Object> prepareData(RuleDTO ruleDTO) {
        Map<String, Object> data = new HashMap<>();
        ActivityRule rule = ruleDTO.getRule();
        data.put("ruleCode", ruleDTO.hashCode());
        data.put("beginTime", DateUtil.dateToStringFormat(ruleDTO.getBeginTime(), "dd-MMM-yyyy"));
        data.put("endTime", DateUtil.dateToStringFormat(ruleDTO.getEndTime(), "dd-MMM-yyyy"));
        data.put("eventType", FactManager.getFactClassByEvent(rule.getEvent()).getName());
        data.put("rule", rule.getRuleValue());
        data.put("awardeeType", rule.getAwardeeType());
//        data.put("ruleId", rule.getId());
//        data.put("joinChannels", ruleDTO.getJoinChannel());
//        data.put("priority", rule.getPriority());
//        log.info("data={}", JSON.toJSON(data));
        return data;
    }

    /**
     * 根据String格式的Drl生成Maven结构的规则
     *
     * @param rules
     */
    private void createOrRefreshDrlInMemory(List<String> rules) {
        KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.generateAndWritePomXML(RuleExecutor.getReleaseId());
        for (String str : rules) {
            kieFileSystem.write("src/main/resources/rules/" + UUID.randomUUID() + ".drl", str);
            log.info("str={}", str);
        }
        KieBuilder kb = kieServices.newKieBuilder(kieFileSystem).buildAll();
        if (kb.getResults().hasMessages(Message.Level.ERROR)) {
            log.error("create rule in kieFileSystem Error", kb.getResults());
            throw new IllegalArgumentException("生成规则文件失败");
        }
        doAfterGenerate(kieServices);
    }

    /**
     * 生成完毕后的清理工作，目前主要用于debug模式测试完毕后，从内存中清理掉规则文件。
     */
    protected void doAfterGenerate(KieServices kieServices) {

    }

}
