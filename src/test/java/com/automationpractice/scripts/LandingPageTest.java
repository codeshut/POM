package com.automationpractice.scripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationpractice.base.BaseClass;
import com.automationpractice.pages.LandingPage;
import com.automationpractice.pages.ProductSearchPage;
import com.automationpractice.pages.SignInPage;

public class LandingPageTest extends BaseClass{
	
	LandingPage landingPage;
	ProductSearchPage productSearchPage;
	SignInPage signInPage;
	//constructor to call BaseClass constructor which will initialize and load properties file using prop object 
	public LandingPageTest() {
		super();
	}

	//This will execute before any method under @Test annotation 
	@BeforeMethod
	public void setUp() {
		//This method will invoke the browser with url since super() has already loaded the value using prop object
		init();
		//LandingPage object is created and stored in landingPage variable
		landingPage = new LandingPage();

	}
	
	
	@Test
	public void isWebpageLoaded() {
		boolean flag = landingPage.isPageLoaded();
		//Test Case will pass if flag value is true
		Assert.assertTrue(flag);
	}
	
	

	
	//This method is called once the method under @Test annotation is executed
	@AfterMethod
	public void cleanUp() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}
}
