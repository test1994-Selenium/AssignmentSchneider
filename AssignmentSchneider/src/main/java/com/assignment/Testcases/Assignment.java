package com.assignment.Testcases;

import java.util.concurrent.TimeUnit;
import com.assignment.Pages.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Assignment {
	
	@Test
	public void assignment() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.way2automation.com/angularjs-protractor/banking/#/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		LoginPage login=new LoginPage(driver);
		login.managerLogin();
		
		ManagerOperationPage operation=new ManagerOperationPage(driver);
		operation.CustomerCreation();
		operation.custCreationAlert();
		
		System.out.println("===================================================");
		
		operation.accntOpenening();
		operation.accntOpeningAlert();
		
		System.out.println("===================================================");
		
		operation.searchCust();
		
		System.out.println("===================================================");
		
		operation.homePage();
		
		login.custLogin();
		
		CustomerOperationPage custsearch=new CustomerOperationPage(driver);
		custsearch.searchCustomer();
		
		CustomerWelcomePage custWelcome=new CustomerWelcomePage(driver);
		custWelcome.custDetailVerification();
		
		System.out.println("===================================================");
		
		custWelcome.amntDeposit();
		
		System.out.println("===================================================");
		
		custWelcome.amntWithdraw();
		
		System.out.println("===================================================");
		
		custWelcome.logout();
	
	}

}
