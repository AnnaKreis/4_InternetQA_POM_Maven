package internet.pages;

import internet.core.BasePage;
import internet.pages.alertsJavaScript.AlertsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
}
