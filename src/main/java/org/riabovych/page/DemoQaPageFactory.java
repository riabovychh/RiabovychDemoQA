package org.riabovych.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.riabovych.page.elements.TextBoxPage;

public class DemoQaPageFactory {
    private static final WebDriver DRIVER = new ChromeDriver();
    private DemoQaPageFactory() {}

    public static TextBoxPage getTextBoxPage() {
        return PageFactory.initElements(DRIVER, TextBoxPage.class);
    }

    public static WebDriver getDriver() {
        return DRIVER;
    }

    public static <T extends EachPage> T getPage(Class<T> tclass){   // для создания каждого обьекта страницы
        return PageFactory.initElements(DRIVER, tclass); // возвращает инстанс введенного класса
    }
}
