package com.eh.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eh.qa.base.BaseTest;
import com.eh.qa.pages.AddInventoryPage;
import com.eh.qa.pages.AllInventoryPage;
import com.eh.qa.pages.HomePage;
import com.eh.qa.pages.LoginPage;
import com.eh.qa.utils.UtilsTest;

public class AddInventoryTest extends BaseTest {

	LoginPage Lpage;
	HomePage Hpage;
	AddInventoryPage addInventPage;
	AllInventoryPage allInventPage;
	static String shname = "Sheet1";
	public AddInventoryTest() throws Throwable {
		super();
	}
	
	@BeforeMethod
	public void setup() throws Throwable
	{
		Initialization();
		Lpage = new LoginPage();
		Hpage = new HomePage();
		addInventPage = new AddInventoryPage();	
		allInventPage = new AllInventoryPage();
		Hpage = Lpage.VerifyEHLoginpage();
		addInventPage = Hpage.VerifyHomepageDash();	
	}

	@Test
	public void VerifyAddInventoryPageTitleTest()
	{
		String title = addInventPage.VerifyAddInventoryPageTitle();
		Assert.assertEquals(title, "Empire Home Admin Panel");	
	}
	
	@DataProvider
	public Object[][] Excel() throws Throwable
	{
		Object[][] data = UtilsTest.getExcelData(shname);
		return data;
	}
	
	@Test(dataProvider = "Excel")
	public void VerifyAddInventoryPageTest(String ModelNumber, String ItemTitle, String ItemDescription, String Height, String Width, String Breadth, String Colorname, String ActualPrice, String Qty) throws Throwable
	{
		allInventPage = addInventPage.VerifyAddInventoryPage(ModelNumber, ItemTitle, ItemDescription, Height, Width, Breadth, Colorname, ActualPrice, Qty);
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
