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

public class Test_GapEx {
    public WebDriver driver;
    String descriptionn;
    List<WebElement> images2;
    BaseTest baseTest;



    @BeforeClass
    void beforeClass(){
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
        baseTest.GetDateFromFotos_37rows_WithNewLikes("https://www.instagram.com/gap/?hl=en", "GapEx");
        /*
        driver.navigate().to("https://www.instagram.com/columbia1938/?hl=en");
        Wait<WebDriver> wait0 = new WebDriverWait(driver, 30);
        wait0.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[contains(text(), 'Posts')]")));
        driver.manage().window().maximize();


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(1000);
        List<WebElement> images = driver.findElements(By.cssSelector("div[class='v1Nh3 kIKUG  _bz0w']"));

        int count=0;
        for(int i = 0; i < images.size(); i++) {

            //driver.navigate().to("https://www.instagram.com/columbia1938/?hl=en");

            WebElement a = (WebElement) driver.findElement(By.cssSelector("div[class='Nnq7C weEfm']"));
            WebElement b = a.findElement(By.cssSelector("div[class='v1Nh3 kIKUG  _bz0w']"));

            //Thread.sleep(2000);
            Actions actions = new Actions(driver);
            if(count > 32){
                images2 = driver.findElements(By.cssSelector("div[class='v1Nh3 kIKUG  _bz0w']"));
                actions.moveToElement(images2.get(i)).build().perform();
            }

            else{
                actions.moveToElement(images.get(i)).build().perform();
            }
            //actions.moveToElement(images.get(i)).build().perform();

            Thread.sleep(3000);
            //driver.findElement(By.cssSelector("div[class='eLAPa']"))

            //WebElement c = b.findElement(By.cssSelector("div[class='qn-0x']"));

            Wait<WebDriver> wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("li[class='-V_eO']")));

            WebElement d = null;
            WebElement e = null;
            if(driver.findElements(By.cssSelector("li[class='-V_eO']")).size() > 2){
                d = driver.findElements(By.cssSelector("li[class='-V_eO']")).get(2);
                e = driver.findElements(By.cssSelector("li[class='-V_eO']")).get(3);
            }

            else {
                d = driver.findElement(By.cssSelector("li[class='-V_eO']"));

                e = driver.findElements(By.cssSelector("li[class='-V_eO']")).get(1);
            }

            String likes = d.getText();

            System.out.println("Likes " + likes);

            String comments = e.getText();

            System.out.println("Comments " + comments);

            //driver.findElement(By.cssSelector("div[class='v1Nh3 kIKUG  _bz0w']")).click();
            //images.get(i).click();
            if(count > 32){
                images2.get(i).click();
            }
            else {
                images.get(i).click();
            }

            Thread.sleep(2000);
            Wait<WebDriver> wait1 = new WebDriverWait(driver, 10);
            wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("time[class='_1o9PC Nzb55']")));

            WebElement datee = driver.findElement(By.cssSelector("time[class='_1o9PC Nzb55']"));
            String date = datee.getText();
            System.out.println("Date " + date);


            //String descriptionn;
            if (driver.findElements((By.cssSelector("div[class='C4VMK']"))).size() != 0) {
                WebElement descrip = driver.findElement(By.cssSelector("div[class='C4VMK']"));
                descriptionn = descrip.getText();
            }


            if (driver.findElements((By.cssSelector("span[title='Edited']"))).size() != 0) {
                WebElement description = driver.findElement(By.cssSelector("span[title='Edited']"));
                descriptionn = description.getText();
            }


            System.out.println("Description " + descriptionn);

            List<String> table = new ArrayList<String>();
            table.add(likes);
            table.add(comments);
            table.add(date + "   ");
            table.add(descriptionn);


            //writing to  Excel
            HSSFWorkbook workbook = new HSSFWorkbook();
            //XSSFWorkbook workbook = new XSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Employees sheet");
            //XSSFSheet sheet = workbook.createSheet("Employees sheet");

            int rownum = 0;
            Cell cell;
            Row row;


            if(count==0) {
                //int rownum = 0;
                int rownumTitle = 0;
                row = sheet.createRow(rownumTitle);

                // EmpNo
                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue("Likes");
                //cell.setCellStyle(style);


                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue("Coments");
                //cell.setCellStyle(style);
                // Salary
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue("Date      ");
                //cell.setCellStyle(style);
                // Grade
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue("Description");
                //cell.setCellStyle(style);
                // Bonus
                //cell = row.createCell(4, CellType.STRING);
                //cell.setCellValue("Bonus");
            }

            if(count > 0){

                File file1 = new File("C:\\demo\\columbia1938.xls");

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
            }



            File file = new File("C:\\demo\\columbia1938.xls");//E:/demo/employee2.xls
            //file.getParentFile().mkdirs();

            FileOutputStream outFile = new FileOutputStream(file);
            workbook.write(outFile);
            outFile.close();

            // try
            //{
            //     String filename= "E:/demo/employee"+i+".xls";
            //      FileWriter outFile = new FileWriter(filename,true); //the true will append the new data
            //     outFile.write("add a line\n");//appends the string to the file
            //         outFile.close();
            //    }
            //   catch(IOException ioe)
            //  {
            //      System.err.println("IOException: " + ioe.getMessage());
            //    }

            System.out.println("Created file: " + file.getAbsolutePath());
            count++;
            driver.findElement(By.cssSelector("button[class='ckWGn']")).click();
            //driver.findElement(By.cssSelector("div[class='Nnq7C weEfm']")).click();
            //driver.navigate().refresh();
            //Wait<WebDriver> wait2 = new WebDriverWait(driver, 10);
            //wait2.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='Nnq7C weEfm']")));
        }



        //FileWriter writer = new FileWriter(fullPathToFile);
        //for(String str: actualReport) {
        //    writer.write(str);

        //}

        */
    }
}
