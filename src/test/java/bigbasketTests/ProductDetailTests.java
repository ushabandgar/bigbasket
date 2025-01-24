package bigbasketTests;
import org.testng.annotations.Test;
import com.bigbasket.base.*;
import com.bigbasket.pages.HomePage;
import com.bigbasket.pages.ProductDetailPage;
import com.bigbasket.pages.ProductSearchPage;

//@Test(groups = {"RegressionTests", "SanityTests"})
public class ProductDetailTests extends TestBase{

	@Test (groups = "SanityTests")
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
		productDetailPage.switchWindowOnproductDetailPage();
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
	public void verifyWhenUserClickOnProductThenProductUrlLoadFully() {
		HomePage homePage = new HomePage();
		homePage.clickOnSearchText();
		homePage.sendProductName();
		ProductSearchPage productSearchPage = new ProductSearchPage();
		productSearchPage.clickOnProduct();
		productSearchPage.switchDriverOnProductSearchPage();
		ProductDetailPage productDetailPage = new ProductDetailPage();
		productDetailPage.switchWindowOnproductDetailPage();
		productDetailPage.CheckProductUrlLoadingSuccessfully();
		System.out.println("Product Page loaded successfully! product image visible.");
	}
	
	@Test
	public void verifyWhenUserClickOnProductShouldDisplaySameProductTitleOnProductDetailPage() {
		HomePage homePage = new HomePage();
		homePage.clickOnSearchText();
		homePage.sendProductName();
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
		ProductSearchPage productSearchPage = new ProductSearchPage();
		productSearchPage.clickOnProduct();
		//productSearchPage.switchDriverOnProductSearchPage();
		ProductDetailPage productDetailPage = new ProductDetailPage();
		productDetailPage.switchWindowOnproductDetailPage();
		productDetailPage.CheckProductImageToverifyImageloadingSuccessfully();	
	}

	@Test
	public void verifyHoverFeatureWorksWhenUserHoversOnProductImage() {
		HomePage homePage = new HomePage();
		homePage.clickOnSearchText();
		homePage.sendProductName();
		homePage.verifyUrlAfterSearch();
		ProductSearchPage productSearchPage = new ProductSearchPage();
		productSearchPage.clickOnProduct();
		productSearchPage.switchDriverOnProductSearchPage();
		ProductDetailPage productDetailPage = new ProductDetailPage();
		productDetailPage.switchWindowOnproductDetailPage();
		productDetailPage.hoverOnImage();
		productDetailPage.verifyHoverFeatureWorks();
	}
	
	
	@Test
	public void verifyMultipleImagesForProductAreClikable() throws InterruptedException {
		HomePage homePage = new HomePage();
		homePage.clickOnSearchText();
		homePage.sendProductName();
		homePage.verifyUrlAfterSearch();
		ProductSearchPage productSearchPage = new ProductSearchPage();
		productSearchPage.clickOnProduct();
		productSearchPage.switchDriverOnProductSearchPage();
		ProductDetailPage productDetailPage = new ProductDetailPage();
		productDetailPage.switchWindowOnproductDetailPage();
	    productDetailPage.verifyclickFucntinalityOnProductImageGallaryOnebyOne();
	}

	@Test
	public void verifyGallaryImagesForProductAreHighQuality() throws InterruptedException{
		HomePage homePage = new HomePage();
		homePage.clickOnSearchText();
		homePage.sendProductName();
		homePage.verifyUrlAfterSearch();
		ProductSearchPage productSearchPage = new ProductSearchPage();
		productSearchPage.clickOnProduct();
		productSearchPage.switchDriverOnProductSearchPage();
		ProductDetailPage productDetailPage = new ProductDetailPage();
		productDetailPage.switchWindowOnproductDetailPage();
		productDetailPage.verifyclickFucntinalityOnProductImageGallaryOnebyOne();
		productDetailPage.verifyGallaryImageQuality();
	}
	
	@Test(groups = "SanityTests")
	public void VerifyThePriceFormattingFollowTheStandardCurrenctSymbolLike₹() {
		HomePage homePage = new HomePage();
		homePage.clickOnSearchText();
		homePage.sendProductName();
		homePage.verifyUrlAfterSearch();
		ProductSearchPage productSearchPage = new ProductSearchPage();
		productSearchPage.clickOnProduct();
		productSearchPage.switchDriverOnProductSearchPage();
		ProductDetailPage productDetailPage = new ProductDetailPage();
		productDetailPage.switchWindowOnproductDetailPage();
		productDetailPage.getExpectedProductDetailPagePrice();
		productDetailPage.verifyPriceContainCurrencySymbolLike₹();
	}
	
	@Test(groups = "SanityTests")
	public void verifyProductPriceChangeWhileSelectingPackSize() {
		HomePage homePage = new HomePage();
		homePage.clickOnSearchText();
		homePage.sendProductName();
		homePage.verifyUrlAfterSearch();
		ProductSearchPage productSearchPage = new ProductSearchPage();
		productSearchPage.clickOnProduct();
		productSearchPage.switchDriverOnProductSearchPage();
		ProductDetailPage productDetailPage = new ProductDetailPage();
		productDetailPage.switchWindowOnproductDetailPage();
		productDetailPage.verifyAfterclickOnProductPackSizeFor500mlProductPriceWillChange();
	}
	
}
