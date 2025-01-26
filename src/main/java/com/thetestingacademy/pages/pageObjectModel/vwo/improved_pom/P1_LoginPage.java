package com.thetestingacademy.pages.pageObjectModel.vwo.improved_pom;

import com.thetestingacademy.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertiesReader;

import java.io.IOException;

public class P1_LoginPage extends CommonToAllPage {

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
    public String loginToVWOLogininValidCreds(String user, String pwd) throws IOException, InterruptedException { //Method: Return type with arguments
        openVWOUrl();
        //driver.get(PropertiesReader.readKey("url"));
        enterinput(username, user);
        //driver.findElement(username).sendKeys(user);
        enterinput(password, pwd);
        //driver.findElement(password).sendKeys(pwd);
        clickElement(signButton);
        custom_wait();
        //driver.findElement(signButton).click();

        //Wait mechanism:
        //Thread.sleep(3000);
        presenceOfElement(error_message);
//        String error_message_text = driver.findElement(error_message).getText();
        return getText(error_message);
//        return error_message_text;
    }

    //Valid Credentials:
    public void loginToVWOLoginValidCreds(String user, String pwd) throws IOException, InterruptedException { //Method: No return type with arguments
        openVWOUrl();
        //driver.get(PropertiesReader.readKey("url"));
        enterinput(username, user);
        //driver.findElement(username).sendKeys(user);
        enterinput(password, pwd);
        //driver.findElement(password).sendKeys(pwd);
        clickElement(signButton);
        //driver.findElement(signButton).click();

        //Wait mechanism:
        custom_wait();
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }
}
