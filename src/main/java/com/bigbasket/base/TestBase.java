package com.bigbasket.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.bigbasket.Utilities.TestUtils;

public class TestBase {
	private Keyword keyword = new Keyword();

    @BeforeMethod(groups = { "RegressionTests", "SanityTests" })
    public void setUp() throws Exception {
        keyword.openBrowser(TestUtils.getBrowserName());
        keyword.launchUrl(TestUtils.getURL());
        keyword.maximizeBrowser();
    }

    @AfterMethod(groups = { "RegressionTests", "SanityTests" })
    public void tearDown() {
        keyword.quitBrowser(); 
    }

}
