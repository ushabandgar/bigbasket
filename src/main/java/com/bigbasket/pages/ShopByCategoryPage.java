package com.bigbasket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.bigbasket.base.Keyword;
import com.bigbasket.base.WaitFor;

public class ShopByCategoryPage {
	
	@FindBy(xpath = "//a[@href=\"/cl/fashion/?nc=ct-fa\"]")
	WebElement categoryNameOnCategoryPage;

	public ShopByCategoryPage() {
		PageFactory.initElements(Keyword.driver, this);
	}

	public String getTextOfCategory(String cateoryName) {
		String CategoryNameOnCategoryPage = Keyword.driver
				.findElement(By.xpath("//a[@href=\"/cl/" + cateoryName + "/?nc=ct-fa\"]")).getText();
		return CategoryNameOnCategoryPage;
	}

	public void verifySpecificCatgeoryPageOpens() throws InterruptedException {		
		Thread.sleep(3000);
		//WaitFor.untilUrlLoad("https://www.bigbasket.com/cl/fashion/?nc=nb");
		WaitFor.elementToBeDisplayed(categoryNameOnCategoryPage);
		if(Keyword.driver.getCurrentUrl().contains("fashion")) {
		String categoryNameAfterClick = categoryNameOnCategoryPage.getText();
		Assert.assertTrue(categoryNameAfterClick.equals("Fashion"));
		}
	}

}
