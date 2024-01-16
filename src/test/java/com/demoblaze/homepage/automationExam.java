package com.demoblaze.homepage;

import com.aventstack.extentreports.Status;
import com.demoblaze.base.listener;
import com.demoblaze.utility.*;
import org.openqa.selenium.By;;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

public class automationExam extends listener {

    static WebDriver driver;

    static String username = "keem";
    static String password = "Test123!";

    @Test
    public static void TC1_loginDemoTest() throws InterruptedException, IOException {

        String className = new Throwable().getStackTrace()[0].getMethodName();
        String loginDisplay;

        methodFactory.reportTitle(className);

        driver = browserManager.getDriver(driver);
        driver.get("https://www.demoblaze.com/index.html");
        System.out.println("User redirected to 'demoblaze' app");
        extentTest.get().log(Status.INFO, "User redirected to 'demoblaze' app");

        methodFactory.login(driver, username, password);

        loginDisplay = elements.getText(driver, By.id("nameofuser"));

        Assert.assertEquals(loginDisplay, "Welcome " + username);

        System.out.println("PASSED: User Successfully login to the dashboard");
        extentTest.get().log(Status.INFO, "PASSED: User Successfully login to the dashboard");

        capture.screenPass(driver, className);
        driver.quit();
    }

    @Test
    public static void TC2_logoutDemoTest() throws InterruptedException, IOException {

        String className = new Throwable().getStackTrace()[0].getMethodName();
        String homepageDisplay;

        methodFactory.reportTitle(className);

        driver = browserManager.getDriver(driver);
        driver.get("https://www.demoblaze.com/index.html");
        System.out.println("User redirected to 'demoblaze' app");
        extentTest.get().log(Status.INFO, "User redirected to 'demoblaze' app");

        methodFactory.login(driver, username, password);

        elements.click(driver, By.id("logout2"));
        System.out.println("User clicked logout button");
        extentTest.get().log(Status.INFO, "User clicked logout button");

        homepageDisplay = elements.getText(driver, By.id("signin2"));

        Assert.assertEquals(homepageDisplay, "Sign up");

        System.out.println("PASSED: User Successfully logout and redirected to homepage");
        extentTest.get().log(Status.INFO, "PASSED: User Successfully logout and redirected to homepage");

        capture.screenPass(driver, className);
        driver.quit();
    }

}
