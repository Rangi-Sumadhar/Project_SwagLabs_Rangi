package pagerepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage_02 
{

	@FindBy(id="finish")
	private WebElement finishbutton;
	
	public CheckoutPage_02(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getfinishbutton()
	{
		return finishbutton;
	}
	
	
	
	
	
	
	
}
