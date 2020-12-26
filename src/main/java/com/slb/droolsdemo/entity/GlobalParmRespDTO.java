package com.slb.droolsdemo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 规则响应实体
 *
 * @author SLB0547
 * @date 2020/12/2 11:57
 */
@Data
@ApiModel(value = "规则响应实体", description = "规则响应实体")
public class GlobalParmRespDTO {

    @ApiModelProperty(value = "规则命中结果集")
    private List<RuleInfoDTO> ruleList;
}
