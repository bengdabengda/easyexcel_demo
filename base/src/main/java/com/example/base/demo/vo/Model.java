/*
 * Copyright (C), 2015-2019, 壹永科技有限公司
 * FileName: Model
 * Author:   sun
 * Date:     2019/6/14 16:37
 * History:
 * <author>          <time>                <version>
 *   sun         2019/6/14 16:37           v1.0.0
 */
package com.example.base.demo.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * 通过对象生成excel
 * 需要继承BaseRowModel
 * 需要使用ExcelProperty注解属性
 * value中的第X个表示第X行
 * 表头格式为 A,X
 *            A,Z
 *            B,X
 *      的注解会出错,A和B对应的下一级列名不能重复
 *
 * @author sun
 * @create 2019/6/14
 * @since v1.0.0
 */
public class Model extends BaseRowModel {

    @ExcelProperty(value = {"日期","日期"},index = 0)
    private String c1;
    @ExcelProperty(value = {"天气","天气"},index = 1)
    private String c2;
    @ExcelProperty(value = {"自然","温度1℃"},index = 2)
    private String c3;
    @ExcelProperty(value = {"自然","湿度1%"},index = 3)
    private String c4;
    @ExcelProperty(value = {"调整","温度2℃"},index = 4)
    private String c5;
    @ExcelProperty(value = {"调整","湿度2%"},index = 5)
    private String c6;
    @ExcelProperty(value = {"备注","备注"},index = 6)
    private String c7;
    @ExcelProperty(value = {"记录人","记录人"},index = 7)
    private String c8;


    public String getC1() {
        return c1;
    }

    public void setC1(String c1) {
        this.c1 = c1;
    }

    public String getC2() {
        return c2;
    }

    public void setC2(String c2) {
        this.c2 = c2;
    }

    public String getC3() {
        return c3;
    }

    public void setC3(String c3) {
        this.c3 = c3;
    }

    public String getC4() {
        return c4;
    }

    public void setC4(String c4) {
        this.c4 = c4;
    }

    public String getC5() {
        return c5;
    }

    public void setC5(String c5) {
        this.c5 = c5;
    }

    public String getC6() {
        return c6;
    }

    public void setC6(String c6) {
        this.c6 = c6;
    }

    public String getC7() {
        return c7;
    }

    public void setC7(String c7) {
        this.c7 = c7;
    }

    public String getC8() {
        return c8;
    }

    public void setC8(String c8) {
        this.c8 = c8;
    }

    public Model() {
    }

    public Model(String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8) {
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.c4 = c4;
        this.c5 = c5;
        this.c6 = c6;
        this.c7 = c7;
        this.c8 = c8;
    }
}