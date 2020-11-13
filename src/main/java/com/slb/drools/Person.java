package com.slb.drools;

import java.io.Serializable;

/**
 * @Description:
 * @Date: 2020/9/15 10:41
 * @Author: Carson
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 4355400756403689678L;

    private Integer id;

    private String name;

    private String age;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

}
