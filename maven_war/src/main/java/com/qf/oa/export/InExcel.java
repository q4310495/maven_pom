package com.qf.oa.export;

import com.qf.oa.entity.EmployeeDomain;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InExcel {

    public List<EmployeeDomain> loadScoreInfo() throws IOException, InvalidFormatException {
        File file = new File("D:/book.xlsx");
        List<EmployeeDomain> employees= new ArrayList<>();
        //创建Excel，读取文件内容
        try {
            XSSFWorkbook workbook =
                    new XSSFWorkbook(FileUtils.openInputStream(file));
            //创建Excel,读取文件内容
//      Workbook workbook=new Workbook(new FileInputStream(new File("e:/测试文件.xls")));
            //获取第一个工作表workbook.getSheet("ygc开发表");
//      Sheet sheet=workbook.getSheet("ygc开发表");
            //第二种获取方式通过index 获取第一个表
            Sheet sheet = workbook.getSheetAt(0);
            int firstRowNum=1;
            //获取表中最后一行
            int lastRowNum = sheet.getLastRowNum();
            System.out.println(lastRowNum);
            for(int i=firstRowNum;i<=lastRowNum;i++){
                Row row = sheet.getRow(i);
                //获取当前最后单元格列号
                EmployeeDomain employee=new EmployeeDomain();
                employee.setEmail(row.getCell(1).getStringCellValue());
                System.out.println(row.getCell(1).getStringCellValue());
                employee.setPassword(row.getCell(2).getStringCellValue());
                employee.setName(row.getCell(3).getStringCellValue());
                employee.setBirthday(row.getCell(4).getDateCellValue());
                employees.add(employee);
                /*int lastCellNum = row.getLastCellNum();
                for(int j=0;j<lastCellNum;j++){

                    Cell cell = row.getCell(j);
                    String value = cell.getStringCellValue();
                    System.out.print(value + "  ");//注意value后面的空格
                }
                System.out.println();*/
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }
}