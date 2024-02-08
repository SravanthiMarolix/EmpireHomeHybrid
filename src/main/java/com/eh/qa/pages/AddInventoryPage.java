package com.eh.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eh.qa.base.BaseTest;
import com.eh.qa.utils.UtilsTest;

public class AddInventoryPage extends BaseTest {

	@FindBy(id="catDD")
	WebElement category;
	
	@FindBy(name="SubCategoryId")
	WebElement subcategory;
	
	@FindBy(name="ModelNumber")
	WebElement modNum;
	
	@FindBy(name="Title")
	WebElement itemTitle;

	@FindBy(name="ItemDescription")
	WebElement itemDes;
	
	@FindBy(name="Brand")
	WebElement brand;

	@FindBy(name="Height")
	WebElement height;

	@FindBy(name="Width")
	WebElement width;

	@FindBy(name="Breadth")
	WebElement breadth;

	@FindBy(name="ColorName")
	WebElement colorname;

	@FindBy(name="ColorImageUploaded")
	WebElement colorImg;

	@FindBy(xpath = "//span[@data-select2-id='19']")
	WebElement inventStatus;

	@FindBy(id="InventoryConditonId")
	WebElement inventCond;

	@FindBy(name="InventoryLocationId")
	WebElement inventLoc;

	@FindBy(id="RecievedDate") 
	WebElement receivedDate;

	@FindBy(name="ActualPrice")
	WebElement actualPrice;

	@FindBy(name="MRPFactorId")
	WebElement mrpFac;

	@FindBy(name="MRPPrice")
	WebElement mrpPrice;

	@FindBy(name="HSNCode")
	WebElement hsnCode;

	@FindBy(name="RackName")
	WebElement rackName;

	@FindBy(name="PODetails")
	WebElement suppDetail;
	
	@FindBy(name="InvoiceNumber")
	WebElement invoiceNum;
	
	@FindBy(name="Qty")
	WebElement qty;
	
	@FindBy(id="gstName")
	WebElement taxApp;
	
	@FindBy(xpath = "//input[@name='ProductMainImageUploaded']")
	WebElement primaryImg;
	
	@FindBy(name="ProductOtherImagesUploaded")
	WebElement otherImg;
	
	@FindBy(name="DocumentsUploaded")
	WebElement docUpload;
	
	@FindBy(xpath = "//button[@class='btn btn-success']")
	WebElement savebtn;
	
	public AddInventoryPage() throws Throwable {
		super();
		PageFactory.initElements(driver,this);
	}
	public String VerifyAddInventoryPageTitle()
	{
		return driver.getTitle();
	}
	public AllInventoryPage VerifyAddInventoryPage(String Modelnumber, String ItemTitle, String ItemDescription, String Height, String Width, String Breadth, String Colorname, String ActualPrice, String Qty) throws Throwable
	{
		UtilsTest.Dropdown(category, "Chair");
		UtilsTest.Dropdown(subcategory, "JuiceBar");
		modNum.sendKeys(Modelnumber);
		itemTitle.sendKeys(ItemTitle);
		itemDes.sendKeys(ItemDescription);
		height.sendKeys(Height);
		width.sendKeys(Width);
		breadth.sendKeys(Breadth);
		colorname.sendKeys(Colorname);
		receivedDate.clear();
		receivedDate.sendKeys("12/02/2023");
		actualPrice.sendKeys(ActualPrice);
		UtilsTest.Dropdown(mrpFac, "2.50");
		qty.clear();
		qty.sendKeys(Qty);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", primaryImg);
		UtilsTest.UploadFiles();
		savebtn.click();
		return new AllInventoryPage();
	}
}
