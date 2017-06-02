package com.css.training.google.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.css.training.wiki.page.WikiBiographyPage;

/**
 * 
 * Models google search result page
 *
 */
public class GoogleSearchResultPage {
	private WebDriver driver;

	public GoogleSearchResultPage(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * models click event of Wiki link with partial link text, onClick returns {@link WikiBiographyPage}
	 */
	public WikiBiographyPage clickWikiLinkContainsText(String partialLinkText) {
		(new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By
						.id("resultStats")));
		List<WebElement> links = driver.findElements(By
				.xpath("//*[@id='rso']//h3/a"));
		for (WebElement it : links) {
			System.out.println(it.getText());
			if (it.getText().contains(partialLinkText)) {
				it.click();
				break;
			}
		}
		return new WikiBiographyPage(driver);
	}
	/**
	 * models click event of Wiki link with prefix & suffix of the link, onClick returns {@link WikiBiographyPage}
	 */
	public WikiBiographyPage clickWikiLinkText(String prefix,String suffix) {
		(new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By
						.id("resultStats")));
		List<WebElement> links = driver.findElements(By
				.xpath("//*[@id='rso']//h3/a"));
		for (WebElement it : links) {
			System.out.println(it.getText());
			if (it.getText().startsWith(prefix) && it.getText().endsWith(suffix)) {
				it.click();
				break;
			}
		}
		return new WikiBiographyPage(driver);
	}
	/**
	 * returns the href(url) of the link 
	 */
	public String hrefWikiLinkContainsText(String partialLinkText) {
		WebElement link = driver.findElement(By
				.partialLinkText(partialLinkText));
		return link.getAttribute("href");
	}
}
