package org.riabovych.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class EachPage {

    protected WebDriver driver;

    public EachPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
