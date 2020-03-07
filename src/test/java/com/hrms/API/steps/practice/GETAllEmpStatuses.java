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

public class GETAllEmpStatuses {

	private static RequestSpecification request;
	private Response response;

	@Given("user calls employeeStatus API")
	public void user_calls_employeeStatus_API() {

		request = given().header("Content-Type", "Application/json").header("Authorization",
				SyntaxAPIAuthentificationSteps.Token);

	}

	@When("User retrieves response for  all employee Status API")
	public void user_retrieves_response_for_all_employee_Status_API() {
		
		response = request.when().get(APIConstants.GET_ALL_EMPLOYEE_STATUSES_URI);
		response.prettyPrint();
	}

	@Then("status code is {int} for employee Status API")
	public void status_code_is_for_employee_Status_API(Integer int1) {
		
		response.then().assertThat().statusCode(int1);
	}

	@Then("user validates all employee statuses are returned")
	public void user_validates_all_employee_statuses_are_returned() {
		
		//** ASSERTION USING JSON OBJECT
		
		JSONObject json = new JSONObject(response.prettyPrint());
		JSONArray array = json.getJSONArray("Employee Status List");
		
		for(int i=0; i<=array.length()-1; i++) {
			System.out.println(array.get(i));
			
			if(i==0) {
				Assert.assertEquals("Employee", array.get(i));
			}else if(i==1) {
				Assert.assertEquals("Worker", array.get(i));
			}else if(i==2) {
				Assert.assertEquals("Self-Employee", array.get(i));
			}else if(i==3) {
				Assert.assertEquals("Independent contractor", array.get(i));
			}else if(i==4) {
				Assert.assertEquals("Freelance", array.get(i));
			}else if(i==5) {
				Assert.assertEquals("Zero hours contract", array.get(i));
			}else if(i==6) {
				Assert.assertEquals("Gig economy", array.get(i));
			}else if(i==7) {
				Assert.assertEquals("Self-employe", array.get(i));
			}else if(i==8) {
				Assert.assertEquals("internee", array.get(i));
			}
		}
		Assert.assertEquals(9, array.length());
		System.out.println(array.length());
	}
}
