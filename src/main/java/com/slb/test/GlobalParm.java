package com.slb.test;

import com.slb.version.domain.RuleExecutorResult;
import lombok.Data;

import java.util.List;

/**
 * @author LT
 * @version 1.0
 * @description com.slb.test
 * @date 2020/11/29
 */
@Data
public class GlobalParm {

    // 匹配总数
    private int count;

    //
    private List<String> msgList;
}
