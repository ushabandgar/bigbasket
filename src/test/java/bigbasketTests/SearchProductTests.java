package bigbasketTests;

import org.testng.annotations.Test;

import com.bigbasket.pages.HomePage;

public class SearchProductTests {
	
	@Test
	public void verifySearchTextBoxVisibleOnThePageOrNot() {
		HomePage page = new HomePage();
		page.verifySearchTextBoxVisibleOnThePageOrNot();

	}

	@Test
	public void verifyThatUserCanAbleToTypeTextIntoTheSearchBar() {
		HomePage page = new HomePage();
		page.verifyThatUserCanAbleToTypeTextIntoTheSearchBar();

	}

	@Test
	public void verifyThePlaceholderTextIsDisplayedWhenTheSearchBarIsEmpty() {
		HomePage page = new HomePage();
		page.verifyThePlaceholderTextIsDisplayedWhenTheSearchBarIsEmpty();

	}

	@Test
	public void verifyThatRelevantSearchResultsAreDisplayedWhenValidTextIsEntered() throws InterruptedException {
		HomePage page = new HomePage();
		page.verifyThatRelevantSearchResultsAreDisplayedWhenValidTextIsEntered();

	}

	@Test
	public void verifyThebBehaviourWhenThSearchbBarIsLeftEmptyAndUserPressTheEnter() {
		HomePage page = new HomePage();
		page.verifyThebBehaviourWhenThSearchbBarIsLeftEmptyAndUserPressTheEnter();

	}
	

	@Test
	public void verifyWhenEnterPartialTextIntoSerachbarThenResultShouldBeDisplayeOrNot() throws InterruptedException {
		HomePage page = new HomePage();
		page.EnterPartialTextIntoTextBox();
		page.getAllSearchResultDescriptionWhenEnterPartialText();
		page.verifyWhenEnterPartialTextIntoSerachbarThenResultShouldBeDisplayeOrNot();

	}
}


