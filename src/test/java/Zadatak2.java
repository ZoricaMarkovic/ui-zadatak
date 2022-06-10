import drivers.DriverWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.BasePage;

public class Zadatak2 extends BasePage {

    @Test
    public void zadatak2() {

        String pageUrl = "http://the-internet.herokuapp.com/disappearing_elements";
        WebDriver driver = DriverWrapper.getWebDriver("chrome");

        String galleryButtonXPath = "//ul/li[5]";

        try {

            // Navigate to the url
            driver.get(pageUrl);

            // Create a loop that will do the following
            for (int i = 0; i < 10; i++) {

                // Refresh the page
                driver.navigate().refresh();

                WebElement galleryButton = findElementByXPath(driver, galleryButtonXPath);
                if (findElementByXPath(driver, galleryButtonXPath) != null) {

                    // Output the message “Gallery button present!” to console if “Gallery” button exists
                    System.out.println("Gallery button present!");
                    assert galleryButton.isDisplayed() : "Gallery button is available in the DOM, but it's not displayed.";
                }
                else {
                    // Output the message “Gallery button missing!” to console if the “Gallery” button is not available in the DOM
                    System.out.println("Gallery button missing!");
                }
            }
        }
        finally {
            driver.quit();
        }
    }
}
