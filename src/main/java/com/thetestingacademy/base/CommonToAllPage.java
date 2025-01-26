package com.thetestingacademy.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertiesReader;

import java.io.IOException;
import java.time.Duration;

import static com.thetestingacademy.driver.DriverManager.driver;
import static com.thetestingacademy.driver.DriverManager.getDriver;

public class CommonToAllPage {
    //If you want to call something before every page object class call, put your code here
    //OPEN file, open database connection you can write code here

    //Method Overloading >

    public void openVWOUrl() throws IOException {
        getDriver().get(PropertiesReader.readKey(("url")));
    }

    public void custom_wait(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickElement(By by) {
        getDriver().findElement(by).click();
    }

    public void clickElement(WebElement by) {
        by.click();
    }

    //Method Overloading >
    public void enterinput(By by, String email) {
        getDriver().findElement(by).sendKeys(email);
    }

    public void enterinput(WebElement by, String key) {
        by.sendKeys(key);
    }

    public String getText(By by) {
       return getDriver().findElement(by).getText();
    }
    public String getText(WebElement by) {
        return by.getText();
    }

    public WebElement presenceOfElement(By elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    public WebElement visibilityOfElement(By elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));

    }
    public WebElement getElement (By key){
        return  getDriver().findElement(key);
    }
}

