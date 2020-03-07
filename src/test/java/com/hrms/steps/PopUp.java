package com.hrms.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopUp {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        
        
        //driver.get("http://abcdatabase.com/basicauth");
        driver.get("http://test:test@abcdatabase.com/basicauth");
	}

}
