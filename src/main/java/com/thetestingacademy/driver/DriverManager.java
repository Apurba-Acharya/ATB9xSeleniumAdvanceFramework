package com.thetestingacademy.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.PropertiesReader;

import java.io.IOException;

public class DriverManager {
    public static WebDriver driver; //Webdriver instance

    //getter and setter
    public static WebDriver getDriver() {
        return driver;
    }
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    //When we want to start the browser
    public static void initializing_browser() throws IOException {
        String Browser = PropertiesReader.readKey("browser");
        Browser = Browser.toLowerCase();
        if (driver == null){ //driver = null means browser is not yet started
            switch (Browser){
                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--InPrivate");
                    driver = new EdgeDriver(edgeOptions);
                    driver.manage().window().maximize();
                    break;
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--Incognito");
                    driver = new ChromeDriver(chromeOptions);
                    driver.manage().window().maximize();
                    break;
                case "firefox":
                    FirefoxOptions firefoxDriver = new FirefoxOptions();
                    firefoxDriver.addArguments("--guest");
                    driver = new FirefoxDriver(firefoxDriver);
                    driver.manage().window().maximize();
                    break;
                default:
                    System.out.println("Not browser Found!!");
            }
        }
    }

    //When we want to close the browser
    public static void close_down(){
        if (driver != null){
            //driver.quit();
            driver = null;
        }
    }
}
