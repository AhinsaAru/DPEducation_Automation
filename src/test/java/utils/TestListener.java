package utils;

import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    // Single ExtentReports instance
    private static ExtentReports extent = ExtentManager.getExtent();

    // Thread-safe ExtentTest for parallel execution
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        if (test.get() != null) {
            test.get().pass("Test Passed");
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {

        Object testClass = result.getInstance();

        if (testClass instanceof BaseTest) {
            BaseTest baseTest = (BaseTest) testClass;

            // Take screenshot using the getter
            String screenshotPath = ScreenshotUtils.takeScreenshot(
                    baseTest.getDriver(),
                    result.getName()
            );

            // Log the exception
            if (test.get() != null) {
                test.get().fail(result.getThrowable());

                // Attach screenshot if available
                if (screenshotPath != null) {
                    try {
                        test.get().addScreenCaptureFromPath(screenshotPath);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        if (test.get() != null) {
            test.get().skip("Test Skipped");
        }
    }

    @Override
    public void onStart(ITestContext context) {
        // Nothing to do here
    }

    @Override
    public void onFinish(ITestContext context) {
        if (extent != null) {
            extent.flush();
        }
    }
}
