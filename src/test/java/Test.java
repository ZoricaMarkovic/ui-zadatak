import drivers.DriverWrapper;
import org.openqa.selenium.WebDriver;

public class Test {

    public static void main(String[] args) {

        WebDriver chromeDriver = DriverWrapper.getWebDriver("chrome");
        WebDriver firefoxDriver = DriverWrapper.getWebDriver("firefox");

        try {
            chromeDriver.get("http://facebook.com");
            firefoxDriver.get("http://facebook.com");

        } finally {
            chromeDriver.quit();
            firefoxDriver.quit();
        }
    }
}
