package com.qualitystream.tutorial;

import static org.junit.Assert.assertEquals;
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

public class GoogleSearchTest {
	Logger log = Logger.getLogger("GoogleSearchTest");
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
		driver.get("https://www.google.com/");
		WebElement searchhBox = driver.findElement(By.name("q"));
		searchhBox.clear();
		searchhBox.sendKeys(busqueda);
		searchhBox.submit();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		assertTrue(driver.getTitle().contains(busqueda));		
	}
	
	@After
	public void endTest() {
		log.info("Fin de prueba");
	}
	
	
}
