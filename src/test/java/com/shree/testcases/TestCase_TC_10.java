package com.shree.testcases;

import com.shree.framework.utility.WebUtil;
import com.shree.pages.homepage.HomePage;
import com.shree.pages.loginpage.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class TestCase_TC_10 {
    WebDriver driver;
    Map data;

    @BeforeClass
    public void getinstance() throws IOException {
        data = WebUtil.getExcelData("TC_10", "Sheet1");
        driver=WebUtil.BrowserLaunch((String) data.get("BrowserName"));
        System.out.println("HI");
        WebUtil.OpenUrl((String) data.get("url"));
    }

    

    @Test
    public void VerifyCheckbox() throws InterruptedException {

        
        HomePage homepage = PageFactory.initElements(driver, HomePage.class);
        homepage.clickOnLogin();
        LoginPage login = PageFactory.initElements(driver, LoginPage.class);
        login.validLogin();
        homepage.clickOnSearchIcon();
        homepage.clickOnFlight();


    }


}
