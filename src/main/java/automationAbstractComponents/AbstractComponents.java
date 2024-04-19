package automationAbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationJavaDesign.pageobjects.CartPage;
import automationJavaDesign.pageobjects.OrderListPage;

public class AbstractComponents {

	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;

	@FindBy(css="[routerlink*='myorders']")
	WebElement orderHistory;
	
	@FindBy(css=".ng-animating")
	WebElement animation;
	
	

	public void waitForElementToAppear(By findBy) {
		
	WebDriverWait prodwait = new WebDriverWait(driver,Duration.ofSeconds(5));
	prodwait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	
	}
	
	public void waitForWebElementToAppear(WebElement findBy)
	{
		WebDriverWait prodwait = new WebDriverWait(driver,Duration.ofSeconds(5));
		prodwait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	
	public void waitForElementToDisappear(WebElement ele) 
	{
		
		WebDriverWait prodwait = new WebDriverWait(driver,Duration.ofSeconds(5));
		prodwait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public CartPage goToCartListPage() 
	{
		waitForElementToDisappear(animation);
		cartHeader.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
		
	}
	
	public OrderListPage goToOrderListPage() 
	{
		
		orderHistory.click();
		OrderListPage orderPage = new OrderListPage(driver);
		return orderPage;
		
	}
	
	
	
}
