package com.srtf.pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage extends BaseTest{

	WebDriver driver;
	
	//constructor
	public DashBoardPage(WebDriver lDriver)
	{
		this.driver=lDriver;
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[@class='lg_button']")
	WebElement dashboardBtn;
	
	@FindBy(xpath="//a[text()='Offered Academies']")
	WebElement offerAcademiesLink;
	
	@FindBy(xpath="//div//h3[contains(text(),'Web Development Academy')]/../div/../form/div/button[contains(text(),'Subscribe Now')]")
	WebElement webDvelopementSubscribeButton;
	
	
	
//	public void dashboardportal(String dashtext) throws IOException
//	{
//		String actualdash= dash.getText();
//		System.out.println(actualdash);
//		
//		if(actualdash.equals(dashtext))
//			{
//				System.out.println("Test Passed");
//				
//			}
//			else
//			{
//				captureScreenShot(driver,"fetchDashboardText");
//			}
//		assertEquals(dashtext, actualdash);
//
//	}
	
	public void dashboardclick()
	{
		dashboardBtn.click();	
		offerAcademiesLink.click();
		webDvelopementSubscribeButton.click();
	}
}