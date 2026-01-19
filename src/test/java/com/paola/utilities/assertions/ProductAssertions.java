package com.paola.utilities.assertions;

import com.paola.pojo.ProductRequest;
import com.paola.pojo.ProductResponse;
import io.restassured.path.json.JsonPath;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductAssertions {

    //Private Constructor, preventing new object to be created from this class
    private ProductAssertions(){
    }

    public static void assertProductMatchesRequest(JsonPath jsonPath, ProductRequest req) {
        assertEquals(req.getTitle(), jsonPath.getString("title"));
        assertEquals(req.getPrice(), jsonPath.getInt("price"));
        assertEquals(req.getDescription(), jsonPath.getString("description"));
        assertEquals(req.getCategoryId(), jsonPath.getInt("category.id"));
        assertEquals(req.getImages(), jsonPath.getList("images"));
    }

    public static void assertIdMatches(int expectedId, ProductResponse response) {
        assertEquals(expectedId, response.getId());
    }
}
