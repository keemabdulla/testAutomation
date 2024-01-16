package com.demoblaze.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.demoblaze.utility.extentReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class listener implements ITestListener {

    public static String path = "./Automation Reports/";
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
    // Screenshot Set Up
    static SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy HH");
    static Date d = new Date();
    static String setDate = sdf.format(d);
    public static String dateName = setDate.replace(" ", "_");
    private static final ExtentReports extent = extentReporter.ReportGenerator();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getMethod().getMethodName()); // Test

        extentTest.set(test);
    }

    @Override
    public void onFinish(ITestContext context) {

        double totalTC = context.getPassedTests().size() + context.getFailedTests().size() + context.getSkippedTests().size();
        int TCCount = (int) totalTC;
        int TCPassed = context.getPassedTests().size();
        System.out.println("Total Number of Executed Tests: "+ TCCount);
        System.out.println("Passed Tests: "+ TCPassed);
        double percentage = (TCPassed/totalTC) * 100;
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Percentage of Passed Tests: " + df.format(percentage) + "%");
        extent.flush();

    }

    @Override
    public void onTestFailure(ITestResult result) {

        String methodName = result.getMethod().getMethodName();
        String exceptionMessage = result.getThrowable().getMessage();
        extentTest.get().fail("<details><summary><b><font color=red>" + "Exception Occured, click to see details:"
                + "</font></b></summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details> \n");
        System.out.println(exceptionMessage.replaceAll(",", "<br>"));
        WebDriver driver = null;

        String path2 = "./";
        String path = "./Automation Reports/";
        String ScreenshotNames = (path + methodName);
        Object testObject = result.getInstance();
        Class clazz = result.getTestClass().getRealClass();
        try {
            driver = (WebDriver) clazz.getField("driver").get(testObject);
        } catch (Exception e1) {
            // TODO Auto-generated catch block

        }
        try {
            File scrnshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrnshot, new File(ScreenshotNames + "_" + dateName + ".png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        extentTest.get().fail("<b><font color=red>" + "Screenshot of failure" + "</font></b>",
                MediaEntityBuilder.createScreenCaptureFromPath(path2 + methodName + "_" + dateName + ".png").build());

        driver.quit();

        String logText = "<b>" + methodName + " Failed</b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
        extentTest.get().log(Status.FAIL, m);

    }
}
