package com.slb.droolsdemo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/**
 * 规则引擎 被保人Fact
 *
 * @author SLB0547
 * @date 2020/12/4 16:21
 */
@Data
@ApiModel(value="被保人Fact", description="被保人")
public class InsuredFact {


    @ApiModelProperty(value = "被保人姓名")
    private String name;

    @ApiModelProperty(value = "被保人英文名")
    private String nameEn;

    @ApiModelProperty(value = "证件类型，1为身份证，10为户口本")
    private String cardType;

    @ApiModelProperty(value = "被保人证件号")
    private String cardNo;

    @ApiModelProperty(value = "证件有效期起期")
    private LocalDate cardExpStartdate;

    @ApiModelProperty(value = "证件有效期止期")
    private LocalDate cardExpEnddate;

    @ApiModelProperty(value = "出生日期")
    private LocalDate birthday;

    @ApiModelProperty(value = "性别，1男 2女 0不详")
    private String sex;

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

    @ApiModelProperty(value = "职业类别")
    private String occGrade;

    @ApiModelProperty(value = "个人年收入")
    private String personIncome;

    @ApiModelProperty(value = "身高", required = true)
    private String height;

    @ApiModelProperty(value = "体重", required = true)
    private String weight;

    @ApiModelProperty(value = "婚姻状况")
    private String marriage;

    @ApiModelProperty(value = "年龄", hidden = true)
    private long age;

    @ApiModelProperty(value = "领取证件年龄", hidden = true)
    private long certAge;
}
