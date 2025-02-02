package com.pages_CucumberMiniProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    // By Locators
    private By emailInputLocator = By.name("email");
    private By passwordInputLocator = By.name("password");
    private By loginButtonLocator = By.xpath("//input[@type='submit']");
    private By forgottenPasswordLinkLocator = By.linkText("Forgotten Password");
    private By logoutLinkLocator = By.linkText("Logout");


    // Parameterized Constructor
    public LoginPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        Thread.sleep(5000);
    }

    // Page Methods/Actions
    public void enterEmail(String email) throws InterruptedException {
        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.sendKeys(email);
        Thread.sleep(5000);
    }

    public void enterPassword(String password) throws InterruptedException {
        WebElement passwordInput = driver.findElement(passwordInputLocator);
        passwordInput.sendKeys(password);
        Thread.sleep(5000);
    }

    public void clickLoginButton() throws InterruptedException {
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
        Thread.sleep(5000);

    }

    public void clickForgottenPasswordLink() throws InterruptedException {
        WebElement forgottenPasswordLink = driver.findElement(forgottenPasswordLinkLocator);
        forgottenPasswordLink.click();
        Thread.sleep(5000);

    }

    public boolean checkForgotPwdLink() {
        return driver.findElement(forgottenPasswordLinkLocator).isDisplayed();

    }

    public boolean checkLogoutLink(){
        return driver.findElement(logoutLinkLocator).isDisplayed();
    }

    public void login(String email, String password) throws InterruptedException {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    public String getForgotPwdPageUrl() {
        String forgotPwdPageUrl = driver.getCurrentUrl();
        return forgotPwdPageUrl;

    }


}
