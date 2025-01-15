package com.bigbasket.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bigbasket.base.*;

public class ProductSearchPage {

	@FindBy(css = "li.PaginateItems___StyledLi-sc-1yrbjdr-0")
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
		keyword.clickOn(ClickonProduct);
		System.out.println("Clicked on product.");

	}

	public void switchDriverOnProductSearchPage() {
		keyword.switchToChildWindowHandle();
		System.out.println("driver switch on Product search page");
	}

	public void getActualSearchProductTitleText() {
		System.out.println("Actual Product Title: " + actualProductTitleText.getText());
	}

	public void getActualSearchProductTitlePrice() {
		WaitFor.untilUrlLoad("https://www.bigbasket.com/ps");
		System.out.println("Actual Product Title: " + actualProductPrice.getText());

	}

}
