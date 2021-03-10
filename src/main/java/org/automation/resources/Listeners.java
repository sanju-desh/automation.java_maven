package org.automation.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.*;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
    private static ExtentReports report = Reporter.getExtentReport();
    private static Logger log = LogManager.getLogger(Listeners.class.getName());
    ExtentTest test;
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult result) {
        test = report.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
        log.info(result.getName() + " test has started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, result.getMethod().getMethodName() + " test has passed");
        log.info(result.getName() + " test has passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().log(Status.FAIL, result.getMethod().getMethodName() + " test has failed");
        log.error(result.getName() + " test has failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().log(Status.SKIP, result.getMethod().getMethodName() + " test is skipped");
        log.info(result.getName() + " test is skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        log.error(result.getName() + " test has failed but will be reported as pass due to success %");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        log.error(result.getName() + " test has failed due to timeout");
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
        report.flush();
    }
}
