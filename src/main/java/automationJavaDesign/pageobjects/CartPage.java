package automationJavaDesign.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationAbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {
	
	WebDriver driver;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	@FindBy(css=".cartSection h3")
	private List<WebElement> productTitles;

	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	public Boolean VerifyProductDisplay(String cartproductsname)
	{
		
	 Boolean match = productTitles.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(cartproductsname));
	 return match;	
	}
	
	public CheckOutPage goToCheckout() 
	{
		checkoutEle.click();
		CheckOutPage checkOut = new CheckOutPage(driver);
		return checkOut;
		
	}
	

	
	
}
