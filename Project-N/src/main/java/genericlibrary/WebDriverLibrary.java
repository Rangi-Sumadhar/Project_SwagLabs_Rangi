package genericlibrary;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverLibrary implements FrameworkConstant

{
	public static WebDriver driver;
	public static JavascriptExecutor js;
	public static Actions action;
	public static Select S;
	public static WebDriverWait wait;
	Alert alert;
	
	public static WebDriver openBrowswer(String BrowserName)
	{
		
		if(BrowserName.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		
		else if(BrowserName.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();
		}
		
		else if(BrowserName.equalsIgnoreCase("Safari"))
		{
			driver = new SafariDriver();
		}
		
		else
		{
			System.out.println("INVALID BROWSER NAME!!");
		}
		
		return driver;
	}
	
	
	public static void maximiseBrowser(WebDriver driver)
	
	{
		driver.manage().window().maximize();
	}

	
	public static void navigateToApp(String url)
	{
		driver.get(url);
	}
	
	public static void WaitStatement()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(standardwait));	
	}
	
	
	public static void WaitStatement(WebElement element)
	{
		 wait = new WebDriverWait(driver, Duration.ofSeconds(standardwait));
		 wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	public static void selectFromDropdown(WebElement element, String value)
	{
		S = new Select(element);
		S.selectByValue(value);
	}
	
	
	public static void selectFromDropdown(String value, WebElement element)
	{
		S = new Select(element);
		S.selectByVisibleText(value);
	}
	
	
	public static void selectFromDropdown(WebElement element, int index)
	{
		S = new Select(element);
		S.selectByIndex(index);
	}
	
	
	public static void switchToFrame(int index)
	{
		driver.switchTo().frame(index);
	}
	
	
	public static void switchToFrame(String idOrName)
	{
		driver.switchTo().frame(idOrName);
	}
	
	
	public static void switchToFrame(WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	
	public static void switchToDefaultWindow()
	{
		driver.switchTo().defaultContent();		
	}
	
	
	public static void handleAlert(String status)
	{
		if(status.equalsIgnoreCase("Ok"))
			{
				driver.switchTo().alert().accept();
			}
		else
			{
				driver.switchTo().alert().dismiss();
			}
	}
	
	
	public static void closeWindow()
	{
		driver.close();
	}
	
	
	public static void closeAllWindows()
	{
		driver.quit();
	}
	
	
	public static void mouseHover(WebElement element)
	{
		action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	
	public static void dragAndDropElement(WebElement element, WebElement target)
	{
		action = new Actions(driver);
		action.dragAndDrop(element, target).perform();
	}
	

	public static void rightClick(WebElement element)
	{
		action = new Actions(driver);
		action.contextClick(element).perform();
	}
	
	
	public static void elementClick_Actions(WebElement element)
	{
		action = new Actions(driver);
		action.click(element).perform();
	}
	
	public static void elementClick(WebElement element)
	{
		element.click();
	}
	
	
	public static void enterTheData(WebElement element, String data)
	{
		element.sendKeys(data);
	}
	
	public static String verifyUrl()
	{
		String url = driver.getCurrentUrl();
		return url;
	}
	
	public static void navigateBack()
	{
		driver.navigate().back();
	}
	
	
}
