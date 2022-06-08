package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    public void waitForElementToDisappear(WebDriver driver, String xPath) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xPath)));
    }

    public void waitForPresenceOfElement(WebDriver driver, String xPath) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
    }

    public void clickOnElement(WebElement element) {
        element.click();
    }

    public WebElement findElementByXPath (WebDriver driver, String xPath) {

        WebElement element;

        try {
            element = driver.findElement(By.xpath(xPath));

        } catch (NoSuchElementException noSuchElementException) {
            noSuchElementException.printStackTrace();
            return null;
        }
        return element;
    }

    public List<WebElement> findElementsByXPath (WebDriver driver, String xPath) {

        List<WebElement> elements;

        try {
            elements = driver.findElements(By.xpath(xPath));

        } catch (NoSuchElementException noSuchElementException) {
            noSuchElementException.printStackTrace();
            return null;
        }
        return elements;
    }
}
