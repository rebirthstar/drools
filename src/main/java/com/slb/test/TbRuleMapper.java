package com.slb.test;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LT
 * @version 1.0
 * @description com.slb.test
 * @date 2020/11/29
 */
@Mapper
public interface TbRuleMapper {

    TbRule selectByProCodeAndChannel(String productCode, String channel);

    List<TbRule> selectAll();
}
