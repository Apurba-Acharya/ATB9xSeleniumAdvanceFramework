package com.thetestingacademy.pages.pageObjectModel.orangeHR;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class P1_LoginHRPage {
    WebDriver driver;

    public P1_LoginHRPage(WebDriver driver) {
        this.driver = driver;
    }

    // page locators
    private By username = By.xpath("//input[@placeholder='Username']");
    private By password = By.xpath("//input[@placeholder='Password']");
    private By submit_btn = By.xpath("//button[normalize-space()='Login']");

    //Page 2 - Page Actions:
    public void loginToHRCreads(String user, String pwd){
        driver.manage().deleteAllCookies();
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(submit_btn).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
