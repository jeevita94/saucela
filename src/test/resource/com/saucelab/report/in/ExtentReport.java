package com.saucelab.report.in;


	

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.saucelab.base.in.DriverManager;
import com.saucelab.utility.in.Takescreenshoot;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
	import org.testng.ITestResult;
	public class ExtentReport implements ITestListener{


	    private ExtentReports extent;
	    private ExtentTest test;
	    Takescreenshoot shott;

	    @Override
	    public void onStart(org.testng.ITestContext context) {
	        ExtentSparkReporter reporter =
	                new ExtentSparkReporter("extentreport/ExtentReport.html");

	        extent = new ExtentReports();
	        extent.attachReporter(reporter);
	    }

	    @Override
	    public void onTestStart(ITestResult result) {
	        test = extent.createTest(result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        test.pass("Test Passed");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	    	test.fail("Test Failed");
	        test.fail(result.getThrowable());

	        try {
	            String screenshot =
	                    ((TakesScreenshot) DriverManager.getDriver())
	                    .getScreenshotAs(OutputType.BASE64);

	            test.addScreenCaptureFromBase64String(
	                    screenshot,
	                    "Failure Screenshot"
	            );

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        test.skip("Test Skipped");
	    }

	    @Override
	    public void onFinish(org.testng.ITestContext context) {
	        extent.flush();
	    }
	}


