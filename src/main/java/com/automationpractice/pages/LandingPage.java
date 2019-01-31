package com.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.base.BaseClass;

public class LandingPage extends BaseClass {
	//Page Factory
	@FindBy(id="search_query_top")
	WebElement searchTextBox;
	
	@FindBy(className="ajax_cart_quantity.unvisible")
	WebElement cartValueLabel;
	
	@FindBy(xpath=".//a[@title='Contact Us']")
	WebElement contactUsLink;
	
	@FindBy(className="login")
	WebElement signInLink;
	
	@FindBy(xpath=".//img[@class='replace-2x img-responsive'][@title='Faded Short Sleeve T-shirts']")
	WebElement firstProductMouseHover;
	
	@FindBy(xpath=".//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 first-in-line first-item-of-tablet-line first-item-of-mobile-line hovered']//a[@title='Add to cart']")
	WebElement addToCartButton;
	
	@FindBy(name="submit_search")
	WebElement searchIcon;
	
	public LandingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isPageLoaded() {
		return signInLink.isDisplayed();
	}
	
	public ProductSearchPage searchProduct(String product) {
		searchTextBox.sendKeys(product);
		searchIcon.click();
		return new ProductSearchPage();
	}
	
	public SignInPage clickSignIn() {
		signInLink.click();
		return new SignInPage();
	}
}
