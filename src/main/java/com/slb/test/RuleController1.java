package com.slb.test;

import com.slb.version.domain.fact.BaseFact;
import com.slb.version.service.RuleService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public Map<String, Object> useRule(@RequestBody BaseFactEntity baseFactEntity) {
        GlobalParm globalParm = ruleService.useRule(baseFactEntity);
        Map<String, Object> ruleMap = new HashMap<>();
        ruleMap.put("code", "0000");
        ruleMap.put("msg", "成功");
        ruleMap.put("data", globalParm);
        return ruleMap;
    }

    @PostMapping("/loadRule")
    public String loadRule(Map<String, Object> map) {
        ruleService.loadRule();
        return "success";

    }
}
