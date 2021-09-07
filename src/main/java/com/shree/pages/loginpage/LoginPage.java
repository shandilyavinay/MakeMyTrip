package com.shree.pages.loginpage;

import com.shree.framework.utility.WebUtil;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Map;

public class LoginPage extends ORLoginPage {
    WebDriver driver = WebUtil.driver;
    Map data = WebUtil.data;

    public void validLogin() throws InterruptedException {
        WebUtil.sendKeys(username, (String) data.get("username"));
        Thread.sleep(3000);
        WebUtil.Click(continueButton);
        WebUtil.Click(continueButton);
        WebUtil.sendKeys(password, (String) data.get("password"));
        Thread.sleep(3000);
        WebUtil.Click(LoginButton);

    }


}
