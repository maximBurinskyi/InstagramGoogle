package API;
import com.google.gson.Gson;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class API_Google_trends {
  String token = null;
  String formValue = null;

  @Test
  public void apiTest1() throws UnirestException, FileNotFoundException {
    String postApi = "https://trends.google.com/trends/api/explore?hl=en-US&tz=-120&req=%7B%22comparisonItem%22:%5B%7B%22keyword%22:%22food%22,%22geo%22:%22US%22,%22time%22:%22today+5-y%22%7D%5D,%22category%22:0,%22property%22:%22%22%7D&tz=-120";

    String body = Unirest.get(postApi)
            .header("hl", "ru")
            .header("tz", "-120")
            .header("req", "%7B%22comparisonItem%22:%5B%7B%22keyword%22:%22food%22,%22geo%22:%22US%22,%22time%22:%22today+5-y%22%7D%5D,%22category%22:0,%22property%22:%22%22%7D")

            .header("authority", "trends.google.com")
            .header("path", "/trends/api/explore?hl=ru&tz=-120&req=%7B%22comparisonItem%22:%5B%7B%22keyword%22:%22food%22,%22geo%22:%22US%22,%22time%22:%22today+5-y%22%7D%5D,%22category%22:0,%22property%22:%22%22%7D&tz=-120")
            .header("accept", "application/json, text/plain, */*")
            .header("accept-encoding", "gzip, deflate, br")
            .header("cookie", "__utmc=10102256; __utma=10102256.398216924.1572949697.1575372718.1575448579.16; __utmz=10102256.1575448579.16.4.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); HSID=AbcEJ3E7KS0UH40gF; SSID=ADO3ynr-V6VL9EB6p; APISID=R-SniXXBhbh-ZwI6/AxjGvs-oZzBCS9HM0; SAPISID=gmZJXB4skpnDKSo6/AnDHKnLTjpFuRSeZN; SEARCH_SAMESITE=CgQIsI0B; S=billing-ui-v3=d68qgOBhigRN6WpV5jl3V8u0UucPOon1:billing-ui-v3-efe=d68qgOBhigRN6WpV5jl3V8u0UucPOon1; SID=rAdtgVwnvMyZedtqgFeh2fAg_dvo4iOW-6o0qLGGQCN2PTySwKrURuAuuLY75B1vWKZT2w.; ANID=AHWqTUnRpPZDiVYxu6nUCi54lVPZ4xzRQ5gI8U_69_VjuO6veu774Izupd65t7hg; NID=192=SUANyzFji8Ogxx5WQKv9WIKG5XX7GOAiPs2bNTP_uT2Ilc3f3SXJ2cojicho_dP8S6vi2xkDZbzOb3pyD-Yj5BkfK3t5BJO4oA3J5Fpg4MeLpC0RamVP7yXUpTqx7QI7QK7mWw6l4-F379Ii1I3ukoBdbFxZXlqB9F6zI8FkJ-gLCT9F4jgEP_N9EgFvckmHp_cHsL-lRBxvwyQZI5Z05ljm7gLKtJKgbKK12hHRst0; 1P_JAR=2019-12-4-9; SIDCC=AN0-TYvA3fWHptnsf17sAKZ463Ojs2Ph1P5GVNzqppS5uU6AdPT-hZjHHXprhGfZk-auDcrp7kgB")
            .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.80 Safari/537.36")
            .header("x-client-data", "CI22yQEIo7bJAQjBtskBCKmdygEIqKPKAQjiqMoBCJetygEIza3KAQjLrsoBCMqvygEI97TKAQ==")
            //.body(template.render(model))
            .asString()
            //.asJson()
            .getBody();
    System.out.println(body);         // gives the full json response
    String jsonString = body;
    Gson g = new Gson();

    Wi request = g.fromJson(jsonString, Wi.class);

    for (Wi wi : request.widgets) {

      System.out.println("token:" + wi.token);
      //System.out.println("id:" + wi.id);
      if (token == null) {
        for (int i = 0; i < 1; i++) {
          token = wi.token;
        }
      }

    }
    System.out.println(token);
    //PrintStream listOut = new PrintStream("C://Users//Максим//Desktop//Testo.txt");
    //listOut.print(token);


    //String test1 = request.token;

    //System.out.println(test1);


  }


  @Test
  public void apiTest2() throws UnirestException, IOException {
    String postApi = "https://trends.google.com/trends/api/widgetdata/multiline?tz=-120&req=%7B%22time%22:%222014-12-27+2019-12-27%22,%22resolution%22:%22WEEK%22,%22locale%22:%22en-US%22,%22comparisonItem%22:%5B%7B%22geo%22:%7B%22country%22:%22US%22%7D,%22complexKeywordsRestriction%22:%7B%22keyword%22:%5B%7B%22type%22:%22BROAD%22,%22value%22:%22food%22%7D%5D%7D%7D%5D,%22requestOptions%22:%7B%22property%22:%22%22,%22backend%22:%22IZG%22,%22category%22:0%7D%7D&token=" + token + "&tz=-120";

    String body = Unirest.get(postApi)
            // .routeParam("hl", "ru")
            //.header("tz", "-120")
            //.header("req", "%7B%22time%22:%222014-12-04+2019-12-04%22,%22resolution%22:%22WEEK%22,%22locale%22:%22en-US%22,%22comparisonItem%22:%5B%7B%22geo%22:%7B%22country%22:%22US%22%7D,%22complexKeywordsRestriction%22:%7B%22keyword%22:%5B%7B%22type%22:%22BROAD%22,%22value%22:%22food%22%7D%5D%7D%7D%5D,%22requestOptions%22:%7B%22property%22:%22%22,%22backend%22:%22IZG%22,%22category%22:0%7D%7D")
            //.header("token", "APP6_UEAAAAAXekxCQiy4BMDtREcWW08HCOR4bBU_MLo")

            .header("authority", "trends.google.com")
            .header("path", "/trends/api/widgetdata/multiline?hl=en-US&tz=-120&req=%7B%22time%22:%222014-12-04+2019-12-04%22,%22resolution%22:%22WEEK%22,%22locale%22:%22en-US%22,%22comparisonItem%22:%5B%7B%22geo%22:%7B%22country%22:%22US%22%7D,%22complexKeywordsRestriction%22:%7B%22keyword%22:%5B%7B%22type%22:%22BROAD%22,%22value%22:%22food%22%7D%5D%7D%7D%5D,%22requestOptions%22:%7B%22property%22:%22%22,%22backend%22:%22IZG%22,%22category%22:0%7D%7D&token=APP6_UEAAAAAXejBnEj_wMQBRwqtbkpwA_kWwA1E6M6F&tz=-120")
            .header("accept", "application/json, text/plain, */*")
            .header("accept-encoding", "gzip, deflate, br")
            //.header("cookie", "__utmc=10102256; __utma=10102256.398216924.1572949697.1575372718.1575448579.16; __utmz=10102256.1575448579.16.4.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); __utmt=1; __utmb=10102256.7.9.1575448586551; HSID=AbcEJ3E7KS0UH40gF; SSID=ADO3ynr-V6VL9EB6p; APISID=R-SniXXBhbh-ZwI6/AxjGvs-oZzBCS9HM0; SAPISID=gmZJXB4skpnDKSo6/AnDHKnLTjpFuRSeZN; SEARCH_SAMESITE=CgQIsI0B; S=billing-ui-v3=d68qgOBhigRN6WpV5jl3V8u0UucPOon1:billing-ui-v3-efe=d68qgOBhigRN6WpV5jl3V8u0UucPOon1; SID=rAdtgVwnvMyZedtqgFeh2fAg_dvo4iOW-6o0qLGGQCN2PTySwKrURuAuuLY75B1vWKZT2w.; ANID=AHWqTUnRpPZDiVYxu6nUCi54lVPZ4xzRQ5gI8U_69_VjuO6veu774Izupd65t7hg; NID=192=SUANyzFji8Ogxx5WQKv9WIKG5XX7GOAiPs2bNTP_uT2Ilc3f3SXJ2cojicho_dP8S6vi2xkDZbzOb3pyD-Yj5BkfK3t5BJO4oA3J5Fpg4MeLpC0RamVP7yXUpTqx7QI7QK7mWw6l4-F379Ii1I3ukoBdbFxZXlqB9F6zI8FkJ-gLCT9F4jgEP_N9EgFvckmHp_cHsL-lRBxvwyQZI5Z05ljm7gLKtJKgbKK12hHRst0; 1P_JAR=2019-12-4-8; SIDCC=AN0-TYvU12D7ngM85RKEETkd13Mno2V_rS0nPi-L-WvrnLymrLIiUUdnyIKAY3pn10vt1uJ_qQyq")
            .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.80 Safari/537.36")
            .header("x-client-data", "CI22yQEIo7bJAQjBtskBCKmdygEIqKPKAQjiqMoBCJetygEIza3KAQjLrsoBCMqvygEI97TKAQ==")
            //.body(template.render(model))
            .asString()
            //.asJson()
            .getBody();

    System.out.println(body);         // gives the full json response

    String jsonString = body;
    System.out.println(jsonString.length());
    int xx = jsonString.length();
    jsonString = jsonString.substring(17, xx - 1);
    System.out.println(jsonString);

    Gson g = new Gson();
    Wi2 request = g.fromJson(jsonString, Wi2.class);

    List<String> valueAndTime = new ArrayList<>();
    List<String> justTime = new ArrayList<>();


    for (Wi2 wi2 : request.timelineData) {

      for (int i = 0; i < wi2.formattedValue.length; i++) {

        String formValue = wi2.formattedValue[i];

        System.out.println(wi2.formattedAxisTime);
        System.out.println("formattedValue :" + formValue);

        //valueAndTime.add(wi2.formattedAxisTime);
        valueAndTime.add(formValue);
      }
      for (int i = 0; i < wi2.formattedValue.length; i++) {

        String formValue = wi2.formattedValue[i];

        System.out.println(wi2.formattedAxisTime);
        System.out.println("formattedValue :" + formValue);

        justTime.add(wi2.formattedAxisTime);
        //valueAndTime.add(formValue);


        //if (formValue == null) {
        //for (int j = 0; j < formValue.length(); j++) {
        //formValue = wi2.formattedValue[j];
        // }
        // }


        //PrintStream listOut = new PrintStream("C://Users//Максим//Desktop//Testo1.txt");
        //listOut.print(formValue);


      }
    }

      FileWriter writer = new FileWriter("C://Users//Максим//Desktop//Testo1.txt");
      for (String str : valueAndTime) {
        writer.write(str);
        writer.write("\n");
      }
      writer.close();
      //System.out.println(valueAndTime);


      Workbook wb = new HSSFWorkbook();
      Sheet sheet = wb.createSheet("Google Trends data");

      int rownumValue = 0;
      int rownumTime = 0;
      int i = 0;
      Cell cell;
      Cell cell2;
      Cell cell3;
      Cell cell4;
      Row rowValue;
      Row rowTime;
      Row row2;


      rowValue = sheet.createRow(rownumValue);
      rowTime = sheet.createRow(rownumTime);

      cell = rowValue.createCell(0);
      //cell.setCellValue("Value");

      // EmpName
      //cell = rowTime.createCell(1);
     // cell.setCellValue("Other");

      // Data


      for (String data : valueAndTime) {


        rownumValue++;
        rowValue = sheet.createRow(rownumValue);
        //row2 = sheet.createRow(rownumValue);


        // EmpNo (A)
        //for (int i = 0; i < valueAndTime.size(); i++) {
        //i++;
        //if( i % 2 == 0) {


        cell = rowValue.createCell(0, CellType.NUMERIC);
        cell.setCellValue(data);

        //}
      }

      Sheet sheet2 = wb.createSheet("Google Trends Date");

      for (String data2 : justTime) {
        rownumTime++;
        //row = sheet.createRow(rownumTime);
        row2 = sheet2.createRow(rownumTime);
        rowTime = sheet2.createRow(rownumTime);


        // EmpNo (A)
        //for (int i = 0; i < valueAndTime.size(); i++) {
        //i++;
        //if( i % 2 == 0) {


        cell2 = rowTime.createCell(0, CellType.NUMERIC);
        cell2.setCellValue(data2);
        //cell3 = rowTime.createCell(2);

        for (int j = 0; i < 261; i++) {


          cell3 = rowTime.createCell(2);
         // String ref  = (char) ('A' + j) + "3:" + (char)('A'+j)+12;
          //int ref2 =   ('A') +  (2 + j);

          //cell3.setCellFormula("SUM(" + ref + ")");
          cell3.setCellFormula("'Google Trends data'!A2");


          //cell4 = rowTime.createCell(3);
          //String ref2  = (char) ('A' + j) + "2";

          //cell4.setCellFormula("Google Trends data'!" + ref2 + "");

        }
        //}
      }


        //Cell cell3 = row2.createCell(2);
        //cell3.setCellFormula("A1 + B1");


      //if (i % 2 != 0) {
      // cell2 = row2.createCell(2, CellType.NUMERIC);
      //for(int a = 0; a < valueAndTime.size(); a+=2){
      //String rawData =  valueAndTime.get(a);
      //cell = row.createCell(2, CellType.NUMERIC);
      //  cell2.setCellValue(data);


      // EmpName (B)
      // cell = row.createCell(1);
      //cell.setCellValue(data);


      File file = new File("C:/demo/employee.xls");
      file.getParentFile().mkdirs();

      FileOutputStream outFile = new FileOutputStream(file);
      wb.write(outFile);
      outFile.close();

   /* for (int j = 0; i < 261; i++) {


      cell4 = rowTime.createCell(3);
      String ref2 = (char) ('A' + j) + "2";

      cell4.setCellFormula("Google Trends data'!" + ref2 + "");


    }
    File file2 = new File("C:/demo/employee.xls");
    file2.getParentFile().mkdirs();

    FileOutputStream outFile2 = new FileOutputStream(file2, true);
    wb.write(outFile2);
    */


      //int rowNumb = 0;
      //for (String data : valueAndTime) {


      //Row row = sheet0.createRow(rowNumb++);
      //int colNum = 0;
      //for (Object field : data) {
      //  Cell cell = row.createCell(colNum++);
      //  if (field instanceof String) {
      //     cell.setCellValue((String) field);
      //   } else if (field instanceof Integer) {
      //   cell.setCellValue((Integer) field);

    //cell.setCellValue(field);
    //FileOutputStream fos = new FileOutputStream("C://Users//Максим//Desktop//Mysheet2.xls");


    //for (String data : valueAndTime) {
    // cell.setCellValue(data);
    //writer.write("\n");
    //((HSSFWorkbook) wb).write(fos);
    //fos.close();
    //}
    //((HSSFWorkbook) wb).write(fos);
    //FileOutputStream fos = new FileOutputStream("C://Users//Максим//Desktop//Mysheet2.xls");
    //((HSSFWorkbook) wb).write(fos);
    //fos.close();
    //((HSSFWorkbook) wb).write(fos);
    //fos.close();


    //Workbook wb = new HSSFWorkbook();
    //Sheet sheet0 = wb.createSheet("Google Trends data");
    //Row row = sheet0.createRow(1);
    //Cell cell = row.createCell(1);

    //FileOutputStream fos = new FileOutputStream("C://Users//Максим//Desktop//Mysheet2.xls");
    //cell.setCellValue(data);
    //FileOutputStream fos = new FileOutputStream("C://Users//Максим//Desktop//Mysheet2.xls");


    // for(String str : valueAndTime) {
    // cell.setCellValue(str);


    //FileOutputStream fos = new FileOutputStream("C://Users//Максим//Desktop//Mysheet2.xls");


    //((HSSFWorkbook) wb).write(fos);


    //fos.close();


  }
}

    //}
  //}
//}


//APP6_UEAAAAAXejBnEj_wMQBRwqtbkpwA_kWwA1E6M6F
//        APP6_UEAAAAAXejAsd5uEw9b7VrWcay78jiXJbQEk9TV



