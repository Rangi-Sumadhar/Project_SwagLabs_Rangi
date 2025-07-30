package pagerepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThankyouPage 

{
	@FindBy(id="back-to-products")
	private WebElement backtohome;
	
	public ThankyouPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getbacktohome()
	{
		return backtohome;
	}
}
