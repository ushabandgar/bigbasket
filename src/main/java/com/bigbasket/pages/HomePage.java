package com.bigbasket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.bigbasket.base.Keyword;

public class HomePage {
	Keyword keyword=new Keyword();
	@FindBy(css="button[id*='headlessui-menu-button-:R5bab6:']")
	WebElement shopByCategoryMenu;
	
	@FindBy(xpath="//li[@class=\"jsx-1259984711\" and @role=\"none\"]")
	List<WebElement> categoryList;
	
	public void verifyShopByCategoryMenuIsAvailable() {
		Assert.assertTrue(shopByCategoryMenu.isDisplayed());
	}
	public HomePage() {
		PageFactory.initElements(Keyword.driver, this);
	}
	
	public void verifyAllCatgoriesOfShopByCatogoryAreDisplayedProperly() {
		keyword.clickOn(shopByCategoryMenu);
		SoftAssert softlyAssert = new SoftAssert();
		for (WebElement category : categoryList) {
			Assert.assertTrue(category.isDisplayed());
		}
		softlyAssert.assertAll();
		}
	
	public void verifyAllCatgoriesOfShopByCatogoryNamesAreDisplayedProperly() {
		keyword.clickOn(shopByCategoryMenu);
		List<String> expectedCategoryNames=keyword.getExpectedCategoryNames();	
		ArrayList<String> actualCategoryNames=new ArrayList<String>();
		SoftAssert softlyAssert = new SoftAssert();
		for (WebElement category : categoryList) {
			actualCategoryNames.add(category.getText());
		}
		softlyAssert.assertEquals(actualCategoryNames, expectedCategoryNames);
		softlyAssert.assertAll();		
	}
}
