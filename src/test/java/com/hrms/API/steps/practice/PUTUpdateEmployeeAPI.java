package com.hrms.API.steps.practice;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import com.hrms.utils.APIConstants;
import com.hrms.utils.CommonMethods;
import static org.hamcrest.Matchers.equalTo;

public class PUTUpdateEmployeeAPI {

	private Response response;
	private static RequestSpecification request;
	public String file = CommonMethods.readJson(APIConstants.UPDATE_EMPLOYEE_JSON);
	
	@Given("user calls updateEmployee")
	public void user_calls_updateEmployee() {

		request = given().header("Content-Type", "application/json").header("Authorization",
				SyntaxAPIAuthentificationSteps.Token);

		request.body("{ \"employee_id\" : \"" + POSTCreateEmployeeAPI.employee_ID + "\"," + file);
	}

	@When("User retrieves response for updateEmployee API")
	public void user_retrieves_response_for_updateEmployee_API() {
		
		response = request.when().put(APIConstants.UPDATE_EMPLOYEE_URI);

		response.prettyPrint();
	}

	@Then("status code is {int} for updateEmployee API")
	public void status_code_is_for_updateEmployee_API(Integer int1) {

		int statusCode = response.getStatusCode();
		response.then().assertThat().statusCode(int1);
		System.out.println(statusCode);
	}

	@Then("user verifies employee name was updated")
	public void user_verifies_employee_name_was_updated() {
		
		response.then().body("employee[0].emp_firstname", equalTo("Ivanna"));

		response.then().body("employee[0].emp_lastname", equalTo("Trump"));
	}

	@Then("user validates employee was updated")
	public void user_validates_employee_was_updated() {
		
		response.then().body("Message", equalTo("Entry updated"));
		boolean checkPoint = response.asString().contains("Entry updated");

		if (checkPoint) {
			System.out.println("Employee was successfully created");
		}

	}

}
