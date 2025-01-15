package bigbasketTests;

import org.testng.annotations.Test;

import com.bigbasket.pages.HomePage;

public class SearchProductTests {
	@Test
	public void verifySearchTextBoxVisibleOrNot() {
		HomePage page = new HomePage();
		page.verifySearchTextBoxVisibleOrNot();
	}

	@Test
	public void verifyUserCanableToTypeTextIntoSearchBar() {
		HomePage page = new HomePage();
		page.verifyUserCanAbleToTextIntoSearchTextBox();
	}

	public void verifyUserCanAbleToEnterTextIntoTextBox() {
		HomePage page = new HomePage();
		page.verifyUserCanAbleToTextIntoSearchTextBox();
	}

	@Test
	public void verifyEnterTextPlaceholderTextIsEmpty() {
		HomePage page = new HomePage();
		page.verifyEnterTextWhenPlaceholderTextIsEmpty();
	}

	@Test
	public void verifyRelevantResultIsDispalyedWhenEnterText() throws InterruptedException {
		HomePage page = new HomePage();
		page.verifyRelevantResultIsDispalyedWhenEnterText();
}

	@Test
	public void verifyBehaviourOfSearchbarWhenLeftEmptyAndPressEnter() {
		HomePage page = new HomePage();
		page.verifyBehaviourOfSearchbarWhenLeftEmptyAndPressEnter();

	}

}
