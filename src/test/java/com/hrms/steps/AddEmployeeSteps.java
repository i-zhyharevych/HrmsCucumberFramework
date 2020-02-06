package com.hrms.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.InvalidElementStateException;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetailsPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AddEmployeeSteps extends CommonMethods {

	
	String empId;
	

	@Given("I am logged into HRMS")
	public void i_am_logged_into_HRMS() {
		
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	}

	@Given("I navigated to Add Employee Page")
	public void i_navigated_to_Add_Employee_Page() {
		
		dashboard.navigateToAddEmoloyee();
	}

	@When("I add {string}, {string} and {string}")
	public void i_add_and_(String fName, String mName, String lName) {
		
		sendText(addEmp.fName, fName);
		sendText(addEmp.mName, mName);
		sendText(addEmp.lName, lName);
		empId = addEmp.empId.getText();
	}

	@When("I click Save")
	public void i_click_Save() {
		
		click(addEmp.saveBtn);
	}

	@Then("I see Employee has been succesfully added")
	public void i_see_Employee_has_been_succesfully_added() {
		
		// Assert.assertEquals("Employee is NOT being added", pdetails.empId.getText(),
		// empId);
		Assert.assertTrue("Employee is NOT being added", pdetails.nameOnPicture.isDisplayed());
	}

	@Then("I see Employee with {string}, {string} and {string} is displayed")
	public void i_see_Employee_with_and_is_displayed(String fName, String mName, String lName) {
		
		if (mName.isEmpty()) {
			pdetails.verifyAddEmp(fName + " " + lName);
		} else {
			pdetails.verifyAddEmp(fName + " " + mName + " " + lName);
		}
	}

	@When("I delete employee id")
	public void i_delete_employee_id() {
		
		addEmp.empId.clear();
	}

	@Then("I see employee without employee id is being added")
	public void i_see_employee_without_employee_id_is_being_added() {
		
		Assert.assertTrue("Employee is NOT being added", pdetails.nameOnPicture.isDisplayed());
	}

	@Then("I see required error message next to the first and last name")
	public void i_see_required_error_message_next_to_the_first_and_last_name() {
		
		Assert.assertTrue("Required Message is not displayed", addEmp.warningMessgFirstName.isDisplayed());
		Assert.assertTrue("Required Message is not displayed", addEmp.warningMessgLastName.isDisplayed());
	}

	@When("I click on create login checkbox")
	public void i_click_on_create_login_checkbox() {
		
		click(addEmp.createLoginDetails);
	}

	@When("I enter {string}, {string} and {string}")
	public void i_enter_and(String username, String password, String confirmPassword) {
		
		sendText(addEmp.username, username);
		sendText(addEmp.userPassword, password);
		sendText(addEmp.confirmUserPassword, confirmPassword);
	}

	@When("I enter employee details")
	public void i_enter_employee_details(DataTable empDetails) {
		
		List<Map<String, String>> empDetailList = empDetails.asMaps();

		for (Map<String, String> map : empDetailList) {
			sendText(addEmp.fName, map.get("FirstName"));
			sendText(addEmp.mName, map.get("MiddleName"));
			sendText(addEmp.lName, map.get("LastName"));
		}
	}

	@When("I click on Edit")
	public void clickOnEdit_SaveButton() {
		
		jsClick(pdetails.edit_saveBtn);
	}

	@Then("I am able to modify Employee Details")
	public void i_am_able_to_modify_Employee_Details_and_click_save(DataTable modifyEmpDetail) throws InterruptedException {
		

		List<Map<String, String>> modifyList = modifyEmpDetail.asMaps();

		for (Map<String, String> map : modifyList) {
			//click edit
			jsClick(pdetails.edit_saveBtn);
			//send info to modify data
			sendText(pdetails.driverLicenceDetails, map.get("DriverLisence"));
			sendText(pdetails.dLExp, map.get("ExpirationDate"));
			sendText(pdetails.ssnNumber, map.get("SSN"));
			sendText(pdetails.sinNumber, map.get("SIN"));
			sendText(pdetails.birth, map.get("DOB"));
			clickRadio(pdetails.genderLabels, map.get("Gender"));
			Thread.sleep(5000);
			
			//select gender
//			if (map.get("Gender").equalsIgnoreCase("Male")) {
//				jsClick(pdetails.maleRButton);
//			} else if (map.get("Gender").equalsIgnoreCase("Female")) {
//				jsClick(pdetails.femaleRButton);
//			}

			//select Marital Status and Nationality
			selectDdValue(pdetails.maritalStatus, map.get("MaritalStatus"));
			selectDdValue(pdetails.nationality, map.get("Nationality"));

			jsClick(pdetails.smokeCkeckbox);
			
			takeScreenshot("EditEmployee");

			//click save
			jsClick(pdetails.edit_saveBtn);
			takeScreenshot("EditEmployee");
		}

	}
	


}