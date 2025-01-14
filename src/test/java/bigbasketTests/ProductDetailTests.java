package bigbasketTests;
import org.testng.annotations.Test;
import com.bigbasket.base.*;
import com.bigbasket.pages.HomePage;
import com.bigbasket.pages.ProductDetailPage;
import com.bigbasket.pages.ProductSearchPage;
<<<<<<< HEAD

public class ProductDetailTests {
	Keyword keyword = new Keyword();

	@Test
	public void verifyWhenUserSearchProductAfterUrlWillChangedOnSameTab() {
		HomePage homePageFactory = new HomePage();
		homePageFactory.clickOnSearchText();
		homePageFactory.sendProductName();
		homePageFactory.verifyUrlAfterSearch();
=======
public class ProductDetailTests extends TestBase{
	
	
	@Test
	public void verifyWhenUserSearchProductAfterUrlWillChangedOnSameTab() {
		HomePage homePage = new HomePage();
		homePage.clickOnSearchText();
		homePage.sendProductName();
		homePage.verifyUrlAfterSearch();
>>>>>>> 31de80155af300a3e4b3dbe320001bf4280205ac
	}

	@Test
	public void verifyWhenUserClickOnProductThenProductUrlTitleChanged() {
<<<<<<< HEAD
		HomePage homePageFactory = new HomePage();
		homePageFactory.clickOnSearchText();
		homePageFactory.sendProductName();
		homePageFactory.verifyUrlAfterSearch();
=======
		HomePage homePage = new HomePage();
		homePage.clickOnSearchText();
		homePage.sendProductName();
		homePage.verifyUrlAfterSearch();
>>>>>>> 31de80155af300a3e4b3dbe320001bf4280205ac
		ProductSearchPage productSearchPage = new ProductSearchPage();
		productSearchPage.clickOnProduct();
		productSearchPage.switchDriverOnProductSearchPage();
		ProductDetailPage productDetailPage = new ProductDetailPage();
		productDetailPage.verifyAfterClickOnProductThenProductUrlTitleChanged();
	}

	@Test
	public void verifyWhenUserClickOnProductThenProductPageURlchanged() {
<<<<<<< HEAD
		HomePage homePageFactory = new HomePage();
		homePageFactory.clickOnSearchText();
		homePageFactory.sendProductName();
		homePageFactory.verifyUrlAfterSearch();
=======
		HomePage homePage = new HomePage();
		homePage.clickOnSearchText();
		homePage.sendProductName();
		homePage.verifyUrlAfterSearch();
>>>>>>> 31de80155af300a3e4b3dbe320001bf4280205ac
		ProductSearchPage productSearchPage = new ProductSearchPage();
		productSearchPage.clickOnProduct();
		productSearchPage.switchDriverOnProductSearchPage();
		ProductDetailPage productDetailPage = new ProductDetailPage();
		productDetailPage.verifyAfterClickOnProductThenProductUrlTitleChanged();
	}

	@Test
<<<<<<< HEAD
	public void verifyWhenUserClickOnProductThenProductUrlLoadFully() {
		HomePage homePageFactory = new HomePage();
		homePageFactory.clickOnSearchText();
		homePageFactory.sendProductName();
		homePageFactory.verifyUrlAfterSearch();
=======
	public void verifyWhenUserClickOnProductThenProductUrlFullyLoaded() {
		HomePage homePage = new HomePage();
		homePage.clickOnSearchText();
		homePage.sendProductName();
		homePage.verifyUrlAfterSearch();
>>>>>>> 31de80155af300a3e4b3dbe320001bf4280205ac
		ProductSearchPage productSearchPage = new ProductSearchPage();
		productSearchPage.clickOnProduct();
		productSearchPage.switchDriverOnProductSearchPage();
		ProductDetailPage productDetailPage = new ProductDetailPage();
		productDetailPage.switchWindowOnproductDetailPage();
		productDetailPage.CheckProductImageToverifyImageloadingSuccessfully();
		Keyword keyword=new Keyword();
		keyword.print("verify Page loaded successfully! product image visible.");
	}
	
	@Test
	public void verifyWhenUserClickOnProductShouldDisplaySameProductTitleOnProductDetailPage() {
		HomePage homePage = new HomePage();
		homePage.clickOnSearchText();
		homePage.sendProductName();
		homePage.verifyUrlAfterSearch();
		ProductSearchPage productSearchPage = new ProductSearchPage();
		productSearchPage.getActualSearchProductTitleText();
		productSearchPage.clickOnProduct();
		productSearchPage.switchDriverOnProductSearchPage();
		ProductDetailPage productDetailPage = new ProductDetailPage();
		productDetailPage.switchWindowOnproductDetailPage();
		productDetailPage.getexpectedProductDetailTitleText();
	    productDetailPage.verifyActualAndExpectedProductText();

	}
	
	@Test
	public void verifyWhenUserClickOnProductShouldDisplaySameProductPriceOnProductDetailPage() {
		HomePage homePage = new HomePage();
		homePage.clickOnSearchText();
		homePage.sendProductName();
		homePage.verifyUrlAfterSearch();
		ProductSearchPage productSearchPage = new ProductSearchPage();
		productSearchPage.getActualSearchProductTitlePrice();
		productSearchPage.clickOnProduct();
		productSearchPage.switchDriverOnProductSearchPage();
		ProductDetailPage productDetailPage = new ProductDetailPage();
		productDetailPage.switchWindowOnproductDetailPage();
		productDetailPage.getExpectedProductDetailPagePrice();
	    productDetailPage.verifyActualAndExpectedProductPrice();

	}
	
	@Test
	public void verifyProductImageDisplayProperlyOnProductDetailPage(){
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
		
	}
	

}
