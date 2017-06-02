package so;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class AddCookieTest {
	@Test
	public void f() {
		FirefoxDriver driver = new FirefoxDriver();
		String webpage = "http://www.google.co.in";
		driver.get(webpage);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Cookie ck = new Cookie("nativeApp", "os=Android|cv=1|sv=1|id=0",
				"google.co.in", "/", null, true);
		driver.manage().addCookie(ck);
		Cookie result = driver.manage().getCookieNamed("nativeApp");
		System.out.println(result);
	}
}
