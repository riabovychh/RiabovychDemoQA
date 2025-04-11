package page.elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.riabovych.page.elements.RadioButtonPage;
import org.riabovych.page.elements.TextBoxPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.EachPageTest;


public class RadioButtonPageTest extends EachPageTest {
    private RadioButtonPage radioButtonPage;
    // private WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        openPage("https://demoqa.com/radio-button");
        radioButtonPage = new RadioButtonPage(driver);
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
