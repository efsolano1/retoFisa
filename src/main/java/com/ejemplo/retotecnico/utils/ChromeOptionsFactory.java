package com.ejemplo.retotecnico.utils;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsFactory {
    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();

        boolean isCI = System.getenv("CI") != null;

        if (isCI) {
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }

        options.addArguments("--remote-allow-origins=*");
        return options;
    }
}
