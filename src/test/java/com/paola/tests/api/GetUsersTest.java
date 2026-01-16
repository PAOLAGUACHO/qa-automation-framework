package com.paola.tests.api;

import com.paola.utilities.ApiBaseTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.baseURI;

public class GetUsersTest extends ApiBaseTest {

    @Test
    public void getUsers() {

        given()
                .when()
                .get("/products")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0))
                .body("[0].id", notNullValue());
    }


}
