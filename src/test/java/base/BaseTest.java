// BaseTest.java (responsável pelo setup e teardown)
package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    public static AppiumDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        if (driver == null) {
            UiAutomator2Options options = new UiAutomator2Options()
                    .setPlatformName(MobilePlatform.ANDROID)
                    .setDeviceName("emulator-5554")
                    .setApp(System.getProperty("user.dir") + "/src/test/resources/apk/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk")
                    .setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2)
                    .setAppPackage("com.swaglabsmobileapp")
                    .setAppActivity("com.swaglabsmobileapp.MainActivity")
                    .setNoReset(false)
                    .setNewCommandTimeout(Duration.ofSeconds(300));

            URL appiumServer = new URL("http://localhost:4723/");
            driver = new AndroidDriver(appiumServer, options);
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
