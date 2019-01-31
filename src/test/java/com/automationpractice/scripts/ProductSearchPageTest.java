package com.automationpractice.scripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationpractice.base.BaseClass;
import com.automationpractice.pages.LandingPage;
import com.automationpractice.pages.ProductSearchPage;

public class ProductSearchPageTest extends BaseClass {

	LandingPage landingPage;
	ProductSearchPage productSearchPage;

	// constructor to call BaseClass constructor which will initialize and load
	// properties file using prop object
	public ProductSearchPageTest() {
		super();
	}

	// This will execute before any method under @Test annotation
	@BeforeMethod
	public void setUp() {
		// This method will invoke the browser with url since super() has already loaded
		// the value using prop object
		init();
		// LandingPage object is created and stored in landingPage variable
		landingPage = new LandingPage();
	}

	@Test
	public void productSearchResult() {
		productSearchPage = landingPage.searchProduct("printed dress");
		Assert.assertTrue(productSearchPage.getSearchResult());
	}

	@Test
	public void productSearch() {
		productSearchPage = landingPage.searchProduct("printed dress");
		Assert.assertTrue(productSearchPage.isProductSearchPageDisplayed());
	}

	// This method is called once the method under @Test annotation is executed
	@AfterMethod
	public void cleanUp() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}
}
