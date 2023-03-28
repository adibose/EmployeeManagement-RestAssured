package com.pab.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.Test;

public class ExtentReportDemo {

    @Test
    public void extentTest(){
        //Before Suite
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
        extent.attachReporter(spark);

        ExtentTest test  = extent.createTest("MyFirstTest");
        test.log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");

        ExtentTest test1  = extent.createTest("MySecondTest");
        test1.log(Status.PASS, "This is a logging event for MySecondTest, and it passed!");

        //After suite
        extent.flush();

    }
}
