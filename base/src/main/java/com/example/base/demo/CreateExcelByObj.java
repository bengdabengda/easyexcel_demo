/*
 * Copyright (C), 2015-2019, 壹永科技有限公司
 * FileName: CreateExcelByObj
 * Author:   sun
 * Date:     2019/6/14 16:37
 * History:
 * <author>          <time>                <version>
 *   sun         2019/6/14 16:37           v1.0.0
 */
package com.example.base.demo;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.example.base.demo.vo.Model;
import com.example.base.demo.vo.User;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 通过对象生成excel
 *
 * @author sun
 * @create 2019/6/14
 * @since v1.0.0
 */
public class CreateExcelByObj {

    /**
     * 使用对象创建excel
     */
    public static void createExcel(List<User> data){
        OutputStream out = null;
        try {
            out = new FileOutputStream("C:\\Users\\18513\\Desktop\\excel\\easyexcel3.xlsx");
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            //使用对象生成sheet，需要是定sheet的对象类型
            Sheet sheet = new Sheet(1, 0, User.class);
            sheet.setSheetName("sheet-user测试");


            //使用对象生成excel,使用write方法
            writer.write(data, sheet);
            writer.finish();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(out != null){
                try {
                    out.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void createMultipleRowsExcel(List<Model> data){
        OutputStream out = null;
        try {
            out = new FileOutputStream("C:\\Users\\18513\\Desktop\\excel\\easyexcel4.xlsx");
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            //使用对象生成sheet，需要指定sheet的对象类型 -- 或者使用table对象指定
            Sheet sheet = new Sheet(1, 0, Model.class);
            sheet.setSheetName("sheet-user测试");


            //使用对象生成excel,使用write方法
            writer.write(data, sheet);
            writer.finish();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(out != null){
                try {
                    out.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 一个sheet对应多个表格
     */
    public static void createExcelWithOneSheetMultipleTable(List<User> users, List<Model> models){
        OutputStream out = null;
        try {
            out = new FileOutputStream("C:\\Users\\18513\\Desktop\\excel\\easyexcel5.xlsx");
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            Sheet sheet1 = new Sheet(1, 0);
            sheet1.setSheetName("sheet1");

            // 数据全是List<String> 无模型映射关系
            Table table1 = new Table(1);
            List<List<String>> data1 = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                List<String> item = new ArrayList<>();
                item.add("编号" + (i + 1));
                item.add("姓名" + (i + 1));
                item.add("性别" + (i + 1));
                data1.add(item);
            }
            writer.write0(data1, sheet1, table1);

            // 模型上有表头的注解
            Table table2 = new Table(2);
            table2.setClazz(Model.class);
            writer.write(models, sheet1, table2);

            // 模型上没有注解，表头数据动态传入,此情况下模型field顺序与excel现实顺序一致

            //设置表头
            List<List<String>> head = new ArrayList<>();
            List<String> head1 = new ArrayList<>();
            head1.add("id");
            head1.add("id2");
            head1.add("id3");
            head.add(head1);
            List<String> head2 = new ArrayList<>();
            head2.add("姓名");
            head.add(head2);
            List<String> head3 = new ArrayList<>();
            head3.add("性别1");
            head3.add("性别2");
            head.add(head3);

            Table table3 = new Table(3);
            table3.setHead(head);
            writer.write0(data1, sheet1, table3);

            writer.finish();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        User user = new User();
        for(int i = 0 ;i <100; i++){
            user = new User(i, 10000 + i, "name" + i, i % 2 == 0 ? 2 : 1, i * 0.5, i * 0.5, "email" + i, "phone" + i);
            list.add(user);
        }
        createExcel(list);

        List<Model> mList = new ArrayList<>();
        Model model = new Model();
        for(int i = 0 ;i <100; i++){
            model = new Model("日期" + i, "天气" + i, "温度1" + i, "湿度1" + i, "温度2" + i, "湿度2" + i, "备注" + i,"记录人" + i);
            mList.add(model);
        }
        createMultipleRowsExcel(mList);

        createExcelWithOneSheetMultipleTable(list,mList);
    }
}