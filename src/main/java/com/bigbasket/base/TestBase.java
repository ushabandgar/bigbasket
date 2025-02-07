package com.bigbasket.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
	private Keyword keyword = new Keyword();

    @BeforeMethod(groups = { "RegressionTests", "SanityTests" })
    public void setUp() throws Exception {
        keyword.openBrowser("Firefox");
        keyword.launchUrl("https://www.bigbasket.com/");
        keyword.maximizeBrowser();
    }

    @AfterMethod(groups = { "RegressionTests", "SanityTests" })
    public void tearDown() {
        keyword.quitBrowser(); 
    }

}
