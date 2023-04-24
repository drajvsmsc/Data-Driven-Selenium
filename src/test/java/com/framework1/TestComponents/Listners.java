package com.framework1.TestComponents;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.resources.ExtentReport;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listners extends Intializedr implements ITestListener {

    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
    ExtentTest test;
    ExtentReports extent = ExtentReport.getReport();
    @Override
    public void onFinish(ITestContext context) {
        extent.flush();

    }

    @Override
    public void onStart(ITestContext context) {


    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("test got skipped bro");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
    }



    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS,"Test Passed");


    }

    @Override
    public void onTestStart(ITestResult result) {
       test= extent.createTest(result.getMethod().getMethodName());

    }
}

