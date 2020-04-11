package API;

import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataFormat {

  @Test
  public void data() {
    //String timeStampCurentData = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
    //System.out.println(timeStampCurentData);

    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    Calendar cal = Calendar.getInstance();

    //Substract one day to current date.
    //cal = Calendar.getInstance();
    cal.add(Calendar.DATE, -9);
    System.out.println(dateFormat.format(cal.getTime()));

    //cal.add(Calendar.YEAR, -5);
    //System.out.println(dateFormat.format(cal.getTime()));

    for(int i = 0; i<259; i++) {
      //Add seven days to current date.
      cal.add(Calendar.DATE, -7);
      System.out.println(dateFormat.format(cal.getTime()));
    }



  }
}
