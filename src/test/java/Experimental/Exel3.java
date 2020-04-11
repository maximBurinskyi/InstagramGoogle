package Experimental;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.*;

public class Exel3 {

    @Test
    public void Test_01_Instagram() throws IOException {


        FileInputStream fsIP= new FileInputStream(new File("C:\\demo\\UnderArmour.xls"));//E:/demo/employee2.xls
//Access the workbook
        HSSFWorkbook wb = new HSSFWorkbook(fsIP);
//Access the worksheet, so that we can update / modify it.
        HSSFSheet worksheet = wb.getSheetAt(0);
// declare a Cell object
        Cell cell = null;
// Access the second cell in second row to update the value
        cell = worksheet.getRow(1).getCell(1);
// Get current cell value value and overwrite the value
        cell.setCellValue("OverRide existing value");

        Row row;
        row = worksheet.createRow(37);//2
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("hi");

//Close the InputStream
        fsIP.close();
//Open FileOutputStream to write updates
        FileOutputStream output_file =new FileOutputStream(new File("C:\\demo\\UnderArmour.xls"));
        //write changes
        wb.write(output_file);
//close the stream
        output_file.close();
}}