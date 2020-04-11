package Youtube;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Yutube_BaseTest {
    public WebDriver driver;
    WebDriverWait wait;
    String coments;

    @BeforeClass
    void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, 25);

    }

    public void GetDataFromVideo_25rows(String urll, String fileName) throws IOException, InterruptedException {

        driver.manage().window().maximize();
        //wait = new WebDriverWait(driver, 25);
        driver.navigate().to(urll);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//img[@id='img']")));

        List<WebElement> videos = driver.findElements(By.id("dismissable"));

        int count = 0;
        for(int i = 0; i < videos.size()-5; i++){
            //subscribers
            WebElement subscribers = driver.findElement(By.id("subscriber-count"));
            String subscription = subscribers.getText();
            System.out.println("Subscribers " + subscription);

            videos.get(i).click();

            Thread.sleep(1500);
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("yt-formatted-string[class='style-scope ytd-video-primary-info-renderer']")));
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("yt-formatted-string[class='style-scope ytd-toggle-button-renderer style-text']")));


            WebElement titlee = driver.findElement(By.cssSelector("yt-formatted-string[class='style-scope ytd-video-primary-info-renderer']"));
            String title = titlee.getText();
            String date = driver.findElement(By.id("date")).getText();
            String likes = driver.findElement(By.cssSelector("yt-formatted-string[class='style-scope ytd-toggle-button-renderer style-text']")).getText();
            String url = driver.getCurrentUrl();


            //coments
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,450)");
            //Thread.sleep(2000);

            //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("yt-formatted-string[class='more-button style-scope ytd-video-secondary-info-renderer']")));
            Thread.sleep(1000);
            if(driver.findElements(By.cssSelector("yt-formatted-string[class='count-text style-scope ytd-comments-header-renderer']")).size() !=0) {

                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("yt-formatted-string[class='count-text style-scope ytd-comments-header-renderer']")));
                WebElement comentss = driver.findElement(By.cssSelector("yt-formatted-string[class='count-text style-scope ytd-comments-header-renderer']"));
                coments = comentss.getText();
            }
            else{

            WebElement comentsDenied = driver.findElement(By.cssSelector("yt-formatted-string[class='style-scope ytd-message-renderer']"));
            coments = comentsDenied.getText();
            }
            //description
            WebElement descrip = driver.findElement(By.cssSelector("ytd-expander[class='style-scope ytd-video-secondary-info-renderer']"));
            String description = descrip.getText();

            System.out.println("Title " + title);
            System.out.println("Date " + date);
            System.out.println("Likes " + likes);
            System.out.println("Coments " + coments);
            System.out.println("Url " + url);
            System.out.println("Description " + description);


            List<String> table = new ArrayList<String>();
            table.add(title);
            table.add(date);
            table.add(likes);
            table.add(coments);
            table.add(subscription);
            table.add(url);
            table.add(description);


            //writing to  Excel
            HSSFWorkbook workbook = new HSSFWorkbook();
            //XSSFWorkbook workbook = new XSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Employees sheet");

            int rownum = 0;
            Cell cell;
            Row row;


            if(count==0) {
                //int rownum = 0;
                int rownumTitle = 0;
                row = sheet.createRow(rownumTitle);

                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue("Title");

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue("Date");

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue("Likes");

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue("Coments");

                cell = row.createCell(4, CellType.STRING);//5
                cell.setCellValue("Url");

                cell = row.createCell(5, CellType.STRING);//6
                cell.setCellValue("Description");

                cell = row.createCell(6, CellType.STRING);//4
                cell.setCellValue("Subscription " + subscription);

            }

            if(count > 0){

                File file1 = new File("C:\\Users\\Максим\\Desktop\\Insta output\\Youtube\\"+fileName+".xls");

                FileInputStream inputStream = new FileInputStream(file1);

                // Get the workbook instance for XLS file
                workbook = new HSSFWorkbook(inputStream);

                // Get first sheet from the workbook

                sheet = workbook.getSheetAt(0);


                int rownumData = i;

                row = sheet.getRow(i);
                row = sheet.getRow(1);

                int rownumData3 = i+1;

                row = sheet.createRow(rownumData3);

                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(table.get(0));

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(table.get(1));

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(table.get(2));

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(table.get(3));

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(table.get(5));

                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(table.get(6));

                //cell = row.createCell(6, CellType.STRING);
                //cell.setCellValue(table.get(4));//6

                //cell = sheet.getRow(1).getCell(1);


                //cell = row.createCell(0, CellType.STRING);
                //cell.setCellValue(likes);

                //cell = row.getCell(0);

                //cell = row.getCell(1);

                //cell = row.getCell(2);

                //cell = row.getCell(3);

            }
            //data

            if(count == 0) {

                int rownumData = i + 1;

                row = sheet.createRow(rownumData);

                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(table.get(0));

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(table.get(1));

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(table.get(2));

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(table.get(3));

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(table.get(5));

                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(table.get(6));

                //cell = row.createCell(6, CellType.STRING);
                //cell.setCellValue(table.get(4));//6
                //cell = row.createCell(5, CellType.STRING);
                // cell.setCellValue(table.get(5));

                //cell = row.createCell(6, CellType.STRING);
                //cell.setCellValue(table.get(6));
            }


            // Resize all columns to fit the content size
            for(int c = 0; c < table.size()-3; c++) {
                sheet.autoSizeColumn(c);
            }


            File file = new File("C:\\Users\\Максим\\Desktop\\Insta output\\Youtube\\"+fileName+".xls");
            //file.getParentFile().mkdirs();

            FileOutputStream outFile = new FileOutputStream(file);
            workbook.write(outFile);
            outFile.close();

            System.out.println("Created file: " + file.getAbsolutePath());
            count++;
            driver.navigate().back();
        }


    }

    public void GetDataFromVideo_30rows(String urll, String fileName) throws IOException, InterruptedException {
        driver.manage().window().maximize();
        //wait = new WebDriverWait(driver, 25);
        driver.navigate().to(urll);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//img[@id='img']")));

        List<WebElement> videos = driver.findElements(By.id("dismissable"));

        int count = 0;
        for(int i = 0; i < videos.size(); i++){
            //subscribers
            WebElement subscribers = driver.findElement(By.id("subscriber-count"));
            String subscription = subscribers.getText();
            System.out.println("Subscribers " + subscription);

            videos.get(i).click();

            Thread.sleep(1500);
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("yt-formatted-string[class='style-scope ytd-video-primary-info-renderer']")));
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("yt-formatted-string[class='style-scope ytd-toggle-button-renderer style-text']")));


            WebElement titlee = driver.findElement(By.cssSelector("yt-formatted-string[class='style-scope ytd-video-primary-info-renderer']"));
            String title = titlee.getText();
            String date = driver.findElement(By.id("date")).getText();
            String likes = driver.findElement(By.cssSelector("yt-formatted-string[class='style-scope ytd-toggle-button-renderer style-text']")).getText();
            String url = driver.getCurrentUrl();


            //coments
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,450)");
            //Thread.sleep(2000);
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("yt-formatted-string[class='count-text style-scope ytd-comments-header-renderer']")));
            WebElement comentss = driver.findElement(By.cssSelector("yt-formatted-string[class='count-text style-scope ytd-comments-header-renderer']"));
            String coments = comentss.getText();
            //description
            WebElement descrip = driver.findElement(By.cssSelector("ytd-expander[class='style-scope ytd-video-secondary-info-renderer']"));
            String description = descrip.getText();

            System.out.println("Title " + title);
            System.out.println("Date " + date);
            System.out.println("Likes " + likes);
            System.out.println("Coments " + coments);
            System.out.println("Url " + url);
            System.out.println("Description " + description);


            List<String> table = new ArrayList<String>();
            table.add(title);
            table.add(date);
            table.add(likes);
            table.add(coments);
            table.add(subscription);
            table.add(url);
            table.add(description);


            //writing to  Excel
            HSSFWorkbook workbook = new HSSFWorkbook();
            //XSSFWorkbook workbook = new XSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Employees sheet");

            int rownum = 0;
            Cell cell;
            Row row;


            if(count==0) {
                //int rownum = 0;
                int rownumTitle = 0;
                row = sheet.createRow(rownumTitle);

                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue("Title");

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue("Date");

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue("Likes");

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue("Coments");

                cell = row.createCell(4, CellType.STRING);//5
                cell.setCellValue("Url");

                cell = row.createCell(5, CellType.STRING);//6
                cell.setCellValue("Description");

                cell = row.createCell(6, CellType.STRING);//4
                cell.setCellValue("Subscription " + subscription);

            }

            if(count > 0){

                File file1 = new File("C:\\Users\\Максим\\Desktop\\Insta output\\Youtube\\"+fileName+".xls");

                FileInputStream inputStream = new FileInputStream(file1);

                // Get the workbook instance for XLS file
                workbook = new HSSFWorkbook(inputStream);

                // Get first sheet from the workbook

                sheet = workbook.getSheetAt(0);


                int rownumData = i;

                row = sheet.getRow(i);
                row = sheet.getRow(1);

                int rownumData3 = i+1;

                row = sheet.createRow(rownumData3);

                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(table.get(0));

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(table.get(1));

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(table.get(2));

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(table.get(3));

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(table.get(5));

                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(table.get(6));

                //cell = row.createCell(6, CellType.STRING);
                //cell.setCellValue(table.get(4));//6

                //cell = sheet.getRow(1).getCell(1);


                //cell = row.createCell(0, CellType.STRING);
                //cell.setCellValue(likes);

                //cell = row.getCell(0);

                //cell = row.getCell(1);

                //cell = row.getCell(2);

                //cell = row.getCell(3);

            }
            //data

            if(count == 0) {

                int rownumData = i + 1;

                row = sheet.createRow(rownumData);

                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(table.get(0));

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(table.get(1));

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(table.get(2));

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(table.get(3));

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(table.get(5));

                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(table.get(6));

                //cell = row.createCell(6, CellType.STRING);
                //cell.setCellValue(table.get(4));//6
                //cell = row.createCell(5, CellType.STRING);
                // cell.setCellValue(table.get(5));

                //cell = row.createCell(6, CellType.STRING);
                //cell.setCellValue(table.get(6));
            }


            // Resize all columns to fit the content size
            for(int c = 0; c < table.size()-3; c++) {
                sheet.autoSizeColumn(c);
            }


            File file = new File("C:\\Users\\Максим\\Desktop\\Insta output\\Youtube\\"+fileName+".xls");
            //file.getParentFile().mkdirs();

            FileOutputStream outFile = new FileOutputStream(file);
            workbook.write(outFile);
            outFile.close();

            System.out.println("Created file: " + file.getAbsolutePath());
            count++;
            driver.navigate().back();
        }


    }

    @AfterClass
    void afterClass() {
        driver.quit();
    }
}
