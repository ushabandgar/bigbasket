package com.bigbasket.pages;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import com.bigbasket.base.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.bigbasket.base.Keyword;

public class HomePage {
	Keyword keyword = new Keyword();

	@FindBy(css = "button[id*='headlessui-menu-button-:R5bab6:']")
	WebElement shopByCategoryMenu;

	@FindBy(xpath = "//li[@class=\"jsx-1259984711\" and @role=\"none\"]")
	List<WebElement> categoryList;

	@FindBy(xpath = "(//input[@placeholder=\"Search for Products...\"])[2]")
	WebElement SearchTextBox;

	@FindBy(xpath = "//li[@class=\"QuickSearch___StyledMenuItem-sc-rtz2vl-4 ibNDA-d\"]")
	List<WebElement> results;

	@FindBy(css = "div.Header___StyledQuickSearch2-sc-19kl9m3-0 input.flex-1")
	WebElement searchText;

	public HomePage() {
		PageFactory.initElements(Keyword.driver, this);
	}

	public void verifyShopByCategoryMenuIsAvailable() {
		Assert.assertTrue(shopByCategoryMenu.isDisplayed());
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
		List<String> expectedCategoryNames = keyword.getExpectedCategoryNames();
		ArrayList<String> actualCategoryNames = new ArrayList<String>();
		SoftAssert softlyAssert = new SoftAssert();
		for (WebElement category : categoryList) {
			actualCategoryNames.add(category.getText());
		}
		softlyAssert.assertEquals(actualCategoryNames, expectedCategoryNames);
		softlyAssert.assertAll();
	}

	public void verifySearchTextBoxVisibleOrNot() {
		Assert.assertTrue(SearchTextBox.isDisplayed());

	}
	public void verifyUserCanAbleToTextIntoSearchTextBox() {
		SearchTextBox.sendKeys("Apple");
		Assert.assertEquals(SearchTextBox.getAttribute("value"), "Apple");

	}

	public void verifyEnterTextWhenPlaceholderTextIsEmpty() {
		String value = SearchTextBox.getAttribute("value");
		SearchTextBox.sendKeys("Apple");
		String value1 = SearchTextBox.getAttribute("value");
		Assert.assertFalse(value == value1);

	}

	public void VerifyRelevantResultIsDispalyedWhenEnterText() throws InterruptedException {
		SearchTextBox.sendKeys("Tomato");
		Thread.sleep(3000);
		System.out.println(results.size());
		for (WebElement result : results) {
			String text = result.getText();
			System.out.println(text);
			assertTrue(text.contains("Tomato"));

		}

	}

	public void verifyBehaviourOfSearchbarWhenLeftEmptyAndPressEnter() {
		String urlBefore = Keyword.driver.getCurrentUrl();
		System.out.println(urlBefore);
		SearchTextBox.sendKeys("");
		SearchTextBox.sendKeys(Keys.ENTER);
		String urlAfter = Keyword.driver.getCurrentUrl();
		System.out.println(urlAfter);
		Assert.assertEquals(urlBefore, urlAfter);

	}

	public void clickOnSearchText() {
		WaitFor.visibilityOfElement(searchText);
		searchText.click();
		System.out.println("Clicked on search text field.");
	}

	public void sendProductName() {
		searchText.sendKeys("Amul Taaza Milk, 1 L Pouch");
		searchText.sendKeys(Keys.ENTER);
		WaitFor.untilUrlLoad("https://www.bigbasket.com/ps");

	}

	public void verifyUrlAfterSearch() {
		String currentURL = Keyword.driver.getCurrentUrl();
		keyword.print("Current URL: " + currentURL);
		assertTrue(currentURL.contains("https://www.bigbasket.com/ps"));

	}

}
