package com.css.training.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Example11Test {
	@Test(groups={"local-file","practice"})
  public void testExample11() {
	  WebDriver driver = new FirefoxDriver();
		driver.get("file:///home/css95048/training/selenium/webserver/Example11.html");
		WebElement cell = driver.findElement(By.cssSelector("table:nth-child(2)  tr:nth-child(2) td:nth-child(1)"));
		Assert.assertEquals(cell.getText(), "Pizza");
		driver.quit();
  }
}
