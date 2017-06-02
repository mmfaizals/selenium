package sample.headless;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class ExampleHeadless {

	public static void main(String a[])

	{

		// Declaring and initialising the HtmlUnitWebDriver

		WebDriver unitDriver = new HtmlUnitDriver();

		// open google.com webpage

		unitDriver.get("https://www.google.com");

		System.out.println("Title of the page is -> " + unitDriver.getPageSource());

		// unitDriver.quit();

	}

}