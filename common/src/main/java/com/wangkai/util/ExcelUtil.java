package com.wangkai.util;

import com.wangkai.bean.DueResult;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Excel读写工具类(xlsx:一个sheet最大存储10W多行)
 * Created by admin on 16/7/11.
 */
public class ExcelUtil {

    public static void write(List<DueResult> list,String pathName){
        //
        try {
            FileOutputStream os = new FileOutputStream("/Users/admin/Desktop/his-overdue-last2.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook();
            final XSSFSheet wsheet = workbook.createSheet();
            //
            for(int i = 0;i<list.size();i++){
                //
                DueResult result = list.get(i);
                //
                Row rowTmp = wsheet.createRow(i);
                rowTmp.createCell(0).setCellValue(result.getCustId());
                rowTmp.createCell(1).setCellValue(result.getUserName());
                rowTmp.createCell(2).setCellValue(result.getOrderId());
                rowTmp.createCell(3).setCellValue(result.getAmount().toString());
                rowTmp.createCell(4).setCellValue(result.getStage());
                rowTmp.createCell(5).setCellValue(result.getOverDueStages());
                rowTmp.createCell(6).setCellValue(result.getOverdueCount());
                rowTmp.createCell(7).setCellValue(result.getOverDueAmount());
                rowTmp.createCell(8).setCellValue(result.getMaxOverdue());
                rowTmp.createCell(9).setCellValue(result.getAddressProvince());
                rowTmp.createCell(10).setCellValue(result.getAddressCity());
                rowTmp.createCell(11).setCellValue(result.getApplyAddressProvince());
                rowTmp.createCell(12).setCellValue(result.getApplyAddressCity());
                rowTmp.createCell(13).setCellValue(result.getPhoneAddressProvince());
                rowTmp.createCell(14).setCellValue(result.getPhoneAddressCity());
                //
            }
            //
            workbook.write(os);
        } catch (IOException e) {
            //
        }
    }
}
