package ui;

import ui.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class SubscriptionTest extends BaseTest {

    @Test
    @Description("Test Case 10: Verify Subscription in home page")
    public void verifySubscriptionInHomePage() {
        HomePage homePage = new HomePage(driver);

        scrollToFooter(homePage);
        verifySubscriptionTextVisible(homePage);
        enterEmailAndSubscribe(homePage, "testuser@example.com");
        verifySuccessMessage(homePage);
    }

    @Step("Scroll down to footer")
    private void scrollToFooter(HomePage homePage) {
        homePage.scrollToFooter();
    }

    @Step("Verify 'SUBSCRIPTION' is visible")
    private void verifySubscriptionTextVisible(HomePage homePage) {
        Assert.assertTrue(homePage.isSubscriptionVisible(), "Subscription text should be visible");
    }

    @Step("Enter email address: {email} and click arrow button")
    private void enterEmailAndSubscribe(HomePage homePage, String email) {
        homePage.enterSubscriptionEmail(email);
        homePage.clickSubscribeButton();
    }

    @Step("Verify success message 'You have been successfully subscribed!' is visible")
    private void verifySuccessMessage(HomePage homePage) {
        String actualMessage = homePage.getSuccessMessage();
        Assert.assertTrue(actualMessage.contains("successfully subscribed"),
                "Success message should contain 'successfully subscribed'");
    }
}