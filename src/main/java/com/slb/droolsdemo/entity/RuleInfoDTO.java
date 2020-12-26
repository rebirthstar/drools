package com.slb.droolsdemo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 规则信息
 *
 * @author SLB0547
 * @date 2020/12/2 20:49
 */
@Data
@ApiModel(value = "命中的规则实体", description = "命中的规则实体")
public class RuleInfoDTO {

    @ApiModelProperty("规则代码")
    private String ruleCode;

    @ApiModelProperty("规则提示信息")
    private String msg;
}
