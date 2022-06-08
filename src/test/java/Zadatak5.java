import drivers.DriverWrapper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.BasePage;

public class Zadatak5 extends BasePage {


    @Test
    public void zadatak5() {

        WebDriver driver = DriverWrapper.getWebDriver("chrome");
        String pageUrl = "http://the-internet.herokuapp.com/large";

        String xPathExpression = "//tr[@class='row-40']/td[10]";
        //String xPathExpression = "//tr[40]//child::td[10]";
        //String xPathExpression = "//td[@class='column-10' and text()='40.10']";

        try {

            // Navigate to the url
            driver.get(pageUrl);

            String text = findElementByXPath(driver, xPathExpression).getText();

            assert text.equals("40.10") : "The cell doesn't have the expected value.";

        } finally {
            driver.quit();
        }


    }
}
