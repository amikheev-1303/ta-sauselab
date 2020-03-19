package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.trueautomation.client.TrueAutomationHelper.ta;

public class MainPage {
    protected static WebDriver driver;

    private By goBtnTA = By.xpath(ta("ta:mainPage:goBtn", "//*[@class='jet-button__label' and text()='Go']"));
    private By goBtn = By.xpath("//*[@class='jet-button__label' and text()='Go']");
    private By loginBtnTA = By.xpath(ta("ta:mainPage:loginBtn", "//*[@class='jet-button__label' and text()='Login']"));
    private By loginBtn = By.xpath("//*[@class='jet-button__label' and text()='Login']");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public LoginPage goesToLoginPage() {
        WebDriverWait wait = new WebDriverWait(driver, 6);
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtn));
        actions.moveToElement(driver.findElement(loginBtn)).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(goBtn));
        driver.findElement(goBtn).click();
        return new LoginPage(driver);
    }

    @Step
    public MainPage open() {
        driver.get("https://trueautomation.io");
        return new MainPage(driver);
    }
}
