package com.thetestingacademy.ex_03_TestNG_AllureReport;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Lab004_APITesting_TestCase {
    String pincode = "110048";

    @Test
    public void test_GET_Postive_TC1(){
        pincode = "110048";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);

    }

    @Test
    public void test_GET_Negative_TC2(){
        pincode = "@";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);

    }

    @Test
    public void test_GET_Negative_TC3(){
        pincode = " ";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);

    }

}
