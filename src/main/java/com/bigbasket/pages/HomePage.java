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
		String expectedShopByCategoryMenuName = "Shop by";
		String actualShopByCategoryMenuName = shopByCategoryMenu.getText();
		if (shopByCategoryMenu.isDisplayed()) {
			Assert.assertTrue(actualShopByCategoryMenuName.contains(expectedShopByCategoryMenuName));
		}
	}

	public void verifyAllCatgoriesAreDisplayedProperly() {
		SoftAssert softlyAssert = new SoftAssert();
		for (WebElement category : categoryList) {
			Assert.assertTrue(category.isDisplayed());
		}

		softlyAssert.assertAll();
	}

	public void verifyAllCatgoriesOfShopByCatogoryNamesAreDisplayedProperly() {
		List<String> expectedCategoryNames = keyword.getExpectedCategoryNames();
		ArrayList<String> actualCategoryNames = new ArrayList<String>();
		SoftAssert softlyAssert = new SoftAssert();
		for (WebElement category : categoryList) {
			actualCategoryNames.add(category.getText());
		}
		softlyAssert.assertEquals(actualCategoryNames, expectedCategoryNames);
		softlyAssert.assertAll();
	}

	public void SearchTextBoxVisibleOrNotUsingPagefactory() {

		System.out.println(SearchTextBox.isDisplayed());
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

	public void verifyRelevantResultIsDispalyedWhenEnterText() throws InterruptedException {
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

	public void verifyShopByCategoryCollapsesOnClickAfterExapands() {
		String classNameAfterExapnd = shopByCategoryMenu.getAttribute("class");
		clickOnShopByCategoryMenu();
		String classNameAfterCollapse = shopByCategoryMenu.getAttribute("class");
		Assert.assertFalse(classNameAfterCollapse.equals(classNameAfterExapnd));
	}

	public void verifyAllCategoriesAreClickable() throws InterruptedException {
		keyword.maximizeBrowser();
		for (WebElement category : categoryList) {
			WaitFor.visibilityOfElement(category);
			String categoryNames = category.getText();
			System.out.println(categoryNames);
			// keyword.clickOn(category);
			clickOnCategory(categoryNames);
			Thread.sleep(5000);
			if (categoryNames.equals("Paan Corner")) {
				break;
			}
			clickOnShopByCategoryMenu();

		}
	}

	public void verifyUrlAfterSearch() {
		String currentURL = Keyword.driver.getCurrentUrl();
		keyword.print("Current URL: " + currentURL);
		assertTrue(currentURL.contains("https://www.bigbasket.com/ps"));

	}

	public void clickOnShopByCategoryMenu() {
		keyword.clickOn(shopByCategoryMenu);
	}

	public void clickOnCategory(String categoryName) throws InterruptedException {
		WebElement fashionCat = shopByCategoryMenu.findElement(
				By.xpath("//div[@class=\"CategoryMenu___StyledMenuItems-sc-d3svbp-4 fpskRu\"]/nav/ul/li/a[@href=\"/cl/"
						+ categoryName + "/?nc=nb\"]"));
		fashionCat.click();
	}
}
