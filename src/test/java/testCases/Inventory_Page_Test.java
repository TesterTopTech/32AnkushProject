package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.Screenshot;

public class Inventory_Page_Test extends TestBase
{
	LoginPage login;
	Inventory_Page invent;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_Page();
		login.loginToApplication();
	}
	@Test(enabled = true,groups = {"Sanity","Retest"})
	public void verifypageTitleTest()
	{
		String expTitle="Products";
		String actTitle=invent.verifypageTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Title of Inventory Page = "+actTitle);
	}
	@Test(enabled = true)
	public void verifyLinkedinLogoTest()
	{
		boolean result=invent.verifyLinkedinLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Linkedin Logo is Present = "+result);
	}
	@Test(enabled = true,groups = {"Sanity","Retest","Regression"})
	public void add6ProductTest()
	{
		String expCount="6";
		String actCount=invent.add6Product();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Total Product Added to Cart = "+actCount);
	}
	@Test(enabled = true,groups = "Retest")
	public void verifyheaderLabelTest()
	{
		String expLabel="Swag Labs";
		String actLabel=invent.verifyheaderLabel();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("Header Label is = "+actLabel);
	}
	@Test(enabled = true,groups = {"Retest","Regression"})
	public void verifyFacebookLogo()
	{
		boolean result=invent.verifyFacebookLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Facebook logo is present = "+result);
	}
	@Test(enabled = true,groups = {"Sanity","Regression"})
	public void remove6ProductTest()
	{
		String expCount="1";
		String actCount=invent.remove6Product();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Total Product Remove is ="+ actCount);
	}
	@Test(enabled = true,groups = "Regression")
	public void verifycartIconTest()
	{
		String expURL="https://www.saucedemo.com/cart.html";
		String actURL=invent.verifycartIcon();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Step one URL = "+actURL);
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
