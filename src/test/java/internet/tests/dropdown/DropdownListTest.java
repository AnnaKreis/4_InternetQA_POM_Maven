package internet.tests.dropdown;

import internet.core.TestBase;
import internet.pages.HomePage;
import internet.pages.dropdown.DropdownListPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownListTest extends TestBase {
    @BeforeMethod
    public void preconditions() {
        new HomePage(app.driver, app.wait).getDropdownList();
    }

    @Test
    public void selectOptionTest() {
        new DropdownListPage(app.driver, app.wait)
                .selectOption("Option 2")
                .verifyOption();
    }
}
