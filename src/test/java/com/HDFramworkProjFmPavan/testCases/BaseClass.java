package com.HDFramworkProjFmPavan.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.HDFramworkProjFmPavan.utilities.ReadConfig;


public class BaseClass {
	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public WebDriver driver;
	
	public static Logger logger; //Added logger
	
	@BeforeClass
	@Parameters("browser")
	public void setUp(String br)
	{
		/*
		 * if(br.equals("chrome")) {
		 * System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());
		 * driver = new ChromeDriver(); } else if(br.equals("ie")) {
		 * System.setProperty("webdriver.ie.driver",readconfig.getiePath()); driver =
		 * new InternetExplorerDriver(); } else if(br.equals("firefox")) {
		 * System.setProperty("webdriver.gecko.driver",readconfig.getfirefoxPath());
		 * driver = new FirefoxDriver(); }
		 */
		
		switch(br)
		{
			case "chrome" :
				{
					System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());
				     driver = new ChromeDriver(); 
				     
				     break;
				}  
			case "firefox" :
				{
					System.setProperty("webdriver.gecko.driver",readconfig.getfirefoxPath());
				    driver = new FirefoxDriver();
				    break;
				}
				
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		logger = Logger.getLogger("eCommerce");
		PropertyConfigurator.configure("Log4j.properties");
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreenshots(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("screenshot taken");
		
	}
	
	public static String randomString() 
	{
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return generatedString1;
	}
	
	public static String randomNum()
	{
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return generatedString2;
	}

}
