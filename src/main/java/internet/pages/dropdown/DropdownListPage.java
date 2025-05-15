package internet.pages.dropdown;

import internet.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DropdownListPage extends BasePage {

    public DropdownListPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

@FindBy(id = "dropdown")
    WebElement dropdown;

    public DropdownListPage selectOption(String option) {
        new Select(dropdown).selectByVisibleText(option);
        return this;
    }

    public DropdownListPage verifyOption() {
        String selectedOption = new Select(dropdown)
                .getFirstSelectedOption()
                .getText();
        Assert.assertTrue(shouldHaveText(dropdown, selectedOption, 5));
        return this;
    }
}
