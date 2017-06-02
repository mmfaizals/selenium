package com.css.training.wiki.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * 
 * models wiki page
 *
 */
public class WikiBiographyPage {
	private WebDriver driver;

	public WikiBiographyPage(WebDriver driver) {
		this.driver = driver;
	}
	/**
	 * Locates text "Born" then finds the birth info 
	 * @return
	 */
	public String locateBornOn(){
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
		 return bornOn.getText();
	}
}
