package automationJavaDesign.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationAbstractComponents.AbstractComponents;

public class productCatalouge extends AbstractComponents  {
	
	
	WebDriver driver;
	
	public productCatalouge(WebDriver driver)
	{
		super(driver);
		this.driver =driver ;
		PageFactory.initElements(driver, this);
		
	}
	
	//List<WebElement> webproducts =driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(css=".mb-3")
	List<WebElement> webProducts;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By collProducts = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
    By toastMessage = By.cssSelector("#toast-container");
   
	
	public List<WebElement> getListProducts() {
		
		waitForElementToAppear(collProducts);
		return webProducts;
	}
	
	public WebElement getProdutsByName(String cartproductsname) 
	{
		WebElement prodcollect = getListProducts().stream().filter(techproduct->
		 techproduct.findElement(By.cssSelector("b")).getText().equals(cartproductsname)).findFirst().orElse(null);
		 return prodcollect;
	}
	
	
	public void addToProductToCart(String cartproductsname)
	{
		WebElement prodcollect = getProdutsByName(cartproductsname);
		prodcollect.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
		
	}
	
	
	
	
	
	
	

}
