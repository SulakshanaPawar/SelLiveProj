package Utilities;

import TestCases.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ListenerClass implements ITestListener {
    ExtentSparkReporter html;
    ExtentReports report;
    ExtentTest test;

    BaseClass bs;
    public void setReports(){

        String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
        String ReportName ="Facebook"+timestamp+".html";
        html = new ExtentSparkReporter(System.getProperty("user.dir")+"//Reports//"+ReportName);
        report = new ExtentReports();
        report.attachReporter(html);

//----------setting environment
        report.setSystemInfo("Title","Facebook login");
        report.setSystemInfo("OS","Windows 11");
        report.setSystemInfo("browser","Chrome");
        report.setSystemInfo("created_By","Mona");


//----------report configuration-
        html.config().setDocumentTitle("Facebook report");
        html.config().setReportName("Facebook test report");
        html.config().setTheme(Theme.STANDARD);
//htmlreport.config().setTimeStampFormat("EEEE,MM,DD,hh:mm a '('zzz')'");



    }
    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Test execution is started");

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("test executed successfully");
        test =report.createTest(iTestResult.getName());
        test.log(Status.PASS, MarkupHelper.createLabel("Name of failed test case: "+ iTestResult.getName(), ExtentColor.GREEN));

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        test =report.createTest(iTestResult.getName());
        test.log(Status.FAIL, MarkupHelper.createLabel("Name of failed test case: "+ iTestResult.getName(), ExtentColor.RED));
        bs=new BaseClass();
        try {
            bs.Capture_Screenshot(BaseClass.driver,iTestResult.getName());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        test =report.createTest(iTestResult.getName());
        test.log(Status.SKIP, MarkupHelper.createLabel("Name of failed test case: "+ iTestResult.getName(), ExtentColor.YELLOW));

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }


    @Override
    public void onStart(ITestContext iTestContext) {
        setReports();
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        report.flush();
    }
}
