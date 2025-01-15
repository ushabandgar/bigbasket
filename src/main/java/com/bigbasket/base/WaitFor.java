package com.bigbasket.base;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
public class WaitFor {
	public static FluentWait<WebDriver> wait;

	static {
		wait = new FluentWait<WebDriver>(Keyword.driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.ignoring(NoSuchElementException.class);
	}
	
	public static  void elementTobeVisible(WebElement element ){
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public static void visibilityOfElement(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (StaleElementReferenceException e) {
           
            wait.until(ExpectedConditions.visibilityOf(element));
        }
    }


	public static void untilUrlLoad(String url) {
		 WebDriverWait wait = new WebDriverWait(Keyword.driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains(url));

	}

	public static void elementToBeDisplayed(WebElement element) {

		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
}
