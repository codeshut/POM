package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automationpractice.base.BaseClass;

public class SignInPage extends BaseClass {

	// Page Factory
	// Sign In Button
	@FindBy(id = "SubmitLogin")
	WebElement signInBtn;

	// email address text box
	@FindBy(id = "email")
	WebElement emailTextBox;

	// Password text box
	@FindBy(id = "passwd")
	WebElement passwordTextBox;
	
	public SignInPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean isSignInPageDisplayed() {
		return signInBtn.isDisplayed();
	}
	
	public HomePage login(String userName, String password) {
		emailTextBox.sendKeys(userName);
		passwordTextBox.sendKeys(password);
		signInBtn.click();
		return new HomePage();
	}
	
	
}
