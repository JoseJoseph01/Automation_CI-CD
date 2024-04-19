package automationFrameDesign.tests;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.HashMap;

import automation.TestComponents.baseTest;
import automationJavaDesign.pageobjects.LandingPage;
import automationJavaDesign.pageobjects.OrderListPage;
import automationJavaDesign.pageobjects.productCatalouge;
import automationJavaDesign.pageobjects.CartPage;
import automationJavaDesign.pageobjects.CheckOutPage;
import automationJavaDesign.pageobjects.ConfirmationPage;

public class IndependentTest extends baseTest {

	
	//Whenever you using TestNG annotations in javaclass for execution just follow below steps
	/*Adding the TestNG Library into the project. Steps are:

		Right Click on the Project
		Build Path
		Configure Build Path
		Libraries (Tab)
		Go to "Add Library" and click the button.
		Add the 'TestNG' Library and click Ok/Next.
		TestNG Library will be added to your project.*/
	
	String cartproductsname = "ADIDAS ORIGINAL";
	
	
	                              
	@Test(dataProvider="getData",groups= {"PurchaseProduct"})//To add mutiple groups(groups= {"group1","group2"})
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException
	{
		// TODO Auto-generated method stub
		
		
		productCatalouge prodClassify = landingPage.appLogin(input.get("email"), input.get("password"));
		List<WebElement> finalproducts = prodClassify.getListProducts();
		prodClassify.addToProductToCart(input.get("cartproductsname"));
		CartPage cartPage = prodClassify.goToCartListPage();
		//CartPage cartPage = new CartPage(driver);
		Boolean match = cartPage.VerifyProductDisplay(input.get("cartproductsname"));
		Assert.assertTrue(match);
		CheckOutPage checkOut = cartPage.goToCheckout();
		checkOut.selectCountry("India");
		 JavascriptExecutor jscroll = (JavascriptExecutor)driver;
			
	       //jscroll.executeScript("window.scrollTo(0,700)");
	       jscroll.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	       Thread.sleep(2000);
		ConfirmationPage confirmPage = checkOut.submitOrder();
		String confirmMsg = confirmPage.getConfirmationMessage();
		Assert.assertTrue(confirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));	
	
		
	}
	
	
	@Test(dependsOnMethods= {"submitOrder"}	)
	public void orderInfoHistory()
	{
		
		productCatalouge prodClassify = landingPage.appLogin("jeevap@gmail.com", "Jeeva$1234#");
		OrderListPage orderPage = prodClassify.goToOrderListPage();
		Assert.assertTrue(orderPage.VerifyOrderDisplay(cartproductsname));
		
	}
	
	
	/*public String getScreenshot(String testCaseName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File mainsource = ts.getScreenshotAs(OutputType.FILE);
		File sourcefile = new File(System.getProperty("user.dir")+"//reports//" + testCaseName +".png");
		FileUtils.copyFile(mainsource, sourcefile);
		return System.getProperty("user.dir")+"//reports//" + testCaseName +".png";
		
		
	}*/
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "jeevap@gmail.com");
//		map.put("password", "Jeeva$1234#");
//		map.put("cartproductsname", "ADIDAS ORIGINAL");
		
//		HashMap<String, String> map01 = new HashMap<String, String>();
//		map01.put("email", "pauljim@rediffmail.com");
//		map01.put("password", "Paul$43210#");
//		map01.put("cartproductsname", "ZARA COAT 3");
		
		
		List<HashMap<String, String>> data =getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//automationsel//testdata//PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
	}
	
	
	
	
	
	
	//@DataProvider
	//public Object[][] getData()
	//{
	//	
	//	return new Object[][] {{"jeevap@gmail.com","Jeeva$1234#","ADIDAS ORIGINAL"},{"pauljim@rediffmail.com","Paul$43210#","ZARA COAT 3"}};
	//}
	
	
	

}
