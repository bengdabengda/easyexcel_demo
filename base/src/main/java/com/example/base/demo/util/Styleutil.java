/*
 * Copyright (C), 2015-2019, 壹永科技有限公司
 * FileName: Styleutil
 * Author:   sun
 * Date:     2019/6/14 17:56
 * History:
 * <author>          <time>                <version>
 *   sun         2019/6/14 17:56           v1.0.0
 */
package com.example.base.demo.util;

import com.alibaba.excel.metadata.Font;
import com.alibaba.excel.metadata.TableStyle;
import org.apache.poi.ss.usermodel.IndexedColors;

/**
 * 一句话功能简述
 *
 * @author sun
 * @create 2019/6/14
 * @since v1.0.0
 */
public class Styleutil {
    public static TableStyle createTableStyle() {
        TableStyle tableStyle = new TableStyle();
        // 设置表头样式
        Font headFont = new Font();
        // 字体是否加粗
        headFont.setBold(true);
        // 字体大小
        headFont.setFontHeightInPoints((short)12);
        // 字体
        headFont.setFontName("楷体");
        tableStyle.setTableHeadFont(headFont);
        // 背景色
        tableStyle.setTableHeadBackGroundColor(IndexedColors.BLUE);


        // 设置表格主体样式
        Font contentFont = new Font();
        contentFont.setBold(true);
        contentFont.setFontHeightInPoints((short)12);
        contentFont.setFontName("黑体");
        tableStyle.setTableContentFont(contentFont);
        tableStyle.setTableContentBackGroundColor(IndexedColors.GREEN);
        return tableStyle;
    }
}