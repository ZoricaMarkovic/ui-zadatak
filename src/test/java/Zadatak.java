import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Zadatak extends BasePage {

    @Test
    public void zadatak1() {

        String addElementButtonXPath = "//button[@onclick='addElement()']";
        String deleteButtonXPath = "//button[@onclick='deleteElement()']";

        try {

            // Navigate to the url
            driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

            // Add three elements via the appropriate “Add element” button
            WebElement addElementButton = findElementByXPath(addElementButtonXPath);

            clickOnElement(addElementButton);
            clickOnElement(addElementButton);
            clickOnElement(addElementButton);

            // Verify that three “Delete” buttons are present
            List<WebElement> deleteButtons = findElementsByXPath(deleteButtonXPath);
            Assert.assertEquals(deleteButtons.size(), 3, String.format("Should be three Delete buttons, but found: %d ", deleteButtons.size()));

            for (int i = 0; i < 3; i++) {
                Assert.assertTrue(deleteButtons.get(i).isDisplayed(), String.format("%d. Delete button is not present.", i));
            }

            // Click on the second “Delete” button
            WebElement secondDeleteButton = deleteButtons.get(2);
            clickOnElement(secondDeleteButton);

            // Verify that two “Delete” buttons are present
            deleteButtons = findElementsByXPath(deleteButtonXPath);
            Assert.assertEquals(deleteButtons.size(), 2, "Two Delete buttons are not present!");

            for (int i = 0; i < 2; i++) {
                Assert.assertTrue(deleteButtons.get(i).isDisplayed());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void zadatak2() {

        String pageUrl = "http://the-internet.herokuapp.com/disappearing_elements";

        String galleryButtonXPath = "//ul/li[5]";

        try {

            // Navigate to the url
            driver.get(pageUrl);

            // Create a loop that will do the following
            for (int i = 0; i < 10; i++) {

                // Refresh the page
                driver.navigate().refresh();

                WebElement galleryButton = findElementByXPath(galleryButtonXPath);
                if (findElementByXPath(galleryButtonXPath) != null) {

                    // Output the message “Gallery button present!” to console if “Gallery” button exists
                    System.out.println("Gallery button present!");
                    Assert.assertTrue(galleryButton.isDisplayed(), "Gallery button is available in the DOM, but it's not displayed.");
                }
                else {
                    // Output the message “Gallery button missing!” to console if the “Gallery” button is not available in the DOM
                    System.out.println("Gallery button missing!");
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void zadatak3() {

        String pageUrl = "http://the-internet.herokuapp.com/dynamic_controls";

        String enableButtonXPath = "//button[@onclick='swapInput()']";
        String buttonToDisappearXPath = "//button[@onclick='swapInput()' and @disabled='disabled']";
        String inputFieldXPath = "//form[@id='input-example']/input";

        try {

            // Navigate to the url
            driver.get(pageUrl);

            // Click on the “Enable” button
            WebElement enableButton = findElementByXPath(enableButtonXPath);
            clickOnElement(enableButton);

            // Assert that the field is actually enabled once the loading completes
            waitForElementToDisappear(buttonToDisappearXPath);

            WebElement inputField = findElementByXPath(inputFieldXPath);
            Assert.assertTrue(inputField.isEnabled(), "Field is disabled");

            // Click on the “Disable” button
            clickOnElement(enableButton);

            // Assert that the field is actually disabled once the loading completes
            waitForElementToDisappear(buttonToDisappearXPath);

            inputField = findElementByXPath(inputFieldXPath);
            Assert.assertFalse(inputField.isEnabled(), "Field is enabled");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void zadatak4() {

        String pageUrl = "http://the-internet.herokuapp.com/iframe";

        String iFrameXPath = "//iframe[@id='mce_0_ifr']";
        String textBoxXPath = "//body[@data-id='mce_0']/p";
        String text = "selenium.dev/documentation/webdriver/browser/frames/";

        try {

            // Navigate to the url
            driver.get(pageUrl);

            // Need to switch to the iframe first
            WebElement iframe = findElementByXPath(iFrameXPath);
            driver.switchTo().frame(iframe);

            // Clear the “Your content goes here.”
            waitForPresenceOfElement(textBoxXPath);
            WebElement textBoxElement = findElementByXPath(textBoxXPath);
            textBoxElement.clear();

            //Enter the text into the text box
            textBoxElement.sendKeys(text);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void zadatak5() {

        String pageUrl = "http://the-internet.herokuapp.com/large";
        String expectedCellValue = "40.10";
        String xPathExpression = "//td[text()='40.10']";

        try {

            // Navigate to the url
            driver.get(pageUrl);

            String text = findElementByXPath(xPathExpression).getText();

            Assert.assertEquals(text, expectedCellValue, "The cell doesn't have the expected value.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }
}
