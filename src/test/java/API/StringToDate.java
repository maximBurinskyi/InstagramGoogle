package API;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDate {

  public static void main(String[] args) throws ParseException {
//    SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
//    String str = args.length == 0 ? "2011-11-11" : args[0];
//
//    System.out.print("Строка " + str + " распаршена как ");
//    Date parsingDate;
//    try {
//      parsingDate = ft.parse(str);
//      System.out.println(parsingDate);
//    }catch (ParseException e) {
//      System.out.println("Нераспаршена с помощью " + ft);
//    }
    //DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

    String s = "05.09.2013";
    SimpleDateFormat format = new SimpleDateFormat();
    format.applyPattern("dd.MM.yyyy");
    Date docDate = format.parse(s);
    System.out.println(docDate.getTime());

  }
}
