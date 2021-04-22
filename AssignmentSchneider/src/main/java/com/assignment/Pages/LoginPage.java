package com.assignment.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * Store methods and locators of login page
 *
 */

public class LoginPage {
	
	WebDriver driver;

	By custLogin=By.xpath("//button[text()='Customer Login']");
	
	By mngrLogin=By.xpath("//button[contains(.,'Bank Manager Login')]");
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void managerLogin() throws Exception
	{
		Thread.sleep(3000);
		driver.findElement(mngrLogin).click();
	}
	
	public void custLogin() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(custLogin).click();
	}
}
