package bigbasketTests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.bigbasket.Listeners.TestListener;
import com.bigbasket.base.Keyword;
import com.bigbasket.base.TestBase;
import com.bigbasket.pages.HomePage;

@Listeners(TestListener.class)
@Test(groups = { "RegressionTests", "SanityTests" })
public class SearchProductTests extends TestBase {
	Keyword keyword = new Keyword();
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

	@Test(groups = "SanityTests")
	public void verifyThatRelevantSearchResultsAreDisplayedWhenValidTextIsEntered() throws InterruptedException {
		HomePage page = new HomePage();
		page.verifyThatRelevantSearchResultsAreDisplayedWhenValidTextIsEntered();

	}

	@Test
	public void verifyThebBehaviourWhenThSearchbBarIsLeftEmptyAndUserPressTheEnter() {
		HomePage page = new HomePage();
		page.verifyThebBehaviourWhenThSearchbBarIsLeftEmptyAndUserPressTheEnter();

	}

	@Test(groups = "SanityTests")
	public void verifyWhenEnterPartialTextIntoSerachbarThenResultShouldBeDisplayeOrNot() throws InterruptedException {
		HomePage page = new HomePage();
		page.EnterPartialTextIntoTextBox();
		page.getAllSearchResultDescriptionWhenEnterPartialText();
		page.verifyWhenEnterPartialTextIntoSerachbarThenResultShouldBeDisplayeOrNot();

	}

}
