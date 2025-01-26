package com.thetestingacademy.tests.OrageHR;

import com.thetestingacademy.pages.pageObjectModel.orangeHR.P1_LoginHRPage;
import com.thetestingacademy.pages.pageObjectModel.orangeHR.P2_EmployeeListHomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestOrangeHR_POM {
    @Owner("Apurba")
    @Description("Verify that the login to the OrangeHR")
    @Test
    public void testLoginPositive(){
        WebDriver driver = new ChromeDriver();
        P1_LoginHRPage loginHRPage = new P1_LoginHRPage(driver);
        loginHRPage.loginToHRCreads("admin", "Hacker@4321");

        P2_EmployeeListHomePage dashboardPagePom  = new P2_EmployeeListHomePage(driver);
        String loggedInUserName = dashboardPagePom.loggedInUserName();
        assertThat (loggedInUserName).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(loggedInUserName, "PIM");
    }
}
