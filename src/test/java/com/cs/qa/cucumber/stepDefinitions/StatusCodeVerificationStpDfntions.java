package com.cs.qa.cucumber.stepDefinitions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.cs.qa.util.RestAssuredExtension;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

public class StatusCodeVerificationStpDfntions {

	static ResponseOptions<Response> response;
	static HttpURLConnection httpURLConnection;
	
	@Given("I send GET request to {string} as following")
	public void i_send_get_request_as_following(String BaseURL, DataTable dataTable)
	{
		String pathParam = "";
		RestAssuredExtension.SetUp(BaseURL);
		
		System.out.println("**-->START: I send GET request as following");

				List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);	    
			    for (Map<String, String> columns : rows)
			    {
			    	if(columns.get("Fields").equals("path param"))
			    		pathParam = columns.get("Values");		
			    }
		System.out.println("*-->pathParam: "+ pathParam);	    
		//Send request Without SERIALIZING	    
		response = RestAssuredExtension.GETRequest(pathParam);	
	}
	
	@Then("I should receive response as following")
	public void i_should_receive_response_with_unique_data_as_following(DataTable dataTable)
	{
		System.out.println("*-->START: I should receive response with unique data as following");
		
		List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);	    
	    for (Map<String, String> columns : rows)
	    {    		
	    	if (columns.get("Fields").equals("status code") & columns.get("Values") != null)
	    	{
	    		Assert.assertTrue(String.valueOf(response.statusCode()).equals(columns.get("Values")));
	    	}
	    }
	}
	
	@Given("I send {string} request to {string}")
	public void i_send_get_request_to(String Request, String Url)
	{
		URL url;
		try {
			url = new URL(Url);
			httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod(Request);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Then("I should receive response with status code {string}")
	public void i_send_get_request_to(String StatusCode)
	{
		try {
				Assert.assertEquals(Integer.valueOf(StatusCode), httpURLConnection.getResponseCode());
				System.out.println("Status code: "+ httpURLConnection.getResponseCode());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
