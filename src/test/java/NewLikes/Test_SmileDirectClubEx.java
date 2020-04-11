package NewLikes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class Test_SmileDirectClubEx {
  public WebDriver driver;
  String descriptionn;
  List<WebElement> images2;
  BaseTest baseTest;


  @BeforeClass
  void beforeClass() {
    System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
    ChromeOptions chromeOptions = new ChromeOptions();
    driver = new ChromeDriver(chromeOptions);      // в ссылку присв. элем


  }

  @AfterClass
  void afterClass() {
    driver.quit();
  }

  @Test
  public void Test_01_Instagram() throws InterruptedException, IOException {

    BaseTest baseTest = new BaseTest(driver);
    //baseTest.GetDateFromFotos_37rows("https://www.instagram.com/reignbodyfuel/?hl=en", "Reign");
    baseTest.GetDateFromFotos_37rows_WithNewLikes("https://www.instagram.com/smiledirectclub/?hl=en", "SmileDirectClubEx");
  }
}