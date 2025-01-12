package bigbasketTests;

import org.testng.annotations.Test;

import com.bigbasket.base.*;
import com.bigbasket.pages.HomePage;
import com.bigbasket.pages.ProductDetailPage;
import com.bigbasket.pages.ProductSearchPage;


public class ProductDetailTests {
	Keyword keyword = new Keyword();

	@Test
	public void verifyWhenUserSearchProductAfterUrlWillChangedOnSameTabUisngFactory() {
		HomePage homePageFactory = new HomePage();
		homePageFactory.clickOnSearchText();
		homePageFactory.sendProductName();
		homePageFactory.verifyUrlAfterSearch();
	}

	@Test
	public void verifyWhenUserClickOnProductThenProductUrlTitleChangedUsingFactory() {
		HomePage homePageFactory = new HomePage();
		homePageFactory.clickOnSearchText();
		homePageFactory.sendProductName();
		homePageFactory.verifyUrlAfterSearch();
		ProductSearchPage productSearchPage = new ProductSearchPage();
		productSearchPage.clickOnProduct();
		productSearchPage.switchDriverOnProductSearchPage();
		ProductDetailPage productDetailPage = new ProductDetailPage();
		productDetailPage.verifyAfterClickOnProductThenProductUrlTitleChanged();
	}

	@Test
	public void verifyWhenUserClickOnProductThenProductPageURlchangedUsingFactory() {
		HomePage homePageFactory = new HomePage();
		homePageFactory.clickOnSearchText();
		homePageFactory.sendProductName();
		homePageFactory.verifyUrlAfterSearch();
		ProductSearchPage productSearchPage = new ProductSearchPage();
		productSearchPage.clickOnProduct();
		productSearchPage.switchDriverOnProductSearchPage();
		ProductDetailPage productDetailPage = new ProductDetailPage();
		productDetailPage.verifyAfterClickOnProductThenProductUrlTitleChanged();

	}

	@Test
	public void verifyWhenUserClickOnProductThenProductUrlFullyLoadedUsingFactory() {
		HomePage homePageFactory = new HomePage();
		homePageFactory.clickOnSearchText();
		homePageFactory.sendProductName();
		homePageFactory.verifyUrlAfterSearch();
		ProductSearchPage productSearchPage = new ProductSearchPage();
		productSearchPage.clickOnProduct();
		productSearchPage.switchDriverOnProductSearchPage();
		ProductDetailPage productDetailPage = new ProductDetailPage();
		productDetailPage.switchWindowOnproductDetailPage();
		productDetailPage.CheckProductImageToverifyImageloadingSuccessfully();
		keyword.print("verify Page loaded successfully! product image visible.");
	}
	
	@Test
	public void Testmethod1() {
		System.out.println("Test method");

	}
}
