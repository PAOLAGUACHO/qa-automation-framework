package com.paola.tests.api;

import com.paola.pojo.ProductRequest;
import com.paola.utilities.ApiBaseTest;
import com.paola.utilities.TestDataFactory;
import com.paola.utilities.assertions.ProductAssertions;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static com.paola.utilities.assertions.ProductAssertions.assertProductMatchesRequest;

public class PostUserTest extends ApiBaseTest {

    @DisplayName("Validating one Product flow")
    @Test
    public void newUser() {

        ProductRequest product = TestDataFactory.randomProduct();

        JsonPath jsonPath = given()
                .contentType(ContentType.JSON)
                .body(product)
                .when()
                .post("/products/")
                .then().log().ifValidationFails()
                .statusCode(201)
                .extract().jsonPath(); // Chaining

        ProductAssertions.assertProductMatchesRequest(jsonPath, product);


        int id = jsonPath.getInt("id");
        System.out.println(id);

        JsonPath responseJson = given()
                .contentType(ContentType.JSON)
                .pathParam("id", id)
                .when()
                .get("/products/{id}")
                .then()
                .statusCode(200)
                .extract().jsonPath();

        ProductAssertions.assertIdMatches(id,responseJson);

    }

    @DisplayName("Validate product without title should Fail")
    @Test
    public void createProductWithoutTitle_shouldFail(){

        String body = "{\n" +
                "  \"title\": \"\",\n" +
                "  \"price\": 10,\n" +
                "  \"description\": \"A description\",\n" +
                "  \"categoryId\": 1,\n" +
                "  \"images\": [\"https://placehold.co/600x400\"]\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/products/")
                .then()
                .statusCode(not(201))
                .body("message",notNullValue());
    }

    @DisplayName("Validate product with negative price should Fail")
    @Test
    public void createProductWithNegativePrice_shouldFail(){

        String body = "{\n" +
                "  \n" +
                "  \"title\": \"Negative Shirt\",\n" +
                "  \"price\": -5,\n" +
                "  \"description\": \"A description\",\n" +
                "  \"categoryId\": 1,\n" +
                "  \"images\": [\"https://placehold.co/600x400\"]\n" +
                "\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/products/")
                .then()
                .log().ifValidationFails()
                .statusCode(not(201));
    }

}
