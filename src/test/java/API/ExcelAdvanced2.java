package API;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelAdvanced2 {
  private static final String FILE__NAME = "C://Users//Максим//Desktop//Mysheet3.xlsx";

  public static void main(String[]args) {

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("Datatypes in Java");
    Object[][]datatypes = {
            {"Datatype", "Type", "Size(in bytes)"},
            {"int", "Primitive", 2},
            {"float", "Primitive", 4},
            {"double", "Primitive", 8},
            {"char", "Primitive", 1},
            {"String", "Non-Primitive", "No fixed size"}
    };
    String datatypes2 = "Dec 28, 2014 – Jan 3, 2015\n" +
            "formattedValue :57\n" +
            "Jan 4 – 10, 2015\n" +
            "formattedValue :55\n" +
            "Jan 11 – 17, 2015\n" +
            "formattedValue :55\n" +
            "Jan 18 – 24, 2015\n" +
            "formattedValue :55\n" +
            "Jan 25 – 31, 2015\n" +
            "formattedValue :57\n" +
            "Feb 1 – 7, 2015\n" +
            "formattedValue :54";


    int rowNum = 0;
    System.out.println("Creating excel");

    for (Object[]datatype : datatypes) {
      Row row = sheet.createRow(rowNum++);
      int colNum = 0;
      for (Object field : datatype) {
        Cell cell = row.createCell(colNum++);
        if (field instanceof String) {
          cell.setCellValue((String) field);
        } else if (field instanceof Integer) {
          cell.setCellValue((Integer) field);
        }
      }
    }

    try {
      FileOutputStream outputStream = new FileOutputStream(FILE__NAME);
      workbook.write(outputStream);
      workbook.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println("Done");
  }
}

