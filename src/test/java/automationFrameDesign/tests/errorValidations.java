package automationFrameDesign.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation.TestComponents.Retry;
import automation.TestComponents.baseTest;
import automationJavaDesign.pageobjects.CartPage;
import automationJavaDesign.pageobjects.CheckOutPage;
import automationJavaDesign.pageobjects.ConfirmationPage;
import automationJavaDesign.pageobjects.productCatalouge;

public class errorValidations extends baseTest {

	
	//Whenever you using TestNG annotations in javaclass for execution just follow below steps
	/*Adding the TestNG Library into the project. Steps are:

		Right Click on the Project
		Build Path
		Configure Build Path
		Libraries (Tab)
		Go to "Add Library" and click the button.
		Add the 'TestNG' Library and click Ok/Next.
		TestNG Library will be added to your project.*/
	
	
	@Test(groups={"ErrorHandling"},retryAnalyzer = Retry.class)
	public void loginErrorValidation() throws IOException, InterruptedException
	{
		// TODO Auto-generated method stub
		
		String cartproductsname = "ADIDAS ORIGINAL";
		landingPage.appLogin("jeevap@gmail.com", "Jeeva$1234");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
		
		
	}
	
	@Test
	public void productErrorVaildation() throws IOException, InterruptedException
	{
		// TODO Auto-generated method stub
		
		String cartproductsname = "ADIDAS ORIGINAL";
		productCatalouge prodClassify = landingPage.appLogin("pauljim@rediffmail.com","Paul$43210#");
		List<WebElement> finalproducts = prodClassify.getListProducts();
		prodClassify.addToProductToCart(cartproductsname);
		CartPage cartPage = prodClassify.goToCartListPage();
		//CartPage cartPage = new CartPage(driver);
		Boolean match = cartPage.VerifyProductDisplay("ADIDAS ORIGINAL 11");
		Assert.assertFalse(match);
		
	}
	
	
	
	
	

}
