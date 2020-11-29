package com.slb.test;

import com.slb.version.annotation.Fact;
import lombok.Data;

import java.io.PipedReader;

/**
 * @author LT
 * @version 1.0
 * @description com.slb.test
 * @date 2020/11/29
 */
@Data
public class BaseFactEntity {

    /**
     * 产品代码
     */
    private String productCode;
    /**
     *  渠道
     */
    private String Channel;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 缴费方式
     */
    private String payType;
    /**
     *  保险期间
     */
    private String insuYear;

    /**
     *  保险金额
     */
    private String insuMoney;
    /**
     *  投保人英文名
     */
    private String appliantEnglistName;




}
