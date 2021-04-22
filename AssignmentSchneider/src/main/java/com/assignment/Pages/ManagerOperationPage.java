/**
 * 
 */
package com.assignment.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/**
 * 
 *Store methods and locators of Bank Manager login page
 */
public class ManagerOperationPage {

	WebDriver driver;

	By addCust=By.xpath("//button[@ng-click='addCust()']");
	
	By openAccnt=By.xpath("//button[contains(.,'Open Account')]");
	
	By customers=By.xpath("//button[@ng-click='showCust()']");
	
	// Add customers requirements
	
	By firstName=By.xpath("//input[@placeholder='First Name']");
	By lastName=By.xpath("//input[@placeholder='Last Name']");
	By postCode=By.xpath("//input[@placeholder='Post Code']");
	By addCustButn=By.xpath("//button[@type='submit']");
	
	//Open Accounts attributes
	
	By selCust=By.xpath("//select[@id='userSelect']");
	By selCurrency=By.id("currency");
	By processButn=By.xpath("//button[text()='Process']");
	
	//Customer Search attributes
	
	By searchCust=By.xpath("//button[@ng-click='showCust()']");
	By selCreatedCust=By.xpath("//input[@placeholder='Search Customer']");
	By dispFirstName=By.xpath("//tbody/tr/td[1]");
	By dispLastName=By.xpath("//tbody/tr/td[2]");
	By dispAccntNum=By.xpath("//tbody/tr/td[4]");
	
	By homeBtn=By.xpath("//button[text()='Home']");
	
	
	public ManagerOperationPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void CustomerCreation() throws Exception
	{
        Thread.sleep(3000);
		
		driver.findElement(addCust).click();
		Thread.sleep(1000);
		
		driver.findElement(firstName).sendKeys("Test");
		Thread.sleep(1000);
		driver.findElement(lastName).sendKeys("Selenium");
		Thread.sleep(1000);
		driver.findElement(postCode).sendKeys("123456");
		Thread.sleep(1000);
		
		driver.findElement(addCustButn).click();
	}
	
	public void custCreationAlert()
	{
		driver.switchTo().alert();
		String alertText=driver.switchTo().alert().getText();
		
		System.out.println("Alert popup displays = "+ alertText);
		
		driver.switchTo().alert().accept();
	}
	
	public void accntOpenening() throws Exception
	{
		Thread.sleep(2000);
		driver.findElement(openAccnt).click();
		Thread.sleep(2000);
		WebElement CustName=driver.findElement(selCust);
		CustName.click();
		Thread.sleep(2000);
		Select sel1=new Select(CustName);
		sel1.selectByValue("6");
		Thread.sleep(2000);
		WebElement Currency=driver.findElement(selCurrency);
		Select sel2=new Select(Currency);
		sel2.selectByValue("Rupee");
		driver.findElement(processButn).click();
	}
	
	public void accntOpeningAlert()
	{
		driver.switchTo().alert();
		String CurrencyAdd=driver.switchTo().alert().getText();
		String  AccntNm= CurrencyAdd.substring(50);
		
		System.out.println("Alert popup displays = "+ CurrencyAdd);
		System.out.println("Account Number =" +AccntNm);
		driver.switchTo().alert().accept();
	}
	
	public void searchCust()throws Exception
	{
		driver.findElement(By.xpath("//button[@ng-click='showCust()']")).click();
		String AccntNm = "1016";
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Search Customer']")).sendKeys("Test");
		Thread.sleep(2000);
		String firstName = driver.findElement(By.xpath("//tbody/tr/td[1]")).getText();
		Assert.assertEquals("Test",firstName,"First Name did not match");
		String lastName = driver.findElement(By.xpath("//tbody/tr/td[2]")).getText();
		Assert.assertEquals("Selenium",lastName,"Last Name did not match");
		String AccntNo=driver.findElement(By.xpath("//tbody/tr/td[4]")).getText();
		Assert.assertEquals(AccntNm,AccntNo,"Account No did not match");
		System.out.println("Customer is displayed");
	}
	
	public void homePage() throws Exception
	{
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Home']")).click();
	}
}
