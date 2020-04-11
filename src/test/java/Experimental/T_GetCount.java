package Experimental;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class T_GetCount {
   public WebDriver driver;
    @BeforeClass
    void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);      // в ссылку присв. элем
        driver.navigate().to("https://www.instagram.com/columbia1938/?hl=en");
        Wait<WebDriver> wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[contains(text(), 'Posts')]")));
        driver.manage().window().maximize();
    }

    @AfterClass
    void afterClass() {
        driver.quit();
    }

    @Test
    public void Test_01_Instagram() throws InterruptedException, IOException {

        List<WebElement> images = driver.findElements(By.cssSelector("div[class='eLAPa']"));

        WebElement a = (WebElement) driver.findElement(By.cssSelector("div[class='Nnq7C weEfm']"));
        WebElement b = a.findElement(By.cssSelector("div[class='v1Nh3 kIKUG  _bz0w']"));

        Actions actions = new Actions(driver);
                actions.moveToElement(driver.findElement(By.cssSelector("div[class='v1Nh3 kIKUG  _bz0w']"))).build().perform();

        Thread.sleep(1000);
        //driver.findElement(By.cssSelector("div[class='eLAPa']"))

        WebElement c = b.findElement(By.cssSelector("div[class='qn-0x']"));

        WebElement d = c.findElement(By.cssSelector("li[class='-V_eO']"));


        WebElement e = c.findElements(By.cssSelector("li[class='-V_eO']")).get(1);

        String likes = d.getText();

        System.out.println("Likes " + likes);

        String comments = e.getText();

        System.out.println("Comments " + comments);

        driver.findElement(By.cssSelector("div[class='v1Nh3 kIKUG  _bz0w']")).click();
        Thread.sleep(2000);
        WebElement datee = driver.findElement(By.cssSelector("time[class='_1o9PC Nzb55']"));
        String date = datee.getText();
        System.out.println("Date " + date);

        WebElement description = driver.findElement(By.cssSelector("span[title='Edited']"));
        String descriptionn = description.getText();
        System.out.println("Description " + descriptionn);

        List<String> table = new ArrayList<String>();
        table.add(likes);
        table.add(comments);
        table.add(date +"   ");
        table.add(descriptionn);




        //writing to  Excel
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Employees sheet");

        int rownum = 0;
        Cell cell;
        Row row;

        row = sheet.createRow(rownum);

        // EmpNo
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Likes");
        //cell.setCellStyle(style);


        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Coments");
        //cell.setCellStyle(style);
        // Salary
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Date");
        //cell.setCellStyle(style);
        // Grade
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Description");
        //cell.setCellStyle(style);
        // Bonus
        //cell = row.createCell(4, CellType.STRING);
        //cell.setCellValue("Bonus");

        //data

        row = sheet.createRow(1);

        //cell = row.createCell(0, CellType.STRING);
        //cell.setCellValue(likes);

        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue(table.get(0));

        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue(table.get(1));

        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue(table.get(2));

        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue(table.get(3));


        File file = new File("E:/demo/employee.xls");
        file.getParentFile().mkdirs();

        FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);
        System.out.println("Created file: " + file.getAbsolutePath());


        //FileWriter writer = new FileWriter(fullPathToFile);
        //for(String str: actualReport) {
        //    writer.write(str);

        //}
    }
}
