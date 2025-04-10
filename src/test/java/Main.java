import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.riabovych.page.elements.TextBoxPage;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        Runtime.getRuntime().addShutdownHook(new Thread(driver::quit)); // щою закрив браузер в будь якому разi

        TextBoxPage page = new TextBoxPage(driver);


    }
}
