package producttest;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//Verify user is able to order 3 products from the SauceLabs web site

public class Example1Test 

{
	public WebDriver driver;
	public JavascriptExecutor js;
//	@Test
	public void SwagLabs_3Products() throws InterruptedException
	{
		
////		Open the Browser 
//		driver = new ChromeDriver();
//		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		
////		Navigate to the application via URL
//		driver.get("https://www.saucedemo.com/");
//		
////		Verify the URL
//		System.out.println(driver.getCurrentUrl());
//		
		
		WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']")); 
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		WebElement login 	= driver.findElement(By.xpath("//input[@id='login-button']"));
		
//		Verify the user name text field is displayed
		assertTrue(username.isDisplayed());
		
//		Verify the user name text field is enabled
		assertTrue(username.isEnabled());
		
//		Verify the password text field is displayed
		assertTrue(password.isDisplayed());
		
//		Verify the password text field is enabled
		assertTrue(password.isEnabled());
		
//		Verify the Login button is displayed
		assertTrue(login.isDisplayed());
//		Verify the Login button is enabled
		assertTrue(login.isDisplayed());
		
//		Enter the user name in the user name text field
		username.sendKeys("standard_user");
		
//		Enter the password in the password text field
		password.sendKeys("secret_sauce");
		
//		Click on the login button
		login.click();
		
		Thread.sleep(2000);
		
//		Click on Product 1
		WebElement product01 = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
		product01.click();
		
		
//		Click on add to cart button
		WebElement addtocart01 = driver.findElement(By.xpath("//button[@name='add-to-cart']"));
		addtocart01.click();
		
//		Navigate to previous list of products page to add another item
		driver.navigate().back();
		
//		Verify the page
		
//		Click on Product 2
		WebElement product02 = driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']"));
		product02.click();
		
//		Click on add to cart button
		WebElement addtocart02 = driver.findElement(By.xpath("//button[@name='add-to-cart']"));
		addtocart02.click();
		
//		Navigate to previous list of products page to add another item
		driver.navigate().back();
		
		
//		Verify the page
		
//		Click on Product 3
		WebElement product03 = driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']"));
		product03.click();
		
//		Click on add to cart button
		WebElement addtocart03 = driver.findElement(By.xpath("//button[@name='add-to-cart']"));
		addtocart03.click();
		
//		Verify there are 3 products on the cart icon
		WebElement cart_numOfItems = driver.findElement(By.xpath("//span[@class='shopping_cart_badge' and text() = '3']"));
		Assert.assertEquals("3",cart_numOfItems.getText());
		
		
//		Click on Cart icon
		WebElement cart_icon = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
		cart_icon.click();
		
		
//		Verify the cart page
		System.out.println(driver.getCurrentUrl());
		
//		Scroll down until checkout button is visible
		js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)");
		
//		Verify the Checkout button is displayed
		WebElement checkout = driver.findElement(By.xpath("//button[@id='checkout']"));
		Assert.assertTrue(checkout.isDisplayed());
		
//		Verify the Checkout button is enabled
		Assert.assertTrue(checkout.isEnabled());
		
//		Click on the Checkout button
		checkout.click();
		
//		Verify the Checkout page
		driver.getCurrentUrl();
		
//		Verify the First name text field is displayed
		WebElement firstname = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		Assert.assertTrue(firstname.isDisplayed());
		
//		Verify the First name text field is enabled
		Assert.assertTrue(firstname.isEnabled());
		
//		Verify the Last name text field is displayed
		WebElement lastname = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		Assert.assertTrue(lastname.isDisplayed());
		
//		Verify the Last name text field is enabled
		Assert.assertTrue(lastname.isEnabled());
		
//		Verify the Zipcode text field is displayed
		WebElement zipcode = driver.findElement(By.xpath("//input[@placeholder='Zip/Postal Code']"));
		Assert.assertTrue(zipcode.isDisplayed());
		
//		Verify the Zipcode text field is enabled
		Assert.assertTrue(zipcode.isEnabled());
		
		
//		Verify the Continue button is displayed
		WebElement continue_btn = driver.findElement(By.xpath("//input[@id='continue']"));
		Assert.assertTrue(continue_btn.isDisplayed());
		
//		Verify the Continue button is enabled
		Assert.assertTrue(continue_btn.isEnabled());
		
//		Enter the Firstname in the Firstname textfield
		firstname.sendKeys("ABC");
		
//		Enter the Lastname in the Lastname textfield
		lastname.sendKeys("BCD");
		
//		Enter the Zipcode in the Zipcode textfield
		zipcode.sendKeys("587833");
		
//		Click on the Continue button
		continue_btn.click();
		
//		Verify the Checkout-step two page
		System.out.println(driver.getCurrentUrl());
		
//		Scroll down until Finish button is visible
		js.executeScript("window.scrollBy(0,300)");
		
//		Verify the Finish button is displayed
		WebElement finish = driver.findElement(By.xpath("//button[@id='finish']"));
		Assert.assertTrue(finish.isDisplayed());
		
//		Verify the Finish button is enabled
		Assert.assertTrue(finish.isEnabled());
		
//		Click on the Finish button
		finish.click();
		
//		Verify the Thank you page
		System.out.println(driver.getCurrentUrl());
		WebElement thankyou_text = driver.findElement(By.xpath("//h2"));
		System.out.println(thankyou_text.getText());
		
//		Verify the BackToHome button is displayed
		WebElement back_To_Home = driver.findElement(By.id("back-to-products"));
		Assert.assertTrue(back_To_Home.isDisplayed());
		
//		Verify the BackToHome button is enabled
		Assert.assertTrue(back_To_Home.isEnabled());
		
//		Click on the BackToHome button
		back_To_Home.click();
		
//		Verify the intial Products page
		System.out.println(driver.getCurrentUrl());
		
//		Verify the Hamburger menu is displayed
		WebElement hamburger = driver.findElement(By.id("react-burger-menu-btn"));
		Assert.assertTrue(hamburger.isDisplayed());
		
//		Verify the Hamburger menu is enabled
		Assert.assertTrue(hamburger.isEnabled());
		
//		Click on the Hamburger menu
		hamburger.click();
		
//		Verify the Logout button is displayed
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement logout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
				
		Assert.assertTrue(logout.isDisplayed());
		
//		Verify the Logout button is enabled
		Assert.assertTrue(logout.isEnabled());
		
//		Click on the Logout button
		logout.click();
		
//		Verify the login page
		System.out.println(driver.getCurrentUrl());
		
//		Close the browser
		driver.close();
		
	}
}
