package com.hrms.API.steps.practice;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import com.hrms.utils.APIConstants;

public class GETAllEmployeesAPI {

	private static RequestSpecification request;
	private Response response;

	@Given("user calls getAllEmployees API")
	public void user_calls_getAllEmployees_API() {
		request = given().header("Content-Type", "application/json").header("Authorization",
				SyntaxAPIAuthentificationSteps.Token);
	}

	@When("User retrieves response for getAllEmployees API")
	public void user_retrieves_response_for_getAllEmployees_API() {
		response = request.when().get(APIConstants.GET_ALL_EMLOYEES_URI);
		response.prettyPrint();
	}

	@Then("status code is {int} for getAllEmployees API")
	public void status_code_is_for_getAllEmployees_API(Integer int1) {

		response.then().assertThat().statusCode(int1);
	}

	@Then("user validates all employees are retrieved")
	public void user_validates_all_employees_are_retrieved() {

		JSONObject json = new JSONObject(response.prettyPrint());
		JSONArray array = json.getJSONArray("Employee");
		System.out.println("Size of list for returned Employees is: " + array.length());

		// interesting code, helps to find exact employee of the list
//		for (int i = 0; i <= array.length() - 1; i++) {
//			//"emp_firstname":"Ivanka",
//			String createdEmployee = response.jsonPath().getString("Employee["+i+"].emp_firstname");
//			
//			if(createdEmployee.equals("Ivanka")) {
//				response.then().body("Employee["+i+"].emp_lastname", equalTo("Z"));
//				response.then().body("Employee["+i+"].emp_middle_name", equalTo("J"));
//				response.then().body("Employee["+i+"].emp_gender", equalTo("2"));
//				response.then().body("Employee["+i+"].emp_birthday", equalTo("1997-02-20"));
//				response.then().body("Employee["+i+"].emp_status", equalTo("Freelance"));
//				response.then().body("Employee["+i+"].emp_job_title", equalTo("Developer"));
//				
//				break;
//			}else {
//				System.out.println("Employee was not found!!!!!");
//			}
//
//		}

	}

}
