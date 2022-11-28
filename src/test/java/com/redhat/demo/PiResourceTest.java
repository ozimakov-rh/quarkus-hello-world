package com.redhat.demo;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PiResourceTest {

    @Test
    public void testPiEndpoint() {
        given()
                .when().get("/pi/4")
                .then()
                .statusCode(200)
                .body("n", is(10000f))
                .body("pi", is(3.1416926F));
    }

}