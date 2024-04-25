package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import utility.Handle_DropDown;

public class Inventory_Page extends TestBase
{
	//object Repository
	@FindBy(xpath = "//span[@class='title']") private WebElement pageTitle;
	@FindBy(xpath = "//a[@class='shopping_cart_link']") private WebElement cartIcon;
	@FindBy(xpath = "//span[@class='shopping_cart_badge']") private WebElement cartCount;
	@FindBy(xpath = "//select[@class='product_sort_container']") private WebElement DropDown;
	//Adding Product
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement BackpackAddBtn;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement BikeLightAddBtn;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement BoltTshirtAddBtn;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement JacketAddBtn;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-onesie']") private WebElement onesieAddBtn;
	@FindBy(xpath = "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement RedShirtAddBtn;
	@FindBy(xpath = "//a[text()='LinkedIn']") private WebElement LinkedinLogo;
	@FindBy(xpath = "//a[text()='Facebook']") private WebElement FacebookLogo;
	@FindBy(xpath = "//div[@class='app_logo']") private WebElement HeaderLabel;
	@FindBy(xpath = "//div[@class='footer_copy']") private WebElement footerTxt;
	//Removing Product
	@FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']") private WebElement BackpackRemoveBtn;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bike-light']") private WebElement BikeLightRemoveBtn;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bolt-t-shirt']") private WebElement TShirtRemoveBtn;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-fleece-jacket']") private WebElement JacketRemoveBtn;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-onesie']") private WebElement OnesieRemoveBtn;
	@FindBy(xpath = "//button[@id='remove-test.allthethings()-t-shirt-(red)']") private WebElement RedTShirtRemoveBtn;
	
	//constructor
	public Inventory_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	//methods
	public String verifypageTitle()
	{
		return pageTitle.getText();
	}
	public boolean verifyLinkedinLogo()
	{
		return LinkedinLogo.isDisplayed();	
	}
	public String add6Product()
	{
		Handle_DropDown.handleSelect(DropDown, "Price (low to high)");
		BackpackAddBtn.click();
		BikeLightAddBtn.click();
		BoltTshirtAddBtn.click();
		JacketAddBtn.click();
		onesieAddBtn.click();
		RedShirtAddBtn.click();
		return cartCount.getText();
	}
	public String remove6Product()
	{
		add6Product();
		BackpackRemoveBtn.click();
		BikeLightRemoveBtn.click();
		TShirtRemoveBtn.click();
		JacketRemoveBtn.click();
		//OnesieRemoveBtn.click();
		RedTShirtRemoveBtn.click();
		return cartCount.getText();
		
	}
	public String verifyheaderLabel()
	{
		return HeaderLabel.getText();	
	}
	public String verifyfooterTxt()
	{
		return footerTxt.getText();	
	}
	public boolean verifyFacebookLogo()
	{
		return FacebookLogo.isDisplayed();	
	}
	public String verifycartIcon()
	{
		cartIcon.click();
		return driver.getCurrentUrl();		
	}
}
