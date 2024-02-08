package com.eh.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import com.eh.qa.base.BaseTest;
import com.eh.qa.pages.AddInventoryPage;
import com.eh.qa.pages.HomePage;
import com.eh.qa.pages.LoginPage;

public class HomePageTest extends BaseTest {
	LoginPage Lpage;
	HomePage Hpage;
	AddInventoryPage AddInventPage;

	public HomePageTest() throws Throwable {
		super();
	}
	
	@BeforeMethod
	public void setup() throws Throwable
	{
		Initialization();
		Lpage = new LoginPage();
		Hpage = new HomePage();
		AddInventPage = new AddInventoryPage();	
		Hpage = Lpage.VerifyEHLoginpage();
	}
	@Test
	public void VerifyHomePageTitleTest()
	{
		String title = Hpage.VerifyHomePageTitle();
		Assert.assertEquals(title,"Empire Home Admin Panel");
	}
	@Test
	public void VerifyHomepageDashTest() throws Throwable
	{
		AddInventPage = Hpage.VerifyHomepageDash();
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
}
