package com.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {


    public static ExtentReports getReport(){
        String path = System.getProperty("user.dir")+"//reports//index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Automation results");
        reporter.config().setDocumentTitle("Results");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Rajvsmsc");
        return extent;

    }
}
