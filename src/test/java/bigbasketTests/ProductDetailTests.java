package bigbasketTests;
import org.testng.annotations.Test;

import com.bigbasket.base.*;
import com.bigbasket.pages.HomePage;
import com.bigbasket.pages.ProductDetailPage;
import com.bigbasket.pages.ProductSearchPage;

public class ProductDetailTests extends TestBase{
	@Test
	public void verifyWhenUserSearchProductAfterUrlWillChangedOnSameTab() {
		HomePage homePage = new HomePage();
		homePage.clickOnSearchText();
		homePage.sendProductName();
		homePage.verifyUrlAfterSearch();
	}

	@Test
	public void verifyWhenUserClickOnProductThenProductUrlTitleChanged() {
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
	public void verifyWhenUserClickOnProductThenProductPageURlchanged() {
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
	public void verifyWhenUserClickOnProductThenProductUrlFullyLoaded() {
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
		Keyword keyword=new Keyword();
		keyword.print("verify Page loaded successfully! product image visible.");
	}
	
	
}
