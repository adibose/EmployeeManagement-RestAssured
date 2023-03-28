package com.pab.tests;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.pab.reports.ExtentLogger;
import com.pab.reports.ExtentManager;
import com.pab.reports.ExtentReport;
import com.pab.requestbuilder.ApiBuilders;
import io.restassured.response.Response;
import static org.assertj.core.api.Assertions.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetTests extends BaseTest {

    @Test
    public void getEmployeeDetails(){
       Response response =  ApiBuilders.buildRequestForGetCalls()
                .get("/employees");
        ExtentLogger.logResponse(response.asPrettyString());
        assertThat(response.getStatusCode())
                .isEqualTo(200);

        System.out.println("Employee list size : "+response.jsonPath().getList("$").size());
        assertThat(response.jsonPath().getList("$").size())
                .isPositive()
                .as("Validating the size of the employee list").isGreaterThan(30);

    }

    @Test(dataProvider = "getData")
    public void getSingleEmployeeDetails(int id,String lastname){
        System.out.println(id);
        Response response = ApiBuilders.buildRequestForGetCalls()
                .pathParam("id",id)
                .get("/employees/{id}");

        ExtentLogger.logResponse(response.asPrettyString());


        assertThat(response.getStatusCode())
                .isEqualTo(200);

        assertThat(response.jsonPath().getString("last_name"))
                .isEqualTo(lastname);

    }

    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                {1,"Fay"},
                {2,"Moen"},
                {3,"Smith"},
                {5,"Bose"}
        };
    }




}
