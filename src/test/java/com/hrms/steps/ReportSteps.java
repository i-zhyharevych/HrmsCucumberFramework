package com.hrms.steps;

import org.junit.Assert;

import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.ReportsPageElements;
import com.hrms.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class ReportSteps extends CommonMethods{
	
	
	@Given("I navigated to the Reports Page")
	public void i_navigated_to_the_Reports_Page() {
	    dashboard.navigateToReports();
	}

	@When("I enter invalid report")
	public void i_enter_invalid_report() {
	    sendText(report.searchField, "Hello");
	}

	@When("I click search button")
	public void i_click_search_button() {
	    click(report.searchButton);
	}

	@Then("I see no record found message")
	public void i_see_no_record_found_message() {
	   Assert.assertTrue("Message was not displayed", report.noFoundMessg.isDisplayed());
	}

	@When("I enter valid report")
	public void i_enter_valid_report() {
	    sendText(report.searchField, "PIM Sample Report");	
	}

	@Then("I see the search report is displayed")
	public void i_see_the_search_report_is_displayed() {
		
	    Assert.assertTrue("Search report was not found", report.foundReport.isDisplayed());
	}

}
