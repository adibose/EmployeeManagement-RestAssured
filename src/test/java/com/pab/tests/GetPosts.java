package com.pab.tests;

import static com.pab.constants.FrameworkConstants.*;
import com.pab.pojo.Employee;
import com.pab.reports.ExtentLogger;
import com.pab.requestbuilder.ApiBuilders;
import static com.pab.utils.RandomUtils.*;

import com.pab.utils.ApiUtils;
import com.pab.utils.RandomUtils;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class GetPosts extends BaseTest{

    Employee emp = Employee.builder()
            .setId(getID())
            .setFname(getFirstName())
            .setLname(getLastName())
            .setEmail(getEmail())
            .build();

    @Test
    public void createEmployee(){
        Response response = ApiBuilders
                .buildRequestForPostCalls()
                .body(emp)
                .post("/employees");
        ExtentLogger.logResponse(response.asPrettyString());

        Assertions.assertThat(response.getStatusCode()).isEqualTo(202);
    }
    @Test
    public void postRequestUsingExternalFile(){
        String resource = ApiUtils.readJsonAndGetAsString(getRequestJsonFolderPath()+"request.json")
                .replace("fname", RandomUtils.getFirstName())
                .replace("number",String.valueOf(RandomUtils.getID()));

        Response response = ApiBuilders
                .buildRequestForPostCalls()
                .body(resource)
                .post("/employees");

        ExtentLogger.logResponse(response.asPrettyString());
        ApiUtils.storeResponseInExternalFile(getResponseJsonFolderPath()+"response.json",response);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(201);
    }
}
