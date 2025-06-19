package steps;

import base.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.CheckoutPage;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

import static steps.ProductsSteps.getStoredProductPrice;
import static steps.ProductsSteps.getStoredProductTitle;

public class CheckoutSteps extends BaseTest {

    private final CheckoutPage checkoutPage = new CheckoutPage(driver);

    @Then("the user fills the last name with {string} and zip code with {string}")
    public void theUserFillsLastNameAndZipCode(String lastName, String zipCode) {
        checkoutPage.enterLastName(lastName);
        checkoutPage.enterZipCode(zipCode);
    }

    @And("taps continue button")
    public void tapsContinueButton() {
        checkoutPage.tapContinue();
    }


    @Then("the user taps the finish button")
    public void theUserTapsFinish() {
        checkoutPage.tapFinish();
    }

    @Then("the final screen should display {string}")
    public void finalScreenShouldDisplayMessage(String expectedText) {
        String actualText = checkoutPage.isOrderConfirmed();
        Assert.assertEquals(actualText, expectedText);
    }

    @And("the user taps back home")
    public void theUserTapsBackHome() {
        checkoutPage.tapBackHome();
    }

    @And("the user fills in checkout info with:")
    public void theUserFillsInCheckoutInfoWith(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String lastName = data.getFirst().get("lastName");
        String postalCode = data.getFirst().get("postalCode");

        checkoutPage.enterLastName(lastName);
        checkoutPage.enterZipCode(postalCode);
    }

    @And("the user taps the continue button")
    public void theUserTapsTheContinueButton() {
        checkoutPage.tapContinue();
    }


    @Then("an error message {string} should be displayed")
    public void anErrorMessageShouldBeDisplayed(String arg0) {
        String actualMessage = checkoutPage.getErrorMessage();
        Assert.assertEquals(actualMessage, arg0, "Error message mismatch");
    }

    @When("the user fills in the first name as {string}")
    public void theUserFillsInTheFirstNameAs(String arg0) {
        checkoutPage.enterFirstName(arg0);
    }

    @Then("the user should be on the checkout overview screen")
    public void theUserShouldBeOnTheCheckoutOverviewScreen() {
        checkoutPage.isOnCheckoutPage();
    }

    @And("the product in the overview should match the selected product")
    public void theProductInTheOverviewShouldMatchTheSelectedProduct() {
        Assert.assertEquals(checkoutPage.getCheckoutItemTitle(), getStoredProductTitle());
    }

    @And("the total price should be correct")
    public void theTotalPriceShouldBeCorrect() {
        Assert.assertEquals(checkoutPage.getCheckoutItemPrice(), getStoredProductPrice());
    }

    @Then("a message {string} should be displayed")
    public void aMessageShouldBeDisplayed(String arg0) {
        Assert.assertEquals(checkoutPage.isOrderConfirmed(), arg0);
    }
}
