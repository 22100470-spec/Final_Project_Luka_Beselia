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


    public void clickSignupLogin() {
        WebElement signupLogin = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Signup / Login')]"))
        );
        signupLogin.click();
    }


    public void clickLogout() {
        if (!isLoggedInAsVisible()) {
            return;
        }

        try {
            WebElement logout = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Logout')]"))
            );
            logout.click();
        } catch (Exception e) {
            // ignore if  not clickable
        }
    }

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


    public void clickContinueAfterDelete() {
        WebElement continueBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Continue']"))
        );
        continueBtn.click();
    }
}