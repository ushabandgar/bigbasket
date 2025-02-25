package com.bigbasket.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.bigbasket.Utilities.TestUtils;

public class TestBase {
	private Keyword keyword = new Keyword();

	@BeforeMethod(groups = { "RegressionTests", "SanityTests" })
	@Parameters("browser-name")
	public void setUp(@Optional("") String xmlBrowser) throws Exception {

		if (!xmlBrowser.isEmpty()) {
			keyword.openBrowser(xmlBrowser);
			
		} else {
			keyword.openBrowser(TestUtils.getBrowserName());
			
		}
		keyword.launchUrl(TestUtils.getURL());
		keyword.maximizeBrowser();
	}

	@Parameters("browser-name")
	@AfterMethod(groups = { "RegressionTests", "SanityTests" })
	public void tearDown() {
		keyword.quitBrowser();
	}

}
