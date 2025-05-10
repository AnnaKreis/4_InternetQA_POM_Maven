package internet.tests;

import internet.core.TestBase;
import internet.pages.HomePage;
import internet.pages.LoginPage;
import internet.utils.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        new HomePage(app.driver, app.wait)
                .getFormAuthentication();
    }

    @Test
    public void loginPositiveTest() {
        new LoginPage(app.driver, app.wait)
                .enterPersonalData("tomsmith", "SuperSecretPassword!")
                .clickOnLoginButton()
                .verifySuccessfulLogin("Welcome to the Secure Area. When you are done click logout below.");
    }

    @Test(dataProvider = "invalidLoginData", dataProviderClass = DataProviders.class)
    public void loginNegativeFromDataProviderTest(String user, String password, String expectedErrorText) {
        new LoginPage(app.driver, app.wait)
                .enterPersonalData(user, password)
                .clickOnLoginButton2()
                .verifyLoginError(expectedErrorText);
    }
}
