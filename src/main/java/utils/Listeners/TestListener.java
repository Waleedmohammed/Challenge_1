package utils.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    public void onStart(ITestContext iTestContext) {
        System.out.println("+Begin test: " + iTestContext.getName());
    }

    public void onTestStart(ITestResult iTestResult) {
        System.out.println(" Starting test: " + iTestResult.getName());
    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println(" Test passed: " + iTestResult.getName());
    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println(" Test failed: " + iTestResult.getName());
    }

    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println(" Test ignored: " + iTestResult.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onFinish(ITestContext iTestContext) {
        System.out.println("-End test: " + iTestContext.getName());
    }
}
