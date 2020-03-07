package com.hrms.API.steps.practice;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
//import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;

import com.hrms.utils.APIConstants;

public class GETOneEmployeeAPISteps {

	private Response response;
	private static RequestSpecification request;

	@Given("user calls getOneEmployeeAPI")
	public void user_calls_getOneEmployeeAPI() {

		request = given().header("Content-Type", "application/json")
				.header("Authorization", SyntaxAPIAuthentificationSteps.Token)
				.param("employee_id", POSTCreateEmployeeAPI.employee_ID);

	}

	@When("User retrieves response for getOneEmployee API")
	public void user_retrieves_response_for_getOneEmployee_API() {

		response = request.when().get(APIConstants.GET_ONE_EMPLOYEE_URI);
		response.prettyPrint();

	}

	@Then("status code is {int} for getOneEmployee API")
	public void status_code_is_for_getOneEmployee_API(int int1) {
		
		response.then().assertThat().statusCode(int1);
	}

	@Then("user validates created employee is existing")
	public void user_validates_created_employee_is_existing() {

		response.then().body("employee[0].employee_id", equalTo(POSTCreateEmployeeAPI.employee_ID));
		
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		
		String actualEmployeeID =  jsonPathEvaluator.get("employee[0].employee_id");
		System.out.println("Actual Emloyee ID is: "+ actualEmployeeID);
		
		Assert.assertEquals("Verifying Employee IDs", POSTCreateEmployeeAPI.employee_ID, actualEmployeeID);
		
		
				try {
					Assert.assertEquals("Verifying Employee IDs", POSTCreateEmployeeAPI.employee_ID, actualEmployeeID);
					
				}catch(AssertionError e) {
					
					System.out.println("Employee ID's DO NOT MATCH");
				}
				System.out.println("EMPLOYEE ID's MATCH");
		
	}

}
