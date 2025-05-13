package internet.pages.frames;

import internet.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class NestedFramesPage extends BasePage {
    public NestedFramesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(name = "frame-top")
    WebElement topFrame;

    public NestedFramesPage switchToTopFrame() {
        driver.switchTo().frame(topFrame);
        return this;
    }

    @FindBy(name = "frame-left")
    WebElement leftFrame;

    public NestedFramesPage switchToLeftFrame() {
        driver.switchTo().frame(leftFrame);
        return this;
    }

    @FindBy(name = "frame-middle")
    WebElement middleFrame;

    public NestedFramesPage switchToMiddleFrame() {
        driver.switchTo().frame(middleFrame);
        return this;
    }

    @FindBy(name = "frame-right")
    WebElement rightFrame;

    public NestedFramesPage switchToRightFrame() {
        driver.switchTo().frame(rightFrame);
        return this;
    }

    @FindBy(name = "frame-bottom")
    WebElement bottomFrame;

    public NestedFramesPage switchToBottomFrame() {
        driver.switchTo().frame(bottomFrame);
        return this;
    }

    @FindBy(tagName = "body")
    WebElement bodyFrame;

    public NestedFramesPage verifyFrameText(String text) {
        Assert.assertTrue(shouldHaveText(bodyFrame, text, 10));
        return this;
    }

    public NestedFramesPage switchToDefaultContent() {
        driver.switchTo().defaultContent();
        return this;
    }

//    public NestedFramesPage verifyFrameCount(int expectedCount) {
//        Integer actualCount = Integer.parseInt(js.executeScript("return window.frames.length").toString());
//        Assert.assertEquals(actualCount, expectedCount);
//        return this;
//    }

}
