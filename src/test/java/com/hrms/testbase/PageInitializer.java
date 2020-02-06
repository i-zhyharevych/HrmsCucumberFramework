package com.hrms.testbase;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetailsPageElements;
import com.hrms.pages.ReportsPageElements;

public class PageInitializer extends BaseClass{
	
	public static LoginPageElements login;
	public static DashboardPageElements dashboard;
	public static AddEmployeePageElements addEmp;
	public static PersonalDetailsPageElements pdetails;
	public static ReportsPageElements report;
	
	
	public static void initializeAllPages() {
		
		 login=new LoginPageElements();
		 dashboard=new DashboardPageElements();
		 addEmp=new AddEmployeePageElements();
		 pdetails= new PersonalDetailsPageElements();
		 report = new ReportsPageElements();	 
	}

}
