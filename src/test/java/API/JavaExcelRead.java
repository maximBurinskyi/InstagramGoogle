package API;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class JavaExcelRead {
  public static void main(String[] args) throws IOException {

    FileInputStream fis = new FileInputStream("C:/demo/employee.xls");
    Workbook wb = new HSSFWorkbook(fis);

    String result = "";
    for(int i = 0; i < 261; i++) {


       result = wb.getSheetAt(0).getRow(i++).getCell(i).getStringCellValue();
    }
    //for( int i = 0; i < result.length(); i++) {
      System.out.println(result);
    //}
    fis.close();
  }

}
