package com.thetestingacademy.base;

import com.thetestingacademy.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
public class CommonToAllTest {
    @BeforeMethod
    public void setup() throws IOException {
        DriverManager.initializing_browser();
    }

    @AfterMethod
    public  void  tearDown(){
        DriverManager.close_down();
    }
}
