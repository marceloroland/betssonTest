package steps;

import base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CartPage;
import org.testng.Assert;

import static steps.ProductsSteps.getStoredProductPrice;
import static steps.ProductsSteps.getStoredProductTitle;

public class CartSteps extends BaseTest {

    private final CartPage cartPage = new CartPage(driver);


    @Then("the user taps the checkout button")
    public void theUserTapsTheCheckoutButton() {
        cartPage.tapCheckoutButton();
    }

    @Then("the user should be on the cart screen")
    public void theUserShouldBeOnTheCartScreen() {
        cartPage.isOnCartPage();
    }

    @And("the product in the cart should have the same title and price")
    public void theProductInTheCartShouldHaveTheSameTitleAndPrice() {
        String actualTitle = cartPage.getCartItemTitle();
        String actualPrice = cartPage.getCartItemPrice();

        Assert.assertEquals(actualTitle, getStoredProductTitle(), "Item titles does not match");
        Assert.assertEquals(actualPrice, getStoredProductPrice(), "Item price does not match");
    }
}
