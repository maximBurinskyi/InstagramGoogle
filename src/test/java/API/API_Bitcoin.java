package API;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.testng.annotations.Test;

public class API_Bitcoin {

  @Test
  public void apiTest2() throws UnirestException {
    String postApi = "https://api.coindesk.com/v1/bpi/historical/close.json";
    //String postApi = "https://api.privatbank.ua/p24api/exchange_rates?json";

    String body = Unirest.get(postApi)
            .header("start", "12-12-2018")
            .header("end", "11-12-2019")
            //.routeParam("date", "01.12.2014")
            // .routeParam("tz", "-120")
            // .routeParam("req", "%7B%22comparisonItem%22:%5B%7B%22keyword%22:%22food%22,%22geo%22:%22US%22,%22time%22:%22today+5-y%22%7D%5D,%22category%22:0,%22property")


            //.header("date", "01.12.2018")

//            .header("authority", "trends.google.com")
//            .header("path", "/trends/api/explore?hl=ru&tz=-120&req=%7B%22comparisonItem%22:%5B%7B%22keyword%22:%22food%22,%22geo%22:%22US%22,%22time%22:%22today+5-y%22%7D%5D,%22category%22:0,%22property%22:%22%22%7D&tz=-120")
//            .header("accept", "application/json, text/plain, */*")
//            .header("accept-encoding", "gzip, deflate, br")
//            .header("cookie", "__utma=10102256.408681705.1575404504.1575404504.1575404504.1; _utmc=10102256; _utmz=10102256.1575404504.1.1.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); _utmt=1; _utmb=10102256.7.9.1575404523623; CONSENT=YES+UA.ru+; SEARCH_SAMESITE=CgQIuI4B; ANID=AHWqTUmzLPOR6uTFkMO17c3VpTYsK_UTNZklQou7Mxc1pcynFbKqktmiibsMC4Ph; SID=rAfXAQdtjn3wWGrW73mbkk2eco20IPjMhVfSk5h_6jQBZTCliihrkDJ3vZigfbTNdVKuqw.; HSID=AQx5KesDucnIrJjFq; SSID=APwKySgFKH1jWDfG9; APISID=AjBv06inCfIPEsiR/AykcXXbRzFS7yfy6y; SAPISID=78fpUrqnXdFHA3x6/AR_yqWnOZHjGKAtfA; NID=192=O9ANmnnp_jK2FrfQlJV08kdKz7SMo7Y51nwMm6I4UfCyudLCWCT-RiUzTLbQGXIBCuj6YaUb1ZIdkCMgNUcMQHOsvZq_jQWYjkrilyBMOlduEEYky3tIVWGokFOgG0dC6O9pDvD16EpF__ysn4YSfNvCoUEwcnTRdwEw2eXyIRBwKpbPcUJjCkFNwWh6okC8cOGceOKNJaH-GuVrkE35Nej7_wBC5PyPDLSdGEln-1EE5zxlu2bxmmPY8N0fO2yYr-rewzWkA1raxFrlsBcGDBjUwhw0Qdhft5xwJFFzxZDicw; 1P_JAR=2019-12-3-20; SIDCC=AN0-TYtVVGtxU-XLxZaZpT6uG6K3aGFhsgCI4EUTcMkV5ryVw4JJTd3sQ9_G-MWs_2R4CEEKCA")
//            .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.80 Safari/537.36")
//            .header("x-client-data", "CKS1yQEIjrbJAQiktskBCMS2yQEIqZ3KAQioo8oBCLGnygEI4qjKAQjxqcoBCJetygEIza3KAQjLrsoBCPe0ygE=")
            //.body(template.render(model))
            .asString()
            //.asJson()
            .getBody();
    System.out.println(body);         // gives the full json response

  }



}
