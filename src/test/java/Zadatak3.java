import drivers.DriverWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;

public class Zadatak3 extends BasePage {

    @Test
    public void zadatak3() {

        WebDriver driver = DriverWrapper.getWebDriver("chrome");
        String pageUrl = "http://the-internet.herokuapp.com/dynamic_controls";

        String enableButtonXPath = "//button[@onclick='swapInput()']";
        String messageXPath = "//p[@id='message']";
        String buttonToDisappearXPath = "//button[@onclick='swapInput()' and @disabled='disabled']";

        String buttonEnabledMessage = "It's enabled!";
        String buttonDisabledMessage = "It's disabled!";

        try {

            // Navigate to the url
            driver.get(pageUrl);

            // Click on the “Enable” button
            WebElement enableButton = findElementByXPath(driver, enableButtonXPath);
            clickOnElement(enableButton);

            // Assert that the field is actually enabled once the loading completes
            waitForElementToDisappear(driver, buttonToDisappearXPath);

            String text = findElementByXPath(driver, messageXPath).getText();
            Assert.assertEquals(text, buttonEnabledMessage, "Button is disabled!");

            // Click on the “Disable” button
            clickOnElement(enableButton);

            // Assert that the field is actually enabled once the loading completes
            waitForElementToDisappear(driver, buttonToDisappearXPath);

            text = findElementByXPath(driver, messageXPath).getText();
            Assert.assertEquals(text, buttonDisabledMessage, "Button is enabled!");

        } finally {
            driver.quit();
        }
    }
}