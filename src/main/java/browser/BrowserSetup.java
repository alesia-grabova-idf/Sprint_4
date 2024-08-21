package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserSetup {
    private WebDriver driver;

    public WebDriver setup() {
        String browser = System.getProperty("browser", "chrome");

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            return driver = new ChromeDriver();
        } else {
            WebDriverManager.firefoxdriver().setup();
            return driver = new FirefoxDriver();
        }

    }
}
