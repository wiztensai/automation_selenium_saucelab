package core.reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.util.HashMap;
import java.util.Map;

public class MyExtentReport {
    private static ExtentReports extent;
    private static Map extentTestMap = new HashMap();

    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter("reports/index.html");
            reporter.config().setDocumentTitle("Swag Labs Web Automation");
            reporter.config().setReportName("Smoke Test");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Project Name", "Swag Labs Demo Website");
            extent.setSystemInfo("Domain", "https://www.saucedemo.com");
            extent.setSystemInfo("Product Description", "Sauce Labs is the only cloud-based continuous testing platform that enables developers to run their automated tests across desktops, emulators, simulators and real devices, using Selenium, Appium, Espresso or XCUITest");
            extent.setSystemInfo("Project Description", "Automation test using multiple browser: Chrome, Firefox, & Edge");
            extent.setSystemInfo("Project Type", "Smoke Testing");
        }

        return extent;
    }

    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = getReporter().createTest(testName, desc);
        extentTestMap.put((int)(Thread.currentThread().getId()), test);

        return test;
    }

    public static synchronized ExtentTest getTest() {
        return (ExtentTest) extentTestMap.get((int)(Thread.currentThread()).getId());
    }

    public static synchronized void updateReport() {
        MyExtentReport.extent.flush();
    }
}
