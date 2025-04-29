package org.riabovych.page.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DriverManager {
    public static WebDriver getDriver(String driverName, Map<String, String> options) {
        WebDriver driver = null;
        String downloadDirectory = options.get("download_directory");
        File downloadDir = null;
        if (Objects.nonNull(downloadDirectory)) {
            downloadDir = new File(downloadDirectory);
            if (!downloadDir.exists()) {
                downloadDir.mkdir();  // cоздание новой папки
            }
            switch (driverName) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();

                    if (Objects.nonNull(downloadDirectory)) {

                        HashMap<String, Object> prefs = new HashMap<>();
                        prefs.put("download.default_directory", downloadDir.getAbsolutePath());
                        chromeOptions.setExperimentalOption("prefs", prefs);
                    }
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "mozilla":
                    FirefoxProfile firefoxProfile = new FirefoxProfile();
                    if (Objects.nonNull(downloadDir)) {
                        firefoxProfile.setPreference("browser.download.dir", downloadDir.getAbsolutePath());
                    }
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setProfile(firefoxProfile);
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Unknown driver name");
            }


            driver.manage().window().maximize();

            String implicitlyWait = options.getOrDefault("implicitlyWait", "5");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(implicitlyWait)));


        }
        return driver;
    }
}
