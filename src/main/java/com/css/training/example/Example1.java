package com.css.training.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Example1 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///home/css95048/training/mine/selenium-resource/webserver/Example1.html");
		WebElement box = driver.findElement(By.name("myName"));
		box.sendKeys("Selenium entered via Program");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElementValue(box, "Close"));
		driver.quit();
	}
}
