package automationJavaDesign.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationAbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{
	//Pageobject always focus on element and actions and it doesn't hold any data
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);//To catch variable in parent class from child class it user super keyword
		this.driver =driver ;
		PageFactory.initElements(driver, this);
	}
	
	  //WebElement userEmail = driver.findElement(By.id("userEmail"));
	  //PageFactory
	  
	  @FindBy(id="userEmail")
	  WebElement userEmail;
	  
	  @FindBy(id="userPassword")
	  WebElement userpwd;
	  
	  @FindBy(id="login")
	  WebElement loginuser;
	  
	  @FindBy(css="[class*='flyInOut']")
	  WebElement errormessage;
	  
	  public productCatalouge appLogin(String email, String password) 
	  {
		  userEmail.sendKeys(email);
		  userpwd.sendKeys(password);
		  loginuser.click();
		  productCatalouge prodClassify = new productCatalouge(driver);
		  return prodClassify;
	  }
	  
	  public String getErrorMessage()
	  {
		  waitForWebElementToAppear(errormessage);
		  return errormessage.getText();
	  }
	  
	  
	  public void goToUrl()
	  {
		  
		  driver.get("https://www.rahulshettyacademy.com/client");
		  
	  }
	  
	  

}
