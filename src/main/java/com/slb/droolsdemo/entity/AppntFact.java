package com.slb.droolsdemo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/**
 *  规则引擎 投保人 Fact
 *
 * @author SLB0547
 * @date 2020/12/3 16:52
 */
@Data
@ApiModel(value="投保人Fact", description="投保人")
public class AppntFact {

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "英文名")
    private String nameEn;

    @ApiModelProperty(value = "证件类型")
    private String cardType;

    @ApiModelProperty(value = "证件号")
    private String cardNo;

    @ApiModelProperty(value = "证件有效期起期")
    private LocalDate cardExpStartdate;

    @ApiModelProperty(value = "证件有效期止期")
    private LocalDate cardExpEnddate;

    @ApiModelProperty(value = "出生日期")
    private LocalDate birthday;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "电子邮箱")
    private String email;

    @ApiModelProperty(value = "省市区")
    private List<String> addressCode;

    @ApiModelProperty(value = "详细地址")
    private String detailAddress;

    @ApiModelProperty(value = "邮政编码")
    private String postCode;

    @ApiModelProperty(value = "职业代码")
    private String occCode;

    @ApiModelProperty(value = "年收入")
    private String personIncome;

    @ApiModelProperty(value = "身高")
    private String height;

    @ApiModelProperty(value = "体重")
    private String weight;

    @ApiModelProperty(value = "婚姻状况")
    private String marriage;

    @ApiModelProperty(value = "持卡人姓名")
    private String accName;

    @ApiModelProperty(value = "预留手机号")
    private String accMobile;

    @ApiModelProperty(value = "开户地区")
    private String bankAreaCode;

    @ApiModelProperty(value = "银行账号")
    private String accBankCardNo;

    @ApiModelProperty(value = "开户行")
    private String bank;

    @ApiModelProperty(value = "开户支行")
    private String bankBranch;

    @ApiModelProperty(value = "年龄", hidden = true)
    private long age;

    @ApiModelProperty(value = "领取证件年龄", hidden = true)
    private long certAge;












}
