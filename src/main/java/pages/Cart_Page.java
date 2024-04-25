package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Cart_Page extends TestBase
{
	//object repository
	@FindBy(xpath = "//button[@class='btn btn_secondary back btn_medium']") private WebElement continueShopBtn;
	@FindBy(xpath = "//button[@class='btn btn_action btn_medium checkout_button ']") private WebElement checkOutBtn;

	//constructor(PageFactory)
	public Cart_Page()
	{
		PageFactory.initElements(driver, this);
	}
	//methods
	public String verifycontinueShopBtn()
	{
		continueShopBtn.click();
		return driver.getCurrentUrl();
	}
	public String verifycheckOutBtn()
	{
		checkOutBtn.click();
		return driver.getCurrentUrl();
	}
}
