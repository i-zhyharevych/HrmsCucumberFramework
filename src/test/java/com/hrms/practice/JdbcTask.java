package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class JdbcTask {

	// Create connection to db and retrieve all job titles and store them inside
	// arraylist

	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	// jdbc:type drivers:host:port/name of the database
	String dbUrl = "jdbc:mysql://54.167.125.15:3306/syntaxhrm_mysql";

	@Test
	public void getDataBaseJobTitles() throws SQLException {
		

		Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		
		System.out.println("Connection created");
		
		Statement statement = con.createStatement();
		
		ResultSet resultSet = statement.executeQuery("select * from ohrm_job_title");
		resultSet.next();
		
		List<String> jobTitlesList = new ArrayList<>();
		while(resultSet.next()) {
			jobTitlesList.add(resultSet.getString("job_title"));
		}
		
		for(String jobT: jobTitlesList) {
			System.out.println(jobT);
		}
		
		resultSet.close();
		statement.close();
		con.close();
		

	}

}
