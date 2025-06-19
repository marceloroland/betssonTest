package base;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Objects;

public class BasePage {

    protected AppiumDriver driver;

    // Elementos globais
    private final By hamburgerMenuIcon = By.xpath("//android.view.ViewGroup[@content-desc='test-Menu']");
    private final By cartIcon = By.xpath("//android.view.ViewGroup[@content-desc='test-Cart']");
    private final By logoutButton = By.xpath("//android.view.ViewGroup[@content-desc='test-LOGOUT']");
    private final By cartBadge = By.xpath("//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.TextView");

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
    }


    public WebElement waitForElement(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            System.out.println("Elemento não localizado: " + locator.toString());
            throw e;
        }
    }

    public void validateCartBadgeCount(int expectedCount) {
        String badgeText = waitForElement(cartBadge).getText();
        Assert.assertEquals(badgeText, String.valueOf(expectedCount), "Cart badge count mismatch!");
    }


    public void tapHamburgerMenu() {
        waitForElement(hamburgerMenuIcon).click();
    }

    public void tapLogout() {
        waitForElement(logoutButton).click();
    }

    public void tapCartIcon() {
        waitForElement(cartIcon).click();
    }


    public void isHamburgerMenuVisible() {
        waitForElement(hamburgerMenuIcon).isDisplayed();
    }

    public boolean isTextPresent(String text) {
        return Objects.requireNonNull(driver.getPageSource()).contains(text);
    }

}
