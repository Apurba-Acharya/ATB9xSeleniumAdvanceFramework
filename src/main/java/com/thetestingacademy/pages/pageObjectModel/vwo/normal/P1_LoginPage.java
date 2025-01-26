package com.thetestingacademy.pages.pageObjectModel.vwo.normal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertiesReader;

import java.io.IOException;

public class P1_LoginPage {

    WebDriver driver; //Attributes
    public P1_LoginPage(WebDriver driver) { //Parameterized constructor
        this.driver = driver;
    }

    //Page Class = Page Locators + Page Actions
    //Step 1 - Page Locators:
    private By username = By.xpath("//input[@id='login-username']"); //Encapsulation
    private By password = By.xpath("//input[@id='login-password']"); //Encapsulation
    private By signButton = By.xpath("//button[@id='js-login-btn']"); //Encapsulation
    private By error_message = By.xpath("//div[@id='js-notification-box-msg']"); //Encapsulation

    //Page 2 - Page Actions:
    //Invalid Credentials:
    public String loginToVWOLogininValidCreds(String user, String pwd) throws IOException { //Method: Return type with arguments
        driver.get(PropertiesReader.readKey("url"));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();

        //Wait mechanism:
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String error_message_text = driver.findElement(error_message).getText();
        return error_message_text;
    }

    //Valid Credentials:
    public void loginToVWOLoginValidCreds(String user, String pwd) throws IOException { //Method: No return type with arguments
        driver.get(PropertiesReader.readKey("url"));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();

        //Wait mechanism:
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
