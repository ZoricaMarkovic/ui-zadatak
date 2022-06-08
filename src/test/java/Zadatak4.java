import drivers.DriverWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.BasePage;

public class Zadatak4 extends BasePage {

    @Test
    public void zadatak4() {

        WebDriver driver = DriverWrapper.getWebDriver("chrome");
        String pageUrl = "http://the-internet.herokuapp.com/iframe";

        String iFrameXPath = "//iframe[@id='mce_0_ifr']";
        String textBoxXPath = "//body[@data-id='mce_0']/p";
        String text = "selenium.dev/documentation/webdriver/browser/frames/";

        try {

            // Navigate to the url
            driver.get(pageUrl);

            // Need to switch to the iframe first
            WebElement iframe = findElementByXPath(driver, iFrameXPath);
            driver.switchTo().frame(iframe);

            // Clear the “Your content goes here.”
            waitForPresenceOfElement(driver, textBoxXPath);
            WebElement textBoxElement = findElementByXPath(driver, textBoxXPath);
            textBoxElement.clear();

            //Enter the text into the text box
            textBoxElement.sendKeys(text);

        } finally {
            driver.quit();
        }

    }
}
