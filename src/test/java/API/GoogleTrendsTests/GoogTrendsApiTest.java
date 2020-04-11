package API.GoogleTrendsTests;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;

public class GoogTrendsApiTest extends GoogTrendsApiBase{
  String token = null;
  String query = "drink";
  @Test
  public void apiTest1() throws UnirestException, MalformedURLException {
    token = APITest1("https://trends.google.com/trends/api/explore?hl=en-US&tz=-120&req=%7B%22comparisonItem%22:%5B%7B%22keyword%22:%22"+query+"%22,%22geo%22:%22US%22,%22time%22:%22today+5-y%22%7D%5D,%22category%22:0,%22property%22:%22%22%7D&tz=-120");
    //System.out.println(token + "AAAAAA");



  }



  @Test
  public void apiTest2() throws UnirestException, IOException {
    APITest2(token);


  }



}
