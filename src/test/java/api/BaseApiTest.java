package api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public abstract class BaseApiTest {

    protected RequestSpecification requestSpec;

    @BeforeClass
    public void setUpApi() {
        RestAssured.baseURI = "https://automationexercise.com";

        requestSpec = new RequestSpecBuilder()
                .setBaseUri(RestAssured.baseURI)
                .addFilter(new AllureRestAssured())   // attaches request/response to Allure
                .setContentType(ContentType.URLENC)   // form-url-encoded for POSTs
                .build();
    }
}