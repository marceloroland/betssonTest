package pages;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By usernameField = By.xpath("//android.widget.EditText[@content-desc='test-Username']");
    private final By passwordField = By.xpath("//android.widget.EditText[@content-desc='test-Password']");
    private final By loginButton = By.xpath("//android.view.ViewGroup[@content-desc='test-LOGIN']");
    private final By errorMessage = By.xpath("//*[@content-desc='test-Error message']//android.widget.TextView");

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        waitForElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        waitForElement(passwordField).sendKeys(password);
    }

    public void tapLoginButton() {
        waitForElement(loginButton).click();
    }

    public String getErrorMessage() {
        return waitForElement(errorMessage).getText();
    }

    public boolean isOnLoginPage() {
        waitForElement(loginButton);
        return isTextPresent("LOGIN");
    }
}
