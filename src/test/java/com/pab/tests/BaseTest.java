package com.pab.tests;

import com.pab.reports.ExtentLogger;
import com.pab.reports.ExtentReport;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class BaseTest {

    @BeforeSuite
    public void setupSuite(){
        ExtentReport.initReport();
    }

    @AfterSuite
    public void tearDownSuite(){
        ExtentReport.tearDownReport();
    }

    @BeforeMethod
    public void setup(Method m){
        ExtentReport.createTest(m.getName());
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        if(!result.isSuccess()){
            ExtentLogger.fail(String.valueOf(result.getThrowable()));
        }

    }
}
