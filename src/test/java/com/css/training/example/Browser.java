package com.css.training.example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Browser {

	public static WebDriver fireFox(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		return driver;
	}
	
	public static WebDriver fireFox(FirefoxProfile profile){
		WebDriver driver = new FirefoxDriver(profile);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		return driver;
	}
	
	public static WebDriver chromDriver(){
		System.setProperty("webdriver.chrome.driver", "/home/css95048/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		return driver;
	}
	
	public static WebDriver getDriver(String name){
		WebDriver driver = null;
		switch(name){
		case "firefox":
			driver=fireFox();
			break;
		case "chrome":
			driver=chromDriver();
			break;
		default:
			driver=fireFox();
			break;
		}
		return driver;
	}
}

