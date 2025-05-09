package com.thetestingacademy.ex_04_TestNG_HTTP_method.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab010_APITesting_PATCH_Non_BDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;


    @Test
    public void test_PATCH_method(){
        String token="80b4fa50bbf9d2e";
        String bookingId="1565";

        String payloadPatch="{\n" +
                "    \"firstname\" : \"Sanjeev\",\n" +
                "    \"lastname\" : \"Kushwaha\"\n" +
                "}";

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingId);
        r.contentType(ContentType.JSON);
        r.cookie("token", token);
        r.body(payloadPatch).log().all();

        response=r.when().log().all().patch();

        vr=response.then().log().all();
        vr.statusCode(200);


    }
}
