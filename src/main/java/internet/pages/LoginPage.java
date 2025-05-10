package internet.pages;

import internet.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(id = "username")
    WebElement userName;

    @FindBy(id = "password")
    WebElement userPassword;

    public LoginPage enterPersonalData(String user, String password) {
        type(userName, user);
        type(userPassword, password);
        return this;
    }

    @FindBy(css = ".fa.fa-2x.fa-sign-in")
    WebElement loginButton;

    public SecureAreaPage clickOnLoginButton() {
        click(loginButton);
        return new SecureAreaPage(driver, wait);
    }

    public LoginPage clickOnLoginButton2() {
        click(loginButton);
        return this;
    }

    @FindBy(css = ".flash.error")
    WebElement loginError;
    public LoginPage verifyLoginError(String text) {
        Assert.assertTrue(loginError.getText().contains(text));
        return this;
    }

}
