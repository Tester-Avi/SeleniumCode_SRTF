package com.srtf.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.srtf.pageobjects.BaseTest;
import com.srtf.pageobjects.LoginPage;
import com.srtf.pageobjects.ReadExcelFile;

public class LoginTestDriverData extends BaseTest {

	String fileName = System.getProperty("user.dir")+("\\TestData\\TestInfo.xlsx");

	@Test (priority = 1, dataProvider = "LoginDataProvider")
	void testCheck (String userEmail, String userPwd) throws Exception {

		LoginPage lp = new LoginPage(driver);

//		String username = "Demo12";
//		String password = "Test123456$";
		lp.loginToPortal(userEmail, userPwd);

		if(userEmail.equals("Demo12") && userPwd.equals("Test123456$"))
		{
			System.out.println("Test Passed");
			Assert.assertTrue(false);
			lp.logout();
		}
		else
		{
			captureScreenShot(driver,"VerifyLogin");
			Assert.assertTrue(false);
		}
	}


	@DataProvider(name = "LoginDataProvider")
	public String [][] LoginDataProvider() {

		int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginData");
		int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginData");

		String data[][] = new String[ttlRows-1][ttlColumns];

		for (int currentRow=1; currentRow<ttlRows; currentRow++) {

			for (int currentCell=0; currentCell<ttlColumns; currentCell++ ) {

				data[currentRow-1] [currentCell] = ReadExcelFile.getCellValue(fileName, "LoginData", currentRow, currentCell);

			}
		}
		return data;
	}


}
