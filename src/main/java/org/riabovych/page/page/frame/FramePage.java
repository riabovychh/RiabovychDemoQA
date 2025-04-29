package org.riabovych.page.page.frame;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.riabovych.page.EachPage;

public class FramePage extends EachPage {

    @FindBy (css = "#frame1")
    private WebElement firstFrame;

    public FramePage(WebDriver driver) {
        super(driver);
    }

    public String getFirstFrameHeaderText() {
        driver.switchTo().frame(firstFrame);
        SamplePage firstFrame = new SamplePage();
        String headerText = firstFrame.getHeaderText();
        driver.switchTo().parentFrame();
        return headerText;
    }

    public SamplePage getFirstFrame() {
        driver.switchTo().frame(firstFrame);
        return new SamplePage();
    }

    public class SamplePage {
        @FindBy (css = "#sampleHeading")
        private WebElement header;

        public SamplePage() {
            PageFactory.initElements(driver, this);
        }

        public String getHeaderText() {
            return header.getText();
        }

        public FramePage returnToParentFrame() {
            driver.switchTo().parentFrame();
            return new FramePage(driver);
        }
    }
}
