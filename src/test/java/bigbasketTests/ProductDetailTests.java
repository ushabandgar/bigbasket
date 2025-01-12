package bigbasketTests;
import org.testng.annotations.Test;

import com.bigbasket.base.*;
import com.bigbasket.pages.HomePage;
import com.bigbasket.pages.ProductDetailPage;
import com.bigbasket.pages.ProductSearchPage;

public class ProductDetailTests extends TestBase{
	Keyword keyword = new Keyword();

	@Test
	public void verifyWhenUserSearchProductAfterUrlWillChangedOnSameTabUisngFactory() {
		HomePage homePage = new HomePage();
		homePage.clickOnSearchText();
		homePage.sendProductName();
		homePage.verifyUrlAfterSearch();
	}

	@Test
	public void verifyWhenUserClickOnProductThenProductUrlTitleChangedUsingFactory() {
		HomePage homePage = new HomePage();
		homePage.clickOnSearchText();
		homePage.sendProductName();
		homePage.verifyUrlAfterSearch();
		ProductSearchPage productSearchPage = new ProductSearchPage();
		productSearchPage.clickOnProduct();
		productSearchPage.switchDriverOnProductSearchPage();
		ProductDetailPage productDetailPage = new ProductDetailPage();
		productDetailPage.verifyAfterClickOnProductThenProductUrlTitleChanged();
	}

	@Test
	public void verifyWhenUserClickOnProductThenProductPageURlchangedUsingFactory() {
		HomePage homePage = new HomePage();
		homePage.clickOnSearchText();
		homePage.sendProductName();
		homePage.verifyUrlAfterSearch();
		ProductSearchPage productSearchPage = new ProductSearchPage();
		productSearchPage.clickOnProduct();
		productSearchPage.switchDriverOnProductSearchPage();
		ProductDetailPage productDetailPage = new ProductDetailPage();
		productDetailPage.verifyAfterClickOnProductThenProductUrlTitleChanged();

	}

	@Test
	public void verifyWhenUserClickOnProductThenProductUrlFullyLoadedUsingFactory() {
		HomePage homePage = new HomePage();
		homePage.clickOnSearchText();
		homePage.sendProductName();
		homePage.verifyUrlAfterSearch();
		ProductSearchPage productSearchPage = new ProductSearchPage();
		productSearchPage.clickOnProduct();
		productSearchPage.switchDriverOnProductSearchPage();
		ProductDetailPage productDetailPage = new ProductDetailPage();
		productDetailPage.switchWindowOnproductDetailPage();
		productDetailPage.CheckProductImageToverifyImageloadingSuccessfully();
		keyword.print("verify Page loaded successfully! product image visible.");
	}
	
	
}
