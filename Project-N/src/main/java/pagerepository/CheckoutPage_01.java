package pagerepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage_01 

{
	@FindBy(id="first-name")
	private WebElement firstname;
	
	@FindBy(id="last-name")
	private WebElement lastname;
	
	@FindBy(id="postal-code")
	private WebElement zipcode;
	
	@FindBy(id="continue")
	private WebElement continuebtn;
	
	public CheckoutPage_01(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getfirstname()
	{
		return firstname;
	}
	
	public WebElement getlastname()
	{
		return lastname;
	}
	
	public WebElement getzipcode()
	{
		return zipcode;
	}
	
	public WebElement getcontinuebtn()
	{
		return continuebtn;
	}
	
}
