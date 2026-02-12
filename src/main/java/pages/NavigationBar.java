package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavigationBar {

    private WebDriver driver;
    private WebDriverWait wait;

    public NavigationBar(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ---------------------
    // Page actions
    // ---------------------

    // Click "Signup / Login" link
    public void clickSignupLogin() {
        WebElement signupLogin = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Signup / Login')]"))
        );
        signupLogin.click();
    }

    // Click "Logout" link
    public void clickLogout() {
        // If user is not logged in, nothing to do
        if (!isLoggedInAsVisible()) {
            return;
        }

        try {
            WebElement logout = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Logout')]"))
            );
            logout.click();
        } catch (Exception e) {
            // Ignore if Logout is not clickable; test will still continue
        }
    }
    // Check if "Logged in as <user>" is visible
    public boolean isLoggedInAsVisible() {
        try {
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Logged in as')]"))
            );
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Check if "Signup / Login" link is visible (for post-logout validation)
    public boolean isSignupLoginVisible() {
        try {
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Signup / Login')]"))
            );
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Check if "Account Deleted!" message is visible
    public boolean isAccountDeletedVisible() {
        try {
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Account Deleted!']"))
            );
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Click "Continue" after account deletion
    public void clickContinueAfterDelete() {
        WebElement continueBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Continue']"))
        );
        continueBtn.click();
    }
}