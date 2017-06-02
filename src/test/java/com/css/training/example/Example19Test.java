package com.css.training.example;

import junit.framework.Assert;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class Example19Test {
	/**
	 * Run the browser in German
	 */
	@Test
	public void testGermanFacebook() {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("intl.accept_languages", "de");
		WebDriver driver = new FirefoxDriver(profile);
		driver.get("http://facebook.com");
		Selenium seln = new WebDriverBackedSelenium(driver,
				"http://facebook.com");
		boolean reg = seln.isTextPresent("Registrieren");
		Assert.assertTrue(reg);
		String bodyText = driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue(bodyText.contains("Registrieren"));
		driver.quit();
	}

	/**
	 * run the browser in french
	 */
	@Test
	public void testFrenchFacebook() {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("intl.accept_languages", "fr");
		WebDriver driver = new FirefoxDriver(profile);
		driver.get("http://facebook.com");
		Selenium seln = new WebDriverBackedSelenium(driver,
				"http://facebook.com");
		boolean reg = seln.isTextPresent("Registrieren");
		Assert.assertTrue(reg);
		String bodyText = driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue(bodyText.contains("Inscription"));
		MatcherAssert.assertThat(bodyText,
				CoreMatchers.containsString("Inscription"));
		driver.quit();
	}
}
