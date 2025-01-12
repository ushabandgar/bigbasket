package bigbasketTests;

import org.testng.annotations.Test;

import com.pages.HomePageUsingPageFactory;

public class SearchProductTests {
	@Test
	public void verifySearchTextBoxVisibleOrNotUsingPagefactory() {
		HomePageUsingPageFactory page = new HomePageUsingPageFactory();
		page.SearchTextBoxVisibleOrNotUsingPagefactory();
		
	}
	
	// 2 Test case

	@Test
	public void verifyUserCanEnterTextIntoTxtBoxpageFactory() {
		HomePageUsingPageFactory page = new HomePageUsingPageFactory();
		page.sendKeysToElement();

	}

	// 3 Test

	@Test
	public void verifyEnterTextPlaceholderTextIsEmptyUsingPgaeFactory() {
		HomePageUsingPageFactory page = new HomePageUsingPageFactory();
		page.enterTextPlaceholderTextIsEmptyUsingPgaeFactory();

	}

	// 4 Test

	@Test
	public void verifyRelevantResultIsDispalyedWhenEnterTextUsingPageFactory() throws InterruptedException {
		HomePageUsingPageFactory page = new HomePageUsingPageFactory();
		page.RelevantResultIsDispalyedWhenEnterText();

	}
	//5 TEST CASE
	@Test
	 public void verifyBehaviourOfSearchbarWhenLeftEmptyAndPressEnterUsingPageFactory(){
			HomePageUsingPageFactory page = new HomePageUsingPageFactory();
			page.verifyBehaviourOfSearchbarWhenLeftEmptyAndPressEnter();

	}


}
