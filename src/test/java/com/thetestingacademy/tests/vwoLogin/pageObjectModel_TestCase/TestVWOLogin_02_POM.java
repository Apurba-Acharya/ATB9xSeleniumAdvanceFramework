package com.thetestingacademy.tests.vwoLogin.pageObjectModel_TestCase;

import com.thetestingacademy.pages.pageObjectModel.vwo.normal.P1_LoginPage;
import com.thetestingacademy.pages.pageObjectModel.vwo.normal.P2_DashBoardPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_02_POM {
    @Owner("Apurba")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testLoginNegativeVWO() throws IOException {
        WebDriver driver = new EdgeDriver(); // WebDriver: Interface; driver= Object Reference; EdgeDriver(): Class; new EdgeDriver(): Object.

        P1_LoginPage LoginPage_VWO = new P1_LoginPage(driver); // Object 1
        String error_msg = LoginPage_VWO.loginToVWOLogininValidCreds("admin@gmail.com", "123");
        //LoginPage_VWO.loginToVWOLogininValidCreds("admin@gmail.com", "123"); >> Return from this line is: "error_message_text"
        // Actually:: String error_msg = return value of error_message_text

        assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg, "Your email, password, IP address or location did not match");

        driver.quit();
    }

    @Owner("Apurba")
    @Description("Verify that valid creds dashboard page is loaded")
    @Test
    public void testLoginPositiveVWO() throws IOException {
        WebDriver driver = new EdgeDriver(); // WebDriver: Interface; driver= Object Reference; EdgeDriver(): Class; new EdgeDriver(): Object.

        //Execution: 1
        P1_LoginPage LoginPage_VWO = new P1_LoginPage (driver); // Object 2
        LoginPage_VWO.loginToVWOLogininValidCreds("contact+aug@thetestingacademy.com","TtxkgQ!s$rJBk85");

        //Execution: 2
        P2_DashBoardPage dashBoardPage = new P2_DashBoardPage(driver);
        String usernameLoggedIn = dashBoardPage.loggedInUserName();
        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,"Aman");
    }
}
