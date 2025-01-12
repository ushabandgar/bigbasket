package com.bigbasket.base;


import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Keyword {

	public static RemoteWebDriver driver;

	public void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		} else if (browserName.equalsIgnoreCase("internet")) {
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("Invalid browser name");
		}
		System.out.println("Launched browser: " + browserName);

	}

	public void launchUrl(String url) {
		driver.get(url);
	}

	public WebElement getWebElement(String locator) {

		String locatorType = locator.split("##")[0];
		locator = locator.split("##")[1];

		if (locatorType.equalsIgnoreCase("id")) {
			return driver.findElement(By.id(locator));
		} else if (locatorType.equalsIgnoreCase("name")) {
			return driver.findElement(By.name(locator));
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			return driver.findElement(By.xpath(locator));
		} else if (locatorType.equalsIgnoreCase("linktext")) {
			return driver.findElement(By.linkText(locator));
		} else if (locatorType.equalsIgnoreCase("partial")) {
			return driver.findElement(By.partialLinkText(locator));
		} else if (locatorType.equalsIgnoreCase("css")) {
			return driver.findElement(By.cssSelector(locator));
		} else if (locatorType.equalsIgnoreCase("classname")) {
			return driver.findElement(By.className(locator));
		} else
			return null;

	}

	public void clickOn(WebElement element) {
		element.click();
	}

	public void closeBrowser() {
		driver.quit();
	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();

	}
	
	public void print(String string) {
		System.out.println(string);

	}
	
	// it take webelement and text
		public void sendkeys(WebElement element, String text) {
			element.sendKeys(text);
		}

		public void sendKeys(WebElement element, Keys enter) {
			element.sendKeys(enter);

		}
		
		
		


		public void switchToChildWindowHandle() {
			Set<String> allWindows = driver.getWindowHandles();
			String parentWindow = driver.getWindowHandle();
			for (String handle : allWindows) {
				if (!handle.equals(parentWindow)) {
					driver.switchTo().window(handle);
					break;
				}
			}
		}

		public void switchToWindowByTitle(String expectedTitleSubstring) {
			Set<String> allWindows = driver.getWindowHandles();
			for (String handle : allWindows) {
				String currentTitle = driver.switchTo().window(handle).getTitle();
				if (currentTitle.contains(expectedTitleSubstring)) {
					System.out.println("Switched to window with title: " + currentTitle);
					break;
				}
			}
		}
		
		
		

	public List<WebElement> getWebElements(String locator) {
		String locatorType = locator.split("##")[0];
		locator = locator.split("##")[1];

		if (locatorType.equalsIgnoreCase("id")) {
			return driver.findElements(By.id(locator));
		} else if (locatorType.equalsIgnoreCase("name")) {
			return driver.findElements(By.name(locator));
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			return driver.findElements(By.xpath(locator));
		} else if (locatorType.equalsIgnoreCase("linktext")) {
			return driver.findElements(By.linkText(locator));
		} else if (locatorType.equalsIgnoreCase("partial")) {
			return driver.findElements(By.partialLinkText(locator));
		} else if (locatorType.equalsIgnoreCase("css")) {
			return driver.findElements(By.cssSelector(locator));
		} else if (locatorType.equalsIgnoreCase("classname")) {
			return driver.findElements(By.className(locator));
		} else
			return null;
	}

	public List<String> getExpectedCategoryNames() {
		List<String> expectedCategories=Arrays.asList("Electronics","Fashion","Apparel","Fruits & Vegetables","Foodgrains, Oil & Masala"
				,"Bakery, Cakes & Dairy",
				"Beverages",
				"Snacks & Branded Foods",
				"Beauty & Hygiene",
				"Cleaning & Household",
				"Kitchen, Garden & Pets",
				"Eggs, Meat & Fish",
				"Gourmet & World Food",
				"Baby Care",
				"Paan Corner",
				"Audio devices",
				"Beauty & Grooming",
				"Cameras & Accessories",
				"Electrical Accessories",
				"Home Appliances",
				"Kitchen Appliances",
				"Phone & Laptop Accessory",
				"Phone, Laptop & Tablets",
				"Smart Wearables",
				"Earbuds",
				"Headphones & Earphones",
				"Speakers & Microphones");	
		return expectedCategories;
	}
}
