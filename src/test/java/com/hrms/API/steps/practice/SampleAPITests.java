package com.hrms.API.steps.practice;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.junit.Assert;
import org.junit.Test;

public class SampleAPITests {

	// @Test
	public void getAllJobTitles() {

		Response response = RestAssured.given().contentType("application/json").header("Authorization",
				"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzI5MDcsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4ODEwNywidXNlcklkIjoiOTkifQ.4KUvABSE-6bicFD5pQ8iWTeUSHHNwvVF8PEAINtZ49E")
				.when().get("http://54.167.125.15/syntaxapi/api/jobTitle.php");

		response.prettyPrint();

		int actualResponseCode = response.getStatusCode();
		System.out.println(actualResponseCode);
	}

	// @Test
	public void getOneEmployee() {

		Response response = RestAssured.given().param("employee_id", "3840").contentType("application/json").header(
				"Authorization",
				"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzI5MDcsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4ODEwNywidXNlcklkIjoiOTkifQ.4KUvABSE-6bicFD5pQ8iWTeUSHHNwvVF8PEAINtZ49E")
				.when().get("http://54.167.125.15/syntaxapi/api/getOneEmployee.php");

		response.prettyPrint();

		int actualResponseCode = response.getStatusCode();
		System.out.println(actualResponseCode);
	}

	// @Test
	public void getAllEmployeesStatuses() {

		Response response = RestAssured.given().contentType("application/json").header("Authorization",
				"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzI5MDcsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4ODEwNywidXNlcklkIjoiOTkifQ.4KUvABSE-6bicFD5pQ8iWTeUSHHNwvVF8PEAINtZ49E")
				.when().get("http://54.167.125.15/syntaxapi/api/employeeStatus.php");

		response.prettyPrint();

		int actualResponseCode = response.getStatusCode();
		System.out.println(actualResponseCode);
	}

	@Test
	public void createEmployee() {

		Response response = RestAssured.given().contentType("application/json").header("Authorization",
				"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzI5MDcsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4ODEwNywidXNlcklkIjoiOTkifQ.4KUvABSE-6bicFD5pQ8iWTeUSHHNwvVF8PEAINtZ49E")
				.param("emp_firstname", "Ivanka").param("emp_lastname", "Ivanka").param("emp_middle_name", "J")
				.param("emp_gender", "2").param("emp_birthday", "1997-02-20").param("emp_status", "Freelance")
				.param("emp_job_title", "Developer").when()
				.post("http://54.167.125.15/syntaxapi/api/createEmployee.php");

		response.prettyPrint();
		int actualResponseCode = response.getStatusCode();
		Assert.assertEquals(200, actualResponseCode);

	}

	//@Test
	public void getAllEmployees() {

		Response response = RestAssured.given().contentType("application/json").header("Authorization",
				"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzI5MDcsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4ODEwNywidXNlcklkIjoiOTkifQ.4KUvABSE-6bicFD5pQ8iWTeUSHHNwvVF8PEAINtZ49E")
				.when().get("http://54.167.125.15/syntaxapi/api/getAllEmployees.php");

		response.prettyPrint();
		int actualResponseCode = response.getStatusCode();
		System.out.println(actualResponseCode);
	}
}
