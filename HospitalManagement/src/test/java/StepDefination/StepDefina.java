package StepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefina 
{
WebDriver driver;
@Given("open the browser and enter test url")
public void open_the_browser_and_enter_test_url() 
{
    System.setProperty("webdriver.geckodriver", "./Softwares/geckodriver.exe");
     driver=new FirefoxDriver();
     driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
     driver.get("https://www.facebook.com");
}

@Then("login page should be displayed")
public void login_page_should_be_displayed()
{
  String logtitle = driver.getTitle();
  Assert.assertEquals(logtitle,"Facebook-log in or sign up");
}

@When("enter valid username,valid password")
public void enter_valid_username_valid_password() throws InterruptedException 
{
	Thread.sleep(2000);
	driver.findElement(By.id("email")).sendKeys("vickydadannavar@gmail.com");
	Thread.sleep(2000);
	driver.findElement(By.id("pass")).sendKeys("9449287423");
	
    
}

@When("click on login button")
public void click_on_login_button() throws InterruptedException 
{
	Thread.sleep(2000);
	driver.findElement(By.name("login")).click();
}

@Then("Home page should be displayed")
public void home_page_should_be_displayed() 
{
	String hometitle = driver.getTitle();
   Assert.assertEquals(hometitle, "Facebook");
}

}
