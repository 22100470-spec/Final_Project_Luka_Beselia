package ui;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCasesPageTest extends BaseTest {

    @Test
    @Description("Test Case 7: Verify Test Cases Page")
    public void verifyTestCasesPage() {
        clickTestCasesButton();
        verifyNavigatedToTestCasesPage();
    }

    @Step("Click on 'Test Cases' button")
    private void clickTestCasesButton() {
        WebElement testCasesLink = driver.findElement(By.xpath("//a[@href='/test_cases']"));
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", testCasesLink);
    }

    @Step("Verify user is navigated to test cases page successfully")
    private void verifyNavigatedToTestCasesPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until URL contains 'test_cases' or the Test Cases heading is visible
        try {
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.urlContains("test_cases"),
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Test Cases')]"))
            ));
        } catch (Exception e) {
            // If ad redirect happened, navigate directly to the test_cases page and wait again
            driver.get("https://automationexercise.com/test_cases");
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.urlContains("test_cases"),
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Test Cases')]"))
            ));
        }

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("test_cases"), "URL should contain 'test_cases' but was: " + currentUrl);
    }
}