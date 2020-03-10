import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static io.trueautomation.client.TrueAutomationHelper.ta;

public class BaseTest {

    private WebDriver driver;
    private By loginBtn = By.xpath(ta("ta:mainPage:loginBtn", "//*[@class='jet-button__label' and text()='Login']"));
    private By goBtn = By.xpath(ta("ta:mainPage:goBtn", "//*[@class='jet-button__label' and text()='Go']"));
    private By signupBtn = By.cssSelector(ta("ta:mainPage:signupBtn", "div.sign-up-container > a"));
    private By emailFl = By.name(ta("ta:loginPage:email", "email"));

    @BeforeClass
    public void beforeTest() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("browserVersion", "80");
        System.setProperty("webdriver.chrome.driver", "/Users/alexeymikheev/chromedriver");
        driver = new ChromeDriver(chromeOptions);
    }

    @Test
    public void exampleTest() {
        driver.get("https://trueautomation.io");

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(loginBtn)).perform();
        driver.findElement(goBtn).click();
        driver.findElement(signupBtn).click();

        driver.findElement(emailFl).sendKeys("your@mail.com");
    }

    @AfterClass
    public void afterTest() {
        driver.quit();
    }
}
