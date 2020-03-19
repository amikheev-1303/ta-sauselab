import io.trueautomation.client.driver.TrueAutomationDriver;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MainPage;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    private WebDriver driver;

    @Test
    public void exampleTest() {
        new MainPage(driver)
                .open()
                .goesToLoginPage()
                .opensSignUpForm()
                .entersEmail("your@mail.com");

    }

    @BeforeClass
    public void beforeTest() throws MalformedURLException {
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("screenResolution", "2360x1770");

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setExperimentalOption("w3c", true);
        browserOptions.setCapability("platformName", "macOS 10.15");
        browserOptions.setCapability("browserVersion", "80.0");
        browserOptions.setCapability("sauce:options", sauceOptions);
        //driver = new RemoteWebDriver(new URL(""), browserOptions);
        driver = new TrueAutomationDriver(new URL(""), browserOptions);

    }

    @AfterClass
    public void afterTest() {
        driver.quit();
    }
}
