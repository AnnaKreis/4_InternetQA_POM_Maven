package internet.tests.slider;

import internet.core.TestBase;
import internet.pages.HomePage;
import internet.pages.slider.SliderPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SliderTest extends TestBase {
    @BeforeMethod
    public void preconditions() {
        new HomePage(app.driver, app.wait).getSlider();
    }

    @Test
    public void sliderTest() {
        new SliderPage(app.driver, app.wait).moveSliderInHorizontalDirection()
                .verifySliderValue("4");
    }
}
