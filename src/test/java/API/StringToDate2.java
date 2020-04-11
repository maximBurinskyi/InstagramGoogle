package API;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDate2 {
  public static void main(String[] args) {
    String userDateFormat = "HHmm 'hrs', EEEE, MMMM dd, YYYY";
    SimpleDateFormat userDateFormatter = new SimpleDateFormat(userDateFormat);
    String reference_date = "2000 hrs, Thursday, July 20, 2015";

    Date date = null;
    try {
      date = userDateFormatter.parse(reference_date);
    } catch (ParseException e) {
      System.out.println("Date must be in the format " + userDateFormat);
    }

    System.out.println(userDateFormatter.format(date));

  }
}
