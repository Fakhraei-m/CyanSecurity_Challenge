package com.cs.qa.util;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;

import com.cs.qa.base.TestBase;

//This is a class that implements GET POST PUT DELET requests using Rest_Assured
//The methods are implemented in non-BDD style form of Rest-Assured lib
//These methods can be used in Step Definitions of Cucumber
public class RestAssuredExtension 
{
	public static RequestSpecification Request;

    public RestAssuredExtension()
    {
        //Arrange
    	//System.out.println("**-->Here in RestAssuredExtension constructor");
        //RequestSpecBuilder builder = new RequestSpecBuilder();
        //builder.setBaseUri(TestBase.prop.getProperty("BaseURI"));
        //builder.setContentType(ContentType.JSON);
        ////var requestSpec = builder.build();
        //Request = RestAssured.given().spec(builder.build());
    }
    
    public static void SetUp(String BaseURI)
    {
        //Arrange
    	System.out.println("**-->Here in RestAssuredExtension.SetUp");
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri(BaseURI);
        //builder.setBaseUri(TestBase.prop.getProperty("BaseURI"));
        builder.setContentType(ContentType.JSON);
        //var requestSpec = builder.build();
        Request = RestAssured.given().spec(builder.build());
        System.out.println("**-->End of RestAssuredExtension.SetUp");
    }
    
    public static ResponseOptions<Response> GETRequest(String pathParams)
    {
    	System.out.println("**-->Here in RestAssuredExtension.GETRequest");
    	System.out.println("**-->pathParams: "+ pathParams);
        try {
            return Request.get(new URI(pathParams));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        System.out.println("**-->GETRequest Returned NULL!!!");
        return null;
    }

}

