package com.slb.version.service;

import com.slb.version.domain.ActivityRule;
import com.slb.version.mapper.ActivityRuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @AUTHOR lgp
 * @DATE 2018/9/3 15:31
 * @DESCRIPTION
 **/
@Service
public class TestService {

    @Autowired
    ActivityRuleMapper activityRuleMapper;

    public List<ActivityRule> selectAll() {
        return activityRuleMapper.selectAll();
    }

    public ActivityRule select1() {
        return activityRuleMapper.selectByPrimaryKey(1);
    }

}
