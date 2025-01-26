package com.thetestingacademy.pages.pageObjectModel.vwo.normal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P2_DashBoardPage {
    WebDriver driver; //Attributes

    //Step 1 - Page Locators:
    public P2_DashBoardPage(WebDriver driver) { //Parameterized constructor
        this.driver = driver;
    }
    By userOnDashboard = By.xpath("//span[@data-qa = \"lufexuloga\"]");

    //Page Actions
    public String loggedInUserName(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.findElement(userOnDashboard).getText();
    }
}
