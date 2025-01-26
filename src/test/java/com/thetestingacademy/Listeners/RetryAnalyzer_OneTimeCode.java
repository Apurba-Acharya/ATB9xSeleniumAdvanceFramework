package com.thetestingacademy.Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer_OneTimeCode implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int maxRetryCount =3;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (retryCount < maxRetryCount){
            retryCount++;
            return true;
        }
        return false;
    }
}
