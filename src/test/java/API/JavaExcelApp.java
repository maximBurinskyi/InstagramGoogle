package API;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class JavaExcelApp {
  public static void main(String[] args) throws IOException {
    Workbook wb = new HSSFWorkbook();
    Sheet sheet0 = wb.createSheet("Издатели");
    Row row = sheet0.createRow(3);
    Cell cell = row.createCell(4);
    cell.setCellValue("O relly");

    CellStyle style = wb.createCellStyle();
    //style.setDataFormat();

    //Font font = wb.createFont();
    //font.setCharSet();

    style.setAlignment(CellStyle.ALIGN_LEFT);

    cell.setCellStyle(style);




    //Sheet sheet1 = wb.createSheet("Книги");
    //Sheet sheet2 = wb.createSheet("Авторы");

    FileOutputStream fos = new FileOutputStream("C://Users//Максим//Desktop//Mysheet.xls");
    ((HSSFWorkbook) wb).write(fos);
    fos.close();
  }
}
