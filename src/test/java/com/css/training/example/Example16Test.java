package com.css.training.example;

import java.util.List;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Example16Test {

	@Test
	public void searchGoogle() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("yoonah");
		driver.findElement(By.name("q")).submit();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		ExpectedCondition<WebElement> expect = ExpectedConditions
				.presenceOfElementLocated(By.partialLinkText("Im Yoona - Wiki"));
		WebElement wikiLink = wait.until(expect);
		Assert.assertEquals(wikiLink.getAttribute("href"), "http://en.wikipedia.org/wiki/Im_Yoona");
		wikiLink.click();
		new WebDriverWait(driver, 50).until(new WikiLoaded());
		WebElement infoTable=driver.findElement(By.cssSelector("table.infobox.vcard.plainlist"));
		List<WebElement> rows = infoTable.findElements(By.tagName("tr"));
		WebElement bornOn=null;
		for(WebElement it:rows){
			boolean th=it.findElements(By.tagName("th")).size()!=0;
			if(th){
				WebElement bornTH = it.findElement(By.tagName("th"));
				String text=bornTH.getText();
				if(text.equals("Born")){
					bornOn=it.findElement(By.tagName("td"));
				}
			}
		}
		String date=bornOn.getText();
		Assert.assertTrue(date.contains("May 30, 1990"));
		//when you are limited by testng assert use org.hamcrest
		MatcherAssert.assertThat(date, CoreMatchers.containsString("May 30, 1990"));
	}
}
