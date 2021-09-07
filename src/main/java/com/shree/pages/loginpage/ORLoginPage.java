package com.shree.pages.loginpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ORLoginPage {

    @FindBy(xpath = "//*[@id='username']")
    public WebElement username;

    @FindBy(xpath="//*[text()='Continue']")
    public WebElement continueButton;

    @FindBy(xpath="//*[@id='password']")
    public WebElement password;

    @FindBy(xpath="//*[@id='SW']//span[text()='Login']")
    public WebElement LoginButton;


}
