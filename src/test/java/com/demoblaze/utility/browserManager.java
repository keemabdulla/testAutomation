package com.demoblaze.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;

public class browserManager {

    public static WebDriver getDriver(WebDriver driver) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions ops = getChromeOptions();
        driver = new ChromeDriver(ops);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        return driver;
    }

    private static ChromeOptions getChromeOptions() {
        String downloadFilepath = "/Users/alakeem.abdulla/Downloads/GoFiber Selenium/";
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilepath);
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        ops.addArguments("--start-maximized");
        ops.setPageLoadStrategy(PageLoadStrategy.NONE);
        ops.setExperimentalOption("prefs", chromePrefs);

        return ops;
    }
}
