package OrderPurchase.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import automation.TestComponents.baseTest;
import automationJavaDesign.pageobjects.CartPage;
import automationJavaDesign.pageobjects.CheckOutPage;
import automationJavaDesign.pageobjects.ConfirmationPage;
import automationJavaDesign.pageobjects.LandingPage;
import automationJavaDesign.pageobjects.productCatalouge;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ImplStepDefinitions extends baseTest  {
	
	public LandingPage landingPage;
	public productCatalouge prodClassify;
	public ConfirmationPage confirmPage;
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		
		landingPage = appLunchApplication();
	}

	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_username_and_password(String username, String password)
	{
		
		prodClassify = landingPage.appLogin(username,password);
		
	}
	
	
	
	@When("^I add product (.+) to Cart$")
	public void i_add_product_to_cart(String productName) //throws InterruptedException
	{
		
		List<WebElement> finalproducts = prodClassify.getListProducts();
		prodClassify.addToProductToCart(productName);	
	}
	
	  
	@When("^Checkout (.+) and submit the order$") 
	public void checkout_and_submitorder(String productName) throws InterruptedException
	{
		
		CartPage cartPage = prodClassify.goToCartListPage();
		//CartPage cartPage = new CartPage(driver);
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckOutPage checkOut = cartPage.goToCheckout();
		checkOut.selectCountry("India");
		 JavascriptExecutor jscroll = (JavascriptExecutor)driver;
			
	       //jscroll.executeScript("window.scrollTo(0,700)");
	       jscroll.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	       Thread.sleep(2000);
		confirmPage = checkOut.submitOrder();
		
		
	}
	
	

	 @Then("{string} message is displayed on ConfirmationPage")
	 public void confirmation_message_displayed(String string)
	 {
		 
		 String confirmMsg = confirmPage.getConfirmationMessage();
	     Assert.assertTrue(confirmMsg.equalsIgnoreCase(string));
		 driver.close();
		 
	 }
	
	
	 
	 @Then("^\"([^\"]*)\" message is displayed$")
	 public void something_message_is_displayed(String strArg1) throws Throwable
	 {
		 
		 Assert.assertEquals(strArg1, landingPage.getErrorMessage());
		 driver.close();
		 
		 
	 }
	 
	 
	
}
