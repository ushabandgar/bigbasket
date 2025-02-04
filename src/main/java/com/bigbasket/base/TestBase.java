package com.bigbasket.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
	private Keyword keyword = new Keyword();  // Ensure keyword is non-static to avoid shared WebDriver instances

    @BeforeMethod(groups = { "RegressionTests", "SanityTests" })
    public void setUp() throws Exception {
        keyword.openBrowser("Firefox");
        keyword.launchUrl("https://www.bigbasket.com/");
        keyword.maximizeBrowser();
    }

    @AfterMethod
    public void tearDown() {
        keyword.quitBrowser(); // Ensures browser is properly closed after each test
    }

}
