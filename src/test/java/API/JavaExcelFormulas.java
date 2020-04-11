package API;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class JavaExcelFormulas {
  public static void main(String[] args) throws IOException {

    Workbook wb = new HSSFWorkbook();
    Sheet sheet = wb.createSheet("Formulas");


    int rownum = 0;


    //Row row = sheet.createRow(0);
    for (int i = 0; i < 10; i++) {
      ++rownum;
      Row row = sheet.createRow(i);

      Cell cell0 = row.createCell(0);
      //for(int i = 0; i < 10; i++) {
      cell0.setCellValue(i);


      Cell cell1 = row.createCell(1);
      cell1.setCellValue(7);

      Cell cell2 = row.createCell(2);
      cell2.setCellFormula("A1 + B1");

      Cell cell3 = row.createCell(3);
      char ref = (char) (('A') +  (0 + i));
      char ref2 = (char) (('B') + (1 + i));
      //cell3.setCellFormula("AVERAGE(A1:B1)");
      //cell3.setCellFormula("AVERAGE("+ ref +":" + ref2+")" );

      Row row2 = sheet.getRow(i);
      Cell cell4 = row2.createCell(4);


     //String formula = "0.1*C" + (rownum + 1) + "*D" + (rownum + 1);
      String formuala2 = "A" + (rownum + 1) + "+B" + (rownum +1);
      String formula3 = "AVERAGE(A" + (rownum) + ":" + "B" + rownum + ")";
      cell3.setCellFormula(formuala2);
      // }

      Cell cell5 = row.getCell(4, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
      if (cell5 == null || cell5.getCellTypeEnum() == CellType.BLANK) {

        //cell4.setCellFormula(formula3);
        cell5.setCellFormula(formula3);
      }
      //for (int j = 0; j < 5; j++) {


      //Row row2 = null;
      //Cell cell4 = row2.createCell(4);
      //String ref2 = (char) ('A' + i) + "2";

      //cell4.setCellFormula("Formulas'!" + ref2 + "");


      //}

      //Cell cell3 = row.createCell(3);
      //cell


      FileOutputStream fos = new FileOutputStream("C:/demo/employee3.xls");
      ((HSSFWorkbook) wb).write(fos);
      wb.close();
    }
  }
}
