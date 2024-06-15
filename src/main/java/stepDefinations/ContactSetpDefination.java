package stepDefinations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactSetpDefination {

	WebDriver driver;
	public static Properties prop;
	
	public ContactSetpDefination() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:\\Automation\\FreeCRMBDDFramework\\src\\main\\java\\properties\\config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Given("User is alreadyon Login page")
	public void user_alreadyon_login_page() {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\FreeCRMBDDFramework\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@When("tile of login page is FreeCRM")
	public void tile_of_login_page_is_freecrm() {
		String Pgtile = driver.getTitle();
		System.out.println(Pgtile);
		Assert.assertEquals("Title is not match", "Cogmento CRM", Pgtile);
	}
	
	@Then("^User enters \"(.*)\" and \"(.*)\"$")
	public void User_enter_User_name_and_password(String username, String password)throws Throwable {
		WebElement Username = driver.findElement(By.xpath("//input[@name='email']"));
		
		Username.sendKeys(username);
		
		WebElement Password = driver.findElement(By.xpath("//input[@name='password']"));
		Password.sendKeys(password);
		
	}
	
	@Then("^user clickon login button$")
	public void user_clickon_login_button() {
		WebElement loginbtn = driver.findElement(By.xpath("//div[contains(text(),'Login')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginbtn);

		
	}
	@Then("^user on home page$")
	public void user_on_home_page() {
		WebElement userdisplay = driver.findElement(By.xpath("//span[@class='user-display']"));
		
		String username_onhomepage = userdisplay.getText();
	
		Assert.assertEquals("Bhaumik Gohel", username_onhomepage);
	  
	}
	
	@Then("^user move to the new contact page$")
	public void user_move_to_the_new_contact_page() {
	   driver.navigate().to("https://ui.cogmento.com/contacts/new");
	}
	@Then("^user enter \"(.*)\" and \"(.*)\"$")
	public void user_enter_Data(String firstname, String lastname) {
	   
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(lastname);
		
	}
	@Then("^close the browser$")
	public void close_the_browser() {
	  
	   driver.close();
	}

	
}
