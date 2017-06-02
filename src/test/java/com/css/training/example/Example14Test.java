package com.css.training.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Example14Test {

	@Test(groups={"local-file","practice"})
	public void doYouKnowToSwim(){
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///home/css95048/training/selenium/webserver/Example14.html");
		List<WebElement> labels = driver.findElements(By.xpath("//label"));
		WebElement labelNo=null;
		for(WebElement it:labels){
			if("I can't Swim".equals(it.getText())){
				labelNo=it;
			}
		}
		Assert.assertNotNull(labelNo);
		String attribValue= labelNo.getAttribute("for");
		String xpath=String.format("//input[@name='Skill' and @id='%s']",attribValue);
		WebElement checkBoxNo=driver.findElement(By.xpath(xpath));
		checkBoxNo.click();
		driver.quit();	
	}
}
