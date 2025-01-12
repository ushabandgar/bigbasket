package com.bigbasket.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bigbasket.base.*;

public class ProductSearchPage {

	@FindBy(css = "li.PaginateItems___StyledLi-sc-1yrbjdr-0")
	WebElement ClickonProduct;
	
	Keyword keyword = new Keyword();
	
	public ProductSearchPage() {
		PageFactory.initElements(Keyword.driver, this);
	}
	
	public void clickOnProduct() {
		keyword.clickOn(ClickonProduct);
		System.out.println("Clicked on product.");

	}
	
	public void switchDriverOnProductSearchPage() {
		keyword.switchToChildWindowHandle();
		System.out.println("driver switch on Product search page");
	}
	
}
