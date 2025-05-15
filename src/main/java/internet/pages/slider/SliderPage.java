package internet.pages.slider;

import internet.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SliderPage extends BasePage {
    public SliderPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(xpath = "//input[@type='range']")
    WebElement sliderInput;

    public SliderPage moveSliderInHorizontalDirection() {
        pause(1000);
        moveWithJS(0, 160);
        new Actions(driver).dragAndDropBy(sliderInput,30, 0).perform();
        return this;
    }

    @FindBy(xpath = "(//span[@id='range'])")
    WebElement range;
    public SliderPage verifySliderValue(String number) {
        Assert.assertEquals(range.getText(), number);
        return this;
    }

}
