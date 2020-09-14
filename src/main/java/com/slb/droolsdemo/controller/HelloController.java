package com.slb.droolsdemo.controller;

import com.slb.droolsdemo.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Date: 2020/9/14 16:55
 * @Author: Carson
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private RuleService ruleService;
    @RequestMapping("/rule")
    public String rule(){
        ruleService.rule();
        return "OK";
    }
}
