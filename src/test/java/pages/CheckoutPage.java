package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class CheckoutPage extends BasePage {

    private final By firstNameField = By.xpath("//android.widget.EditText[@content-desc='test-First Name']");
    private final By lastNameField = By.xpath("//android.widget.EditText[@content-desc='test-Last Name']");
    private final By zipCodeField = By.xpath("//android.widget.EditText[@content-desc='test-Zip/Postal Code']");
    private final By continueButton = By.xpath("//android.view.ViewGroup[@content-desc='test-CONTINUE']");
    private final By finishButton = By.xpath("//android.view.ViewGroup[@content-desc='test-FINISH']");
    private final By errorMessage = By.xpath("(//android.view.ViewGroup[@content-desc=\"test-Error message\"]//android.widget.TextView)");
    private final By checkoutItemTitle = By.xpath("(//android.view.ViewGroup[@content-desc=\"test-Description\"]//android.widget.TextView)[1]");
    private final By checkoutItemPrice = By.xpath("(//android.view.ViewGroup[@content-desc=\"test-Price\"]//android.widget.TextView)[1]");
    private final By confirmationMessage = By.xpath("//android.widget.TextView[@text='THANK YOU FOR YOU ORDER']");
    private final By backHomeButton = By.xpath("//android.view.ViewGroup[@content-desc='test-BACK HOME']");

    public CheckoutPage(AppiumDriver driver) {
        super(driver);
    }

    public void enterFirstName(String firstName) {
        waitForElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        waitForElement(lastNameField).sendKeys(lastName);
    }

    public void enterZipCode(String zipCode) {
        waitForElement(zipCodeField).sendKeys(zipCode);
    }

    public void tapContinue() {
        waitForElement(continueButton).click();
    }

    public void tapFinish() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().description(\"test-FINISH\"))"
        ));

        waitForElement(finishButton).click();
    }


    public String getCheckoutItemTitle() {
        return waitForElement(checkoutItemTitle).getText();
    }

    public String getCheckoutItemPrice() {
        return waitForElement(checkoutItemPrice).getText();
    }

    public String getErrorMessage() {
        return waitForElement(errorMessage).getText();
    }

    public String isOrderConfirmed() {
        return waitForElement(confirmationMessage).getText();
    }

    public void tapBackHome() {
        waitForElement(backHomeButton).click();
    }

    public void isOnCheckoutPage() {
        isTextPresent("CHECKOUT");
    }
}
