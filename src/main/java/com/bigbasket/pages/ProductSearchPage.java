package com.bigbasket.pages;
import java.time.Duration;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bigbasket.base.*;

public class ProductSearchPage {

	@FindBy(css = "div.SKUDeck___StyledDiv-sc-1e5d9gk-0")
	WebElement ClickonProduct;

	@FindBy(css = "div.SKUDeck___StyledDiv-sc-1e5d9gk-0 div h3:nth-child(1)")
	WebElement actualProductTitleText;

	@FindBy(css = "span.Pricing___StyledLabel-sc-pldi2d-1")
	WebElement actualProductPrice;

	@FindBy(css = "td.fLZywG")
	WebElement expectedproductprice;

	Keyword keyword = new Keyword();

	public ProductSearchPage() {
		PageFactory.initElements(Keyword.driver, this);
	}

	public void clickOnProduct() {
	    try {
	    	WebDriverWait wait = new WebDriverWait(Keyword.driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(ClickonProduct));
	        ClickonProduct.click();  
	        System.out.println("Clicked on product.");
	    } catch (StaleElementReferenceException e) {
	        System.out.println("StaleElementReferenceException caught. Retrying click...");
	        WaitFor.elementToBeClickable(ClickonProduct);
	        ClickonProduct.click(); 
	        System.out.println("Clicked on product after handling StaleElementReferenceException.");
	    } catch (Exception e) {
	        System.out.println("Failed to click on product. Error: " + e.getMessage());
	    }
	}
	public void switchDriverOnProductSearchPage() {
		keyword.switchToChildWindowHandle();
	    String title= Keyword.driver.getTitle();
	  //  System.out.println("title: "+ title);
	    System.out.println("driver switch on Product search page");
	}

	public void getActualSearchProductTitleText() {
		WaitFor.untilUrlLoad("https://www.bigbasket.com/ps");
		WaitFor.visibilityOfElement(actualProductTitleText);
		String  actualProductTitleTest = actualProductTitleText.getText();
		System.out.println("Actual Product Title: " + actualProductTitleTest);
	}

	public void getActualSearchProductTitlePrice() {
		WaitFor.untilUrlLoad("https://www.bigbasket.com/ps");
		WaitFor.visibilityOfElement(actualProductPrice);
		String  actualProductprice = actualProductPrice.getText();
		System.out.println("Actual Product Title: " +actualProductprice);

	}
	
	

}
