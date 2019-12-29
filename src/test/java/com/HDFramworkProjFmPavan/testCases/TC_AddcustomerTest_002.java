package com.HDFramworkProjFmPavan.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.HDFramworkProjFmPavan.pageObjects.AddCustomerPage;
import com.HDFramworkProjFmPavan.pageObjects.LoginPage;

public class TC_AddcustomerTest_002 extends BaseClass{
	@Test
	public void addNewCustomer() throws IOException
	{
		driver.get(baseURL);
		
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("User name is provided");
		
		lp.setPassword(password);
		logger.info("password is provided");
		
		lp.clkLogin();
		
		logger.info("providing customer details....");
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		addcust.clickOnCustomersMenu();
		addcust.clickOnCustomersMenuItem();
		addcust.clickOnAddnew();
		String email = randomString() + "@gmail.com";
		addcust.setEmail(email);
		addcust.setPassword("test123");
		//Registered - default
				//The customer cannot be in both 'Guests' and 'Registered' customer roles
				//Add the customer to 'Guests' or 'Registered' customer role
				addcust.setCustomerRoles("Guest");
				
				addcust.setManagerOfVendor("Vendor 2");
				
				addcust.setGender("Male");
				
				addcust.setFirstName("Pavan");
				addcust.setLastName("Kumar");
				
				addcust.setDob("7/05/1985"); // Format: D/MM/YYY
				
				addcust.setCompanyName("busyQA");
				addcust.setAdminContent("This is for testing.........");
			
				addcust.clickOnSave();
				
				logger.info("validation started....");
				String msg = driver.findElement(By.tagName("body")).getText();
				if(msg.equals("The new customer has been added successfully"))
				{
					Assert.assertTrue(true);
					logger.info("test case passed");
				}
				else
				{
					captureScreenshots(driver,"addNewCustomer");
					Assert.assertFalse(false);
				}
	}

}
