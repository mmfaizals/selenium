package com.css.training.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Example13Test {

	@Test(groups={"local-file","practice"})
	public void selectSuperb(){
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///home/css95048/training/selenium/webserver/Example13.html");
		WebElement wishes = driver.findElement(By.cssSelector("div.wishes"));
		//Select
		WebElement superb = wishes.findElement(By.xpath("(input[@name='cars'])[1]"));
		superb.click();
		//de select it
//		WebElement superbGlobalXPath = wishes.findElement(By.xpath("(//input[@name='cars'])[4]"));
//		superbGlobalXPath.click();
		driver.quit();	
	}
}
