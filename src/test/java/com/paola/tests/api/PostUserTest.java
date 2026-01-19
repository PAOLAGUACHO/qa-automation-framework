package com.paola.tests.api;

import com.paola.pojo.ProductRequest;
import com.paola.utilities.ApiBaseTest;
import com.paola.utilities.TestDataFactory;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostUserTest extends ApiBaseTest {

    @DisplayName("Validating one business flow")
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

        assertProductMatchesRequest(jsonPath, product);


        int id = jsonPath.getInt("id");

        JsonPath responseJson = given()
                .contentType(ContentType.JSON)
                .pathParam("id", id)
                .when()
                .get("/products/{id}")
                .then()
                .statusCode(200)
                .extract().jsonPath();

        assertIdMatches(id,responseJson);

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

    private void assertProductMatchesRequest(JsonPath jsonPath, ProductRequest req) {
        assertEquals(req.getTitle(), jsonPath.getString("title"));
        assertEquals(req.getPrice(), jsonPath.getInt("price"));
        assertEquals(req.getDescription(), jsonPath.getString("description"));
        assertEquals(req.getCategoryId(), jsonPath.getInt("category.id"));
        assertEquals(req.getImages(), jsonPath.getList("images"));
    }

    private void assertIdMatches(int expectedId,JsonPath json) {
        assertEquals(expectedId, json.getInt("id"));
    }



}
