package com.thetestingacademy.tests.vwoLogin.pageObjectModel_TestCase;

import com.thetestingacademy.Listeners.RetryAnalyzer_OneTimeCode;
import com.thetestingacademy.base.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.pages.pageObjectModel.vwo.improved_pom.P1_LoginPage;
import com.thetestingacademy.pages.pageObjectModel.vwo.normal.P2_DashBoardPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertiesReader;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Test(retryAnalyzer = RetryAnalyzer_OneTimeCode.class)
public class TestVWOLogin_07_Improved_POM_PropertyReader_Drivermanager_RetryListeners extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_07_Improved_POM_PropertyReader_Drivermanager_RetryListeners.class);  //log4j configuration

    @Owner("Apurba")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testLoginNegativeVWO() throws IOException, InterruptedException {
        //WebDriver driver = new EdgeDriver(); // WebDriver: Interface; driver= Object Reference; EdgeDriver(): Class; new EdgeDriver(): Object.

        logger.info("Starting the Testcases Page Object Model");

        P1_LoginPage LoginPage_VWO = new P1_LoginPage(DriverManager.getDriver()); // Object 1
        String error_msg = LoginPage_VWO.loginToVWOLogininValidCreds(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));
        //LoginPage_VWO.loginToVWOLogininValidCreds("admin@gmail.com", "123"); >> Return from this line is: "error_message_text"
        // Actually:: String error_msg = return value of error_message_text

        logger.info("End of the testLoginNegativeVWO!!!");

        //Assertion AssertJ
        assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
        //Assertion TestNG
        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message"));
    }

    @Owner("Apurba")
    @Description("Verify that valid creds dashboard page is loaded")
    @Test
    public void testLoginPositiveVWO() throws IOException, InterruptedException {
        //WebDriver driver = new EdgeDriver(); // WebDriver: Interface; driver= Object Reference; EdgeDriver(): Class; new EdgeDriver(): Object.

        logger.info("Starting the Testcases | Verify that valid creds dashboard page is loaded");

        //Execution: 1
        P1_LoginPage LoginPage_VWO = new P1_LoginPage (DriverManager.getDriver()); // Object 2
        LoginPage_VWO.loginToVWOLoginValidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        //Execution: 2
        P2_DashBoardPage dashBoardPage = new P2_DashBoardPage(DriverManager.getDriver());
        String usernameLoggedIn = dashBoardPage.loggedInUserName();

        logger.info("End and Asserting the output!!!");

        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        //Assert.assertEquals(usernameLoggedIn,PropertiesReader.readKey("expected_username"));
        Assert.assertEquals(usernameLoggedIn,"Apurba");  //>> This line for retry listeners
    }
}
