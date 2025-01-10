package com.apurba.in.sample.tests.sample;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSample {
    @Description("Sample TC 1")
    @Test
    public void testsample1(){
        Assert.assertTrue(true);
    }
    @Description("Sample TC 1")
    @Test
    public void testsample2(){
        Assert.assertTrue(true);
    }
}
