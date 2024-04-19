package automation.TestComponents;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import automationJavaDesign.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class baseTest {
	
	public WebDriver driver;
	public LandingPage landingPage;
	
	public WebDriver intializeDriver() throws IOException {
		
		//To access global properties for it properties class
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//automation//resources//GlobalData.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser"); 
		//String browserName = prop.getProperty("browser");
		
		
	if (browserName.contains("chrome"))	
	{	
	  ChromeOptions options = new ChromeOptions();
	  WebDriverManager.chromedriver().setup();
	  if (browserName.contains("headless")){	 
	     options.addArguments("--headless");
	    
	  }
	
	     driver = new ChromeDriver(options);
		 driver.manage().window().setSize(new Dimension(1440,900));//To run full screen mode
	}
	else if (browserName.equalsIgnoreCase("firefox"))	
	{
		//add firefox driver
		System.setProperty("webdriver.gecko.driver", "C:\\Projects_Jose\\SelandJav\\geckodriver-v0.34.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	else if (browserName.equalsIgnoreCase("edge"))
	{
		
		// add edge driver
	}
	
	//driver = new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	
	//driver.manage().window().setSize(new Dimension(1440,900));
	return driver;
	
	
	}
	
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException 
	{
		//Read Json to String
	String jsonContent =	FileUtils.readFileToString(new File(filePath),
			StandardCharsets.UTF_8);
		
	//String to Hashmap (Usage Jackson databind dependency for converting string to  Hashmap)
	
	 ObjectMapper mapper = new ObjectMapper();
	 List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){
	 });
	 return data;
	
	
		
	}
	
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File mainsource = ts.getScreenshotAs(OutputType.FILE);
		File sourcefile = new File(System.getProperty("user.dir")+"//reports//" + testCaseName +".png");
		FileUtils.copyFile(mainsource, sourcefile);
		return System.getProperty("user.dir")+"//reports//" + testCaseName +".png";
		
		
	}
	
	

	@BeforeMethod(alwaysRun=true)
	public LandingPage appLunchApplication() throws IOException
	{
		
		driver = intializeDriver();
		
		landingPage = new LandingPage(driver);
		landingPage.goToUrl();
		return landingPage;
		
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void urlshutdown()
	{
		driver.close();
	}
	
	
	
	
}
