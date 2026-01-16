package com.paola.tests.api;

import com.paola.pojo.ProductRequest;
import com.paola.utilities.ApiBaseTest;
import com.paola.utilities.TestDataFactory;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

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
                .and()
                .body("title", is(product.getTitle()))
                .body("price", is(product.getPrice()))
                .body("description", is(product.getDescription()))
                .body("category.id", is(product.getCategoryId()))
                .body("images", is(product.getImages()))
                .extract().jsonPath(); // Chaining

        int id = jsonPath.getInt("id");

        given()
                .contentType(ContentType.JSON)
                .pathParam("id", id)
                .when()
                .get("/products/{id}")
                .then()
                .statusCode(200)
                .body("id", is(id));

    }


}
