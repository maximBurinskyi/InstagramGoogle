package New;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class New {
    public WebDriver driver;
    WebDriverWait wait;


    @BeforeClass
    void beforeClass(){
        //baseTest.initialization();

        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);

        //System.setProperty("webdriver.gecko.driver","driver/geckodriver.exe");
        //driver = new FirefoxDriver();

        wait = new WebDriverWait(driver, 30);
        driver.manage().window().maximize();

    }

    @AfterClass
    void afterClass() {
        driver.quit();
    }

    @Test
    public void Test_01_New() throws IOException {
    driver.navigate().to("https://www.fastly.com/industries");
    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("menu--utility-sign-up-mobile")));

    List<WebElement> list = new ArrayList<WebElement>();
    List<String> currentList = new ArrayList<>();
    //WebElement parentElement = driver.findElement(By.cssSelector("div[class='block-customermonotonelogos']"));
        WebElement parentElement = driver.findElement(By.id("customers-hero"));

        list = parentElement.findElements(By.cssSelector("img[alt]"));

    for(WebElement a : list){
      String text = a.getAttribute("alt");
        currentList.add(text);
    }

        String fullPathToFile = "C:\\Users\\Максим\\Desktop\\Insta output\\new.txt";

        FileWriter writer = new FileWriter(fullPathToFile);
        for(String str: currentList) {
            writer.write(str);
            writer.write("\r\n");

        }
        writer.close();

    }
    }
