package com.bigbasket.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

	Keyword keyword=new Keyword();
	
	@BeforeMethod
	public void setUp() {
		keyword.openBrowser("firefox");
		keyword.launchUrl("https://www.bigbasket.com/");
	}
	
	@AfterMethod
	public void tearDown() {
		keyword.closeBrowser();
	}
}
