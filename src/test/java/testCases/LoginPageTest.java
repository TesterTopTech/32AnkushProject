package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class LoginPageTest extends TestBase
{
	LoginPage login;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException
	{
		initialization();
		login=new LoginPage();
	}
	@Test(enabled = true,groups = {"Sanity","Regression"})
	public void verifyTitleOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExcel(0, 0);//Swag Labs(0,0)
		String actTitle=login.verifyTitleOfApplication();
		Assert.assertEquals(expTitle, actTitle);
	}
	@Test(enabled = true,groups = {"Sanity","Regression","Retest"})
	public void verifyURLOfApplication() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(1,0);//https://www.saucedemo.com/(1,0)
		String actURl=login.verifyURLOfApplication();
		Assert.assertEquals(expURL, actURl);
	}
	@Test(enabled = true,groups = {"Sanity","Retest"})
	public void loginToApplicationTest() throws IOException
	{
		String expURL=ReadData.readExcel(2,0);//https://www.saucedemo.com/inventory.html(2,0)
		String actURL=login.loginToApplication();
		Assert.assertEquals(expURL, actURL);
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
