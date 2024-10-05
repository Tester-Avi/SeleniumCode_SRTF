package com.srtf.testcases;

import org.testng.annotations.*;

import com.srtf.pageobjects.BaseTest;
import com.srtf.pageobjects.LoginPage;

public class LoginTest extends BaseTest {


	@Test
	void testCheck () {

		LoginPage lp = new LoginPage(driver);

		String username = "Demo12";
		String password = "Test123456$";
		lp.loginToPortal(username, password);

	}


}
