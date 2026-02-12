package api;

import static org.hamcrest.Matchers.containsString;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ProductsApiTest extends BaseApiTest {

    @Test
    @Description("API 1: Get All Products List")
    public void getAllProductsList_shouldReturn200AndNonEmptyList() {
        given()
                .spec(requestSpec)
                .when()
                .get("/api/productsList")
                .then()
                .statusCode(200)
                .body("products", notNullValue())
                .body("products.size()", greaterThan(0));
    }

    @Test
    @Description("API 2: POST To All Products List")
    public void postToAllProductsList_shouldReturnMethodNotSupportedMessage() {
        given()
                .spec(requestSpec)
                .when()
                .post("/api/productsList")
                .then()
                .statusCode(200)
                .body(containsString("This request method is not supported"));
    }
}