package pages;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage {

    private final By cartIcon = By.xpath("//android.view.ViewGroup[@content-desc='test-Cart']");
    private final By productsTitle = By.xpath("//android.widget.TextView[@text='PRODUCTS' and @package='com.swaglabsmobileapp']");
    private final By allProducts = By.xpath("//*[@content-desc='test-Item title']");
    private final By productTitle = By.xpath("//android.view.ViewGroup[@content-desc='test-Description']/android.widget.TextView[1]");
    private final By productDescription = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Description\"]");
    private final By productPrice = By.xpath("//android.widget.TextView[@content-desc=\"test-Price\"]");
    private final By addToCartInventoryPage = By.xpath("//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"]");


    public ProductsPage(AppiumDriver driver) {
        super(driver);
    }

    public void tapCartIcon() {
        waitForElement(cartIcon).click();
    }

    public void tapAddToCartInventoryPage() {
        waitForElement(addToCartInventoryPage).click();
    }

    public List<WebElement> getAllProducts() {
        return driver.findElements(allProducts);
    }

    public void selectProductByIndex(int index) {
        List<WebElement> products = getAllProducts();
        if (index < 0 || index >= products.size()) {
            throw new IndexOutOfBoundsException("Invalid product index: " + index);
        }
        products.get(index).click();
    }

    public void verifyCartBadgeCount(int expectedCount) {
        validateCartBadgeCount(expectedCount);
    }

    public String getProductTitle() {
        return waitForElement(productTitle).getText();
    }

    public void getProductDescription() {
        waitForElement(productDescription).getText();
    }

    public String getProductPrice() {
        return waitForElement(productPrice).getText();
    }

    public void isProductPriceValid() {
       getProductPrice();
    }

    public void isProductDescriptionValid() {
        getProductDescription();
    }

    public boolean isOnProductsPage() {
        try {
            return waitForElement(productsTitle).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
