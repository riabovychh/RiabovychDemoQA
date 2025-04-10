package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.riabovych.page.EachPage;
import org.riabovych.page.elements.TextBoxPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class EachPageTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }

    protected void openPage(String url) {
        driver.get(url);
    }
}
