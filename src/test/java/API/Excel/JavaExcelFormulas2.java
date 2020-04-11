package API.Excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class JavaExcelFormulas2 {
  public static void main(String[] args) throws IOException {

    Workbook wb = new HSSFWorkbook();
    Sheet sheet = wb.createSheet("Formulas");


    int rownum = 0;
    int rownum2 = 0;
    int rownum3 = 0;
    int rownum4 = 0;


    //Row row = sheet.createRow(0);
    for (int i = 0; i < 200; i++) {
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



    }
    for (int j = 3; j < 200; j++) {
      rownum2++;
      Row row3 = sheet.getRow(j);
      Cell cell6 = row3.createCell(6);
      cell6.setCellValue(2);

      Cell cell7 = row3.createCell(7);
      String formula4 = "AVERAGE(A" + (rownum2) + ":" + "B" + (rownum2+3) + ")";
      cell7.setCellFormula(formula4);

    }

    for (int y = 11; y < 200; y++) {
      rownum3++;
      Row row4 = sheet.getRow(y);
      //Cell cell8 = row4.createCell(8);
      //cell8.setCellValue(2);

      Cell cell9 = row4.createCell(8);
      String formula5 = "AVERAGE(A" + (rownum3) + ":" + "B" + (rownum3+11) + ")";
      cell9.setCellFormula(formula5);

    }

    for (int z = 52; z < 200; z++) {
      rownum4++;
      Row row5 = sheet.getRow(z);
      //Cell cell8 = row4.createCell(8);
      //cell8.setCellValue(2);

      Cell cell10 = row5.createCell(9,CellType.NUMERIC);
      String formula6 = "(B" + (z+1) + "/" + "B" + rownum4 +  ")-1";
      cell10.setCellFormula(formula6);

    }






    FileOutputStream fos = new FileOutputStream("C:/demo/employee3.xls");
    ((HSSFWorkbook) wb).write(fos);
    wb.close();
  }
}
