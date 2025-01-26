package com.thetestingacademy.pages.pageObjectModel.vwo.improved_pom;

import com.thetestingacademy.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P2_DashBoardPage extends CommonToAllPage {
    WebDriver driver; //Attributes

    //Step 1 - Page Locators:
    public P2_DashBoardPage(WebDriver driver) { //Parameterized constructor
        this.driver = driver;
    }
    By userNameOnDashboard = By.xpath("//span[@data-qa = \"lufexuloga\"]");

    //Page Actions
    public String loggedInUserName(){
        visibilityOfElement(userNameOnDashboard);
//        try {
//            Thread.sleep(20000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        return getText(userNameOnDashboard);
//        return driver.findElement(userNameOnDashboard).getText();
    }
}
