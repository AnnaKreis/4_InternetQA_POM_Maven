package internet.pages.alerts;

import internet.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class AlertsPage extends BasePage {

    Logger logger = LoggerFactory.getLogger(AlertsPage.class);

    public AlertsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(css = "button[onclick='jsAlert()']")
    WebElement jsAlertButton;

    public AlertsPage handleSimpleAlert() {
        click(jsAlertButton);
        waitFormAlert(2);
        driver.switchTo().alert().accept();
        return this;
    }

    @FindBy(css = "button[onclick='jsConfirm()']")
    WebElement jsConfirmButton;

    public AlertsPage handleConfirmAlert(boolean accept) {
        click(jsConfirmButton);
        waitFormAlert(2);
        if (accept) {
            driver.switchTo().alert().accept();
        } else {
            driver.switchTo().alert().dismiss();
        }
        return this;
    }

    @FindBy(css = "button[onclick='jsPrompt()']")
    WebElement jsPromptButton;

    public AlertsPage handlePromptAlert(String text, boolean accept) {
        click(jsPromptButton);
        waitFormAlert(2);
        if (text != null) {
            driver.switchTo().alert().sendKeys(text);
        }
        if (accept) {
            driver.switchTo().alert().accept();
        } else {
            driver.switchTo().alert().dismiss();
        }
        return this;
    }

    @FindBy(id = "result")
    WebElement result;

    public AlertsPage verifyResultText(String expectedText) {
        String actualText = result.getText();
        String errorMessage = "\nExpected text: " + expectedText + ",\nActual text: " + actualText;
        System.out.println("Expected text: " + expectedText + ",\nActual text: " + actualText);
        logger.info("Verifying alert result text.");
        logger.info("Expected: '{}', Actual: '{}'", expectedText, actualText);
        Assert.assertTrue(actualText.contains(expectedText), errorMessage);
        return this;
    }

}
