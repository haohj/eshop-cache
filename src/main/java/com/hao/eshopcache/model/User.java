package com.hao.eshopcache.model;

import java.io.Serializable;

/**
 * 测试用户Model类
 */
public class User implements Serializable {

    private Integer id;
    /**
     * 测试用户姓名
     */
    private String name;
    /**
     * 测试用户年龄
     */
    private Integer age;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
