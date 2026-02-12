package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupLoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By signupNameInput = By.name("name");
    private By signupEmailInput = By.xpath("//input[@data-qa='signup-email']");
    private By signupButton = By.xpath("//button[@data-qa='signup-button']");

    private By loginEmailInput = By.xpath("//input[@data-qa='login-email']");
    private By loginPasswordInput = By.xpath("//input[@data-qa='login-password']");
    private By loginButton = By.xpath("//button[@data-qa='login-button']");

    private By newUserSignupText = By.xpath("//h2[text()='New User Signup!']");
    private By loginToAccountText = By.xpath("//h2[text()='Login to your account']");
    private By incorrectCredentialsError = By.xpath("//p[text()='Your email or password is incorrect!']");
    private By emailExistsError = By.xpath("//p[text()='Email Address already exist!']");

    public SignupLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isNewUserSignupVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(newUserSignupText)).isDisplayed();
    }

    public boolean isLoginToAccountVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginToAccountText)).isDisplayed();
    }

    public void enterSignupName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupNameInput)).sendKeys(name);
    }

    public void enterSignupEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupEmailInput)).sendKeys(email);
    }

    public void clickSignupButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signupButton)).click();
    }

    public void enterLoginEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginEmailInput)).sendKeys(email);
    }

    public void enterLoginPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPasswordInput)).sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public boolean isIncorrectCredentialsErrorVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(incorrectCredentialsError)).isDisplayed();
    }

    public boolean isEmailExistsErrorVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emailExistsError)).isDisplayed();
    }
}
