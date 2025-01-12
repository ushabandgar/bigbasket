package com.bigbasket.pages;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.bigbasket.base.*;


public class ProductDetailPage {
	Keyword keyword = new Keyword();
	@FindBy(css="section.Image___StyledSection-sc-1nc1erg-0")
	WebElement productImage;
	
	
	public ProductDetailPage() {
		PageFactory.initElements(Keyword.driver, this);
	}
	
	public void switchWindowOnproductDetailPage() {
		keyword.switchToWindowByTitle("Buy Amul Taaza Milk Online at Best Price of Rs 56 - bigbasket");
		System.out.println("driver switch on Product detail page");

	}

	public void verifyAfterClickOnProductThenProductUrlTitleChanged() {
		String currentTitle = Keyword.driver.getTitle();
		keyword.print("Current title: " + currentTitle);
		assertTrue(currentTitle.contains("Buy Amul Taaza Milk Online at Best Price"),
				"The title did not change to the product page title.");
	}

	public void verifyAfterClickOnProductThenProductUrlChanged() {
		String currentURL = Keyword.driver.getCurrentUrl();
		keyword.print("Current URL: " + currentURL);
		assertTrue(currentURL.contains("https://www.bigbasket.com/pd/"),
				"The url did not change to the product page title.");
	}

	public void CheckProductImageToverifyImageloadingSuccessfully() {
		WaitFor.visibilityOfElement(productImage);
		assertTrue(productImage.isDisplayed(),
				"Product image is not displayed, page might not be fully loaded.");
		System.out.println("Click on product image");

	}
}