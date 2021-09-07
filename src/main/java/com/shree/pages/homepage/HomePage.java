package com.shree.pages.homepage;

import com.shree.framework.utility.WebUtil;

public class HomePage extends ORHomepage {


public void clickOnLogin(){

    WebUtil.Click(loginOrCreateButton);

}

public void clickOnSearchIcon(){
    WebUtil.Click(searchIcon);

}

public void clickOnFlight(){
    WebUtil.Click(FlightLink);
}

}
