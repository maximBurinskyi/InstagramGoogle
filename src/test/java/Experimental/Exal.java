package Experimental;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.*;

public class Exal {

    @Test
    public void Test_01_Instagram() throws FileNotFoundException {

        InputStream inp = new FileInputStream("E:/demo/employee2.xls");
        {
            //InputStream inp = new FileInputStream("workbook.xlsx");

            Workbook wb = null;
            try {
                wb = WorkbookFactory.create(inp);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InvalidFormatException e) {
                e.printStackTrace();
            }
            Sheet sheet = wb.getSheetAt(0);
            Row row = sheet.getRow(1);
            Cell cell = row.getCell(0);
            if (cell == null)
                cell = row.createCell(4);
            cell.setCellType(CellType.STRING);
            cell.setCellValue("a test");

            // Write the output to a file
            try (OutputStream fileOut = new FileOutputStream("workbook.xls")) {
                wb.write(fileOut);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    //public Exal() throws FileNotFoundException {
      //  }
    }
}