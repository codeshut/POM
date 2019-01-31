package com.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.base.BaseClass;

public class ProductSearchPage extends BaseClass {
	
	//Page Factory
		//Result Count displayed at right above the search results
		@FindBy(className="heading-counter")
		WebElement resultValue;
		
		//Search text label above Sort by
		@FindBy(xpath="//h1[contains(@class,'product-listing')]")
		WebElement searchText;
		
		public ProductSearchPage() {
			PageFactory.initElements(driver, this);
		}
		
		public boolean isProductSearchPageDisplayed() {
			return searchText.isDisplayed();
		}
		
		public boolean getSearchResult() {
			return resultValue.getText().contains("5");
		}

}
