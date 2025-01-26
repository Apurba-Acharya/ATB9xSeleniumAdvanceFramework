package com.thetestingacademy.tests.vwoLogin.pageObjectModel_TestCase;

import com.thetestingacademy.base.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.pages.pageObjectModel.vwo.normal.P1_LoginPage;
import com.thetestingacademy.pages.pageObjectModel.vwo.normal.P2_DashBoardPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertiesReader;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_04_POM_PropertyReader_Drivermanager extends CommonToAllTest {
    @Owner("Apurba")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testLoginNegativeVWO() throws IOException {
        //WebDriver driver = new EdgeDriver(); // WebDriver: Interface; driver= Object Reference; EdgeDriver(): Class; new EdgeDriver(): Object.

        P1_LoginPage LoginPage_VWO = new P1_LoginPage(DriverManager.getDriver()); // Object 1
        String error_msg = LoginPage_VWO.loginToVWOLogininValidCreds(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));
        //LoginPage_VWO.loginToVWOLogininValidCreds("admin@gmail.com", "123"); >> Return from this line is: "error_message_text"
        // Actually:: String error_msg = return value of error_message_text

        //Assertion AssertJ
        assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
        //Assertion TestNG
        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message"));
    }

    @Owner("Apurba")
    @Description("Verify that valid creds dashboard page is loaded")
    @Test
    public void testLoginPositiveVWO() throws IOException {
        //WebDriver driver = new EdgeDriver(); // WebDriver: Interface; driver= Object Reference; EdgeDriver(): Class; new EdgeDriver(): Object.

        //Execution: 1
        P1_LoginPage LoginPage_VWO = new P1_LoginPage (DriverManager.getDriver()); // Object 2
        LoginPage_VWO.loginToVWOLoginValidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        //Execution: 2
        P2_DashBoardPage dashBoardPage = new P2_DashBoardPage(DriverManager.getDriver());
        String usernameLoggedIn = dashBoardPage.loggedInUserName();

        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,PropertiesReader.readKey("expected_username"));
    }
}
