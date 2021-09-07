package com.shree.testcases;

import com.shree.framework.utility.WebUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestCase_TC_11 {
    WebDriver driver;

    @Test
    public void Validate_Login() {
        driver = WebUtil.BrowserLaunch("firefox");
        WebUtil.OpenUrl("https://www.gmail.com");

    }


}
