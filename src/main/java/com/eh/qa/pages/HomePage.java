package com.eh.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eh.qa.base.BaseTest;

public class HomePage extends BaseTest {
	
	@FindBy(xpath="//i[@class='fa fa-houzz']")
	WebElement inventory;
	
	@FindBy(xpath="//a[text()='Add Inventory6']")
	WebElement addInventory;

	public HomePage() throws Throwable {
		super();
		
	PageFactory.initElements(driver, this);
	}
	
	public String VerifyHomePageTitle()
	{
		return driver.getTitle();
	}
	public AddInventoryPage VerifyHomepageDash() throws Throwable
	{
		Thread.sleep(2000);
		inventory.click();
		Thread.sleep(2000);
		addInventory.click();
		return new AddInventoryPage();
	}
}
