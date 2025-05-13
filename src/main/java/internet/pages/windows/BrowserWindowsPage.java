package internet.pages.windows;

import internet.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsPage extends BasePage {

    public BrowserWindowsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(css = "a[href='/windows/new']")
    WebElement newWindowButton;

    public BrowserWindowsPage switchToNewWindow(int index) {
        click(newWindowButton);
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(index));
        return this;
    }

    @FindBy(xpath = "//h3[text()='New Window']")
    WebElement newWindowTitle;

    public BrowserWindowsPage verifyNewWindowTitle(String text) {
        Assert.assertTrue(shouldHaveText(newWindowTitle, text, 5));
        return this;
    }
}
