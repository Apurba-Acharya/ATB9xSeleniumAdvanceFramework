package com.thetestingacademy.tests.vwoLogin.pageFactory_TestCase;

import com.thetestingacademy.base.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.pages.pageFactory.LoginPage_PF;
import com.thetestingacademy.tests.vwoLogin.pageObjectModel_TestCase.TestVWOLogin_07_Improved_POM_PropertyReader_Drivermanager_RetryListeners;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertiesReader;

import java.io.IOException;

public class TestVWOLogin_PF extends CommonToAllTest {
    private static final Logger logger = LogManager.getLogger(TestVWOLogin_07_Improved_POM_PropertyReader_Drivermanager_RetryListeners.class);  //log4j configuration

    @Test
    public void testLoginNegativeVWO_PF() throws IOException, InterruptedException {
        logger.info("Starting the Testcases Page Object Model");
        WebDriver driver = DriverManager.getDriver();
        driver.get(PropertiesReader.readKey("url"));
        LoginPage_PF loginPagePf = new LoginPage_PF(driver);
        String error_msg = loginPagePf.loginToVWOInvalidCre();
        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message"));

    }
}
