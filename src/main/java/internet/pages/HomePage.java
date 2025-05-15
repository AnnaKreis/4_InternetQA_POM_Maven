package internet.pages;

import internet.core.BasePage;
import internet.pages.alerts.AlertsPage;
import internet.pages.dropdown.DropdownListPage;
import internet.pages.frames.NestedFramesPage;
import internet.pages.hovers.HoversPage;
import internet.pages.slider.SliderPage;
import internet.pages.windows.BrowserWindowsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(css = "a[href='/login']")
    WebElement loginLink;

    public LoginPage getFormAuthentication() {
        click(loginLink);
        return new LoginPage(driver, wait);
    }

    @FindBy(css = "a[href='/javascript_alerts']")
    WebElement alertsJavaScript;

    public AlertsPage getAlertsJavaScript() {
        click(alertsJavaScript, 0, 100);
        return new AlertsPage(driver, wait);

    }

    @FindBy(css = "a[href='/nested_frames']")
    WebElement frames;

    public NestedFramesPage getNestedFrames() {
        click(frames, 0, 100);
        return new NestedFramesPage(driver, wait);

    }

    @FindBy(css = "a[href='/windows']")
    WebElement windows;

    public BrowserWindowsPage getMultipleWindows() {
        click(windows, 0, 150);
        return new BrowserWindowsPage(driver, wait);
    }

    @FindBy(css = "a[href='/dropdown']")
    WebElement dropdown;

    public DropdownListPage getDropdownList() {
        click(dropdown, 0, 150);
        return new DropdownListPage(driver, wait);
    }

    @FindBy(css = "a[href='/horizontal_slider']")
    WebElement slider;

    public SliderPage getSlider() {
        click(slider, 0, 150);
        return new SliderPage(driver, wait);
    }

    @FindBy(css = "a[href='/hovers']")
    WebElement hovers;

    public HoversPage getHovers() {
        click(hovers, 0, 150);
        return new HoversPage(driver, wait);
    }
}
