package com.css.training.example;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class AbstractTest {

	private WebDriver driver;
	/**
	 * 
	 * gets the driver name as parameter, you can pass as as VM arg.
	 * @see Example18Test
	 */
	@BeforeClass
	@Parameters({ "driverName" })
	public void init(String driverName) {
		driver=Browser.getDriver(driverName);
	}

	@AfterClass
	public void destroy(){
		driver.quit();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}
