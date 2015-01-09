package com.lux.wd1;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.internal.ProfilesIni;




public class WDApproach1 {
	
	private By byXpath = 
			By.xpath(".//*[@id='mainMenuContainer']/ul//span[substring(., string-length() -6) = 'Search']");
		
	static ProfilesIni profile = new ProfilesIni();	
	static WebDriver driver = new FirefoxDriver(profile.getProfile("hw"));
	
	@BeforeClass
	public static void setUp(){
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://dev05.dev.hotwire.com:7002/ccc/loginPage");
		//driver.manage().window().maximize();
		driver.manage().window().setPosition(new Point(0,0));
		driver.manage().window().setSize(new Dimension(960, 1035));
		
		
		driver.findElement(By.xpath(".//*[@id='userName']")).sendKeys("csrcroz1");
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("Admin1234!");
		driver.findElement(By.xpath(".//*[@value='Login']")).click();
	}
	
	@AfterClass
	public static void tearDown(){
		driver.quit();
	}
	
	
	
	
	@Test
	public void test1() {
		
		driver.switchTo().frame("c3Frame");

		
		if(driver.findElements(byXpath).size()!=0){
			driver.findElement(byXpath).click();
		}
		else{			
			System.out.println("No such element!");
			return;
		}
			
		
		
		driver.findElement(By.xpath(".//*[@id='emailAddress']")).sendKeys("ansnitko@gmail.com");
		driver.findElement(By.xpath(".//*[@name='Submit']")).click();
		
		assertEquals("Anastasiia A Snitko", driver.findElement(By.xpath(".//*[@id='listHolder']/ul/li[1]/span[2]")).getText());
		
		driver.switchTo().defaultContent();
	}
	
	
	@Test
	public void test2() {
						
		driver.switchTo().frame("c3Frame");

		assertTrue(driver.findElements(By.xpath(".//*[@id='tileName-A1']/table/tbody/tr/td/table[2]/tbody/tr/td[2]/div/div[3]")).size()!=0);			
		
		driver.switchTo().defaultContent();
	}
	
	
}
