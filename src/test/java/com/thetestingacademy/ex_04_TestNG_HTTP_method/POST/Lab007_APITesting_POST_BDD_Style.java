package com.thetestingacademy.ex_04_TestNG_HTTP_method.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class Lab007_APITesting_POST_BDD_Style {

    String payload="{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";
    @Test
    public void test_POST_Auth(){
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON)
                .log().all()
                .body(payload)
                .when().log().all()
                .post()
                .then().log().all()
                .statusCode(200);
    }
}
