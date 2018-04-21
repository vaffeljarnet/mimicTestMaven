package org.iths.mimicTests.sprint2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelenium {

	
	private WebDriver webdriver;

	public TestSelenium() {
		System.setProperty("webdriver.chrome.driver", "commonFiles/webDriver/chromedriver.exe");
		webdriver = new ChromeDriver();
		webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void openURL(String siteURL) {
		webdriver.get(siteURL);
	}  
	
	public void clickLink() {
		WebElement element = webdriver.findElement(By.cssSelector("div.right-section-container > ul:nth-of-type(1) > li > a.arrowLink"));
		element.click();
	}
	
	public void delay(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
			}
			catch (InterruptedException a) {
			}
	}
	
	public void quitSelenium() {
		webdriver.quit();
	}
	
}
