package api;

import static org.hamcrest.Matchers.containsString;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LoginApiTest extends BaseApiTest {

    // Use an actually existing user on AutomationExercise.
    // If your UI test created "johndoe@example.com" with password "123456", reuse that here.
    private static final String VALID_EMAIL = "johndoe@example.com";
    private static final String VALID_PASSWORD = "123456";

    @Test
    @Description("API 7: POST To Verify Login with valid details")
    public void postVerifyLoginWithValidDetails_shouldReturnStructuredResponse() {
        given()
                .spec(requestSpec)
                .formParam("email", VALID_EMAIL)
                .formParam("password", VALID_PASSWORD)
                .when()
                .post("/api/verifyLogin")
                .then()
                .statusCode(200)
                .body(containsString("responseCode"))
                .body(containsString("message"));
    }

    @Test
    @Description("API 8: POST To Verify Login without email parameter")
    public void postVerifyLoginWithoutEmail_shouldReturnBadRequestMessage() {
        given()
                .spec(requestSpec)
                .formParam("password", VALID_PASSWORD)
                .when()
                .post("/api/verifyLogin")
                .then()
                .statusCode(200)
                .body(containsString("email or password parameter is missing"));
    }

    @Test
    @Description("API 9: DELETE To Verify Login")
    public void deleteVerifyLogin_shouldReturnMethodNotSupportedMessage() {
        given()
                .spec(requestSpec)
                .when()
                .delete("/api/verifyLogin")
                .then()
                .statusCode(200)
                .body(containsString("This request method is not supported"));
    }

    @Test
    @Description("API 10: POST To Verify Login with invalid details")
    public void postVerifyLoginWithInvalidDetails_shouldReturnUserNotFoundMessage() {
        given()
                .spec(requestSpec)
                .formParam("email", "nonexistent_user_123@example.com")
                .formParam("password", "wrongpassword")
                .when()
                .post("/api/verifyLogin")
                .then()
                .statusCode(200)
                .body(containsString("User not found"));
    }
}