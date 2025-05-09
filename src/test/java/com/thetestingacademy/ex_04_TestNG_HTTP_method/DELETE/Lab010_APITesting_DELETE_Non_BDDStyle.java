package com.thetestingacademy.ex_04_TestNG_HTTP_method.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab010_APITesting_DELETE_Non_BDDStyle {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;


    @Test
    public void test_DELETE_method() {
        String token = "51218776f7bc7a3";
        String bookingId = "7764";

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" + bookingId);
        r.contentType(ContentType.JSON);
        r.cookie("token", token);
        r.log().all();

        response = r.when().log().all().delete();

        vr = response.then().log().all();
        vr.statusCode(201);

    }
}
