package API;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class JavaExcelNext {
  public static void main(String[] args) throws IOException {

    Workbook wb = new HSSFWorkbook();
    Sheet sheet = wb.createSheet("format sheet");

    CellStyle style;

    DataFormat format = wb.createDataFormat();

    Row row;

    Cell cell;

    int rowNum = 0;

    int colNum = 0;


    row = sheet.createRow(rowNum++);

    cell = row.createCell(colNum);

    cell.setCellValue(11111.25);

    style = wb.createCellStyle();


    style.setDataFormat(format.getFormat("0.0"));

    cell.setCellStyle(style);



    row = sheet.createRow(rowNum++);

    cell = row.createCell(colNum);

    cell.setCellValue(11111.25);

    style = wb.createCellStyle();

    style.setDataFormat(format.getFormat("#,##0.0000"));

    cell.setCellStyle(style);

    try (OutputStream fileOut = new FileOutputStream("C:/demo/styles.xls")) {

      wb.write(fileOut);

    } catch (IOException e) {
      e.printStackTrace();
    }


    wb.close();

  }

}
