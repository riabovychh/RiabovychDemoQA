package org.riabovych.page;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class ElementUtils {
    public static void clickWithScrollingToElement (WebElement element, WebDriver driver) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(ElementClickInterceptedException.class);
        wait.until(ExpectedConditions.visibilityOf(element));

        Actions actions = new Actions(driver);
        wait.until( webElement -> {
                    actions.scrollByAmount(0, 30);
                    actions.perform();  // обязательно в конце
                    element.click();
                    return webElement;
                }
        );
    }
}
