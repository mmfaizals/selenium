package com.css.training.google.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * Models google seach page 
 *
 */
public class GoogleHomePage {
	@FindBy(name="q")
	private WebElement textBox;
	@FindBy(name = "btnK")
	private WebElement button;
	private WebDriver driver;
	public GoogleHomePage(WebDriver driver){
		this.driver=driver;
		driver.get("http://www.google.com/webhp?complete=0&hl=en");
		PageFactory.initElements(driver, this);
	}
	/**
	 * Models google search , search the input text and returns {@link GoogleSearchResultPage}
	 */
	public GoogleSearchResultPage search(String text){
		textBox.sendKeys(text);
		textBox.sendKeys(Keys.RETURN);
		return new GoogleSearchResultPage(driver);
	}
}
