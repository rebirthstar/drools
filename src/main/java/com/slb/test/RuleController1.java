package com.slb.test;

import com.slb.version.domain.fact.BaseFact;
import com.slb.version.service.RuleService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author LT
 * @version 1.0
 * @description com.slb.test
 * @date 2020/11/29
 */
@RestController
@RequestMapping("/rule")
public class RuleController1 {

    @Autowired
    TestRuleService ruleService;

    @RequestMapping("/useRule")
    public List<String> useRule(@RequestBody  BaseFactEntity baseFactEntity) {
        List<String> strings = ruleService.useRule(baseFactEntity);
        return strings;
    }

    @PostMapping("/loadRule")
    public String loadRule(Map<String, Object> map) {
        ruleService.loadRule();
        return "success";

    }
}
