package com.shree.pages.flightpage;

import com.shree.framework.utility.WebUtil;

public class FlightPage extends ORFlightPage {

public void clickOnewayCheckbox(){

    if(OneWayCheckbox.isSelected()==false){
        WebUtil.Click(OneWayCheckbox);
    }else if(OneWayCheckbox.isSelected()==true) {
        System.out.println("Checkbox is already selected");
    }

}

public void verifyReturnBox(){

    if(returnBox.isEnabled()==true){
        System.out.println("Return Box Is Not Disabled : Test Failed");

    }else if(returnBox.isEnabled()==true){
        System.out.println("Return Box is Disabled : Test passed");
    }

}
}
