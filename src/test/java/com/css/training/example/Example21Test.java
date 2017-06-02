package com.css.training.example;

import java.util.Set;

import org.openqa.selenium.internal.Base64Encoder;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.DefaultCredentialsProvider;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.util.Cookie;

public class Example21Test {
	@Test
	public void f() throws Exception {
		WebClient webClient = new WebClient();
		setCredentials(webClient);
//		DefaultCredentialsProvider creds = new DefaultCredentialsProvider();
//		creds.addCredentials("css95048", "kwanyuri!23");
//		webClient.setCredentialsProvider(creds);
		Page page = webClient.getPage("http://kms.csscorp.com/");
		Set<Cookie> cookies = webClient.getCookieManager().getCookies();
		for (Cookie it : cookies) {
			System.out.println(it.getName() + ":" + it.getValue());
		}
	}

	private static void setCredentials(WebClient webClient) {
		String username = "css95048";
		String password = "kwanyuri!23";
		String base64encodedUsernameAndPassword = base64Encode(username + ":"
				+ password);
		webClient.addRequestHeader("Authorization", "Basic "
				+ base64encodedUsernameAndPassword);
	}

	private static String base64Encode(String stringToEncode) {
		Base64Encoder encode=new Base64Encoder();
		return encode.encode(stringToEncode.getBytes());
	}
}
