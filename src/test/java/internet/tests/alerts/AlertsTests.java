package internet.tests.alerts;

import internet.core.TestBase;
import internet.pages.HomePage;
import internet.pages.alertsJavaScript.AlertsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests extends TestBase {
    @BeforeMethod
    public void preconditions() {
        new HomePage(app.driver, app.wait).getAlertsJavaScript();
    }

    @Test
    public void simpleAlertTest() {
        new AlertsPage(app.driver, app.wait)
                .handleSimpleAlert()
                .verifyResultText("You successfully clicked an alert");
    }

    @Test
    public void confirmAlertAcceptsTest() {
        new AlertsPage(app.driver, app.wait)
                .handleConfirmAlert(true)
                .verifyResultText("You clicked: Ok");
    }

    @Test
    public void confirmAlertCancelTest() {
        new AlertsPage(app.driver, app.wait)
                .handleConfirmAlert(false)
                .verifyResultText("You clicked: Cancel");
    }

    @Test
    public void promptAlertTest() {
        new AlertsPage(app.driver, app.wait)
                .handlePromptAlert("text", true)
                .verifyResultText("You entered: text");;
    }

    @Test
    public void promptAlertCancelTest() {
        new AlertsPage(app.driver, app.wait)
                .handlePromptAlert("", false)
                .verifyResultText("You entered: null");;
    }

}
