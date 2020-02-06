package com.hrms.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class ReportsPageElements {
	@FindBy(id = "search_search")
	public WebElement searchField;
	
	@FindBy (xpath="//input[@class='searchBtn']")
	public WebElement searchButton;
	
	@FindBy(xpath="//td[text()='No Records Found']")
	public WebElement noFoundMessg;
	
	@FindBy(xpath="//td[text()='PIM Sample Report']")
	public WebElement foundReport;
	
	public ReportsPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}

}
