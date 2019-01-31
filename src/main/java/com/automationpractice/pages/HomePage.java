package com.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.base.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(className="account")
	WebElement userNameLink;
	

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	
	
	public String getUserName() {
		return userNameLink.getText();
	}
	

}
