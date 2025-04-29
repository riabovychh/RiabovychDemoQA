package org.riabovych.page.config;

import org.openqa.selenium.WebDriver;

import java.io.*;
import java.util.HashMap;
import java.util.Objects;
import java.util.Properties;

public class Configuration {
    private static final Properties PROPERTIES = readProperties();

    private static Properties readProperties() {
        Properties properties = new Properties();
        String configPath = System.getenv().get("CONFIG_PATH");  // считать переменные окружения
        if (Objects.isNull(configPath)) {
            configPath = "/Users/tetianariabovych/IdeaProjects/RiabovychDemoQA/src/main/resources/config.properties";
        }

        try (FileReader fileReader = new FileReader(configPath)){
            properties.load(fileReader);
            System.out.println(properties);
        } catch (IOException e) {
            System.out.println("Problem with reading file properties");
            throw new RuntimeException(e.getMessage());
        }
        return properties;
    }

    public static WebDriver getDriver() {
        HashMap<String, String> options = new HashMap<>();
        options.put("download_directory", PROPERTIES.getProperty("download.directory"));
        options.put("implicitlyWait", PROPERTIES.getProperty("implicitly.wait"));

        return DriverManager.getDriver(PROPERTIES.getProperty("browser"), options);
    }

    public static File getDownloadFile() {
        return new File (PROPERTIES.getProperty("download.directory"));
    }

    public static void main(String[] args) {
        readProperties();
    }
}
