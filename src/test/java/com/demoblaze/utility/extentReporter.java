package com.demoblaze.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.demoblaze.base.listener;
import com.sun.management.OperatingSystemMXBean;
import java.io.File;
import java.lang.management.ManagementFactory;
import java.text.SimpleDateFormat;
import java.util.Date;

public class extentReporter extends listener {

    static final String userName = (System.getProperty("user.name"));
    static final String OS = (System.getProperty("os.name"));
    static final String app = "demoblaze.com";
    static final String javaVersion = (System.getProperty("java.runtime.version").substring(0, 6));
    static ExtentSparkReporter reporter;
    static ExtentReports extent;

    public static ExtentReports ReportGenerator() {
        String filename = getReportName();
        String directory = "./Automation Reports/";
        new File(directory).mkdirs();
        String path = directory + filename; // File Directory/Title
        reporter = new ExtentSparkReporter(path);
        reporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a");
        reporter.config().setReportName("GoFiber Web Automation Results");
        reporter.config().setDocumentTitle("GoFiber Web Test Results");
        reporter.config().setDocumentTitle("Test Results");
        reporter.config().setTheme(Theme.DARK);
        reporter.config().setEncoding("UTF-8");
        reporter.config().setProtocol(Protocol.HTTPS);

        extent = new ExtentReports();
        extent.attachReporter(reporter);

        // System/Environment
        extent.setSystemInfo("QA Name", "Software Quality Engineer: "+ userName);
        extent.setSystemInfo("Application Used", app);
        extent.setSystemInfo("Java Version", javaVersion);
        extent.setSystemInfo("OS Version", OS);
        extent.setSystemInfo("RAM", String.valueOf(totalRAMGB) + " GB");
        extent.setSystemInfo("IDE", "IntelliJ");
        return extent;

    }

    public static String getReportName() {

        SimpleDateFormat sdf = new SimpleDateFormat("E MMM d yyyy hh:mm");
        Date d = new Date();
        String setDate = sdf.format(d);
        String filename = "Report_" + setDate.replace(":", "-").replace(" ", "_") + ".html";
        return filename;

    }

    static long totalRAMBytes = getTotalRAM();
    public static double totalRAMGB = bytesToGB(totalRAMBytes);

    private static long getTotalRAM() {
        OperatingSystemMXBean osBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        return osBean.getTotalMemorySize();
    }
    private static double bytesToGB(long bytes) {
        return bytes / (1024.0 * 1024.0 * 1024.0);
    }
}

