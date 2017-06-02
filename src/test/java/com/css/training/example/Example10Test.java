package com.css.training.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Example10Test {
	@Test(groups={"local-file","practice"})
	  public void testExample10() {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///home/css95048/training/selenium/webserver/Example10.html");
		WebElement column = driver.findElement(By.cssSelector("table  tr:nth-child(2) td:nth-child(1)"));
		System.out.println(column.getTagName()+"-->"+column.getText());
		driver.quit();
	}
}
