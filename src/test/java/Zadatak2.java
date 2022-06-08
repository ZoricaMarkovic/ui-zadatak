import drivers.DriverWrapper;
import org.openqa.selenium.WebDriver;
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

                // Output the message “Gallery button present!” to console if “Gallery” button exists
                if (findElementByXPath(driver, galleryButtonXPath) != null) {

                    System.out.println("Gallery button present!");
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
