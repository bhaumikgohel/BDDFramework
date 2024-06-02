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
import org.openqa.selenium.support.FindBy;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefination {

	WebDriver driver;
	public static Properties prop;
	
	
	public LoginStepDefination() {
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
	
	@Given("^User is already on Login page$")
	public void user_already_on_login_page() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\FreeCRMBDDFramework\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
	}
	@When("^tile of login page is Free CRM$")
	public void title_of_login_page_is_free_CRM() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Title is not match", "Cogmento CRM", title);
	}
	
	@Then("^User enter User name and password$")
	public void User_enter_User_name_and_password() {
		WebElement username = driver.findElement(By.xpath("//input[@name='email']"));
		
		username.sendKeys("bhaumik@yopmail.com");
		
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("Admin@123123");
		
		//loginbtn.click();
		
	}
	
	@Then("^user click on login button$")
	public void user_click_on_login_button() {
		WebElement loginbtn = driver.findElement(By.xpath("//div[contains(text(),'Login')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginbtn);

		
	}
	@Then("^user is on home page$")
	public void user_is_on_home_page() {
		WebElement userdisplay = driver.findElement(By.xpath("//span[@class='user-display']"));
		
		String username_onhomepage = userdisplay.getText();
	
		Assert.assertEquals("Bhaumik Gohel", username_onhomepage);
	  
	}
}
