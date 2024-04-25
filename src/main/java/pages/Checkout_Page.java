package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Checkout_Page extends TestBase
{
	@FindBy(xpath = "//span[@class='title']") private WebElement checkoutTitle;
	@FindBy(xpath = "//input[@id='first-name']") private WebElement firstnameTxtBox;
	@FindBy(xpath = "//input[@id='last-name']") private WebElement lastnameTxtBox;
	@FindBy(xpath = "//input[@id='postal-code']") private WebElement zipcodeTxtBox;
	@FindBy(xpath = "//input[@id='continue']") private WebElement continueBtn;
	@FindBy(xpath = "//button[@id='cancel']") private WebElement cancelBtn;
	
	public Checkout_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifycheckoutTitle()
	{
		return driver.getTitle();
	}
	public String verifyAddInfo()
	{
		firstnameTxtBox.sendKeys("Ankush");
		lastnameTxtBox.sendKeys("Topkar");
		zipcodeTxtBox.sendKeys("444001");
		continueBtn.click();
		return driver.getCurrentUrl();	
	}
	public String verifycancelBtn()
	{
		cancelBtn.click();
		return driver.getCurrentUrl();
	}
	public String verifycontinueBtn()
	{
		verifyAddInfo();
		continueBtn.click();
		return driver.getCurrentUrl();
	}
}
