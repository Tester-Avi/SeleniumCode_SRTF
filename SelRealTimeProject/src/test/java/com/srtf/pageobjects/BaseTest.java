package com.srtf.pageobjects;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.srtf.utilities.BrowserFactory;
import com.srtf.utilities.ConfigDataProviders;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public ConfigDataProviders config = new ConfigDataProviders();
	//	public ReadExcelFile excel;

	//
	//	@BeforeSuite
	//	public void setUpSuite()
	//	{
	//		config=new ConfigDataProviders();
	//		//		excel =new ReadExcelFile();
	//	}
	@BeforeClass
	public void setUp()
	{
		driver=BrowserFactory.startApplication(driver,config.getBrowser(),config.getStagingUrl());
	}

	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
	}

	public void captureScreenShot (WebDriver driver, String testName) throws Exception {
		// Step-1 : Convert WebDriver object to TakeScreenshot Interface
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		// Step-2 : call getScreenshotAs Method to create Image File
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "\\Screenshots\\" + testName + ".png");
		// Step-3 : Copy Image File to Destination
		FileUtils.copyFile(src, dest);
	} 

}
