package com.css.training.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.base.Predicate;

public class WikiLoaded implements Predicate<WebDriver> {

	public boolean apply(WebDriver driver) {
		boolean present = driver.findElements(By.id("siteSub")).size() != 0;
		if(present){
			WebElement ele =driver.findElement(By.id("siteSub"));
			String text=ele.getText();
			if(text.equals("From Wikipedia, the free encyclopedia")){
				return true;
			}
		}
		return false;
	}

}
