package org.riabovych.page.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.riabovych.page.Path;

public class RadioButtonPage {
    private WebElement yesRadioButton;
    private WebElement impressiveRadioButton;
    private WebElement noRadioButton;
    private WebElement notificationText;

    public RadioButtonPage(WebDriver driver) {
        yesRadioButton = driver.findElement(By.cssSelector(Path.RADIO_BUTTON_YES));
        impressiveRadioButton = driver.findElement(By.cssSelector(Path.RADIO_BUTTON_IMPRESSIVE));
        noRadioButton = driver.findElement(By.cssSelector(Path.RADIO_BUTTON_NO));
       // notificationText = driver.findElement(By.cssSelector(Path.RADIO_BUTTON_NOTIFICATION_TEXT));
    }

    public void clickYesRadioButton() {
        yesRadioButton.click();
    }

    public void clickImpressiveRadioButton() {
        impressiveRadioButton.click();
    }

    public void clickNoRadioButton() {
        noRadioButton.click();
    }

    public String getNotificationText(WebDriver driver) {
        notificationText = driver.findElement(By.cssSelector(Path.RADIO_BUTTON_NOTIFICATION_TEXT));
        return notificationText.getText();
    }

    public boolean isYesRadioButtonSelected() {
        return yesRadioButton.isSelected();
    }
}
