package com.paola.utilities;

import com.paola.pojo.ProductRequest;
import io.restassured.path.json.JsonPath;
import net.datafaker.Faker;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

import static io.restassured.RestAssured.given;

public class TestDataFactory {

    //data generator
    private static final Faker faker = new Faker();


    public static ProductRequest randomProduct() {
        String title = faker.commerce().productName();
        int price = ThreadLocalRandom.current().nextInt(10, 200);
        String description = faker.lorem().sentence(8);
        int categoryId = 5;
        List<String> images = List.of("https://placehold.co/600x400");
        return new ProductRequest(title, price, description, categoryId, images);
    }

}

