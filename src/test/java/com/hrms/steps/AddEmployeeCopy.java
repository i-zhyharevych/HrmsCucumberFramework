package com.hrms.steps;

import org.junit.Assert;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetailsPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddEmployeeCopy  extends CommonMethods{
	
//	AddEmployeePageElements addEmp;
//	String empId;
//	PersonalDetailsPageElements pdetails;
//	LoginPageElements login;
//	DashboardPageElements dashboard;
//	
//	public AddEmployeeCopy(){
//		login=new LoginPageElements();
//		dashboard=new DashboardPageElements();
//		addEmp=new AddEmployeePageElements();
//		pdetails=new PersonalDetailsPageElements();
//	}
//	
//	@Given("I am logged into HRMS")
//	public void i_am_logged_into_HRMS() {
//		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
//	}
//
//	@Given("I navigated to Add Employee Page")
//	public void i_navigated_to_Add_Employee_Page() {
//		dashboard.navigateToAddEmoloyee();
//	}
//
//	@When("I add {string}, {string} and {string}")
//	public void i_add_and_(String fName, String mName, String lName) {
//		sendText(addEmp.fName, fName);
//		sendText(addEmp.mName, mName);
//		sendText(addEmp.lName, lName);
//		empId=addEmp.empId.getText();
//	}
//
//	@When("I click Save")
//	public void i_click_Save() {
//		click(addEmp.saveBtn);
//	}
//
//	@Then("I see Employee has been succesfully added")
//	public void i_see_Employee_has_been_succesfully_added() {
//		Assert.assertEquals("Employee is NOT being added", pdetails.empId.getText(), empId);
//	}
//	
//	@Then("I see Employee with {string}, {string} and {string} is displayed")
//	public void i_see_Employee_with_and_is_displayed(String fName, String mName, String lName) {
//		if(mName.isEmpty()) {
//			pdetails.verifyAddEmp(fName+" "+lName);
//		}else {
//			pdetails.verifyAddEmp(fName+" "+mName+" "+lName);
//		}
//	
//	}

}
