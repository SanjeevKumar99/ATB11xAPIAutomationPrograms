package com.thetestingacademy.ex_04_TestNG_HTTP_method.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab009_APITesting_PUT_Non_BDDStyle {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_PUT_method(){
        String token="3c2aaf52022752e";
        String bookingId="326";

        String payloadPUT="{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingId);
        r.contentType(ContentType.JSON);
        r.cookie("token",token);
        r.body(payloadPUT);

        response = r.when().log().all().put();

        vr = response.then().log().all();
        vr.statusCode(200);
    }
}
