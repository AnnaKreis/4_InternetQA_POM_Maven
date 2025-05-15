package internet.tests.hovers;

import internet.core.TestBase;
import internet.pages.HomePage;
import internet.pages.hovers.HoversPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoversTest extends TestBase {
    @BeforeMethod
    public void preconditions() {
        new HomePage(app.driver, app.wait).getHovers();
    }

    @Test
    public void hoversUserTest() {
        new HoversPage(app.driver, app.wait)
                .hoverOverUser(1)
                .verifyUserName(1,"name: user2")
                .verifyProfileLink(1);
    }
}
