package com.hrms.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;



public class PersonalDetailsPageElements {

	@FindBy(xpath="//h1[text()='Personal Details']")
	public WebElement personalDetailsLbl;
	
	@FindBy(id="empPic")
	public WebElement empPicture;
	
	@FindBy(xpath="//div[@id='profile-pic']/h1")
	public WebElement nameOnPicture;
	
	@FindBy(id="personal_txtEmployeeId")
	public WebElement empId;
	
	@FindBy(id = "btnSave")
	public WebElement edit_saveBtn;
	
	@FindBy(id = "personal_txtLicenNo")
	public WebElement driverLicenceDetails;
	
	@FindBy(id="personal_txtLicExpDate")
	public WebElement dLExp;
	
	@FindBy(id="personal_txtNICNo")
	public WebElement ssnNumber;
	
	@FindBy(id="personal_txtSINNo")
	public WebElement sinNumber;
	
	@FindBy(xpath="//label[contains(@for,'personal_optGender')]")
	public List<WebElement> genderLabels;
	
//	@FindBy(id="personal_optGender_1")
//	public WebElement maleRButton;
//	
//	@FindBy(id="personal_optGender_2")
//	public WebElement femaleRButton;
	
	@FindBy(id ="personal_cmbMarital")
	public WebElement maritalStatus;
	
	@FindBy(id="personal_cmbNation")
	public WebElement nationality;
	
	@FindBy(id="personal_DOB")
	public WebElement birth;
	
	@FindBy(id="personal_chkSmokeFlag")
	public WebElement smokeCkeckbox;
	
	
	
	public PersonalDetailsPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	public void verifyAddEmp(String expectedResult) {
		String actual =nameOnPicture.getText();
		Assert.assertEquals(expectedResult, actual);
	}
}
