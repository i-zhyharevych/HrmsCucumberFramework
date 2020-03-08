package com.hrms.steps;

import org.junit.Assert;

import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps extends CommonMethods {

	

	@Given("I open browser and navigate to the HRMS")
	public void i_open_browser_and_navigate_to_the_HRMS() {
		//setUp();
	}

	@When("I enter valid username and valid password")
	public void i_enter_valid_username_and_valid_password() {

		sendText(login.username, "Admin");
		sendText(login.password, "Hum@nhrm123");

	}

	@When("I click on login button")
	public void i_click_on_login_button() {
		click(login.loginBtn);
	}

	@Then("I successfully logged in")
	public void i_successfully_logged_in() {
		System.out.println("I am logged in");
	}

	@When("I enter valid username and invalid password")
	public void i_enter_valid_username_and_invalid_password() {

		sendText(login.username, "Admin");
		sendText(login.password, "tygygh");

	}

	@Then("I see error message")
	public void i_see_error_message() {
		Boolean error = login.errorMessage.isDisplayed();
		Assert.assertTrue("Error message is not displayed", error);
	}

	@Then("I close browser")
	public void i_close_browser() {
		//tearDown();
	}

//	We all need to learn Java again lol. without paying attention I added two else clause. below is the code (edited) 
//	9:09
//	if(errorMsge.equals(“Invalid credentials”)) {
//				Assert.assertEquals(“Invalid credentials”, loginP.errorMsg.getText());
//			}else if(errorMsge.equals(“Password cannot be empty”)) {
//				Assert.assertEquals(“Password cannot be empty”, loginP.errorMsg.getText());
//			}else {
//				Assert.assertFalse(true);
//			}

	@When("I enter {string} and {string}")
	public void i_enter_and(String username, String password) {

		sendText(login.username, username);
		sendText(login.password, password);

	}

	@Then("I see {string}")
	public void i_see(String errorMessage) {

		if (errorMessage.equals("Invalid credentials")) {
			Assert.assertEquals("Invalid credentials", login.errorMessage.getText());
		} else if (errorMessage.equals("Password cannot be empty")) {
			Assert.assertEquals("Password cannot be empty", login.errorMessage.getText());
		} else if (errorMessage.equals("Username cannot be empty")) {
			Assert.assertEquals("Username cannot be empty", login.errorMessage.getText());
		} else {
			Assert.assertFalse(true);
		}
	}
}
