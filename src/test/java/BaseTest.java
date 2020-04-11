//package java;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BaseTest {

    public WebDriver driver;
    //private WebDriver webDriver;
    public BaseTest(WebDriver driver2001) {
        this.driver = driver2001;
    }

    public File FileUrl(String name){
        File file1 = new File("E:\\demo\\"+name+".xls");
        return file1;
    }

    //XSSFSheet sheet = workbook.createSheet("Employees sheet");
    public void GetDateFromFotos_37rows(String url, String fileName) throws IOException, InterruptedException {

        String descriptionn = "";
        List<WebElement> images2 = null;

        driver.navigate().to(url);//https://www.instagram.com/columbia1938/?hl=en
        Wait<WebDriver> wait0 = new WebDriverWait(driver, 30);
        wait0.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[contains(text(), 'Posts')]")));
        driver.manage().window().maximize();


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(1500);
        List<WebElement> images = driver.findElements(By.cssSelector("div[class='v1Nh3 kIKUG  _bz0w']"));

        int count = 0;
        for (int i = 0; i < images.size(); i++) {

            //driver.navigate().to("https://www.instagram.com/columbia1938/?hl=en");

            WebElement a = (WebElement) driver.findElement(By.cssSelector("div[class='Nnq7C weEfm']"));
            WebElement b = a.findElement(By.cssSelector("div[class='v1Nh3 kIKUG  _bz0w']"));

            //Thread.sleep(2000);
            Actions actions = new Actions(driver);
            if (count > 32) {
                images2 = driver.findElements(By.cssSelector("div[class='v1Nh3 kIKUG  _bz0w']"));
                actions.moveToElement(images2.get(i)).build().perform();
            } else {
                actions.moveToElement(images.get(i)).build().perform();
            }
            //actions.moveToElement(images.get(i)).build().perform();

            Thread.sleep(3000);
            //driver.findElement(By.cssSelector("div[class='eLAPa']"))

            //WebElement c = b.findElement(By.cssSelector("div[class='qn-0x']"));

            Wait<WebDriver> wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("li[class='-V_eO']")));
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[class='-V_eO']")));
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[class='-V_eO']")));
            Thread.sleep(1000);
            WebElement d = null;
            WebElement e = null;
            if (driver.findElements(By.cssSelector("li[class='-V_eO']")).size() > 2) {
                d = driver.findElements(By.cssSelector("li[class='-V_eO']")).get(2);
                e = driver.findElements(By.cssSelector("li[class='-V_eO']")).get(3);
            } else {
                d = driver.findElement(By.cssSelector("li[class='-V_eO']"));

                e = driver.findElements(By.cssSelector("li[class='-V_eO']")).get(1);
            }

            String likes = d.getText();

            System.out.println("Likes " + likes);

            String comments = e.getText();

            System.out.println("Comments " + comments);

            //driver.findElement(By.cssSelector("div[class='v1Nh3 kIKUG  _bz0w']")).click();
            //images.get(i).click();
            if (count > 32) {
                images2.get(i).click();
            } else {
                images.get(i).click();
            }

            Thread.sleep(2000);
            Wait<WebDriver> wait1 = new WebDriverWait(driver, 15);
            wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("time[class='_1o9PC Nzb55']")));

            WebElement datee = driver.findElement(By.cssSelector("time[class='_1o9PC Nzb55']"));
            String date = datee.getText();
            System.out.println("Date " + date);


            //get likes from video
            if (driver.findElements((By.cssSelector("span[class='vcOH2']"))).size() != 0) {
                driver.findElements(By.cssSelector("span[class='vcOH2'][role='button']")).get(0).click();
                wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='vJRqr']")));
                WebElement likesVideo = driver.findElement(By.cssSelector("div[class='vJRqr']"));
                likes = likesVideo.findElement(By.cssSelector("span")).getText();
            }

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

            int rownum = 0;
            Cell cell;
            Row row;


            if (count == 0) {
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

            if (count > 0) {

                File file1 = new File("C:\\demo\\" + fileName + ".xls");

                FileInputStream inputStream = new FileInputStream(file1);

                // Get the workbook instance for XLS file
                workbook = new HSSFWorkbook(inputStream);

                // Get first sheet from the workbook

                sheet = workbook.getSheetAt(0);


                int rownumData = i;

                row = sheet.getRow(i);
                row = sheet.getRow(1);

                int rownumData3 = i + 1;

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

            if (count == 0) {

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


            File file = new File("C:\\demo\\" + fileName + ".xls");//E:/demo/employee2.xls
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

    }
    public void GetDateFromFotos_37rows_WithNewLikes(String url, String fileName) throws IOException, InterruptedException {

        String descriptionn = "";
        List<WebElement> images2 = null;

        driver.navigate().to(url);//https://www.instagram.com/columbia1938/?hl=en
        Wait<WebDriver> wait0 = new WebDriverWait(driver, 30);
        wait0.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[contains(text(), 'Posts')]")));
        driver.manage().window().maximize();


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(1500);
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
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[class='-V_eO']")));
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[class='-V_eO']")));
            Thread.sleep(1000);
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

            String likes = null;
            //String likes = d.getText();

            //System.out.println("Likes " + likes);

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
            Wait<WebDriver> wait1 = new WebDriverWait(driver, 15);
            wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("time[class='_1o9PC Nzb55']")));

            WebElement datee = driver.findElement(By.cssSelector("time[class='_1o9PC Nzb55']"));
            String date = datee.getText();
            System.out.println("Date " + date);


            //likes default
            if(driver.findElements((By.cssSelector("span[class='vcOH2']"))).size() == 0) {
                int count1 = 0;
                while (driver.findElements((By.cssSelector("div[class='Nm9Fw']"))).size() == 0 && count < 5) {
                    Thread.sleep(1000);
                    count1++;
                }
                if (driver.findElements((By.cssSelector("div[class='Nm9Fw']"))).size() != 0) {
                    WebElement likesVideo_ = driver.findElement(By.cssSelector("div[class='Nm9Fw']"));
                    likes = likesVideo_.findElement(By.cssSelector("span")).getText();
                    System.out.println("Likes " + likes);
                }
            }

            //get likes from video
            if (driver.findElements((By.cssSelector("span[class='vcOH2']"))).size() != 0){
                driver.findElements(By.cssSelector("span[class='vcOH2'][role='button']")).get(0).click();
                wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='vJRqr']")));
                WebElement likesVideo = driver.findElement(By.cssSelector("div[class='vJRqr']"));
                likes = likesVideo.findElement(By.cssSelector("span")).getText();
            }

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

                File file1 = new File("C:\\demo\\"+fileName+".xls");

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



            File file = new File("C:\\demo\\"+fileName+".xls");//E:/demo/employee2.xls
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


    }

    public void AddFileToExistExelFile(String fileName, int rownumToAdd) throws IOException {

        FileInputStream fsIP= new FileInputStream(new File("C:\\demo\\"+fileName+".xls"));//E:/demo/employee2.xls
//Access the workbook
        HSSFWorkbook wb = new HSSFWorkbook(fsIP);
//Access the worksheet, so that we can update / modify it.
        HSSFSheet worksheet = wb.getSheetAt(0);
// declare a Cell object
        Cell cell = null;
// Access the second cell in second row to update the value
        cell = worksheet.getRow(1).getCell(1);
// Get current cell value value and overwrite the value
        cell.setCellValue("OverRide existing value");

        Row row;
        row = worksheet.createRow(rownumToAdd);//2
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("hi");

//Close the InputStream
        fsIP.close();
//Open FileOutputStream to write updates
        FileOutputStream output_file =new FileOutputStream(new File("C:\\demo\\"+fileName+".xls"));
        //write changes
        wb.write(output_file);
//close the stream
        output_file.close();
    }

}
