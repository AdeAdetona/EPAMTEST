package Utility;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentTest;


public class ReportManager {
	
	private static ExtentReports extent;
    private static ExtentTest test;

    public static void setUpReport() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("extentReport.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

    public static void createTest(String testName) {
        test = extent.createTest(testName);
    }

    public static ExtentTest getTest() {
        return test;
    }

    public static void tearDownReport() {
        extent.flush();
    }

}
