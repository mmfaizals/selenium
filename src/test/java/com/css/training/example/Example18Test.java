package com.css.training.example;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.css.training.google.page.GoogleHomePage;
import com.css.training.google.page.GoogleSearchResultPage;
import com.css.training.wiki.page.WikiBiographyPage;
/**
 * 
 * Running this tests requires to set VM param <i>-DdriverName=firefox </i> in TestNG Run Configuration.
 * 
 * if you are running using maven use 
 * 
 * mvn -Dtest=Example18Test -DdriverName=firefox  clean test
 *
 */
public class Example18Test extends AbstractTest{
  @Test(dataProvider="dataForBiography",dataProviderClass=TestAutomationDataProvider.class,groups={"internet","practice"})
  public void findYoonaBirthDay(BiographySearchIO input) {
	  WebDriver driver = getDriver();
	  GoogleHomePage home = new GoogleHomePage(driver);
	  GoogleSearchResultPage result=home.search(input.qText);
	  sleep();
	  WikiBiographyPage wiki=result.clickWikiLinkContainsText(input.wikiLink);
	  String born=wiki.locateBornOn();
	  Assert.assertTrue((born.contains(input.born)));
  }
  
  @Test(dataProvider="dataForBiographyFromXls",dataProviderClass=TestAutomationDataProvider.class,groups={"internet","practice"})
  public void findCelebBirthDay(BiographySearchIO input) {
	  WebDriver driver = getDriver();
	  GoogleHomePage home = new GoogleHomePage(driver);
	  GoogleSearchResultPage result=home.search(input.qText.trim());
	  sleep();
	  WikiBiographyPage wiki=result.clickWikiLinkText(input.linkStarts.trim(),input.linkEnds.trim());
	  String born=wiki.locateBornOn();
	  Assert.assertTrue((born.contains(input.born.trim())));
  }
  private void sleep(){
	  try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
  }
}
