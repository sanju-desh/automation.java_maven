package org.automation.resources;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    private static Logger log = LogManager.getLogger(Listeners.class.getName());

    @Override
    public void onTestStart(ITestResult result) {
        log.info(result.getName() + " test has started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info(result.getName() + " test has passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.error(result.getName() + " test has failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
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

    }
}
