package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverWrapper {

    public static WebDriver getWebDriver(String driverType) {

        switch (driverType) {
            case "chrome":

                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();

            case "firefox":

                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();

            case "edge":

                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();

            case "safari":

                WebDriverManager.safaridriver().setup();
                return new SafariDriver();
        }
        return null;
    }
}
