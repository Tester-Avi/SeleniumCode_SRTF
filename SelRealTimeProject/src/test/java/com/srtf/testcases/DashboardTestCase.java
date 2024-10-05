package com.srtf.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.srtf.pageobjects.BaseTest;
import com.srtf.pageobjects.DashBoardPage;
import com.srtf.pageobjects.LoginPage;
import com.srtf.pageobjects.ReadExcelFile;

public class DashboardTestCase extends BaseTest {


	String fileName=System.getProperty("user.dir")+"\\TestData\\TestInfo.xlsx";

	@Test(priority =1)
	public void VerifyLogin()
	{
		LoginPage lp=new LoginPage(driver);
		String username=ReadExcelFile.getCellValue(fileName, "LoginData", 1, 0);
		String password=ReadExcelFile.getCellValue(fileName, "LoginData", 1, 1);
		System.out.println(username+" "+password);
		lp.loginToPortal(username, password);
		
		DashBoardPage dp=new DashBoardPage(driver);
		dp.dashboardclick();
		
	}
//		if((username.equals("Demo12")) && (password.equals("Test123456$")))
//		{
//			System.out.println("Test Passed");
//			Assert.assertTrue(true);
//		}
//		else
//		{
//			captureScreenShot(driver,"VerifyLogin");
//			Assert.assertTrue(false);
//		}
//	}
//	
//	@Test(priority =2)
//	public void fetchDashboardText() throws IOException
//	{
//		DashBoardPage dp=new DashBoardPage(driver);
//		String as=ReadExcelFile.getCellValue(fileName, "dash", 0, 0);
//		System.out.println("This is excel data "+as);
//		dp.dashboardportal(ReadExcelFile.getCellValue(fileName, "dash", 0, 0));
//		dp.dashboardclick();
//
//	}	

}
