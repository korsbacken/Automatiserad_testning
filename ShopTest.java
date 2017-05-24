package se.iths.selenium_first_project;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopTest {
	
	//Local WebDriver
	protected ChromeDriver driver;
	//protected Select select;
	
	//WebDriver
	//protected WebDriver driver;
	
	@Before
	public void setup() throws MalformedURLException {
		
		//Local WebDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
        driver = new ChromeDriver();
       
		//Remote WebDriver
		//DesiredCapabilities capability = DesiredCapabilities.chrome();
        //capability.setBrowserName("chrome");
        //driver = new RemoteWebDriver( new URL("http://192.168.1.95:5566/wd/hub"), capability);
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
	}
	
	@Ignore
	@Test
	public void testGoToDeafaultStore() throws InterruptedException {

        driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/product/the-big-switch.html");
        WebElement element = driver.findElement(By.linkText("Default store"));
        element.click();
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        assertEquals("Shopizer Demo - Default store", driver.getTitle());
                
	}
	
	@Ignore
	@Test
	public void addItemToCart() throws InterruptedException {

        driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/product/the-big-switch.html");
        WebElement addToCart = driver.findElement(By.xpath("//*[@id='input-6']/div/button"));
        addToCart.click();
        Thread.sleep(1000);
        WebElement shoppingCart = driver.findElement(By.xpath("//*[@id='miniCartSummary']/span"));
        shoppingCart.click();
        Thread.sleep(1000);
        WebElement checkOut = driver.findElement(By.xpath("//*[@id='miniCartDetails']/li/div/a"));
        checkOut.click();
        Thread.sleep(1000);
        assertEquals("The Big Switch", driver.findElementByXPath("//*[@id='mainCartTable']/tbody/tr[1]/td[1]/div/div[2]/span/strong").getText());
        
	}
	
	@Ignore
	@Test
	public void removeItemFromCart() throws InterruptedException {
		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop/product/the-big-switch.html");
        driver.findElementByXPath("//*[@id='input-6']/div/button").click();
        Thread.sleep(1000);
        driver.findElementByXPath("//*[@id='miniCartSummary']/span").click();
        Thread.sleep(1000);
        driver.findElementByXPath("//*[@id='6']/td[4]/button").click();
        Thread.sleep(1000);
        driver.findElementByXPath("//*[@id='miniCartSummary']/span").click();
        assertEquals("check empty cart", "No items in your shopping cart", driver.findElementByXPath("//*[@id='miniCartDetails']/li/h4").getText());
	}
	
	@Ignore
	@Test
	public void registerAccount () throws InterruptedException {
		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop");
		Thread.sleep(1000);
		driver.findElementByXPath("//*[@id='customerAccount']/button/span").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//*[@id='registerLink']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//*[@id='firstName']").sendKeys("Sven");
		driver.findElementByXPath("//*[@id='lastName']").sendKeys("Svensson");
		new Select (driver.findElement(By.id("gender"))).selectByVisibleText("Male");
		new Select (driver.findElement(By.id("registration_country"))).selectByVisibleText("Sweden");
		driver.findElementByXPath("//*[@id='hidden_zones']").sendKeys("Örebro län");
		driver.findElementByXPath("//*[@id='userName']").sendKeys("SvenSvensson");
		driver.findElementByXPath("//*[@id='email']").sendKeys("svensvensson1@email.com"); //För varje testfall får man använda en ny mailadress. Detta går att göra i en loop på något sett men hann inte att göra detta.
		driver.findElementByXPath("//*[@id='password']").sendKeys("helloworld");
		driver.findElementByXPath("//*[@id='passwordAgain']").sendKeys("helloworld");
		driver.findElementByXPath("//*[@id='submitRegistration']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//*[@id='main-content']/div/div/div[1]/div/ul/li[2]/a").click();
		Thread.sleep(1000);
		String actualString = driver.findElement(By.xpath("//*[@id='main-content']/div/div[1]/div[1]")).getText();
		assertTrue(actualString.contains("Sven Svensson\nÖrebro län, Sweden"));
		
	}
	
	@Ignore
	@Test
	public void loginValidInformation() throws InterruptedException {
		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop");
		driver .findElementByXPath("//*[@id='customerAccount']/button/span").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//*[@id='signin_userName']").sendKeys("JohnDoe");
		driver.findElementByXPath("//*[@id='signin_password']").sendKeys("helloworld");
		driver.findElementByXPath("//*[@id='login-button']").click();
		Thread.sleep(4000);
		driver.findElementByXPath("//*[@id='customerAccount']/button/span").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//*[@id='customerAccount']/ul/li[1]/a").click();
		Thread.sleep(2000);
		assertEquals("check if logged in", "JOHN", driver.findElementByXPath("//*[@id='customerAccount']/button/span/span").getText());

	}
	
	@Ignore
	@Test
	public void loginInValidInformation () throws InterruptedException {
		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop");
		driver .findElementByXPath("//*[@id='customerAccount']/button/span").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//*[@id='signin_userName']").sendKeys("testing");
		driver.findElementByXPath("//*[@id='signin_password']").sendKeys("testing");
		driver.findElementByXPath("//*[@id='login-button']").click();
		Thread.sleep(1000);
		String actualString = driver.findElement(By.xpath("//*[@id='loginError']")).getText();
		assertTrue(actualString.contains("Login Failed. Username or Password is incorrect."));
		
	}
	
	@Ignore
	@Test
	public void searchFunction() throws InterruptedException {
		driver.get("http://jenkins2017.westeurope.cloudapp.azure.com:8080/shop");
		driver.findElementByXPath("//*[@id='searchField']").sendKeys("spring in action");
		driver.findElementByXPath("//*[@id='header-top-second']/div/div[2]/button/span").click();
		Thread.sleep(2000);
		String actualString = driver.getPageSource();
		assertTrue(actualString.contains("search results"));
	}
	
	
	@After
	public void endTest() {
		driver.quit();
	}
}
