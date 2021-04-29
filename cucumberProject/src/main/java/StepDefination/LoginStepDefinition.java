package StepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepDefinition{

	 WebDriver driver;

	
	 @Given("^user is already on Login Page$")
	 public void user_already_on_login_page(){
	 WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 driver.get("https://login.salesforce.com/");
	 }
	
	
	 @When("^title of login page is Salesforce$")
	 public void title_of_login_page_is_Salesforce() throws Throwable {
	 String title = driver.getTitle();
	 System.out.println(title);
	 Assert.assertEquals("Login | Salesforce", title);
	 }
	
	 //Reg Exp:
	 //1. \"([^\"]*)\"
	 //2. \"(.*)\"
	
	 @Then("^user enters \"(.*)\" and \"(.*)\"$")
	 public void user_enters_username_and_password(String username, String password){
	 driver.findElement(By.id("username")).sendKeys(username);
	 driver.findElement(By.id("password")).sendKeys(password);
	 }
	
	 @Then("^user clicks on login button$")
	 public void user_clicks_on_login_button() throws InterruptedException {
	 WebElement loginBtn = driver.findElement(By.id("Login"));
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	 js.executeScript("arguments[0].click();", loginBtn);
	 }
	 @Then("^user is on home page$")
	 public void user_is_on_hopme_page(){
	 String title = driver.getTitle();
	 System.out.println("Home Page title ::"+ title);
	 Assert.assertEquals("Home Page ~ Salesforce - Developer Edition", title);
	 }
	 @Then("^close the browser$")
	 public void close_the_browser()  {
	     // Write code here that turns the phrase above into concrete actions
	     driver.close();
	 }
	
	
	

}
