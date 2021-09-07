package com.shree.pages.flightpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ORFlightPage {

    @FindBy(xpath="//*[@id='root']//li[text()='Oneway']")
    public WebElement OneWayCheckbox;

    @FindBy(xpath="//*[@id='root']//span[text()='RETURN']")
    public WebElement returnBox;


}
