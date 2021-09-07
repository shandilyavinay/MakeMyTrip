package com.shree.framework.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WebUtil {


    public static Map<String,String> data;
    public static WebDriver driver;
    private static Workbook workbook;

    public static WebDriver BrowserLaunch(String BrowserName) {

        if (BrowserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();

        } else if (BrowserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "./src/main/resources/drivers/geckodriver.exe");
            driver = new FirefoxDriver();

        } else if (BrowserName.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "./src/main/resources/drivers/IEDriverServer.exe");
            driver = new InternetExplorerDriver();

        } else {
            System.out.println("Browser Name is Wrong");
        }

        driver.manage().window().maximize();
        return driver;

    }



    public static void sendKeys(WebElement element,String value){
        element.sendKeys(value);
    }

    public static void Click(WebElement element){
        element.click();
    }

    public static void OpenUrl(String url) {

        driver.get(url);
    }

    public static Map getExcelData(String TestCaseId, String SheetName) throws IOException {
        String filepath = "./src/main/resources/TestData/TestData.xlsx";
        FileInputStream fls = new FileInputStream(new File(filepath));

        if (filepath.contains("xlsx") == true) {
            workbook = new XSSFWorkbook(fls);
        } else if (filepath.contains("xls") == true) {
            workbook = new HSSFWorkbook(fls);
        }
        Sheet sheet = workbook.getSheet(SheetName);
        int rowSize = sheet.getLastRowNum();
        data = new HashMap<String, String>();
        Row row;
        int desiredRow = 0;
        for (int i = 0; i <= rowSize; i++) {

            row = sheet.getRow(i);
            Cell cell = row.getCell(0);
            if (cell.getStringCellValue().equalsIgnoreCase(TestCaseId)) {
                desiredRow = i;
                break;
            }
        }
        Row row1 = sheet.getRow(desiredRow);
        int cellSize = row1.getLastCellNum();
        for (int j = 1; j <= cellSize; j = j + 2) {
            Cell cell = row1.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            String FieldName = cell.getStringCellValue();

            Cell cell2 = row1.getCell(j + 1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            String FieldValue = cell2.getStringCellValue();

            data.put(FieldName, FieldValue);
        }
        return data;

    }


    public static ExtentTest extentReport(String testname, String Description) {
        ExtentHtmlReporter reporter = new ExtentHtmlReporter(".Reports/reporter.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        ExtentTest logger = extent.createTest(testname, Description);
        extent.flush();
        return logger;


    }

}
