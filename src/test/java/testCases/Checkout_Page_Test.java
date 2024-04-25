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
import pages.Checkout_Page;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.Screenshot;

public class Checkout_Page_Test extends TestBase
{
	LoginPage login;
	Inventory_Page invent;
	Cart_Page cart;
	Checkout_Page checkout;
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_Page();
		cart=new Cart_Page();
		checkout=new Checkout_Page();
		login.loginToApplication();
		invent.add6Product();
		invent.verifycartIcon();
		cart.verifycheckOutBtn();
	}
	@Test
	public void verifycheckoutTitleTest()
	{
		String expTitle="Swag Labs";
		String actTitle=checkout.verifycheckoutTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Title of Page is = "+ actTitle);
	}
	@Test
	public void verifyAddInfoTest()
	{
		String expURL="https://www.saucedemo.com/checkout-step-two.html";
		String actURL=checkout.verifyAddInfo();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL after click on continue Button = "+actURL);
	}
	@Test
	public void verifycancelBtnTest()
	{
		String expURL="https://www.saucedemo.com/cart.html";
		String actURL=checkout.verifycancelBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL after click on cancel Button "+actURL);
	}
	@Test
	public void verifycontinueBtnTest()
	{
		String expURL="https://www.saucedemo.com/checkout-step-two.html";
		String actURL=checkout.verifycontinueBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL after click on submit Button "+actURL);
	}
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			Screenshot.screen(it.getName());
		}
		driver.close();
	}
}
