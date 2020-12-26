package com.slb.droolsdemo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * 受益人
 *
 * @author SLB0547
 * @date 2020/12/12 16:05
 */
@Data
@ApiModel(value="受益人", description="受益人")
public class Benefi {

    @ApiModelProperty(value = "是被保人的", required = true)
    private String relaInsured;

    @ApiModelProperty(value = "受益人姓名", required = true)
    private String name;

    @ApiModelProperty(value = "受益人英文名", required = true)
    private String nameEn;

    @ApiModelProperty(value = "证件类型", required = true)
    private String idType;

    @ApiModelProperty(value = "证件号码", required = true)
    private String idNo;

    @ApiModelProperty(value = "证件有效期起期", required = true)
    private LocalDate idExpStartdate;

    @ApiModelProperty(value = "证件有效期止期", required = true)
    private LocalDate idExpEnddate;

    @ApiModelProperty(value = "出生日期")
    private LocalDate birthday;

    @ApiModelProperty(value = "受益人顺位")
    private int bnfGrade;

    @ApiModelProperty(value = "受益比例")
    private String bnfLot;

    @ApiModelProperty(value = "领取证件年龄", hidden = true)
    private long certAge;

    @ApiModelProperty(value = "年龄", hidden = true)
    private long age;
}
