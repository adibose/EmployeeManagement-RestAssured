package com.pab.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ExtentReport {

    private ExtentReport(){
    }
    private static ExtentReports extent;

    private static ExtentTest test;

    public static void initReport(){
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
        extent.attachReporter(spark);
    }

    public static void tearDownReport(){
        extent.flush();
    }

    public static void createTest(String name) {
        test = extent.createTest(name);
        ExtentManager.setTest(test);
    }
}
