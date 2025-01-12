package com.bigbasket.base;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;


public class WaitFor {
	private static FluentWait<WebDriver> wait;

	static {
		wait = new FluentWait<WebDriver>(Keyword.driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.ignoring(NoSuchElementException.class);
	}
	
	public static  void elementTobeVisible(WebElement element ){
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	

}
