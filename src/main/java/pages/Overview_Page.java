package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Overview_Page extends TestBase
{
	//object repository
	@FindBy(xpath = "//span[@class='title']") private WebElement overviewTitle;
	@FindBy(xpath = "//div[@class='cart_desc_label']") private WebElement overviewDecsLabel;
	@FindBy(xpath = "//div[text()='Price Total']") private WebElement pricetotaltxt;
	@FindBy(xpath = "//button[@id='finish']") private WebElement finishBtn;
	
	//constructor
	public Overview_Page()
	{
		PageFactory.initElements(driver, this);
	}
	//methods
	public String verifyoverviewTitle()
	{
		return driver.getTitle();
	}
	public String verifyoverviewDecsLabel()
	{
		return overviewDecsLabel.getText();
	}
	public String verifypricetotaltxt()
	{
		return pricetotaltxt.getText();	
	}
	public String verifyfinishBtn()
	{
		finishBtn.click();
		return driver.getCurrentUrl();
		
	}
}
