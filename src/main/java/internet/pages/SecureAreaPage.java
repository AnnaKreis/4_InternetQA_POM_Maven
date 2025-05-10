package internet.pages;

import internet.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SecureAreaPage extends BasePage {

    public SecureAreaPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(css = ".subheader")
    WebElement successfulLogin;

    public SecureAreaPage verifySuccessfulLogin(String text) {
        Assert.assertTrue(successfulLogin.getText().contains(text));
        return this;
    }
}
