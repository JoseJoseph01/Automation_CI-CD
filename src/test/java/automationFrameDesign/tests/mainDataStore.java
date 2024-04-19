package automationFrameDesign.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationJavaDesign.pageobjects.CartPage;
import automationJavaDesign.pageobjects.CheckOutPage;
import automationJavaDesign.pageobjects.ConfirmationPage;
import automationJavaDesign.pageobjects.OrderListPage;
import automationJavaDesign.pageobjects.productCatalouge;

public class mainDataStore {
	
	//LandingPage landingPage= appLunchApplication();
	
	///WebDriverManager.chromedriver().setup();
			//WebDriver driver = new ChromeDriver();
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			//driver.manage().window().maximize();
			//LandingPage landingPage = new LandingPage(driver);
			//landingPage.goToUrl();
			
			
			
			
			
			//driver.get("https://www.rahulshettyacademy.com/client");
					// import the javaClass import automationJavaDesign.pageobjects.LandingPage;
			//driver.findElement(By.id("userEmail")).sendKeys("jeevap@gmail.com");
					//driver.findElement(By.cssSelector("#userPassword")).sendKeys("Jeeva$1234#");
					//driver.findElement(By.id("login")).click();
					//productCatalouge prodClassify = new productCatalouge(driver);
			//WebDriverWait prodwait = new WebDriverWait(driver,Duration.ofSeconds(5));
			//prodwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
			 //List<WebElement> webproducts =driver.findElements(By.cssSelector(".mb-3"));
			 //For total web element matches with condition filter stream used
			//WebElement finalprod = webproducts.stream().filter(techproduct->
			// techproduct.findElement(By.cssSelector("b")).getText().equals(cartproductsname)).findFirst().orElse(null);
			
			//finalprod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
			
			//prodwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
			//prodwait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
			
			//prodwait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
			//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
			
			//[css].cartSection h3 (classname and parent child traverse)
			//[xpath] //*[@class='cartSection']/h3 (classname and parent child traverse)
			
			
			//List<WebElement> productsCarts = driver.findElements(By.cssSelector(".cartSection h3"));
			
			//productsCarts.stream().filter(cartProduct->cartProduct.getText().equalsIgnoreCase(cartproductsname));
			//only condition matches used anyMatch
	//Boolean match	=	productsCarts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(cartproductsname));
	//Assert.assertTrue(match);	

	      // driver.findElement(By.cssSelector(".totalRow button")).click();
	       
	       
	      // Actions proaction = new Actions(driver);
	      // proaction.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
	       //prodwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ta-results")));
	       //driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
	      // driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
	     
	       //JavascriptExecutor jscroll = (JavascriptExecutor)driver;
			
	       //jscroll.executeScript("window.scrollTo(0,700)");
	       //jscroll.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	      // Thread.sleep(2000);
	     
	      // driver.findElement(By.cssSelector(".action__submit")).click();
	        //String confirmMsg = driver.findElement(By.cssSelector(".hero-primary")).getText();
	       // Assert.assertTrue(confirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	       // driver.close();
	        

	/*
	 * String cartproductsname = "ADIDAS ORIGINAL";
	
	
	
	@Test
	public void submitOrder() throws IOException, InterruptedException
	{
		// TODO Auto-generated method stub
		
		
		productCatalouge prodClassify = landingPage.appLogin("jeevap@gmail.com", "Jeeva$1234#");
		List<WebElement> finalproducts = prodClassify.getListProducts();
		prodClassify.addToProductToCart(cartproductsname);
		CartPage cartPage = prodClassify.goToCartListPage();
		//CartPage cartPage = new CartPage(driver);
		Boolean match = cartPage.VerifyProductDisplay(cartproductsname);
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
	 */
	
	
	/* 
	 * @Test(dataProvider="getData",groups= {"PurchaseProduct"})//To add mutiple groups(groups= {"group1","group2"})
	public void submitOrder(String email, String password, String cartproductsname) throws IOException, InterruptedException
	{
		// TODO Auto-generated method stub
		
		
		productCatalouge prodClassify = landingPage.appLogin(email, password);
		List<WebElement> finalproducts = prodClassify.getListProducts();
		prodClassify.addToProductToCart(cartproductsname);
		CartPage cartPage = prodClassify.goToCartListPage();
		//CartPage cartPage = new CartPage(driver);
		Boolean match = cartPage.VerifyProductDisplay(cartproductsname);
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
	
	 
	 * 
	 * @DataProvider
	public Object[][] getData()
	{
		
		return new Object[][] {{"jeevap@gmail.com","Jeeva$1234#","ADIDAS ORIGINAL"},{"pauljim@rediffmail.com","Paul$43210#","ZARA COAT 3"}};
	}
	
	 */
	
	
	
	
	
	
	
	
	
	
	
}
