package core.testng;

import org.testng.ITestResult;

public class TestngUtil {
    /**
     * @param result: from testng listener
     * @param param: param from testng xml
     * @return
     */
    static public String getXmlParam(ITestResult result, String param) {
        return result.getTestContext().getCurrentXmlTest().getParameter(param);
    }
}
