package Configurations;

import Base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.IOException;

import static Base.BaseTest.*;

public class ExtentReport extends BaseTest
{
    public static ExtentReports report;
    public static ExtentSparkReporter sparkReporter;
    public static ExtentTest test;
    public static ExtentReports getExtentReport() throws IOException
    {
        report = new ExtentReports();
        File extentReportFile = new File(System.getProperty("user.dir")+"\\src\\test\\Test Report\\Test Execution Report.html");
        sparkReporter = new ExtentSparkReporter(extentReportFile);
        report.attachReporter(sparkReporter);
        sparkReporter.loadJSONConfig(new File(System.getProperty("user.dir")+"\\src\\test\\java\\Configurations\\spark-config.json"));
        sparkReporter.config().setDocumentTitle("IRTH Automation Test Report");
        sparkReporter.config().setReportName("IRTH - Automation Test Report");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setEncoding("utf-8");
        return report;
    }
}