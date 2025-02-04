package bigbasketTests;
import org.openqa.selenium.By;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.bigbasket.Listeners.TestListener;
import com.bigbasket.base.Keyword;
import com.bigbasket.base.TestBase;
import com.bigbasket.base.WaitFor;
import com.bigbasket.pages.HomePage;
import com.bigbasket.pages.ShopByCategoryPage;

//@Test(groups = {"RegressionTests"})
@Listeners(TestListener.class)
public class ShopByCategoryTests extends TestBase {

	Keyword keyword = new Keyword();

	@Test(groups = "SanityTests")
	public void verifyShopByCategoryDropDownAvailable() {
		HomePage homepage = new HomePage();
		homepage.verifyShopByCategoryMenuIsAvailable();
	}

	@Test
	public void verifyAllCatgoriesOfShopByCatogoryAreDisplayed() {
		HomePage homepage = new HomePage();
		homepage.clickOnShopByCategoryMenu();
		homepage.verifyAllCatgoriesAreDisplayedProperly();
	}

	@Test
	public void verifyAllCatgoriesOfShopByCatogoryNamesAreDisplayed() {
		HomePage homepage = new HomePage();
		homepage.clickOnShopByCategoryMenu();
		homepage.verifyAllCatgoriesOfShopByCatogoryNamesAreDisplayedProperly();

	}

	@Test
	public void verifyShopByCategoryCollapseOnClickAfterExapand() {
		HomePage homepage = new HomePage();
		homepage.clickOnShopByCategoryMenu();
		homepage.verifyShopByCategoryCollapsesOnClickAfterExapands();
	}

	@Test
	public void verifyAllCategoriesAreClickable() throws InterruptedException {
		HomePage homepage = new HomePage();
		homepage.clickOnShopByCategoryMenu();
		homepage.clickOnAllCategoriesOneByOne();
		homepage.verifyAllCategoriesAreClickable();
	}

	@Test
	public void verifyRespectiveCategoryPageOpensAfterClick() throws InterruptedException {

		HomePage homepage = new HomePage();
		homepage.clickOnShopByCategoryMenu();
		homepage.clickOnCategory("fashion");
		ShopByCategoryPage categoryPage = new ShopByCategoryPage();
		categoryPage.verifySpecificCatgeoryPageOpens();

	}

	//working on this test case don't review it
	@Test
	public void verifyProductCountMatchesActualNumberProductsAvailableUnderThatCategory() throws InterruptedException {
		HomePage homepage = new HomePage();
		homepage.clickOnShopByCategoryMenu();
		homepage.clickOnCategory("fashion");
		Thread.sleep(3000);
		String displayedCount = Keyword.driver.findElement(
				By.cssSelector("span[class=\"Label-sc-15v1nk5-0 Title___StyledLabel-sc-800s46-0 gJxZPQ lnIjdY\"]"))
				.getText();
		displayedCount = displayedCount.replace("(", "");
		displayedCount = displayedCount.replace(")", "");
		System.out.println("displayedCount: "+displayedCount);
		Thread.sleep(5000);
		int actualProductCount = Keyword.driver
				.findElements(By.cssSelector("div[class=\"SKUDeck___StyledDiv-sc-1e5d9gk-0 eA-dmzP\"]")).size();
		System.out.println("actualProductCount: "+actualProductCount);
		Assert.assertEquals(actualProductCount, displayedCount);
	}

	// this is done can review.Tried wait instead of sleep but not working
	@Test
	public void verifyNavigationToHomePageByTappingOnHomeButtonFromCatgeoryPage() throws InterruptedException {
		HomePage homepage = new HomePage();
		homepage.clickOnShopByCategoryMenu();
		homepage.clickOnCategory("fashion");
		Thread.sleep(3000);
		ShopByCategoryPage categoryPage = new ShopByCategoryPage();
		categoryPage.clickOnHomeButton();
		Thread.sleep(3000);
		homepage.verifyNavigatedToHomePageFromCategoryPage();
	}
	@Test(groups = "SanityTests")
	public void verifyNavigationToHomePageByTappingOnBackButtonOfBrowser() throws InterruptedException {
		HomePage homepage = new HomePage();
		homepage.clickOnShopByCategoryMenu();
		homepage.clickOnCategory("fashion");
		Thread.sleep(3000);
		ShopByCategoryPage categoryPage = new ShopByCategoryPage();
		categoryPage.clickOnBackButtonOfBrowserFromCategoryPage();
		Thread.sleep(3000);
		homepage.verifyNavigatedToHomePageFromCategoryPage();
	}
	@Test
	public void verifyNoProductMessageWhenCategoryDoesNotHaveProducts() throws InterruptedException {
		HomePage homepage = new HomePage();
		homepage.clickOnShopByCategoryMenu();
		homepage.clickOnCategory("apparel");	
		WaitFor.untilUrlContains("cl");
		ShopByCategoryPage categoryPage = new ShopByCategoryPage();
		categoryPage.verifyNoProductMessgae();
	}
	

}
