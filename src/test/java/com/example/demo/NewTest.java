package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTest {
	@Test
	public void TestChomer() {
		String title = "Cao đang thuc hanh";
		System.setProperty("webdriver.chrome.driver", "D:/FPT/kiemthunangcao/chromedriver_win32/");
		
		WebDriver driver = new ChromeDriver();
		String url = "https://ap.poly.edu.vn/";
		driver.get(url);
		String actualTitle = driver.getTitle();
		
		Assertions.assertEquals(title, actualTitle);
		driver.close();
	}
}
