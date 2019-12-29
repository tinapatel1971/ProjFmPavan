package com.HDFramworkProjFmPavan.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.HDFramworkProjFmPavan.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		driver.get(baseURL);
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("user proveded.");
		lp.setPassword(password);
		logger.info("password provided.");
		lp.clkLogin();
		logger.info("login clicked");
		Thread.sleep(2000);
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true);
			Thread.sleep(2000);
			lp.clkLogout();
			logger.info("login passed");
		}
		else 
		{
			captureScreenshots(driver, "Login Test");
			Assert.assertTrue(false);
			logger.info("login failed");
		}
	}
	
	

}
