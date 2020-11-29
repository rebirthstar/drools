package com.slb.test;

import lombok.Data;

/**
 * @author LT
 * @version 1.0
 * @description com.slb.test
 * @date 2020/11/29
 */
@Data
public class TbRule {

    private Integer id;

    private String productCode;

    private String calContent;

    private String ruleType;

    private String msg;

    private String channel;
}
