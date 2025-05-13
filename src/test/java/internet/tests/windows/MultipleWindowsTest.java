package internet.tests.windows;

import internet.core.TestBase;
import internet.pages.HomePage;
import internet.pages.windows.BrowserWindowsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindowsTest extends TestBase {
    @BeforeMethod
    public void preconditions() {
        new HomePage(app.driver, app.wait).getMultipleWindows();
    }

    @Test
    public void newWindowTest() {
        new BrowserWindowsPage(app.driver, app.wait).switchToNewWindow(1)
                .verifyNewWindowTitle("New Window");
    }
}
