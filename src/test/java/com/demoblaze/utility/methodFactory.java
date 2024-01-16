package com.demoblaze.utility;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.demoblaze.base.listener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class methodFactory extends listener {

    public static void login(WebDriver driver, String username, String password) throws InterruptedException {

        //not a best practice but it seems that the element is not present upon landing to the app
        Thread.sleep(1500);

        elements.click(driver, By.id("login2"));
        System.out.println("User clicked login button from homepage");
        extentTest.get().log(Status.INFO, "User clicked login button from homepage");

        elements.sendKeys(driver, By.id("loginusername"), username);
        elements.sendKeys(driver, By.id("loginpassword"), password);
        System.out.println("User entered username and password");
        extentTest.get().log(Status.INFO, "User entered username and password");

        elements.click(driver, By.xpath("//button[normalize-space()='Log in']"));
        System.out.println("User clicked login button");
        extentTest.get().log(Status.INFO, "User clicked login button");
    }

    public static Markup reportTitle(String className) {

        String logText2 = "<b> " + className + " Test Start</b>";
        Markup m2 = MarkupHelper.createLabel(logText2, ExtentColor.BLUE);
        extentTest.get().log(Status.INFO, m2);

        return m2;
    }
}
