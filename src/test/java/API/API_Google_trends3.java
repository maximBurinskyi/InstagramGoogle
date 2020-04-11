package API;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.testng.annotations.Test;

public class API_Google_trends3 {
  @Test
  public void apiTest2() throws UnirestException {
    String postApi = "https://trends.google.com/trends/api/explore?hl=en-US&tz=-120&req=%7B%22comparisonItem%22:%5B%7B%22keyword%22:%22food%22,%22geo%22:%22US%22,%22time%22:%22today+5-y%22%7D%5D,%22category%22:0,%22property%22:%22%22%7D&tz=-120";

    String body = Unirest.get(postApi)

            //.header("authority", "trends.google.com")
            //.header("path", "/trends/api/explore?hl=ru&tz=-120&req=%7B%22comparisonItem%22:%5B%7B%22keyword%22:%22food%22,%22geo%22:%22US%22,%22time%22:%22today+5-y%22%7D%5D,%22category%22:0,%22property%22:%22%22%7D&tz=-120")
            //.header("accept", "application/json, text/plain, */*")
            //.header("accept-encoding", "gzip, deflate, br")
            .header("cookie", "__utmc=10102256; __utma=10102256.398216924.1572949697.1575372718.1575448579.16; __utmz=10102256.1575448579.16.4.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); HSID=AbcEJ3E7KS0UH40gF; SSID=ADO3ynr-V6VL9EB6p; APISID=R-SniXXBhbh-ZwI6/AxjGvs-oZzBCS9HM0; SAPISID=gmZJXB4skpnDKSo6/AnDHKnLTjpFuRSeZN; SEARCH_SAMESITE=CgQIsI0B; S=billing-ui-v3=d68qgOBhigRN6WpV5jl3V8u0UucPOon1:billing-ui-v3-efe=d68qgOBhigRN6WpV5jl3V8u0UucPOon1; SID=rAdtgVwnvMyZedtqgFeh2fAg_dvo4iOW-6o0qLGGQCN2PTySwKrURuAuuLY75B1vWKZT2w.; ANID=AHWqTUnRpPZDiVYxu6nUCi54lVPZ4xzRQ5gI8U_69_VjuO6veu774Izupd65t7hg; NID=192=SUANyzFji8Ogxx5WQKv9WIKG5XX7GOAiPs2bNTP_uT2Ilc3f3SXJ2cojicho_dP8S6vi2xkDZbzOb3pyD-Yj5BkfK3t5BJO4oA3J5Fpg4MeLpC0RamVP7yXUpTqx7QI7QK7mWw6l4-F379Ii1I3ukoBdbFxZXlqB9F6zI8FkJ-gLCT9F4jgEP_N9EgFvckmHp_cHsL-lRBxvwyQZI5Z05ljm7gLKtJKgbKK12hHRst0; 1P_JAR=2019-12-4-9; SIDCC=AN0-TYvA3fWHptnsf17sAKZ463Ojs2Ph1P5GVNzqppS5uU6AdPT-hZjHHXprhGfZk-auDcrp7kgB")

            .asString()
            //.asJson()
            .getBody();

    System.out.println(body);

//    JsonNode body = Unirest.get(postApi)
//            .header("hl", "ru")
//            .header("tz", "-120")
//            .header("req", "%7B%22comparisonItem%22:%5B%7B%22keyword%22:%22food%22,%22geo%22:%22US%22,%22time%22:%22today+5-y%22%7D%5D,%22category%22:0,%22property%22:%22%22%7D")
//
//            .header("authority", "trends.google.com")
//            .header("path", "/trends/api/explore?hl=ru&tz=-120&req=%7B%22comparisonItem%22:%5B%7B%22keyword%22:%22food%22,%22geo%22:%22US%22,%22time%22:%22today+5-y%22%7D%5D,%22category%22:0,%22property%22:%22%22%7D&tz=-120")
//            .header("accept", "application/json, text/plain, */*")
//            .header("accept-encoding", "gzip, deflate, br")
//            .header("cookie", "__utmc=10102256; __utma=10102256.398216924.1572949697.1575372718.1575448579.16; __utmz=10102256.1575448579.16.4.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); HSID=AbcEJ3E7KS0UH40gF; SSID=ADO3ynr-V6VL9EB6p; APISID=R-SniXXBhbh-ZwI6/AxjGvs-oZzBCS9HM0; SAPISID=gmZJXB4skpnDKSo6/AnDHKnLTjpFuRSeZN; SEARCH_SAMESITE=CgQIsI0B; S=billing-ui-v3=d68qgOBhigRN6WpV5jl3V8u0UucPOon1:billing-ui-v3-efe=d68qgOBhigRN6WpV5jl3V8u0UucPOon1; SID=rAdtgVwnvMyZedtqgFeh2fAg_dvo4iOW-6o0qLGGQCN2PTySwKrURuAuuLY75B1vWKZT2w.; ANID=AHWqTUnRpPZDiVYxu6nUCi54lVPZ4xzRQ5gI8U_69_VjuO6veu774Izupd65t7hg; NID=192=SUANyzFji8Ogxx5WQKv9WIKG5XX7GOAiPs2bNTP_uT2Ilc3f3SXJ2cojicho_dP8S6vi2xkDZbzOb3pyD-Yj5BkfK3t5BJO4oA3J5Fpg4MeLpC0RamVP7yXUpTqx7QI7QK7mWw6l4-F379Ii1I3ukoBdbFxZXlqB9F6zI8FkJ-gLCT9F4jgEP_N9EgFvckmHp_cHsL-lRBxvwyQZI5Z05ljm7gLKtJKgbKK12hHRst0; 1P_JAR=2019-12-4-9; SIDCC=AN0-TYvA3fWHptnsf17sAKZ463Ojs2Ph1P5GVNzqppS5uU6AdPT-hZjHHXprhGfZk-auDcrp7kgB")
//            .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.80 Safari/537.36")
//            .header("x-client-data", "CI22yQEIo7bJAQjBtskBCKmdygEIqKPKAQjiqMoBCJetygEIza3KAQjLrsoBCMqvygEI97TKAQ==")
//            //.body(template.render(model))
//            //.asString()
//            .asJson()
//            .getBody();
//    System.out.println(body);         // gives the full json response

  }








}
