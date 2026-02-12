package api;

import static org.hamcrest.Matchers.containsString;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SearchProductApiTest extends BaseApiTest {

    @Test
    @Description("API 5: POST To Search Product")
    public void postToSearchProduct_shouldReturn200AndProducts() {
        given()
                .spec(requestSpec)
                .formParam("search_product", "top")
                .when()
                .post("/api/searchProduct")
                .then()
                .statusCode(200)
                .body("products", notNullValue())
                .body("products.size()", greaterThan(0));
    }

    @Test
    @Description("API 6: POST To Search Product without search_product parameter")
    public void postToSearchProductWithoutParam_shouldReturnBadRequestMessage() {
        given()
                .spec(requestSpec)
                .when()
                .post("/api/searchProduct")
                .then()
                .statusCode(200)
                .body(containsString("search_product parameter is missing"));
    }
}