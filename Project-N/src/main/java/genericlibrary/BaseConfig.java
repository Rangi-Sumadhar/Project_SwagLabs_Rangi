package genericlibrary;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import pagerepository.LoginPage;
import pagerepository.ProductPage;


//@Listeners(InvokeBeforeMethod.class)

public class BaseConfig extends PropertiesLibrary

{
	
	public static WebDriver staticdriver;
	public WebDriver driver;
	public JavascriptExecutor js;
	
	
	@Parameters("browser")
	@BeforeClass
	public void BrowserSetup(String browsername)
	{
	
//		Open the Browser 

		WebDriverLibrary.openBrowswer(browsername);
		driver = WebDriverLibrary.driver;
		staticdriver = WebDriverLibrary.driver;
		js = (JavascriptExecutor)driver;
		
//		Navigate to the application via URL
		WebDriverLibrary.navigateToApp("https://www.saucedemo.com/");
		
		//Maximize the browser
		WebDriverLibrary.maximiseBrowser(driver);
	}
	
	
	@BeforeMethod
	public void Login() throws InterruptedException
	{
		//Waiting statement
		WebDriverLibrary.WaitStatement();
		
//		Verify the URL
		System.out.println(WebDriverLibrary.verifyUrl());
		
		LoginPage loginpage = new LoginPage(driver);
		
//		Verify the user name text field is enabled
		Assert.assertTrue(loginpage.getusername().isEnabled());

//		Verify the user name text field is displayed
		Assert.assertTrue(loginpage.getusername().isDisplayed());
		
//		Verify the password text field is enabled
		Assert.assertTrue(loginpage.getpassword().isEnabled());
		
//		Verify the password text field is displayed
		Assert.assertTrue(loginpage.getpassword().isDisplayed());
		
//		Verify the Login button is enabled
		Assert.assertTrue(loginpage.getlogin().isEnabled());
		
//		Verify the Login button is displayed
		Assert.assertTrue(loginpage.getlogin().isDisplayed());		
		
		
//		Enter the user name in the user name text field
		loginpage.getusername().sendKeys("standard_user");
		
//		Enter the password in the password text field
		loginpage.getpassword().sendKeys("secret_sauce");
		
//		Click on the login button
		loginpage.getlogin().click();
		
		Thread.sleep(1000);
		
		
	}	
	
	@AfterClass
	public void logout()
	{
		ProductPage productpage = new ProductPage(driver);
//		Verify the intial Products page
		System.out.println(WebDriverLibrary.verifyUrl());
		
//		Verify the Hamburger menu is displayed
		AssertJUnit.assertTrue(productpage.gethamburger().isDisplayed());
		
//		Verify the Hamburger menu is enabled
		AssertJUnit.assertTrue(productpage.gethamburger().isEnabled());
		
//		Click on the Hamburger menu
		productpage.gethamburger().click();
		
//		Verify the Logout button is displayed
		WebDriverLibrary.WaitStatement(productpage.getlogoutlink());
		AssertJUnit.assertTrue(productpage.getlogoutlink().isDisplayed());
		
//		Verify the Logout button is enabled
		AssertJUnit.assertTrue(productpage.getlogoutlink().isDisplayed());
		
//		Click on the Logout button
		productpage.getlogoutlink().click();
		
//		Verify the login page
		System.out.println(WebDriverLibrary.verifyUrl());
		
//		Close the browser
		driver.close();
	}
	
	
	@DataProvider(name ="data")
	public Object[][] getData()
	{
		Object[][] data = new Object[1][3];
		data[0][0] = ExcelLibrary.ReadData("",1,1);
		
		return data;
	}
}
