package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class StoringDataFromDB {
	String dbUsername = "syntax_hrm";

	String dbPassword = "syntaxhrm123";

	// jdbc:type drivers:host:port/name of the database
	String dbUrl = "jdbc:mysql://54.167.125.15:3306/syntaxhrm_mysql";

	//@Test
	public void storeDataFromDB() throws SQLException {

		Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

		Statement st = connection.createStatement();

		ResultSet rset = st.executeQuery("select id, name, country_code from ohrm_location;");

		List<Map<String, String>> listData = new ArrayList<>();

		while (rset.next()) {
            Map<String, String> map = new LinkedHashMap<>();
            map.put("id", rset.getObject("id").toString());
            map.put("name", rset.getObject("name").toString());
            map.put("county_code", rset.getObject("country_code").toString());
            listData.add(map);
        }
        System.out.println(listData);
        
        rset.close();
		st.close();
		connection.close();

	}

	@Test
	public void storeDataFromDBEnhanced() throws SQLException {

		Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

		Statement st = connection.createStatement();

		ResultSet rset = st.executeQuery("select id, name, country_code from ohrm_location;");
		
		ResultSetMetaData rsetMetaData = rset.getMetaData();

		List<Map<String, String>> listData = new ArrayList<>();
		Map<String, String> rowMap;
		
		while(rset.next()) {
			rowMap = new LinkedHashMap<>();
			
			for(int i = 1; i<=rsetMetaData.getColumnCount(); i++) {
				
				rowMap.put(rsetMetaData.getColumnName(i), rset.getObject(i).toString());
				
				listData.add(rowMap);
			}
		}
		
		System.out.println(listData);
		
		rset.close();
		st.close();
		connection.close();
	}
}
