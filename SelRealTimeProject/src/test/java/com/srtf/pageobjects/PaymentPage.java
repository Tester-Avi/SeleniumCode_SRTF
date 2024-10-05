package com.srtf.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

	WebDriver driver;
	//constructor
	public PaymentPage(WebDriver lDriver)
	{
		this.driver=lDriver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//label[@for='payment_method_stripe']")
	WebElement paystripeclick;
	
	@FindBy(id="learn-press-checkout-place-order")
	WebElement placeorderbtn;
	
	
	
	@FindBy(xpath="//iframe[@title='Secure card payment input frame']")
	WebElement frameelement;
	
	@FindBy(name="cardnumber")
	WebElement cardnum;
	
	@FindBy(name="exp-date")
	WebElement expdate;
	
	@FindBy(name="cvc")
	WebElement cvc;
	
	@FindBy(id="payment-button")
	WebElement paybtn;
	
	
	public void paymentOption(String cardnumber,String exp, String cvcnu)
	{
		paystripeclick.click();
		placeorderbtn.submit();
		
		
		driver.switchTo().frame(frameelement);
		
		cardnum.sendKeys(cardnumber);
		expdate.sendKeys(exp);
		cvc.sendKeys(cvcnu);
		
		driver.switchTo().defaultContent();
	
		paybtn.click();
	}
	
}
