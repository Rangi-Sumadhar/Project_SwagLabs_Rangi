package producttest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import genericlibrary.BaseConfig;
import genericlibrary.WebDriverLibrary;
import pagerepository.CartPage;
import pagerepository.CheckoutPage_01;
import pagerepository.CheckoutPage_02;
import pagerepository.ProductPage;
import pagerepository.ThankyouPage;
import listenerlibrary.ListnerImplementation;

@Listeners(ListnerImplementation.class)
public class TeamNTest extends BaseConfig
{	
	@Test 
	public void AddProduct()
	{
//		Verify the page
		System.out.println(WebDriverLibrary.verifyUrl());
		
//		Click on Product 1
		ProductPage productpage = new ProductPage(driver);
		productpage.getproduct_01().click();
		
//		Click on add to cart button
		productpage.getadd_To_Cart().click();
		
//		Navigate to previous list of products page to add another item
		WebDriverLibrary.navigateBack();
		
//		Verify the page
		System.out.println(WebDriverLibrary.verifyUrl());
		
//		Click on Product 2
		productpage.getproduct_02().click();
		
//		Click on add to cart button
		productpage.getadd_To_Cart().click();
		
//		Navigate to previous list of products page to add another item
		WebDriverLibrary.navigateBack();
		
//		Verify the page
		System.out.println(WebDriverLibrary.verifyUrl());
		
//		Click on Product 3
		productpage.getproduct_03().click();
		
//		Click on add to cart button
		productpage.getadd_To_Cart().click();
		
//		Verify there are 3 products on the cart icon
		AssertJUnit.assertEquals("3",productpage.getcart_items().getText());
		
//		Click on Cart icon
		productpage.getcarticon().click();
		
		
//		Verify the cart page
		System.out.println(WebDriverLibrary.verifyUrl());
		
//		Scroll down until checkout button is visible
		js.executeScript("window.scrollBy(0,300)");
		
//		Verify the Checkout button is displayed
		CartPage cp = new CartPage(driver);
		AssertJUnit.assertTrue(cp.getcheckout().isDisplayed());
		
//		Verify the Checkout button is enabled
		AssertJUnit.assertTrue(cp.getcheckout().isEnabled());
		
//		Click on the Checkout button
		cp.getcheckout().click();
		
		
//		Verify the Checkout page
		System.out.println(WebDriverLibrary.verifyUrl());
		
//		Verify the Firstname textfield is displayed
		CheckoutPage_01 checkout01 = new CheckoutPage_01(driver);
		AssertJUnit.assertTrue(checkout01.getfirstname().isDisplayed());
		
//		Verify the Firstname textfield is enabled
		AssertJUnit.assertTrue(checkout01.getfirstname().isEnabled());
		
//		Verify the Lastname textfield is displayed
		AssertJUnit.assertTrue(checkout01.getlastname().isDisplayed());
		
//		Verify the Lastname textfield is enabled
		AssertJUnit.assertTrue(checkout01.getlastname().isEnabled());
		
//		Verify the Zip code text field is displayed
		AssertJUnit.assertTrue(checkout01.getzipcode().isDisplayed());
		
//		Verify the Zip code text field is enabled
		AssertJUnit.assertTrue(checkout01.getzipcode().isEnabled());
		
//		Verify the Continue button is displayed
		AssertJUnit.assertTrue(checkout01.getcontinuebtn().isDisplayed());
		
//		Verify the Continue button is enabled
		AssertJUnit.assertTrue(checkout01.getcontinuebtn().isEnabled());
		
//		Enter the Firstname in the Firstname textfield
		checkout01.getfirstname().sendKeys("ABC");
		
//		Enter the Lastname in the Lastname textfield
		checkout01.getlastname().sendKeys("ABC");
		
//		Enter the Zipcode in the Zipcode textfield
		checkout01.getzipcode().sendKeys("ABC");
		
//		Click on the Continue button
		checkout01.getcontinuebtn().click();
		
//		Verify the Checkout-step two page
		System.out.println(WebDriverLibrary.verifyUrl());
		
//		Scroll down until Finish button is visible
		js.executeScript("window.scrollBy(0,300)");
		
//		Verify the Finish button is displayed
		CheckoutPage_02 checkout02 = new CheckoutPage_02(driver);
		AssertJUnit.assertTrue(checkout02.getfinishbutton().isDisplayed());
		
//		Verify the Finish button is enabled
		AssertJUnit.assertTrue(checkout02.getfinishbutton().isEnabled());
		
//		Click on the Finish button
		checkout02.getfinishbutton().click();
		
//		Verify the Thank you page
		System.out.println(WebDriverLibrary.verifyUrl());
		
//		Verify the BackToHome button is displayed
		ThankyouPage thankyou = new ThankyouPage(driver);
		AssertJUnit.assertTrue(thankyou.getbacktohome().isDisplayed());
		
//		Verify the BackToHome button is enabled
		AssertJUnit.assertTrue(thankyou.getbacktohome().isEnabled());
		
//		Click on the BackToHome button
		thankyou.getbacktohome().click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
