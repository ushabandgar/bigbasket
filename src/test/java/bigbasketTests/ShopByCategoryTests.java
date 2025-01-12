package bigbasketTests;

import org.testng.annotations.Test;

import com.bigbasket.base.Keyword;
import com.bigbasket.base.TestBase;
import com.bigbasket.pages.HomePage;

public class ShopByCategoryTests extends TestBase{

	Keyword keyword=new Keyword();
	@Test
	public void verifyShopByCategoryDropDownAvailable() {
		HomePage homepage=new HomePage();
		homepage.verifyShopByCategoryMenuIsAvailable();
	}
	
	@Test
	public void verifyAllCatgoriesOfShopByCatogoryAreDisplayed() {
		HomePage homepage=new HomePage();
		homepage.verifyAllCatgoriesOfShopByCatogoryAreDisplayedProperly();
	}
	@Test
	public void verifyAllCatgoriesOfShopByCatogoryNamesAreDisplayed() {
		HomePage homepage=new HomePage();
		homepage.verifyAllCatgoriesOfShopByCatogoryNamesAreDisplayedProperly();
		
	}
}
