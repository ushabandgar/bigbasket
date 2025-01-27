package com.bigbasket.pages;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.bigbasket.base.*;

public class ProductDetailPage {
	Keyword keyword = new Keyword();
	@FindBy(xpath = "//section[contains(@class, 'Image___StyledSection')]")
	WebElement productImage;

	@FindBy(css = "h1.Description___StyledH-sc-82a36a-2")
	WebElement expectedProductTitleText;

	@FindBy(css = "td.fLZywG")
	WebElement expectedproductprice;

	@FindBy(css = "span.Pricing___StyledLabel-sc-pldi2d-1")
	WebElement actualProductPrice;

	@FindBy(css="section.jFkiCb div.w-full:nth-child(2) div.border-silverSurfer-400 div.w-40:nth-child(2) span.cWTZQL span.bvikaK:nth-child(1)")
	WebElement packsize500ml;
	
	public ProductDetailPage() {
		PageFactory.initElements(Keyword.driver, this);
	}

	public void switchWindowOnproductDetailPage() {
		keyword.switchToWindowByTitle("Buy Amul Taaza Milk Online at Best Price of Rs 56 - bigbasket");
	}

	public void verifyAfterClickOnProductThenProductUrlTitleChanged() {
		WaitFor.untilUrlLoad("https://www.bigbasket.com/pd");
		String currentTitle =Keyword.driver.getTitle();
		System.out.println("Current Title: " + currentTitle);
		assertTrue(currentTitle.contains("Buy Amul Taaza Milk Online at Best Price"),
				"The title did not change to the product page title.");
	}
	
	public void verifyAfterClickOnProductThenProductUrlChanged() {
		
		String currentURL = Keyword.driver.getCurrentUrl();
		System.out.println("Current URL: " + currentURL);
		assertTrue(currentURL.contains("https://www.bigbasket.com/pd/"),
				"The url did not change to the product page title.");
	   
	}

	public void CheckProductImageToverifyImageloadingSuccessfully() {
		WaitFor.untilUrlLoad("https://www.bigbasket.com/pd");
		WaitFor.visibilityOfElement(productImage);
		assertTrue(productImage.isDisplayed(), "Product image is not displayed, page might not be fully loaded.");
	}

	public void getexpectedProductDetailTitleText() {
		WaitFor.untilUrlLoad("https://www.bigbasket.com/pd/");
		System.out.println("Expected Product Title: " + expectedProductTitleText.getText());
	}

	public void verifyActualAndExpectedProductText() {
		assertTrue(expectedProductTitleText.getText().contains("Taaza Milk"),
				"Expected product title does not contain 'Taaza Milk'");
	}

	public void getExpectedProductDetailPagePrice() {
		WaitFor.untilUrlLoad("https://www.bigbasket.com/pd");
		WaitFor.visibilityOfElement(expectedproductprice);
		String expectedproductPrice = expectedproductprice.getText();
		System.out.println("Expected Product Title: " + expectedproductPrice);
	}

	public void verifyActualAndExpectedProductPrice() {
		assertTrue(expectedproductprice.getText().contains("₹"), "Price not match!");

	}

	public void CheckProductUrlLoadingSuccessfully() {
		WaitFor.untilUrlLoad("https://www.bigbasket.com/pd/");
		String currentUrl = Keyword.driver.getCurrentUrl();
		System.out.println(currentUrl);
		System.out.println("Product Page loaded successfully! product image visible.");
		assertTrue(currentUrl.contains("https://www.bigbasket.com/pd/"));
		
	}

	public void hoverOnImage() {
		WaitFor.untilUrlLoad("https://www.bigbasket.com/pd");
		WaitFor.elementToBeVisible(productImage); 
		keyword.mouseHoverOn(productImage);

	}

	public void verifyHoverFeatureWorks() {
		assertTrue(productImage.isDisplayed(), "Hover effect did not make the zoomed image visible.");
	}


	public void verifyclickFucntinalityOnProductImageGallaryOnebyOne() throws InterruptedException {
		WaitFor.untilUrlLoad("https://www.bigbasket.com");
		for (int i = 0; i <= 4; i++) {
			String imageSelector = "#thumb-" + i;
			List<WebElement> productImages = 
					WaitFor.visibilityOfElements(Keyword.driver.findElements(By.cssSelector(imageSelector)));
			for (WebElement images : productImages) {
				Thread.sleep(2000);
				WaitFor.elementToBeClickable(images);
				images.click();
				assertTrue(images.isDisplayed(), "Image is not visible");
			}
		}
	}

	public void verifyGallaryImageQuality() {
		assertTrue(productImage.isDisplayed());
	}
	
	public void verifyPriceContainCurrencySymbolLike₹() {
		assertTrue(expectedproductprice.getText().contains("₹"));
		System.out.println("₹ currency symbol available");
	}
	
	
	public void verifyAfterclickOnProductPackSizeFor500mlProductPriceWillChange() {
		WaitFor.untilUrlLoad("https://www.bigbasket.com/pd");
		WaitFor.visibilityOfElement(packsize500ml);
		String actualpacksizePrice= packsize500ml.getText();
	    System.out.println("actualpacksizePrice: "+actualpacksizePrice); 
	    keyword.clickOn(packsize500ml);

	    WaitFor.visibilityOfElement(expectedproductprice);
	    String price = expectedproductprice.getText(); 
	    
	    String[] expectedPackSizePrice = price.split(" ");  // "Price:" and "₹26"
	    String expectedPriceValue = expectedPackSizePrice[1];  // ₹26
	    
	    System.out.println("Expected price: " + expectedPriceValue);  
	    assertEquals(actualpacksizePrice, expectedPriceValue, "Price does not match for the pack size");
	}



	
}
