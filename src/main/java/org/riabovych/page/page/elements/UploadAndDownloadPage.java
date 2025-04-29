package org.riabovych.page.page.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.riabovych.page.EachPage;

public class UploadAndDownloadPage extends EachPage {

    @FindBy (id = "uploadFile")
    private WebElement inputUpload;

    @FindBy (id = "downloadButton")
    private WebElement downloadFileButton;

    public UploadAndDownloadPage(WebDriver driver) {
        super(driver);
    }

    public void uploadFile (String pathToFile) {
        inputUpload.sendKeys(pathToFile);
    }
    public void clickDownloadButton() {
        downloadFileButton.click();
    }


}
