package com.paola.utilities;

import org.junit.jupiter.api.BeforeAll;
import static io.restassured.RestAssured.baseURI;

public class ApiBaseTest {

   // Centralized Configuration

    @BeforeAll
    public static void setUp(){
      baseURI = "https://api.escuelajs.co/api/v1";
    }
}
