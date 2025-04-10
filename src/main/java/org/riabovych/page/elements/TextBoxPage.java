package org.riabovych.page.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.riabovych.page.Path;

import java.util.List;

public class TextBoxPage {
    private WebElement fullNameInput;
    private WebElement emailInput;
    private WebElement currentAddressTextArea;
    private WebElement permanentAddressTextArea;
    private WebElement submitButton;
    private WebElement output;

    public TextBoxPage(WebDriver driver ) {
        fullNameInput = driver.findElement(By.cssSelector(Path.TEXT_BOX_FULL_NAME));
        emailInput = driver.findElement(By.cssSelector(Path.TEXT_BOX_EMAIL));
        currentAddressTextArea = driver.findElement(By.cssSelector(Path.TEXT_BOX_CURRENT_ADDRESS));
        permanentAddressTextArea = driver.findElement(By.cssSelector(Path.TEXT_BOX_PERMANENT_ADDRESS));
        submitButton = driver.findElement(By.cssSelector(Path.TEXT_BOX_SUBMIT_BUTTON));
        output = driver.findElement(By.cssSelector(Path.TEXTBOX_OUTPUT));
    }

    public void fillFullNameInput(String value) {
        fullNameInput.clear();
        fullNameInput.sendKeys(value);
    }

    public void fillEmailInput (String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void fillCurrentAddressTextArea (String currentAddress) {
        currentAddressTextArea.clear();
        currentAddressTextArea.sendKeys(currentAddress);
    }

    public void fillPermanentAddressTextArea (String permanentAddress) {
        permanentAddressTextArea.clear();
        permanentAddressTextArea.sendKeys(permanentAddress);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public String getOutputText() {
        List <WebElement> outputs = output.findElements(By.cssSelector(".mb-1"));
        StringBuilder stringBuilder = new StringBuilder();
        for (WebElement output : outputs) {
            stringBuilder.append(output.getText());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

}
