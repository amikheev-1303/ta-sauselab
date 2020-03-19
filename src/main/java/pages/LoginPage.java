package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static io.trueautomation.client.TrueAutomationHelper.ta;

public class LoginPage {
    protected static WebDriver driver;

    private By signUpBtnTA = By.cssSelector(ta("ta:mainPage:signupBtn", "div.sign-up-container > a[href='signup']"));
    private By signUpBtn = By.cssSelector("div.sign-up-container > a[href='signup']");
    private By signInBtnTA = By.cssSelector(ta("ta:mainPage:signinBtn", "div.sign-up-container > a[href='signin']"));
    private By signInBtn = By.cssSelector("div.sign-up-container > a[href='signin']");
    private By emailFlTA = By.name(ta("ta:loginPage:email", "email"));
    private By emailFl = By.name("email");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public LoginPage opensSignUpForm(){
        driver.findElement(signUpBtn).click();
        return new LoginPage(driver);
    }

    @Step
    public LoginPage opensSignInForm(){
        driver.findElement(signInBtn).click();
        return new LoginPage(driver);
    }

    @Step
    public LoginPage entersEmail(String email) {
        driver.findElement(emailFl).sendKeys(email);
        return new LoginPage(driver);
    }
}
