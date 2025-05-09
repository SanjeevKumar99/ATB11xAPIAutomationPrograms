package com.thetestingacademy.ex_04_TestNG_HTTP_method.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab006_APITesting_GET_Non_BDD_Style {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;


    @Test
    public void test_Positive_GET(){
        String pincode = "110048";
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/"+pincode);

        response=r.when().log().all().get();
        System.out.println(response.asString());

        vr=response.then().log().all();
        vr.statusCode(200);

    }
}
