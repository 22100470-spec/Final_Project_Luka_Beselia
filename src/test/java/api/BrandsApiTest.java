package api;

import static org.hamcrest.Matchers.containsString;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class BrandsApiTest extends BaseApiTest {

    @Test
    @Description("API 3: Get All Brands List")
    public void getAllBrandsList_shouldReturn200AndNonEmptyList() {
        given()
                .spec(requestSpec)
                .when()
                .get("/api/brandsList")
                .then()
                .statusCode(200)
                .body("brands", notNullValue())
                .body("brands.size()", greaterThan(0));
    }

    @Test
    @Description("API 4: PUT To All Brands List")
    public void putToAllBrandsList_shouldReturnMethodNotSupportedMessage() {
        given()
                .spec(requestSpec)
                .when()
                .put("/api/brandsList")
                .then()
                .statusCode(200)
                .body(containsString("This request method is not supported"));
    }
}