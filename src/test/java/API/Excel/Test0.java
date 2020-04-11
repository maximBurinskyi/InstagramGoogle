package API.Excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test0 {
  private static final int MY_MINIMUM_COLUMN_COUNT =3 ;

  public static void main(String[] args) throws IOException {
    // Decide which rows to process
    Workbook wb = new HSSFWorkbook();
    Sheet sheet = wb.createSheet("Formulas2");


    int rowStart = Math.min(15, sheet.getFirstRowNum());
    int rowEnd = Math.max(1400, sheet.getLastRowNum());
    for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
      Row r = sheet.getRow(rowNum);
      if (r == null) {
        // This whole row is empty
        // Handle it as needed

        Cell cell0 = r.createCell(rowStart);
        //for(int i = 0; i < 10; i++) {
        cell0.setCellValue(5);
        continue;
      }
      int lastColumn = Math.max(((Row) r).getLastCellNum(), MY_MINIMUM_COLUMN_COUNT);
      for (int cn = 0; cn < lastColumn; cn++) {
        Cell c = r.getCell(cn, Row.RETURN_BLANK_AS_NULL);
        if (c == null) {
          // The spreadsheet is empty in this cell
        } else {
          // Do something useful with the cell's contents
        }
      }
    }

    FileOutputStream fos = new FileOutputStream("C:/demo/employee4.xls");
    ((HSSFWorkbook) wb).write(fos);
    wb.close();

  }
}
