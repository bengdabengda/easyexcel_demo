/*
 * Copyright (C), 2015-2019, 壹永科技有限公司
 * FileName: User
 * Author:   sun
 * Date:     2019/6/14 16:39
 * History:
 * <author>          <time>                <version>
 *   sun         2019/6/14 16:39           v1.0.0
 */
package com.example.base.demo.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * 通过对象生成excel
 * 需要继承BaseRowModel
 * 需要使用ExcelProperty注解属性
 * 对于每个字段对应一列的excel,ExcelProperty注解的value不能重复，否则从第一个value为X到最后一个value为X的列表头会合并为一个X
 * 对于表头注解格式为A B C A B的对象,会出错
 * @author sun
 * @create 2019/6/14
 * @since v1.0.0
 */
public class User extends BaseRowModel{

    @ExcelProperty(value = "编号" ,index = 0)
    private Integer id;
    @ExcelProperty(value = "编码" ,index = 2)
    private Integer code;
    @ExcelProperty(value = "姓名" ,index = 2)
    private String name;
    @ExcelProperty(value = "性别（1：男 2：女）" ,index = 3)
    private Integer sex;
    @ExcelProperty(value = "身高" ,index = 4)
    private Double high;
    @ExcelProperty(value = "体重" ,index = 5)
    private Double weight;
    @ExcelProperty(value = "邮箱" ,index = 6)
    private String email;
    @ExcelProperty(value = "联系电话" ,index = 7)
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User() {
    }

    public User(Integer id, Integer code, String name, Integer sex, Double high, Double weight, String email, String phone) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.sex = sex;
        this.high = high;
        this.weight = weight;
        this.email = email;
        this.phone = phone;
    }
}