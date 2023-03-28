package com.pab.requestbuilder;

import com.pab.enums.PropertiesType;
import com.pab.utils.PropertyUtils;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
public final class ApiBuilders {

    private ApiBuilders(){}

    public static RequestSpecification buildRequestForGetCalls(){
        return given()
                .baseUri(PropertyUtils.getValue(PropertiesType.BASEURL));
    }

    public static RequestSpecification buildRequestForPostCalls(){
        return given()
                .baseUri(PropertyUtils.getValue(PropertiesType.BASEURL))
                .contentType(ContentType.JSON)
                .log()
                .all();
    }


}
