package com.bigbasket.pages;


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
		WaitFor.untilUrlLoad("https://www.bigbasket.com/");
	}

}
