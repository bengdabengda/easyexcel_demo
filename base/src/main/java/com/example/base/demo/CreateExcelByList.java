/*
 * Copyright (C), 2015-2019, 壹永科技有限公司
 * FileName: CreateExcelByList
 * Author:   sun
 * Date:     2019/6/14 15:59
 * History:
 * <author>          <time>                <version>
 *   sun         2019/6/14 15:59           v1.0.0
 */
package com.example.base.demo;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.support.ExcelTypeEnum;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 通过list生成excel
 *
 * @author sun
 * @create 2019/6/14
 * @since v1.0.0
 */
public class CreateExcelByList {

    /**
     * 最简单的创建excel
     * 没有表头
     */
    public static void createExcelNoHead(){
        OutputStream out = null;
        try {
            out = new FileOutputStream("C:\\Users\\18513\\Desktop\\excel\\easyexcel.xlsx");
            //使用ExcelWriter类处理excel
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            Sheet sheet = new Sheet(1, 0);
            sheet.setSheetName("sheet测试");
            //外层每个list是一列，内层每一个list是一行
            List<List<String>> data = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                List<String> item = new ArrayList<>();
                item.add("编号" + (i + 1));
                item.add("姓名" + (i + 1));
                item.add("性别" + (i + 1));
                data.add(item);
            }
            //使用对象生成excel,使用write0方法
            writer.write0(data, sheet);
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
     * 最简单的创建excel
     * 添加表头
     */
    public static void createExcelWithHead(){
        OutputStream out = null;
        try {
            out = new FileOutputStream("C:\\Users\\18513\\Desktop\\excel\\easyexcel2.xlsx");
            //使用ExcelWriter类处理excel

            //构造函数
            // 最后参数needHead是否需要表头，false表示不需要
            // 可以不传该参数，默认为true,需要表头，但是不设置表头一样没有表头
//            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, false);
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            Sheet sheet = new Sheet(1, 0);
            sheet.setSheetName("sheet测试");
            //外层每个list是一列，内层每一个list是一行
            List<List<String>> data = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                List<String> item = new ArrayList<>();
                item.add("编号" + (i + 1));
                item.add("姓名" + (i + 1));
                item.add("性别" + (i + 1));
                data.add(item);
            }

            //设置表头
            List<List<String>> head = new ArrayList<>();
            //第一列的表头有多个，分别占一行
            List<String> head1 = new ArrayList<>();
            head1.add("id");
            head1.add("id2");
            head1.add("id3");
            head.add(head1);
            //第二列的表头只占一行
            List<String> head2 = new ArrayList<>();
            head2.add("姓名");
            head.add(head2);
            //第三列表头有2个，分别占一行
            List<String> head3 = new ArrayList<>();
            head3.add("性别1");
            head3.add("性别2");
            head.add(head3);

            //
            Table table = new Table(1);
            table.setHead(head);

            //使用对象生成excel,使用write0方法
            writer.write0(data, sheet, table);
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


    public static void main(String[] args) {
        createExcelNoHead();
        createExcelWithHead();
    }
}