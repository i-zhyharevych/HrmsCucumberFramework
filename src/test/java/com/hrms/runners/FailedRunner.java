package com.hrms.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="@target/failed.txt"
		, glue="com/hrms/steps"
		, plugin = {"pretty","html:target/html/cucumber-default-report", "json:target/cucumber.json", "rerun:target/failed.txt"}
		, monochrome=true		
		
		)
public class FailedRunner {
	
	

}
