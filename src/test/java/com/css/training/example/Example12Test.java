package com.css.training.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Example12Test {

	@Test(groups={"local-file","practice"})
	public void selectTamil(){
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///home/css95048/training/selenium/webserver/Example12.html");
		WebElement select = driver.findElement(By.cssSelector("select"));
		Select sel = new Select(select);
		sel.selectByVisibleText("Tamil");
		List<WebElement> options=sel.getOptions();
		for(WebElement it:options){
			if(it.isSelected()){
				Assert.assertEquals(it.getText(),"Tamil");
				Assert.assertEquals(it.getAttribute("value"),"Tamil");
			}
		}
		driver.quit();
	}

}
