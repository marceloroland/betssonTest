package pages;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class CartPage extends BasePage {

    private final By cartItemTitle = By.xpath("(//android.view.ViewGroup[@content-desc=\"test-Description\"]//android.widget.TextView)[1]");
    private final By cartItemPrice = By.xpath("(//android.view.ViewGroup[@content-desc=\"test-Price\"]//android.widget.TextView)[1]");
    private final By checkoutButton = By.xpath("//android.view.ViewGroup[@content-desc='test-CHECKOUT']");

    public CartPage(AppiumDriver driver) {
        super(driver);
    }

    public String getCartItemTitle() {
        return waitForElement(cartItemTitle).getText();
    }

    public String getCartItemPrice() {
        return waitForElement(cartItemPrice).getText();
    }

    public void tapCheckoutButton() {
        waitForElement(checkoutButton).click();
    }

    public void isOnCartPage() {
        isTextPresent("YOUR CART");
    }
}
