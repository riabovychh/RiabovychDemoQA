package page.elements;

import org.openqa.selenium.WebDriver;
import org.riabovych.page.page.elements.TextBoxPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.EachPageTest;

public class TextBoxPageTest extends EachPageTest {
    private TextBoxPage textBoxPage;
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        super.setUp();
        driver.get("https://demoqa.com/text-box");
        textBoxPage = new TextBoxPage(driver);
    }

    @AfterMethod
    public void tearDown(){
        textBoxPage = null;
        super.tearDown();
    }

    @Test
    public void fullNameFieldTest(){
        String input = "Mike";
        String expected = "Mike";

        textBoxPage.fillFullNameInput(input);
        textBoxPage.fillEmailInput("test@test.com");
        textBoxPage.clickSubmitButton();
        String actual = textBoxPage.getOutputText();
        Assert.assertTrue(actual.contains(expected));
    }

}
