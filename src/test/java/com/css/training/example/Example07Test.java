package com.css.training.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Example07Test {
	@Test(groups={"local-file","practice"})
	  public void testExample7() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///home/css95048/training/selenium/webserver/Example7.html");
		WebElement box = driver.findElement(By.tagName("input"));
		box.sendKeys("Rain");
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.textToBePresentInElementValue(box, "quit"));
		driver.quit();
	}
}
