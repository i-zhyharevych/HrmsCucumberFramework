package com.hrms.utils;

public class APIConstants {

	public static final String CREATE_EMPLOYEE_URI = "http://54.167.125.15/syntaxapi/api/createEmployee.php";

	public static final String GET_ONE_EMPLOYEE_URI = "http://54.167.125.15/syntaxapi/api/getOneEmployee.php";

	public static final String UPDATE_EMPLOYEE_URI = "http://54.167.125.15/syntaxapi/api/updateEmployee.php";
	
	public static final String DELETE_EMPLOYEE_URI = "http://54.167.125.15/syntaxapi/api/deleteEmployee.php";
	
	public static final String GET_ALL_EMLOYEES_URI = "http://54.167.125.15/syntaxapi/api/getAllEmployees.php";
	
	public static final String GET_ALL_JOB_TITLES_URI = "http://54.167.125.15/syntaxapi/api/jobTitle.php";

	public static final String GET_ALL_EMPLOYEE_STATUSES_URI = "http://54.167.125.15/syntaxapi/api/employeeStatus.php";

	public static final String CREATE_EMPLOYEE_JSON = System.getProperty("user.dir")
			+ "/src/test/resources/JSONFiles/createEmployee.json";

	public static final String GENERATE_TOKEN_JSON = System.getProperty("user.dir")
			+ "/src/test/resources/JSONFiles/generateToken.json";

	public static final String UPDATE_EMPLOYEE_JSON = System.getProperty("user.dir")
			+ "/src/test/resources/JSONFiles/updateEmployee.json";
	
	public static final String STORE_JSON = System.getProperty("user.dir")
            + "/src/test/resources/JSONFiles/store.json";
}
