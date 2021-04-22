/**
 * 
 */
package com.assignment.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Store methods and locators of Customer login page
 *
 */
public class CustomerOperationPage {
	
	WebDriver driver;

	By custSelect=By.id("userSelect");
	
	By loginBtn=By.xpath("//button[text()='Login']");
	
	By customers=By.xpath("//button[@ng-click='showCust()']");

    public CustomerOperationPage(WebDriver driver)
    {
    	this.driver=driver;
    }
    
    public void searchCustomer() throws Exception
    {
    	
		Thread.sleep(2000);
		WebElement CustSearch = driver.findElement(custSelect);
		Select sel3 = new Select(CustSearch);
		sel3.selectByValue("6");
		Thread.sleep(2000);
		driver.findElement(loginBtn).click();
    }


}

