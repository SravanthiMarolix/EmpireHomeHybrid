package com.eh.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.eh.qa.base.BaseTest;
import com.eh.qa.pages.HomePage;
import com.eh.qa.pages.LoginPage;

public class LoginPageTest extends BaseTest {
		LoginPage Lpage;
		HomePage Hpage;
	
	public LoginPageTest() throws Throwable {
		super();
	}
	
	@BeforeMethod
	public void setup() throws Throwable {
		Initialization();
		Lpage = new LoginPage();
		Hpage = new HomePage();
	}
	@Test
	public void VerifyLoginpageTitleTest() {
		String title = Lpage.VerifyLoginpageTitle();
		Assert.assertEquals(title, "Empire Home Admin Panel");
	}
	@Test
	public void verifyEHLoginImageTest() {
		boolean image = Lpage.verifyEHLoginImage();
		Assert.assertTrue(image);
	}
	@Test
	public void VerifyEHLoginpageTest() throws Throwable {
		Hpage = Lpage.VerifyEHLoginpage();
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
