package API.Excel;

import org.apache.poi.ss.formula.FormulaParser;
import org.apache.poi.ss.formula.FormulaRenderer;
import org.apache.poi.ss.formula.FormulaType;
import org.apache.poi.ss.formula.ptg.AreaPtgBase;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.RefPtgBase;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFEvaluationWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class Test2 {

  private static String copyFormula(XSSFSheet sheet, String formula, int coldiff, int rowdiff) {

    XSSFEvaluationWorkbook workbookWrapper =
            XSSFEvaluationWorkbook.create((XSSFWorkbook) sheet.getWorkbook());
    Ptg[] ptgs = FormulaParser.parse(formula, workbookWrapper, FormulaType.CELL
            , sheet.getWorkbook().getSheetIndex(sheet));

    for (int i = 0; i < ptgs.length; i++) {
      if (ptgs[i] instanceof RefPtgBase) { // base class for cell references
        RefPtgBase ref = (RefPtgBase) ptgs[i];
        if (ref.isColRelative())
          ref.setColumn(ref.getColumn() + coldiff);
        if (ref.isRowRelative())
          ref.setRow(ref.getRow() + rowdiff);
      }
      else if (ptgs[i] instanceof AreaPtgBase) { // base class for range references
        AreaPtgBase ref = (AreaPtgBase) ptgs[i];
        if (ref.isFirstColRelative())
          ref.setFirstColumn(ref.getFirstColumn() + coldiff);
        if (ref.isLastColRelative())
          ref.setLastColumn(ref.getLastColumn() + coldiff);
        if (ref.isFirstRowRelative())
          ref.setFirstRow(ref.getFirstRow() + rowdiff);
        if (ref.isLastRowRelative())
          ref.setLastRow(ref.getLastRow() + rowdiff);
      }
    }

    formula = FormulaRenderer.toFormulaString(workbookWrapper, ptgs);
    return formula;
  }

  public static void main(String[] args) throws Exception {

    XSSFWorkbook workbook = (XSSFWorkbook) WorkbookFactory.create(new FileInputStream("C:/demo/test.xlsx"));
    XSSFSheet sheet = workbook.getSheetAt(0);
    for (Row row : sheet) {
      for (Cell cell : row) {
        if (cell.getCellTypeEnum() == CellType.FORMULA) {
          CellAddress source = cell.getAddress();
          String formula = cell.getCellFormula();
          System.out.print(source + "=" + formula);
          int rowdiff = 3;
          int coldiff = -2;
          CellAddress target = new CellAddress(source.getRow() + rowdiff, source.getColumn() + coldiff);
          String newformula = copyFormula(sheet, formula, coldiff, rowdiff);
          System.out.println("->" + target + "=" + newformula);
        }
      }
    }

    workbook.close();
  }

}
