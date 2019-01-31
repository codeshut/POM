package com.automationpractice.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationpractice.base.BaseClass;
import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.LandingPage;
import com.automationpractice.pages.SignInPage;

public class SignInPageTest extends BaseClass {
	LandingPage landingPage;
	SignInPage signInPage;
	HomePage homePage;

	public SignInPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		// This method will invoke the browser with url since super() has already loaded
		// the value using prop object
		init();
		// LandingPage object is created and stored in landingPage variable
		landingPage = new LandingPage();
		// signInPage = new SignInPage();
	}

	@Test
	public void validateLogin() {
		signInPage = landingPage.clickSignIn();
		homePage = signInPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(homePage.getUserName(), "Dhawal Joshi");
	}

	@Test
	public void validateLoginPageIsDisplayed() {
		signInPage = landingPage.clickSignIn();
		Assert.assertTrue(signInPage.isSignInPageDisplayed());
	}

	@AfterMethod
	public void cleanUp() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}

}
