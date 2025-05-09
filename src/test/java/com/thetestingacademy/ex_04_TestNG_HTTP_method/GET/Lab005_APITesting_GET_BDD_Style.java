package com.thetestingacademy.ex_04_TestNG_HTTP_method.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Lab005_APITesting_GET_BDD_Style {
    String pincode = "110048";

    @Test
    public void test_GET_Postive(){
        pincode = "110048";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);

    }
}
