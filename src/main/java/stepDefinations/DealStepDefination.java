package stepDefinations;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;


public class DealStepDefination {
	
	WebDriver driver;
	
	
	@Given("^user is on credential page$")
	public void user_is_on_credential_page() {
		//System.setProperty("webdriver.chrome.driver", "D:\\Automation\\FreeCRMBDDFramework\\driver\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://ui.cogmento.com/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	@And("^user enter username and password$")
	public void user_enters_username_and_password(DataTable dataTable) throws Throwable{
	    
			for(Map<String, String> logindata : dataTable.asMaps(String.class, String.class)) { 
			
			WebElement Username = driver.findElement(By.xpath("//input[@name='email']"));
			Username.sendKeys(logindata.get("username"));
			
			WebElement Password1 = driver.findElement(By.xpath("//input[@name='password']"));
			Password1.sendKeys(logindata.get("password"));

			
			}
			
	}
	
	@And("^user move to home page and deal link and click on it$")
	public void user_move_to_deal_link_and_click_on_it() {
		
		
		WebElement loginbtn = driver.findElement(By.xpath("//div[contains(text(),'Login')]"));
		loginbtn.click();
	
		
		String title = driver.getTitle();
		
		title.equals("Cogmento CRM");
	   
//		driver.navigate().to("https://ui.cogmento.com/deals");
		
		Actions ab = new Actions(driver);
	
		WebElement deal = driver.findElement(By.xpath("//i[@class='money icon']"));
		
		ab.moveToElement(deal).click().build().perform();
		
		
		 WebElement CreateNewDealBtn = driver.findElement(By.xpath("//button[contains(text(),'Create')]"));
		 
		 ab.moveToElement(CreateNewDealBtn).click().build().perform();
		
	}
	@And("^user enter deal details$")
	public void user_enter_deal_details(io.cucumber.datatable.DataTable dealdata) {
	   
		
		for(Map<String, String> data : dealdata.asMaps(String.class, String.class)) {
			
			
			WebElement title = driver.findElement(By.xpath("//input[@name='title']"));
		    title.sendKeys(data.get("Title"));
		    	    
		    WebElement description = driver.findElement(By.xpath("//textarea[@name='description']"));
		    description.sendKeys(data.get("Description"));
		    
		    WebElement probability = driver.findElement(By.xpath("//input[@name='probability']"));
		    probability.sendKeys(data.get("Probability"));
		    
		    WebElement savedeal = driver.findElement(By.xpath("//button[@class='ui linkedin button']"));
		    
		    Actions ab = new Actions(driver);
		 	ab.moveToElement(savedeal).click().build().perform();
		 	
			
			WebElement deal = driver.findElement(By.xpath("//i[@class='money icon']"));
			
			ab.moveToElement(deal).build().perform();
			
			deal.click();
			
			 WebElement CreateNewDealBtn = driver.findElement(By.xpath("//button[contains(text(),'Create')]"));
			 
			 ab.moveToElement(CreateNewDealBtn).click().build().perform();
			 
		}
	    
		
	}
	@Then("^user click on save button$")
	public void user_click_on_save_button() {
			
			
			driver.navigate().to("https://ui.cogmento.com/deals");
			
			WebElement CreateNewDealBtn = driver.findElement(By.xpath("//button[contains(text(),'Create')]"));
			CreateNewDealBtn.click();
	    
	}
	@Then("^user close the browser$")
	public void user_close_the_browser() {
	   driver.close();
	}
	
}
