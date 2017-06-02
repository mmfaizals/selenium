package com.css.training.example;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.css.training.google.page.GoogleHomePage;
import com.css.training.google.page.GoogleSearchResultPage;
import com.css.training.wiki.page.WikiBiographyPage;

public class Example17Test {
	@Test(groups={"internet","practice"})
  public void findYoonaBirthDay() {
	  WebDriver driver = Browser.fireFox();
	  GoogleHomePage home = new GoogleHomePage(driver);
	  GoogleSearchResultPage result=home.search("yoona");
	  WikiBiographyPage wiki=result.clickWikiLinkContainsText("Im Yoona - Wiki");
	  String born=wiki.locateBornOn();
	  Assert.assertEquals(born,"May 30, 1990 (age 24)");
  }
}
