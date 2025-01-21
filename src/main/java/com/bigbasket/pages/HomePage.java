package com.bigbasket.pages;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import com.bigbasket.base.WaitFor;
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
	public static WebElement shopByCategoryMenu;

	@FindBy(xpath = "//li[@class=\"jsx-1259984711\" and @role=\"none\"]")
	List<WebElement> categoryList;

	@FindBy(xpath = "(//input[@placeholder=\"Search for Products...\"])[2]")
	WebElement searchTextBox;

	@FindBy(xpath = "//li[@class=\"QuickSearch___StyledMenuItem-sc-rtz2vl-4 ibNDA-d\"]")
	List<WebElement> results;

	@FindBy(css = "div.Header___StyledQuickSearch2-sc-19kl9m3-0 input.flex-1")
	WebElement searchText;

	public HomePage() {
		PageFactory.initElements(Keyword.driver, this);
	}

	public void verifySearchTextBoxVisibleOnThePageOrNot() {
		Assert.assertTrue(searchTextBox.isDisplayed());

	}

	public void enterTextIntoSearchTextBox() throws InterruptedException {
		Keyword.sendkeys(searchTextBox, "Apple");
		Thread.sleep(3000);
	}

	public void verifyThatUserCanAbleToTypeTextIntoTheSearchBar() {
		Assert.assertEquals(searchTextBox.getAttribute("value"), "Apple");
	}

	public String getValueOfAttribute() {
		String value = searchTextBox.getAttribute("value");
		Keyword.sendkeys(searchTextBox, "Apple");
		String value1 = searchTextBox.getAttribute("value");
		return value;

	}

	public void verifyThePlaceholderTextIsDisplayedWhenTheSearchBarIsEmpty() {
		String value = getValueOfAttribute();
		String value1 = getValueOfAttribute();
		Assert.assertFalse(value == value1);

	}

	public List<String> getAllSearchResultDescription() {
		List<WebElement> descriptions = results;
		List<String> searchdescriptions = new ArrayList<String>();
		for (WebElement description : descriptions) {
			searchdescriptions.add(description.getText());

		}
		return searchdescriptions;

	}

	public void verifyThatRelevantSearchResultsAreDisplayedWhenValidTextIsEntered() {
		SoftAssert softly = new SoftAssert();
		for (String description : getAllSearchResultDescription()) {
			softly.assertTrue(description.contains("Apple"));

		}
		softly.assertAll();

	}

	public String getUrlBeforeText() {
		String urlBeforeText = Keyword.driver.getCurrentUrl();
		System.out.println(urlBeforeText);
		return urlBeforeText;
	}

	public void KeepEmptySearchBar() {
		Keyword.sendkeys(searchTextBox, "");
		searchTextBox.sendKeys(Keys.ENTER);

	}

	public String getUrlAfterText() {
		String urlAfterText = Keyword.driver.getCurrentUrl();
		System.out.println(urlAfterText);
		return urlAfterText;

	}

	public void verifyThebBehaviourWhenThSearchbBarIsLeftEmptyAndUserPressTheEnter() {
		String urlBeforeText = getUrlBeforeText();
		KeepEmptySearchBar();
		String urlAfterText = getUrlAfterText();
		Assert.assertEquals(urlBeforeText, urlAfterText);

	}

	public void EnterPartialTextIntoTextBox() throws InterruptedException {
		Keyword.sendkeys(searchTextBox, "Toma");
		Thread.sleep(3000);

	}

	public List<String> getAllSearchResultDescriptionWhenEnterPartialText() {
		List<WebElement> descriptions = results;
		List<String> searchdescriptions = new ArrayList<String>();
		for (WebElement description : descriptions) {
			searchdescriptions.add(description.getText());

		}
		return searchdescriptions;

	}

	public void verifyWhenEnterPartialTextIntoSerachbarThenResultShouldBeDisplayeOrNot() {
		SoftAssert softly = new SoftAssert();
		for (String description : getAllSearchResultDescription()) {
			softly.assertTrue(description.contains("Toma"));

		}
		softly.assertAll();

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

	public boolean clickOnAllCategoriesOneByOne() throws InterruptedException {
		boolean areClickable=false;
		keyword.maximizeBrowser();
		for (WebElement category : categoryList) {
			WaitFor.visibilityOfElement(category);
			String categoryNames = category.getText().toLowerCase();
			clickOnCategory(categoryNames);
			System.out.println(categoryNames);
			Thread.sleep(5000);
			clickOnShopByCategoryMenu();
			if (categoryNames.equals("Paan Corner")) {
				areClickable=true;
				System.out.println("flag after last parent category : "+areClickable);
				break;
			}
		}
		return areClickable;
	}

	public void verifyAllCategoriesAreClickable() throws InterruptedException {
		boolean flag=clickOnAllCategoriesOneByOne();
		SoftAssert softlyAssert=new SoftAssert();
		softlyAssert.assertTrue(flag,"All category are not clickable");
		softlyAssert.assertAll();
	}

	public void verifyUrlAfterSearch() {
		String currentURL = Keyword.driver.getCurrentUrl();
		keyword.print("Current URL: " + currentURL);
		assertTrue(currentURL.contains("https://www.bigbasket.com/ps"));

	}

	public void clickOnShopByCategoryMenu() {
		keyword.clickOn(shopByCategoryMenu);
	}

	public void clickOnCategory(String categoryNameInLowerCaseOnly) throws InterruptedException {
		 keyword.clickOnYourCategory(categoryNameInLowerCaseOnly);
		 
	}

	public void verifyNavigatedToHomePageFromCategoryPage() {
		String urlAfterNavigationToHome=keyword.driver.getCurrentUrl();
		assertTrue(urlAfterNavigationToHome.equals("https://www.bigbasket.com/"));
	}
}
