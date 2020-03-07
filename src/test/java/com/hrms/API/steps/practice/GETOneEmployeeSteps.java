package com.hrms.API.steps.practice;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;
import static org.hamcrest.Matchers.equalTo;

public class GETOneEmployeeSteps {

	private static Response response;
	private static RequestSpecification request;

	@Given("user calls getOneEmployee API")
	public void user_calls_getOneEmployee_API() {

		request = given().param("employee_id", "07147A").header("Content-Type", "application/json")
				.header("Authorization", SyntaxAPIAuthentificationSteps.Token);
		String fromFile = CommonMethods.readJson(
				"/Users/ivankazhyharevych/eclipse-workspace/HrmsCucumberFramework/src/test/resources/JSONFiles/createEmployee.json");
		request.body(fromFile);
	}
	
	@When("User retrieves response from getOneEmployee")
	public void user_retrieves_response_from_getOneEmployee() {
	    response= request.when().get("http://54.167.125.15/syntaxapi/api/getOneEmployee.php");
	    response.prettyPrint();
	}
	
	@Then("status code is {int} for getting one employee")
	public void status_code_is_for_getting_one_employee(Integer int1) {
		response.then().assertThat().statusCode(int1);

		//Assert.assertEquals(int1, response.getStatusCode());
	}

	@Then("user validates created employee exists")
	public void user_validates_created_employee_exists() {

		boolean empExisting = response.getBody().asString().contains("07147A");
		Assert.assertTrue("Employee does not exist", empExisting);
		
	}

}
