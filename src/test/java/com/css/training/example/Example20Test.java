package com.css.training.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
/**
 * 
 * Click a link that resides on bottom of the page , not visible on page load .
 *
 */
public class Example20Test {
	/**
	 * Sample usage of {@link WebDriverBackedSelenium}
	 */
	@Test
	public void clickPrivacyAndTermsUsingRC() {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setEnableNativeEvents(true);
		WebDriver driver = new FirefoxDriver(profile);
		driver.get("http://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		(new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By
						.id("resultStats")));
		Selenium sel = new WebDriverBackedSelenium(driver,
				"http://www.google.com/");
		String link = "link=Privacy & Terms";
		sel.click(link);
		driver.quit();
	}

	@Test
	public void clickPrivacyAndTermsUsingWebDriver() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		(new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By
						.id("resultStats")));
		WebElement ele = driver.findElement(By.linkText("Privacy & Terms"));
		ele.click();
		driver.quit();
	}
}
