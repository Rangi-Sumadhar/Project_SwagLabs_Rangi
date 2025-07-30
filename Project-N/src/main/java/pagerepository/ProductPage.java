package pagerepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage

{
	@FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
	private WebElement product_01;
	
	@FindBy(xpath = "//div[text()='Sauce Labs Bike Light']")
	private WebElement product_02;
	
	@FindBy(xpath = "//div[text()='Sauce Labs Bolt T-Shirt']")
	private WebElement product_03;
	
	@FindBy(id="add-to-cart")
	private WebElement add_To_Cart;
	
	@FindBy(xpath = "//span[@class='shopping_cart_badge' and text() = '3']")
	private WebElement cart_items;
	
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	private WebElement carticon;
	
	@FindBy(id="react-burger-menu-btn")
	private WebElement hamburger;
	
	@FindBy(id="logout_sidebar_link")
	private WebElement logoutlink;
	
	
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getproduct_01()
	{
		return product_01;
	}
	
	public WebElement getproduct_02()
	{
		return product_02;
	}
	
	public WebElement getproduct_03()
	{
		return product_03;
	}
	
	public WebElement getadd_To_Cart()
	{
		return add_To_Cart;
	}
	
	public WebElement getcart_items()
	{
		return cart_items;
	}
	
	public WebElement getcarticon()
	{
		return carticon; 
	}
	
	public WebElement gethamburger()
	{
		return hamburger;
	}
	
	public WebElement getlogoutlink()
	{
		return logoutlink;
	}
	
}
