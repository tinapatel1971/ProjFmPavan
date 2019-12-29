package com.HDFramworkProjFmPavan.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop; 
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			
			System.out.println("The exception is "+ e.getMessage());
		}
		
	}
	public String getApplicationURL()
	{
		String url = prop.getProperty("baseURL");
		return url;
	}
	
	public String getUsername()
	{
		String userName = prop.getProperty("username");
		return userName;
	}
	public String getPassword()
	{
		String password = prop.getProperty("password");
		return password;
	}
	public String getChromepath()
	{
		String chromePath = prop.getProperty("chromePath");
		return chromePath;
	}
	public String getiePath()
	{
		String iePath = prop.getProperty("iePath");
		return iePath;
	}
	public String getfirefoxPath()
	{
		String firefoxPath = prop.getProperty("firefoxPath");
		return firefoxPath;
	}
	
	
	
	
}
