package com.thetestingacademy.pages.pageFactory;

import com.thetestingacademy.base.CommonToAllPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PropertiesReader;

import java.awt.print.PageFormat;
import java.io.IOException;

public class LoginPage_PF extends CommonToAllPage {

    //Page Locators
    public LoginPage_PF(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="login-username")
    private WebElement username;

    @FindBy(id="login-password")
    private WebElement password;

    @FindBy(id = "js-login-btn")
    private WebElement signButton;

    @FindBy(css = "#js-notification-box-msg")
    private WebElement  error_message;

    //Page Actions
    public String loginToVWOInvalidCre() throws IOException, InterruptedException {
        enterinput(username, PropertiesReader.readKey("invalid_username"));
        enterinput(password, PropertiesReader.readKey("invalid_password"));
        clickElement(signButton);
        Thread.sleep(3000);
        return getText(error_message);

    }
}
