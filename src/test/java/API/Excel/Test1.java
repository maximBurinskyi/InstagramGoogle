package API.Excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test1 {
  public static void main(String[] args) throws IOException {
    Workbook wb = new HSSFWorkbook();
    //Sheet sheet = wb.createSheet("Formulas2");

    for (Sheet sheet : wb) {
      for (Row row : sheet) {
        for (Cell cell : row) {
          // Do something here
          Cell cell0 = row.createCell(0);
          cell0.setCellValue(1);
        }
      }

      FileOutputStream fos = new FileOutputStream("C:/demo/employee5.xls");
      ((HSSFWorkbook) wb).write(fos);
      wb.close();

    }
  }
}
