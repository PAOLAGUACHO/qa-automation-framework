package com.paola.utilities;

import com.paola.pojo.ProductRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.datafaker.Faker;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class TestDataFactory {

    //data generator
    private static final Faker faker = new Faker();


//    public static ProductRequest randomProduct() {
//        String title = faker.commerce().productName();
//        int price = ThreadLocalRandom.current().nextInt(10, 200);
//        String description = faker.lorem().sentence(8);
//        int categoryId = 30;
//        List<String> images = List.of("https://placehold.co/600x400");
//        return new ProductRequest(title, price, description, categoryId, images);
//    }

    public static ProductRequest randomProduct() {

        Response response = given()
                .accept(ContentType.JSON)
                .when()
                .get("/categories")
                .then()
                .statusCode(200)
                .extract().response();

        String title = faker.commerce().productName();
        int price = ThreadLocalRandom.current().nextInt(10, 200);
        String description = faker.lorem().sentence(8);
        Integer categoryId = response.path("[0].id");
        List<String> images = List.of("https://placehold.co/600x400");
        return new ProductRequest(title, price, description, categoryId, images);
    }


}

