package com.bigbasket.pages;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.bigbasket.base.*;

public class ProductDetailPage {
	Keyword keyword = new Keyword();

	@FindBy(css = "section.Image___StyledSection-sc-1nc1erg-0")
	WebElement productImage;

	@FindBy(css = "h1.Description___StyledH-sc-82a36a-2")
	WebElement expectedProductTitleText;

	@FindBy(css = "td.fLZywG")
	WebElement expectedproductprice;

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
		assertTrue(productImage.isDisplayed(), "Product image is not displayed, page might not be fully loaded.");
		System.out.println("Checked a product image loading.");

	}

	public void getexpectedProductDetailTitleText() {
		WaitFor.untilUrlLoad("https://www.bigbasket.com/pd");
		System.out.println("Expected Product Title: " + expectedProductTitleText.getText());

	}

	public void verifyActualAndExpectedProductText() {
		assertTrue(expectedProductTitleText.getText().contains("Taaza Milk"),
				"Expected product title does not contain 'Taaza Milk'");

	}

	public void getExpectedProductDetailPagePrice() {
		WaitFor.untilUrlLoad("https://www.bigbasket.com/pd");
		System.out.println("Actual Product Title: " + expectedproductprice.getText());
	}

	public void verifyActualAndExpectedProductPrice() {
		assertTrue(expectedproductprice.getText().contains("₹56"), "Price not match!");

	}

	public void CheckProductUrlLoadingSuccessfully() {
		String currentUrl = Keyword.driver.getCurrentUrl();
		keyword.print("Current title: " + currentUrl);

	}

	public void hoverOnImage() {
		keyword.mouseHoverOn(productImage);

	}

	public void verifyHoverFeatureWorks() {
		assertTrue(productImage.isDisplayed(), "Hover effect did not make the zoomed image visible.");
	}
	
	public void clickOnProductImageGallaryOnebyOne(){
   	 for (int i = 0; i <= 4; i++) {
			String imageSelector = "#thumb-" + i;
			List<WebElement> productImages = WaitFor.visibilityOfElements(Keyword.driver.findElements(By.cssSelector(imageSelector)));
			for (WebElement images : productImages) {
				WaitFor.visibilityOfElement(images);
				images.click();
				assertTrue(images.isDisplayed(), "Image is not visible");
			}
		}
    }

}
