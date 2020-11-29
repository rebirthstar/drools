package com.slb.drools;


import com.slb.drools.KieSessionHelper;
import com.slb.drools.RuleLoader;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 规则测试
 *
 * @author loujinhe
 * @date 2019/4/14 01:35
 */
@RequestMapping("rule")
@RestController
public class RuleController2 {

    @Autowired
    private RuleLoader ruleLoader;

    @Autowired
    private KieSessionHelper kieSessionHelper;

    @GetMapping("/")
    public String index() {
        System.out.println("index");
        return "success";
    }

    /**
     * 重新加载所有规则
     */
    @GetMapping("reload")
    public String reload() {
        System.out.println("reload all");
        ruleLoader.reloadAll();
        return "success";
    }

    /**
     * 重新加载给定场景下的规则
     *
     * @param sceneId 场景ID
     */
    @GetMapping("reload/{sceneId}")
    public String reload(@PathVariable("sceneId") Long sceneId) {
        System.out.println("reload scene:" + sceneId);
        ruleLoader.reload(sceneId);
        return "success";
    }

    /**
     * 触发给定场景规则
     *
     * @param sceneId 场景ID
     */
    @GetMapping("fire/{sceneId}")
    public String fire(@PathVariable("sceneId") Long sceneId) {
        System.out.println("fire scene:" + sceneId);
        KieSession kieSession = kieSessionHelper.getKieSessionBySceneId(sceneId);
        kieSession.fireAllRules();
        kieSession.dispose();
        return "success";
    }

}