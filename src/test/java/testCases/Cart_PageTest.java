package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Cart_Page;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.Screenshot;

public class Cart_PageTest extends TestBase
{
	LoginPage login;
	Inventory_Page invent;
	Cart_Page cart;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_Page();
		cart=new Cart_Page();
		login.loginToApplication();
		invent.add6Product();
		invent.verifycartIcon();
	}
	@Test(enabled = true,groups = "Retest")
	public void verifycontinueShopBtnTest()
	{
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL=cart.verifycontinueShopBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL after click on continueshop Button = "+actURL);
	}
	@Test(enabled = true,groups = {"Sanity","Regression"})
	public void verifycheckOutBtn()
	{
		String expURL="https://www.saucedemo.com/checkout-step-one.html";
		String actURL=cart.verifycheckOutBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL after click on checkout Button = "+actURL);
	}
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			Screenshot.screen(it.getName());
		}
		driver.close();
	}
}
