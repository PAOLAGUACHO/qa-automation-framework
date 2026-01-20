package com.paola.tests.api;

import com.paola.utilities.ApiBaseTest;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.*;

public class CategoriesGetTests extends ApiBaseTest {

    @DisplayName("GET all categories")
    @Test
    public void getCategories() {
        JsonPath response = given()
                .accept(ContentType.JSON)
                .when()
                .get("/categories")
                .then()
                .statusCode(200)
                .body("$",hasSize(greaterThan(0)))
                .body("[0].id",notNullValue())
                .extract().jsonPath();
    }

    @DisplayName("GET response with wrong endpoint should Fail")
    @Test
    public void getCategories_wrongEndpoint_shouldReturn404(){
        given()
                .accept(ContentType.JSON)
                .when()
                .get("/category")
                .then()
                .log().ifValidationFails()
                .statusCode(404);
    }
}
