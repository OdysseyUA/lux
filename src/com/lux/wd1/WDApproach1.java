package com.lux.wd1;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.internal.ProfilesIni;




public class WDApproach1 {
		
	ProfilesIni profile = new ProfilesIni();	
	WebDriver driver = new FirefoxDriver(profile.getProfile("hw"));
	
	@Before
	public void setUp(){
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://dev05.dev.hotwire.com:7002/ccc/loginPage");
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
	@Test
	public void test1(){
		driver.findElement(By.xpath(".//*[@id='userName']")).sendKeys("csrcroz1");
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("Admin1234!");
		driver.findElement(By.xpath(".//*[@value='Login']")).click();
		
		
		driver.findElement(By.xpath(".//*[@id='mainMenuContainer']/ul/li[2]/a/span")).click();
		System.out.println("test");
		driver.findElement(By.xpath(".//*[@id='emailAddress']")).sendKeys("ansnitko@gmail.com");
		driver.findElement(By.xpath(".//*[@name='Submit']")).click();
		
		assertEquals("Anastasiia A Snitko", driver.findElement(By.xpath(".//*[@id='listHolder']/ul/li[1]/span[2]")).getText());
	}
	
	
}
