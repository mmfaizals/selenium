package com.css.training.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Example3 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///home/css95048/training/selenium/webserver/Example3.html");
		WebElement box = driver.findElement(By.xpath("//html/body/input"));
		box.sendKeys("Rain");
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.textToBePresentInElementValue(box, "quit"));
		driver.quit();
	}
}
