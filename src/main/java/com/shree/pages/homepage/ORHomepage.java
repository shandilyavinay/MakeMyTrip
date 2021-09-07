package com.shree.pages.homepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ORHomepage {

    @FindBy(xpath = "//*[@id='stickyScroll']/li[1]/a")
    public WebElement searchIcon;

    @FindBy(xpath = "//*[@id='SW']//p[text()=' Login or Create Account']")
    public WebElement loginOrCreateButton;

    @FindBy(xpath="//*[@id='SW']//span[text()='Flights']")
    public WebElement FlightLink;


}
