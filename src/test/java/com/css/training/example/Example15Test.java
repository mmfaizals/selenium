package com.css.training.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Example15Test {
	/**
	 * Locate an element using custom html attribute.
	 */
	@Test(groups={"local-file","practice"})
	public void doYouKnowToSwim() {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///home/css95048/training/selenium/webserver/Example15.html");
		WebElement box = driver.findElement(By
				.xpath("//*[@myEleId='neverChange3']"));
		box.sendKeys("Selenium entered via Program");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElementValue(box,
				"Close"));
		driver.quit();
	}
}
