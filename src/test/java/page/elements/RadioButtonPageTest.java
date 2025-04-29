package page.elements;
import org.riabovych.page.page.elements.RadioButtonPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.EachPageTest;


public class RadioButtonPageTest extends EachPageTest {
    private RadioButtonPage radioButtonPage;
    // private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        driver.get("https://demoqa.com/radio-button");
        radioButtonPage = new RadioButtonPage(driver);
    }

    @AfterMethod
    public void tearDown(){
        radioButtonPage = null;
        super.tearDown();
    }

    @Test
    public void clickYesRadioButtonTest() {
        radioButtonPage.clickYesRadioButton();
        String actualText = radioButtonPage.getNotificationText(driver);
        String expectedText = "Yes";

        Assert.assertTrue(radioButtonPage.isYesRadioButtonSelected());
        Assert.assertEquals(actualText, expectedText);
    }
}
