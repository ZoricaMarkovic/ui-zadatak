import drivers.DriverWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.BasePage;

import java.util.List;

public class Zadatak1 extends BasePage {

    @Test
    public void zadatak1() {

        WebDriver driver = DriverWrapper.getWebDriver("chrome");

        String addElementButtonXPath = "//button[@onclick='addElement()']";
        String deleteButtonXpath = "//button[@onclick='deleteElement()']";

        try {

            // Navigate to the url
            driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

            // Add three elements via the appropriate “Add element” button
            WebElement addElementButton = findElementByXPath(driver, addElementButtonXPath);

            clickOnElement(addElementButton);
            clickOnElement(addElementButton);
            clickOnElement(addElementButton);

            // Verify that three “Delete” buttons are present
            List<WebElement> deleteButtons = findElementsByXPath(driver, deleteButtonXpath);
            assert deleteButtons.size() == 3 : String.format("Should be three Delete buttons, but found: %d ", deleteButtons.size());

            for (int i = 0; i < 3; i++) {
                assert deleteButtons.get(i).isDisplayed() : String.format("%d. Delete button is not present.", i);
            }

            // Click on the second “Delete” button
            WebElement secondDeleteButton = deleteButtons.get(2);
            clickOnElement(secondDeleteButton);

            // Verify that two “Delete” buttons are present
            deleteButtons = findElementsByXPath(driver, deleteButtonXpath);
            assert deleteButtons.size() == 2 : "Two Delete buttons are not present!";

            for (int i = 0; i < 2; i++) {
                assert deleteButtons.get(i).isDisplayed() : String.format("%d. Delete button is not present.", i);
            }

        } finally {
            driver.quit();
        }
    }
}
