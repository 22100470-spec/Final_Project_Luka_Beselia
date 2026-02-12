package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By getInTouchText = By.xpath("//h2[text()='Get In Touch']");
    private By nameInput = By.name("name");
    private By emailInput = By.name("email");
    private By subjectInput = By.name("subject");
    private By messageInput = By.id("message");
    private By uploadFileInput = By.name("upload_file");
    private By submitButton = By.name("submit");
    private By successMessage = By.xpath("//div[@class='status alert alert-success']");
    private By homeButton = By.xpath("//a[@class='btn btn-success']");

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isGetInTouchVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(getInTouchText)).isDisplayed();
    }

    public void enterName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterSubject(String subject) {
        driver.findElement(subjectInput).sendKeys(subject);
    }

    public void enterMessage(String message) {
        driver.findElement(messageInput).sendKeys(message);
    }

    public void uploadFile(String path) {
        driver.findElement(uploadFileInput).sendKeys(path);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    public void acceptAlert() {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
        } catch (Exception e) {
            // ignore
        }
    }

    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText();
    }

    public void clickHomeButton() {
        driver.findElement(homeButton).click();
    }
}
