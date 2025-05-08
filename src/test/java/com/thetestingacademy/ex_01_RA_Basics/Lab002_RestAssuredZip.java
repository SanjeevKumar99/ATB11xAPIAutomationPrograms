package com.thetestingacademy.ex_01_RA_Basics;

import io.restassured.RestAssured;

public class Lab002_RestAssuredZip {
    public static void main(String[] args) {
        // https://api.zippopotam.us/us/90210
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/560016")
                .when()
                .get()
                .then()
                .log().all().statusCode(200);
    }

}
