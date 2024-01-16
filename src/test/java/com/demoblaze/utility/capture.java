package com.demoblaze.utility;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Media;
import com.demoblaze.base.listener;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class capture extends listener {

    public static void screenPass(WebDriver driver, String className) throws IOException {

        String directory = "./";
        String ScreenshotNames = (path + className);

        String logText = "<b> " + className + " Successful</b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        File scrnshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrnshot, new File(ScreenshotNames + "_" + dateName + ".png"));
        extentTest.get().log(Status.PASS, m).pass(MediaEntityBuilder
                .createScreenCaptureFromPath(directory + className + "_" + dateName + ".png").build());

    }
}
