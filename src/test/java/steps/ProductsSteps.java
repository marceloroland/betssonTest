package steps;

import base.BasePage;
import base.BaseTest;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductsSteps extends BaseTest{

    private final ProductsPage productsPage = new ProductsPage(driver);
    private final BasePage basePage = new BasePage(driver);
    private final LoginPage loginPage = new LoginPage(driver);

    private static String storedProductTitle;
    private static String storedProductPrice;


    @Then("the user should be on the products screen")
    public void userShouldBeOnProductsScreen() {
        Assert.assertTrue(productsPage.isOnProductsPage(), "User is not on Products screen");
    }

    @And("the user stores the title and price of the first product")
    public void theUserStoresTheTitleAndPriceOfTheFirstProduct() {
        productsPage.selectProductByIndex(1);
        storedProductTitle = productsPage.getProductTitle();
        storedProductPrice = productsPage.getProductPrice();
    }


    @And("the user navigates to the mini cart")
    public void userNavigatesToCart() {
        basePage.tapCartIcon();
    }


    public static String getStoredProductTitle() {
        return storedProductTitle;
    }

    public static String getStoredProductPrice() {
        return storedProductPrice;
    }

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        loginPage.isOnLoginPage();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.tapLoginButton();
        Assert.assertTrue(productsPage.isOnProductsPage(), "User is not on the products screen");
    }

    @When("the user taps on a product item")
    public void theUserTapsOnAProductItem() {
        productsPage.selectProductByIndex(1);
    }

    @Then("the product details screen should be displayed")
    public void theProductDetailsScreenShouldBeDisplayed() {
        productsPage.isProductDescriptionValid();
        productsPage.isProductPriceValid();
    }


    @And("the user taps add to cart on the stored product")
    public void theUserTapsAddToCartOnTheStoredProduct() {
        productsPage.tapAddToCartInventoryPage();
    }

    @Then("the mini cart icon should show {int} item")
    public void theMiniCartIconShouldShowItem(int arg0) {
        productsPage.verifyCartBadgeCount(arg0);
    }

    @When("the user taps the mini cart icon")
    public void theUserTapsTheMiniCartIcon() {
        basePage.tapCartIcon();
    }

    @And("the user opens the menu")
    public void theUserOpensTheMenu() {
        basePage.tapHamburgerMenu();
    }
}
