package com.assignment.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Store methods and locators of Customer Welcome page
 *
 */

public class CustomerWelcomePage {
	
	WebDriver driver;
	

	By nameVerify=By.xpath("//span[@class='fontBig ng-binding']");
	
	//Deposit functionality
	
	By depositTab=By.xpath("//button[@ng-click='deposit()']");
	
	By depositAmnt=By.xpath("//input[@placeholder='amount']");
	
	By depositCnfrm=By.xpath("//button[text()='Deposit']");
	
	By cnfrmMessage=By.xpath("//span[@class='error ng-binding']");
	
	
	//Withdraw functionality
	
		By withdrawTab=By.xpath("//button[@ng-click='withdrawl()']");
		
		By withdrawAmnt=By.xpath("//input[@placeholder='amount']");
		
		By withdrawCnfrm=By.xpath("//button[text()='Withdraw']");
		
		By errorMessage=By.xpath("//span[@class='error ng-binding']");
		
		By logoutBtn=By.xpath("//button[text()='Logout']");
		
		
		public CustomerWelcomePage(WebDriver driver)
		{
			this.driver=driver;
		}
		
		public void custDetailVerification() throws Exception
		{
			Thread.sleep(2000);
			String acctName = driver.findElement(nameVerify).getText();
			String expectName = "Test Selenium";
			Assert.assertEquals(acctName, expectName, "Incorrect Customer displayed");
			System.out.println("Customer Logged in successful");
		}
		
		public void amntDeposit()throws Exception
		{
			driver.findElement(depositTab).click();
			String depositAmount = "1000";
			Thread.sleep(2000);
			driver.findElement(depositAmnt).sendKeys(depositAmount);
			driver.findElement(depositCnfrm).click();
			String depositSuccess=driver.findElement(cnfrmMessage).getText();
			Assert.assertEquals("Deposit Successful", depositSuccess,"Retry");
			System.out.println("Amount Deposited Successfully");
		}
		
		public void amntWithdraw() throws InterruptedException
		{
			driver.findElement(withdrawTab).click();
			int withdrawAmt = 1001;
			Thread.sleep(2000);
			String withdrawAmount = String.valueOf(withdrawAmt);
			driver.findElement(withdrawAmnt).sendKeys(withdrawAmount);
			driver.findElement(withdrawCnfrm).click();
			String withdrawFail=driver.findElement(errorMessage).getText();
			String acctError = "Transaction Failed. You can not withdraw amount more than the balance.";
			
			Assert.assertEquals(acctError, withdrawFail);
			System.out.println(withdrawFail);
		}
		
		public void logout()
		{
			driver.findElement(logoutBtn).click();
			
			driver.quit();
		}
	

}
