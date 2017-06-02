package com.css.training.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.base.Predicate;

public class Example09Test {

	private static final class ExpectedUrl implements Predicate<WebDriver> {

		public boolean apply(WebDriver driver) {
			String url = driver.getCurrentUrl();
			if ("file:///home/css95048/training/selenium/webserver/Example9.html#"
					.equals(url)) {
				return true;
			} else {
				return false;
			}
		}
	}

	@Test(groups = { "local-file", "practice" })
	public void testExample9() {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///home/css95048/training/selenium/webserver/Example9.html");
		WebElement link = driver.findElement(By.partialLinkText("long text"));
		link.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(new ExpectedUrl());
		driver.quit();
	}
}
