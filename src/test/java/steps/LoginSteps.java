package steps;

import base.BasePage;
import base.BaseTest;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.LoginPage;
import pages.ProductsPage;


public class LoginSteps extends BaseTest{

    private final LoginPage loginPage = new LoginPage(driver);
    private final ProductsPage productsPage = new ProductsPage(driver);
    private final BasePage basePage = new BasePage(driver);



    @Given("the user is on the login screen")
    public void the_user_is_on_the_login_screen() {
        Assert.assertTrue(loginPage.isOnLoginPage(), "User is not on Products screen");
    }

    @When("the user logs in with username {string} and password {string}")
    public void the_user_logs_in_with_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.tapLoginButton();
    }

    @Then("the user should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {
        Assert.assertTrue(productsPage.isOnProductsPage(), "User is not on the products screen");
    }

    @Then("the user should see the login error message {string}")
    public void the_user_should_see_the_login_error_message(String expectedMessage) {
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @And("the user opens the menu and taps logout")
    public void theUserOpensTheMenuAndTapsLogout() {
        basePage.isHamburgerMenuVisible();
        basePage.tapHamburgerMenu();
        basePage.tapLogout();
        Assert.assertTrue(loginPage.isOnLoginPage(),"User is not on Products screen");
    }

    @Then("the user should be returned to the login screen")
    public void theUserShouldBeReturnedToTheLoginScreen() {
    }
}
