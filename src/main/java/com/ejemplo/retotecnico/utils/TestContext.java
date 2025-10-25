package com.ejemplo.retotecnico.utils;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class TestContext {
    private static WebDriver driver;

    public static void initialize() throws IOException {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = ChromeOptionsFactory.getChromeOptions();

            driver = new ChromeDriver(options);
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}