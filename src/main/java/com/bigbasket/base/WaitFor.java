package com.bigbasket.base;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitFor {
	public static FluentWait<RemoteWebDriver> wait;

	static {
		wait = new FluentWait<RemoteWebDriver>(Keyword.driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.ignoring(NoSuchElementException.class);
	}

	public static void elementTobeVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public static void visibilityOfElement(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (StaleElementReferenceException e) {
			wait.until(ExpectedConditions.visibilityOf(element));
			
		}
	}

	// Wait until all elements are visible
	public static List<WebElement> visibilityOfElements(List<WebElement> elements) {
		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(elements));
			return elements;
		} catch (StaleElementReferenceException e) {
			wait.until(ExpectedConditions.visibilityOfAllElements(elements));
			return elements;
		}
	}

	public static void untilUrlLoad(String url) {
		wait.until(ExpectedConditions.urlContains(url));

	}


	public static void elementToBeDisplayed(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void elementToBeClickable(WebElement element) {

		wait.until(ExpectedConditions.elementToBeClickable(element));

		
	}
}
