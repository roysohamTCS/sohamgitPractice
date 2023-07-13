package listeners;

import Configurations.CaptureScreenShot;
import Configurations.ExtentReport;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.IOException;


public class MyListeners extends CaptureScreenShot implements ITestListener
{
    ExtentReports report = ExtentReport.getExtentReport();

    public static ExtentTest eTest;
    public MyListeners() throws IOException
    {

    }

    public void onTestStart(ITestResult result)
    {
        String TestName = result.getMethod().getDescription();
        eTest = report.createTest(TestName);
    }

    public void onTestSuccess(ITestResult result){
        String TestName = result.getMethod().getDescription();
    }

    public void onTestFailure(ITestResult result) {

        String TestName = result.getMethod().getDescription();
        eTest.log(Status.FAIL, TestName);
        eTest.log(Status.FAIL,result.getThrowable());

        //Code to Capture ScreenShot if Test Case Fails
        try {
            Thread.sleep(10000);
            eTest.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(takeFailScreenShot(TestName), TestName).build());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void onTestSkipped(ITestResult result){
        String TestName = result.getMethod().getDescription();
        eTest.log(Status.SKIP,TestName);
    }

    public void onFinish(ITestContext context)
    {
        report.flush();
    }



}
