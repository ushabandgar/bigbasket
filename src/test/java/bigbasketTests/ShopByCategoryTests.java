package bigbasketTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bigbasket.base.Keyword;
import com.bigbasket.base.TestBase;
import com.bigbasket.pages.HomePage;
import com.bigbasket.pages.ShopByCategoryPage;

public class ShopByCategoryTests extends TestBase {

	Keyword keyword = new Keyword();

	@Test
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
}
