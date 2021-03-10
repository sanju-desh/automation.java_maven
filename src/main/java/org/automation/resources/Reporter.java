package org.automation.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporter {
    private static ExtentReports extent = new ExtentReports();
    public static ExtentReports getExtentReport() {
        String path = System.getProperty("user.dir") + "/reports/index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setDocumentTitle("Automation");
        reporter.config().setReportName("Test Report");
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Automation");
        return extent;
    }
}
