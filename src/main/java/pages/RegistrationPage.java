package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Signup form
    public void enterName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name"))).sendKeys(name);
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-qa='signup-email']")))
                .sendKeys(email);
    }

    public void clickSignupButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-qa='signup-button']"))).click();
    }

    // Account information
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(password);
    }

    public void selectDay(String day) {
        driver.findElement(By.id("days")).sendKeys(day);
    }

    public void selectMonth(String month) {
        driver.findElement(By.id("months")).sendKeys(month);
    }

    public void selectYear(String year) {
        driver.findElement(By.id("years")).sendKeys(year);
    }

    public void clickNewsletterCheckbox() {
        driver.findElement(By.id("newsletter")).click();
    }

    public void clickOffersCheckbox() {
        driver.findElement(By.id("optin")).click();
    }

    // Address info
    public void enterFirstName(String firstName) {
        driver.findElement(By.id("first_name")).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(By.id("last_name")).sendKeys(lastName);
    }

    public void enterCompany(String company) {
        driver.findElement(By.id("company")).sendKeys(company);
    }

    public void enterAddress1(String address1) {
        driver.findElement(By.id("address1")).sendKeys(address1);
    }

    public void enterAddress2(String address2) {
        driver.findElement(By.id("address2")).sendKeys(address2);
    }

    public void selectCountry(String country) {
        driver.findElement(By.id("country")).sendKeys(country);
    }

    public void enterState(String state) {
        driver.findElement(By.id("state")).sendKeys(state);
    }

    public void enterCity(String city) {
        driver.findElement(By.id("city")).sendKeys(city);
    }

    public void enterZipcode(String zipcode) {
        driver.findElement(By.id("zipcode")).sendKeys(zipcode);
    }

    public void enterMobileNumber(String mobileNumber) {
        driver.findElement(By.id("mobile_number")).sendKeys(mobileNumber);
    }

    public void clickCreateAccount() {
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
    }

    public void clickContinueButton() {
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
    }

    // Visibility checks
    public boolean isAccountCreatedVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//b[text()='Account Created!']"))).isDisplayed();
    }

    public boolean isEmailAlreadyExistVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//b[text()='Email Address already exist!']"))).isDisplayed();
    }
}
