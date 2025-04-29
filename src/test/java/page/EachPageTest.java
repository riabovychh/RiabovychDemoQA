package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.riabovych.page.config.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;

public class EachPageTest {

    protected File downloadsFolder;
    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){
        // Configuration.getDriver()
        downloadsFolder = Configuration.getDownloadFile();
        driver = Configuration.getDriver();
    }

    @AfterMethod
    public void tearDown(){
        Arrays.stream(downloadsFolder.listFiles()).forEach(File::delete); // это то же, что код снизу


//        downloads.delete();
        driver.quit();
        driver = null;
    }

    protected void openPage(String url) {
        driver.get(url);
    }
}
