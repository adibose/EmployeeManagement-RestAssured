package com.pab.reports;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public final class ExtentLogger {

    ExtentLogger(){}

    public static void fail(String message){
        ExtentManager.getTest().fail(message);
    }

    public static void logResponse(String message){
        ExtentManager.getTest().pass(MarkupHelper.createCodeBlock(message, CodeLanguage.JSON));
    }
}
