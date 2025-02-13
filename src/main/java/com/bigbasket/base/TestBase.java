package com.bigbasket.base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

	Keyword keyword=new Keyword();
	
	@BeforeMethod(groups = "RegressionTests")
	public void setUp() throws Exception {
		keyword.openBrowser("Firefox");
		keyword.launchUrl("https://www.bigbasket.com/");
		keyword.maximizeBrowser();
	}

	
	@AfterMethod(groups = "RegressionTests")
	public void tearDown() {
	    if (Keyword.driver != null) {
	    	keyword.quitBrowser();
	    }
	}
	
	
	
}
