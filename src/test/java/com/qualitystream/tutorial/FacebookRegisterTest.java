package com.qualitystream.tutorial;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookRegisterTest {
	Logger log = Logger.getLogger("FacebookRegisterTest");
	private WebDriver driver;
	
	@Before
	public void setUp() {
		log.info("Iniciar prueba de log");
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();		
	}
	
	@Test
	public void testGoogleTest() {
		String busqueda = "Omar Munguia Rivera";
		driver.get("https://www.facebook.com/campaign/landing.php");
		WebElement firstname = driver.findElement(By.name("firstname"));
		firstname.clear();
		firstname.sendKeys("Luis");
		
		WebElement lastname = driver.findElement(By.name("lastname"));
		lastname.clear();
		lastname.sendKeys("Lopez");
		
		WebElement email = driver.findElement(By.name("reg_email__"));
		email.clear();
		email.sendKeys("evaristolopez@gmail.com");
		
		WebElement pass = driver.findElement(By.name("reg_passwd__"));
		pass.clear();
		pass.sendKeys("eva05");
		
		Select dd = new Select(driver.findElement(By.name("birthday_day")));
		dd.selectByVisibleText("4");
		
		Select mm = new Select(driver.findElement(By.name("birthday_month")));
		mm.selectByVisibleText("abr");
		
		Select yyyy = new Select(driver.findElement(By.name("birthday_year")));
		yyyy.selectByVisibleText("1988");
		
		//searchhBox.submit();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//System.out.println(driver.getTitle());
		assertTrue(true);		
	}
	
	@After
	public void endTest() {
		log.info("Fin de prueba");
	}
	
	
}
