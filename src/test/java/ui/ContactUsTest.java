package ui;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.NavigationBar;

public class ContactUsTest extends BaseTest {

    @Test
    @Description("Test Case 6: Contact Us Form")
    public void submitContactUsForm() {
        navigateToContactUsPage();
        ContactUsPage contactPage = new ContactUsPage(driver);

        verifyGetInTouchVisible(contactPage);
        fillContactForm(contactPage);
        submitForm(contactPage);
        verifySuccessMessage(contactPage);
        returnToHomePage(contactPage);
    }

    @Step("Navigate to Contact Us page")
    private void navigateToContactUsPage() {
        driver.findElement(org.openqa.selenium.By.xpath("//a[@href='/contact_us']")).click();
    }

    @Step("Verify 'GET IN TOUCH' is visible")
    private void verifyGetInTouchVisible(ContactUsPage page) {
        Assert.assertTrue(page.isGetInTouchVisible());
    }

    @Step("Fill contact form with name, email, subject and message")
    private void fillContactForm(ContactUsPage page) {
        page.enterName("Test User");
        page.enterEmail("testuser@example.com");
        page.enterSubject("Test Subject");
        page.enterMessage("This is a test message");
    }

    @Step("Upload file and click Submit button")
    private void submitForm(ContactUsPage page) {
        // Create a simple text file for upload
        String userDir = System.getProperty("user.dir");
        String filePath = userDir + "\\testfile.txt";

        try {
            java.io.File file = new java.io.File(filePath);
            if (!file.exists()) {
                file.createNewFile();
                java.io.FileWriter writer = new java.io.FileWriter(file);
                writer.write("Test file content");
                writer.close();
            }
            page.uploadFile(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        page.clickSubmit();
        page.acceptAlert();
    }

    @Step("Verify success message")
    private void verifySuccessMessage(ContactUsPage page) {
        String message = page.getSuccessMessage();
        Assert.assertTrue(message.contains("Success"));
    }

    @Step("Click Home button and verify navigated to home page")
    private void returnToHomePage(ContactUsPage page) {
        page.clickHomeButton();
    }
}