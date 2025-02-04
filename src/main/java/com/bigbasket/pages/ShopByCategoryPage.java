package com.bigbasket.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.bigbasket.base.Keyword;
import com.bigbasket.base.WaitFor;

public class ShopByCategoryPage {

	Keyword keyword=new Keyword();
	
	@FindBy(css="span[class=\"name text-md leading-md xl:leading-sm xl:text-base text-darkOnyx-800\"]")
	WebElement HomeButtonOnCategoryPage;
	
	@FindBy(css="p[class=\"m-auto text-2xl font-light w-152 leading-lg\"]")
	WebElement NoProductMessage;
	
	@FindBy(css="div[class=\"slug___StyledFilterByCategory-sc-1pgl3kl-2 ebgQYS\"]")
	WebElement ShopByCatgeorySection;
	
	@FindBy(css="span[class=\"Label-sc-15v1nk5-0 FilterByCategory___StyledLabel-sc-c0pkxv-0 gJxZPQ bPmHlw\"]")
	WebElement ShopByCategoryOnCategoryPage;
	
	public ShopByCategoryPage() {
		PageFactory.initElements(Keyword.driver, this);
	}

	public String getNameOfCategoryAfterClick(String categoryName) {
		String CategoryNameOnCategoryPage = Keyword.driver
				.findElement(By.cssSelector("a[href=\"/cl/"+categoryName+"/?nc=ct-fa\"]")).getText();
		return CategoryNameOnCategoryPage;
	}

	public void verifySpecificCatgeoryPageOpens() throws InterruptedException {
		Thread.sleep(3000);
		if (Keyword.driver.getCurrentUrl().contains("fashion")) {
			String categoryNameAfterClick = getNameOfCategoryAfterClick("fashion");
			Assert.assertTrue(categoryNameAfterClick.equalsIgnoreCase("fashion"));
		}
	}
	public void clickOnHomeButton(){
		keyword.clickOn(HomeButtonOnCategoryPage);
		WaitFor.untilUrlContains("https://www.bigbasket.com/");
	}

	public String getNoProductMessage() {
		
				String actualNoProductMessage=NoProductMessage.getText();
				return actualNoProductMessage;
	}
	
	public int getProductListAfterClickOnCategory(){
		List<WebElement> productList=Keyword.driver
				.findElements(By.cssSelector("div[class=\"SKUDeck___StyledDiv-sc-1e5d9gk-0 eA-dmzP\"]"));
		int productCount=productList.size();
		return productCount;
	}
	public void verifyNoProductMessgae(){
		int productCount=getProductListAfterClickOnCategory();
		if(productCount>0) {
		String actualNoProductMessage=getNoProductMessage();
		String expectedMessage = "We couldn't find anything matching your query. Try something else.";
		Assert.assertEquals(actualNoProductMessage, expectedMessage);
		}else {
			System.out.println("Category having products in it.");
		}

	}

	public void clickOnBackButtonOfBrowserFromCategoryPage() {
		keyword.clickOnBackButtonOfBrowser();
	}

	public void verifyShopByCategorySectionAvailableOnCategoryPage() {
		if(ShopByCatgeorySection.isDisplayed()){
			String ShopByCategoryText=ShopByCategoryOnCategoryPage.getText();
			System.out.println(ShopByCategoryText);
			Assert.assertTrue(ShopByCategoryText.equals("Shop By Category"));
		}
	}
	
}
