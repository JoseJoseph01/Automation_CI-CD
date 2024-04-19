package automationJavaDesign.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationAbstractComponents.AbstractComponents;

public class OrderListPage extends AbstractComponents {
	
	WebDriver driver;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	@FindBy(css="tr td:nth-child(3)")
	private List<WebElement> orderListNames;

	public OrderListPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	public Boolean VerifyOrderDisplay(String cartproductsname)
	{
		
	 Boolean match = orderListNames.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(cartproductsname));
	 return match;	
	}
	

	

	
	
}
