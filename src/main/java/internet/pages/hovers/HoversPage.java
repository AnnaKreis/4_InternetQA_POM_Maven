package internet.pages.hovers;

import internet.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;


public class HoversPage extends BasePage {
    public HoversPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(css = ".figure")
    List<WebElement> figures; // <img>

    public HoversPage hoverOverUser(int index) {
        new Actions(driver).moveToElement(figures.get(1)).perform();
        return this;
    }

    @FindBy(css = ".figcaption h5")
    List<WebElement> userNames;

    public HoversPage verifyUserName(int index, String expectedName) {
        String actualName = userNames.get(index).getText();
        Assert.assertEquals(actualName, expectedName);
        return this;
    }

    @FindBy(css = ".figcaption a")
    List<WebElement> profileLinks;

    public HoversPage verifyProfileLink(int index) {
        Assert.assertTrue(profileLinks.get(index).isDisplayed());
        return this;
    }
}
