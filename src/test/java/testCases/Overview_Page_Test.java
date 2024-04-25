package testCases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import base.TestBase;
import pages.Cart_Page;
import pages.Checkout_Page;
import pages.Inventory_Page;
import pages.LoginPage;
import pages.Overview_Page;
import utility.Screenshot;

public class Overview_Page_Test extends TestBase
{
	LoginPage login;
	Inventory_Page invent;
	Cart_Page cart;
	Checkout_Page checkout;
	Overview_Page overview;
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_Page();
		cart=new Cart_Page();
		checkout=new Checkout_Page();
		overview=new Overview_Page();
		login.loginToApplication();
		invent.add6Product();
		invent.verifycartIcon();
		cart.verifycheckOutBtn();
		checkout.verifyAddInfo();
		
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
