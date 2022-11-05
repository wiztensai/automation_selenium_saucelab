package core.reporter;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;

public class ExtentUtil {
    static public void logInfo(String msg) {
        MyExtentReport.getTest().log(Status.INFO,msg);
    }

    static public void logPass() {
        MyExtentReport.getTest().log(Status.PASS,"Test Passed");
    }

    static public void logFail(Throwable t ) {
        MyExtentReport.getTest().log(Status.FAIL,t);
    }

    static public void logFail(String s) {
        MyExtentReport.getTest().log(Status.FAIL,s);
    }

    static public void logFail(Media media) {
        MyExtentReport.getTest().log(Status.FAIL,media);
    }

    static public void setCategory(String... category) {
        MyExtentReport.getTest().assignCategory(category);
    }
}
