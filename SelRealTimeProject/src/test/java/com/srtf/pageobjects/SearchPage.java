package com.srtf.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;

	public SearchPage (WebDriver ldriver ) {
		this.driver = ldriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="search_course")
	WebElement searchInput;

	@FindBy(xpath="//nav[@role='navigation']//button")
	WebElement serachbtn;


	public void serachCourse(String courseName)
	{
		searchInput.sendKeys(courseName);

		serachbtn.click();
	}
}