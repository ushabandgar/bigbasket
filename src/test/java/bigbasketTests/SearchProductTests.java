package bigbasketTests;

import org.testng.annotations.Test;

import com.bigbasket.pages.HomePage;
public class SearchProductTests {
	@Test
	public void verifySearchTextBoxVisibleOrNotUsingPagefactory() {
		HomePage page = new HomePage();
		page.SearchTextBoxVisibleOrNotUsingPagefactory();
		
	}
	
	// 2 Test case

	@Test
	public void verifyUserCanEnterTextIntoTxtBoxpageFactory() {
		HomePage page = new HomePage();
		page.sendKeysToElement();

	}

	// 3 Test

	@Test
	public void verifyEnterTextPlaceholderTextIsEmptyUsingPgaeFactory() {
		HomePage page = new HomePage();
		page.enterTextPlaceholderTextIsEmptyUsingPgaeFactory();

	}

	// 4 Test

	@Test
	public void verifyRelevantResultIsDispalyedWhenEnterTextUsingPageFactory() throws InterruptedException {
		HomePage page = new HomePage();
		page.RelevantResultIsDispalyedWhenEnterText();

	}
	//5 TEST CASE
	@Test
	 public void verifyBehaviourOfSearchbarWhenLeftEmptyAndPressEnterUsingPageFactory(){
		HomePage page = new HomePage();
			page.verifyBehaviourOfSearchbarWhenLeftEmptyAndPressEnter();

	}


}
