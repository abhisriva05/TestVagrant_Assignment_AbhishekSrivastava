package com.TestVagrant.utility;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @ModuleName Utility
 * @CreationDate 02-08-2022
 * @Discription This class stores code which is repetitive through out the framework.
 * @author Abhishek Srivastava
 * 
 */
public class Utility {
	static WebDriver driver;
	Actions ac; 
	
	/**
	 * Instantiate WebDriver
	 * @param driver
	 */
	public Utility(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * @ModuleName waitForElementToAppear
	 * @CreationDate 02-08-2022
	 * @Discription This method will for element till visible.
	 * @param element
	 * @return void
	 * @version 1.0
	 */
	public static void waitForElementToAppear(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * @ModuleName scrollIntoView
	 * @CreationDate 03-08-2022
	 * @Discription This method will scroll to the specific element
	 * @param element
	 * @return void
	 * @version 1.0
	 */
	public static void scrollIntoView(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", (WebElement)element);
		
	}
	
	/**
	 * @ModuleName goTo
	 * @CreationDate 03-08-2022
	 * @Discription This method will navigate to the URL.
	 * @param url
	 * @return void
	 * @version 1.0
	 */
	public void goTo(String url) {
		driver.get(url);
	}

}
