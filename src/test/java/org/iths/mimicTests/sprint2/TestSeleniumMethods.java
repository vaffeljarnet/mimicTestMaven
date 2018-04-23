package org.iths.mimicTests.sprint2;

import org.junit.Test;

public class TestSeleniumMethods {

	//@Test
	public void test() {
		SeleniumMethods driver = new SeleniumMethods();
		driver.openURL("http://www.ikea.se"); 
		driver.clickLink();
		driver.delay(2000);
		driver.quitSelenium();
	}	  

}
