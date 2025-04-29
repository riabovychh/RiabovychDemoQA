package page.frame;

import org.openqa.selenium.WindowType;
import org.riabovych.page.page.frame.FramePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.EachPageTest;

public class FramePageTest extends EachPageTest {
    private FramePage framePage;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        driver.get("https://demoqa.com/frames");
        framePage = new FramePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
        framePage = null;
    }

    @Test
    public void sampleHeaderTextTest() {
        String expected = "This is a sample page";

        String actual = framePage.getFirstFrameHeaderText();
        System.out.println(actual);

        Assert.assertEquals(actual, expected);

        // чтоб остаться в фрейме после теста
        FramePage. SamplePage firstFrame = framePage.getFirstFrame();
        String actual2 = firstFrame. getHeaderText();
        System.out.println(actual2);
        Assert. assertEquals(actual2, expected);
    }

    @Test
    public void newTabTest() throws InterruptedException { // тест на то, чтоб перейти на какую-то табу
        driver.switchTo().newWindow(WindowType.TAB);  // открывает и переходит на новую страницу
        driver.get("https://privatbank.ua/");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://novaposhta.ua/");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://web.monobank.ua/");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://epicentrk.ua/");
        Thread.sleep(3000);

        for (String windowHandle: driver.getWindowHandles()){
            System.out.println(windowHandle);
            String title = driver.switchTo().window(windowHandle).getTitle();
            Thread.sleep(3000);
            if (title.toLowerCase().contains("monobank")) {
                break;
            }
        }

        Thread.sleep(2000);
    }
}