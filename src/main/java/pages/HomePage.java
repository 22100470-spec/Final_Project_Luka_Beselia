package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By subscriptionText = By.xpath("//h2[text()='Subscription']");
    private By emailInput = By.id("susbscribe_email");
    private By arrowButton = By.id("subscribe");
    private By successMessage = By.xpath("//div[@class='alert-success alert']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void scrollToFooter() {
        WebElement subscription = wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionText));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", subscription);
    }

    public boolean isSubscriptionVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionText)).isDisplayed();
    }

    public void enterSubscriptionEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys(email);
    }

    public void clickSubscribeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(arrowButton)).click();
    }

    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText();
    }
}