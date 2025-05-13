package internet.tests.frames;

import internet.core.TestBase;
import internet.pages.HomePage;
import internet.pages.frames.NestedFramesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NestedFramesTests extends TestBase {
    @BeforeMethod
    public void preconditions() {
        new HomePage(app.driver, app.wait).getNestedFrames();
    }

    @Test
    public void nestedLeftFramesTest() {
        new NestedFramesPage(app.driver, app.wait)
                .switchToTopFrame()
                .switchToLeftFrame()
                .verifyFrameText("LEFT")
                .switchToDefaultContent();
    }

    @Test
    public void nestedMiddleFramesTest() {
        new NestedFramesPage(app.driver, app.wait)
                .switchToTopFrame()
                .switchToMiddleFrame()
                .verifyFrameText("MIDDLE")
                .switchToDefaultContent();
    }

    @Test
    public void nestedRightFramesTest() {
        new NestedFramesPage(app.driver, app.wait)
                .switchToTopFrame()
                .switchToRightFrame()
                .verifyFrameText("RIGHT")
                .switchToDefaultContent();
    }

    @Test
    public void nestedBottomFrameTest() {
        new NestedFramesPage(app.driver, app.wait)
                .switchToBottomFrame()
                .verifyFrameText("BOTTOM")
                .switchToDefaultContent();;
    }

    @Test
    public void totalFramesCountTest() {
        new NestedFramesPage(app.driver, app.wait).verifyTotalFramesCount(5);
    }
}

