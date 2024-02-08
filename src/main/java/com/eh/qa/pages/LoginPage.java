package com.eh.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eh.qa.base.BaseTest;

public class LoginPage extends BaseTest {
	
	@FindBy(name="emailid")
	WebElement Uname;
	
	@FindBy(id="pword")
	WebElement Password;
	
	@FindBy(xpath="//img[@src='/WebApp/assets/dist/img/logo.png']")
	WebElement Img;
	
	@FindBy(xpath="//button[text()='Login']")
	WebElement loginbtn;
	
	public LoginPage() throws Throwable {
		super();
		PageFactory.initElements(driver, this);
	}
	public String VerifyLoginpageTitle() {
		return driver.getTitle();
	}
	public boolean verifyEHLoginImage() {
		return Img.isDisplayed();
	}
	public HomePage VerifyEHLoginpage() throws Throwable {
		Uname.sendKeys(prop.getProperty("username"));
		Password.sendKeys(prop.getProperty("password"));
		loginbtn.click();
		return new HomePage();	
	}
	
}
