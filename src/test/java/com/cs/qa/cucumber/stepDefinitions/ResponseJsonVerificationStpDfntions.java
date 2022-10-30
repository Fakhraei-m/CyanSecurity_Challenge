package com.cs.qa.cucumber.stepDefinitions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.cs.qa.pojo.Users;
import com.cs.qa.util.RestAssuredExtension;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

public class ResponseJsonVerificationStpDfntions {

	static ResponseOptions<Response> response;
	Users TheUser;
	
	@Given("I send GET request to {string}")
	public void i_send_get_request_as_following(String Url)
	{
		String pathParam = "";
		RestAssuredExtension.SetUp(Url);			    
		//Send GET request 
		response = RestAssuredExtension.GETRequest(pathParam);	
	}
	
	@Then("I should receive response that contains")
	public void i_should_receive_response_that_contains(DataTable dataTable)
	{
		System.out.println("**-->START: I should receive response that contains");
		
		//DESERIALIZING - Use this when parsing the JSON response using POJO Class
		//POJO classes are defined in src/main/java/com/cs/qa/pojo
		Users[] users = response.getBody().as(Users[].class);
		boolean exist = false;
		
		Map<String, String> dataTableMap = new HashMap<>();
		
		//Getting the dataTable in raw list and put it in Map for easy access
		List<List<String>> data = dataTable.asLists(String.class);	    
		for (List<String> columns : data)
		{
			System.out.println("*-->"+ columns.get(0)+" , "+ columns.get(1));
			dataTableMap.put(columns.get(0), columns.get(1));
		}		
		//System.out.println("dataTableMap: "+ dataTableMap);
		//System.out.println("*-->Response Body: "+ response.getBody().asString());
		
		Assert.assertTrue(String.valueOf(response.statusCode()).equals(dataTableMap.get("status code")));
		
		for(Users user : users)
			if( dataTableMap.get("name").equals(user.getName()))
			{
				TheUser = user;
				exist = true;
			}
				
		System.out.println("*-->TheUser: "+ TheUser.getAddress().getStreet());
		Assert.assertTrue(exist, "Failed: No user with this name was found in the response!");
		
	    System.out.println("**-->END: I should receive response that contains");
	}
	
	@When("I receive response that contains")
	public void i_receive_response_that_contains(DataTable dataTable)
	{
		System.out.println("**-->START: I receive response that contains");
		
		//DESERIALIZING - Use this when parsing the JSON response using POJO Class
		//POJO classes are defined in src/main/java/com/cs/qa/pojo
		Users[] users = response.getBody().as(Users[].class);
		boolean exist = false;
		
		Map<String, String> dataTableMap = new HashMap<>();
		
		//Getting the dataTable in raw list and put it in Map for easy access
		List<List<String>> data = dataTable.asLists(String.class);	    
		for (List<String> columns : data)
		{
			System.out.println("*-->"+ columns.get(0)+" , "+ columns.get(1));
			dataTableMap.put(columns.get(0), columns.get(1));
		}		
		//System.out.println("dataTableMap: "+ dataTableMap);
		//System.out.println("*-->Response Body: "+ response.getBody().asString());
		
		Assert.assertTrue(String.valueOf(response.statusCode()).equals(dataTableMap.get("status code")));
		
		for(Users user : users)
			if( dataTableMap.get("name").equals(user.getName()))
			{
				TheUser = user;
				exist = true;
			}
				
		Assert.assertTrue(exist, "Failed: No user with this name was found in the response!");
		
	    System.out.println("**-->END: I receive response that contains");
	}
	
	@Then("the user address should be")
	public void the_user_address_should_be(DataTable dataTable)
	{
		System.out.println("**-->START: the user address should be");
		
		Map<String, String> dataTableMap = new HashMap<>();
		
		//Getting the dataTable in raw list and put it in Map for easy access
		List<List<String>> data = dataTable.asLists(String.class);	    
		for (List<String> columns : data)
		{
			System.out.println("*-->"+ columns.get(0)+" , "+ columns.get(1));
			dataTableMap.put(columns.get(0), columns.get(1));
		}		
		//System.out.println("dataTableMap: "+ dataTableMap);
		//System.out.println("*-->Response Body: "+ response.getBody().asString());
		
		Assert.assertTrue(TheUser.getAddress().getStreet().equals(dataTableMap.get("street")));
		Assert.assertTrue(TheUser.getAddress().getSuite().equals(dataTableMap.get("suite")));
		Assert.assertTrue(TheUser.getAddress().getCity().equals(dataTableMap.get("city")));
		Assert.assertTrue(TheUser.getAddress().getZipcode().equals(dataTableMap.get("zipcode")));
		Assert.assertTrue(TheUser.getAddress().getGeo().getLat().equals(dataTableMap.get("lat")));
		Assert.assertTrue(TheUser.getAddress().getGeo().getLng().equals(dataTableMap.get("lng")));

	    System.out.println("**-->END: the user address should be");
	}

}
