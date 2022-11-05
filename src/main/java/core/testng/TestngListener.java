package core.testng;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import core.driver.AppDriver;
import core.reporter.MyExtentReport;
import core.reporter.ExtentUtil;
import core.util.ActionUtil;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestngListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        var deviceName = TestngUtil.getXmlParam(result, "deviceName");
        MyExtentReport.startTest(result.getName(), result.getMethod().getDescription())
                .assignCategory(deviceName)
                .assignAuthor("Nanang Fitrianto");

        var threadId = Thread.currentThread().getId();
        System.out.println(result.getName()+" threadId "+threadId);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentUtil.logPass();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        var ss = ActionUtil.takeScreenshot(AppDriver.getDriver());
        var media = MediaEntityBuilder.createScreenCaptureFromBase64String(ss).build();

        ExtentUtil.logFail(media);
        ExtentUtil.logFail(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        MyExtentReport.updateReport();
    }
}