package com.hrms.API.steps.practice;

//import cucumber.api.java.en.Given;

//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//
//
//import static io.restassured.RestAssured.*;
//
//import org.junit.Assert;
//
//import com.hrms.utils.CommonMethods;
//import static org.hamcrest.Matchers.equalTo;
//
///**
// * 
// * 
// * @author API Instructor Please manually import --import static org.hamcrest.Matchers.equalTo;
// *
// */
//
//public class CreateEmployeeAPI {
//
//	/**
//	 * Declaring RequestSpecification request & Response response as global
//	 * variables
//	 */
//
//	private static RequestSpecification request;
//	private Response response;
//
//	@Given("user calls createEmployee API")
//	public void user_calls_createEmployee_API() {
//
//		/**
//		 * Preparing request using given() method
//		 **/
//		request = given().header("Content-Type", "application/json").header("Authorization",
//				SyntaxAPIAuthentificationSteps.Token);
//
//		/**
//		 * Sending body which is stored in createEmployee.json file stored in JSONFiles
//		 * folder(We installed JSON editor) we are sending body using public static
//		 * readJson() method which we stored in CommonMethods class-- (will change
//		 * location next class) which will read your JSON payload and convert to a
//		 * String
//		 * 
//		 **/
//		request.body(CommonMethods.readJson(
//				"/Users/ivankazhyharevych/eclipse-workspace/HrmsCucumberFramework/src/test/resources/JSONFiles/createEmployee.json"));
//
//	}
//
//	@When("User retrieves response")
//	public void user_retrieves_response() {
//
//		/**
//		 * Calling /createEmployee.php endpoint using when() method and storing in to
//		 * response which we made global
//		 */
//
//		response = request.when().post("http://18.232.148.34/syntaxapi/api/createEmployee.php");
//
//		/**
//		 * At this point, we have sent our body with a POST request to our
//		 * /createEmployee.php REST endpoint and below you can do response.prettyPrint()
//		 * to see the response we get
//		 */
//		response.prettyPrint();
//	}
//
//	@Then("status code is {int}")
//	public void status_code_is(int int1) {
//
//		/**
//		 * we are using then() method to perform assertions below are two ways to assert
//		 */
//
//		/**
//		 * Asserting using Assert class from JUnit and using assertEquals() method
//		 */
//		Assert.assertEquals(int1, response.getStatusCode());
//
//		/**
//		 * Preferred way to assert because we can use then() method
//		 */
//		response.then().assertThat().statusCode(int1);
//
//	}
//
//	@Then("user validates employee is created")
//	public void user_validates_employee_is_created() {
//
//		/**
//		 * Here we are asserting to verify that in our response body we see "Message" :
//		 * "Entry Created" We are asserting with equalTo() that comes from --import
//		 * static org.hamcrest.Matchers.equalTo;(You need to manually import)
//		 */
//		response.then().body("Message", equalTo("Entry Created"));
//
//		/**
//		 * Here we are asserting to verify that in our response body we see --
//		 * "emp_firstname" : "SyntaxAPIInstructor" We are asserting with equalTo() that
//		 * comes from --import static org.hamcrest.Matchers.equalTo;(You need to
//		 * manually import) The [0]is because, if you look at the response it is in the
//		 * first object of the Array and first stored object to an array begins with
//		 * index [0]
//		 */
//		response.then().body("Employee[0].emp_firstname", equalTo("Ivanka"));
//
//	}
//
//}

import java.util.Map;
import org.junit.Assert;
import com.hrms.utils.CommonMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class CreateEmployeeAPI {

	private static Response response;
	private static RequestSpecification request;
	String createEmployeeURI = "http://54.167.125.15/syntaxapi/api/createEmployee.php";
	public static Object emp_id;

	@Given("user calls createEmployee API")
	public void user_calls_createEmployee_API() {

		request = given().header("Content-Type", "application/json").header("Authorization",
				SyntaxAPIAuthentificationSteps.Token);
		String fromFile = CommonMethods.readJson(
				"/Users/ivankazhyharevych/eclipse-workspace/HrmsCucumberFramework/src/test/resources/JSONFiles/createEmployee.json");

		request.body(fromFile);
	}

	@When("User retrieves response")
	public void user_retrieves_response() {
		response = request.when().post(createEmployeeURI);
		response.prettyPrint();
	}

	@Then("status code is {int}")
	public void status_code_is(int int1) {

		//response.then().assertThat().statusCode(int1);

		Assert.assertEquals(int1, response.getStatusCode());

	}

	@Then("user validates employee is created")
	public void user_validates_employee_is_created() {
		boolean empCreated = response.getBody().asString().contains("Entry Created");
		Assert.assertTrue("Employee could not be created", empCreated);
	}

	@Then("user keeps the new employee's id")
	public void user_keeps_the_new_employee_s_id() {
		Map<String, Object> result = response.jsonPath().getMap("Employee[0]");
		emp_id = result.get("employee_id");
	}

}
