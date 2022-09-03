package com.TestVagrant.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestVagrant.utility.Utility;

/**
 * @ModuleName ImdbHomePage
 * @CreationDate 02-08-2022
 * @Discription This class has Page Factory web elements and POM implementation and extends utility class
 * @author Abhishek Srivastava
 * 
 */
public class ImdbHomePage extends Utility {
	WebDriver driver;
	
	/**
	 * Instantiate WebDriver
	 * @param driver
	 */
	public ImdbHomePage (WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name = "q")
	WebElement imdbSearchBox;
	
	@FindBy(xpath = "//ul[@role='listbox']/li/a/div[2]/div")
	List<WebElement> allDropDownOption;
	
	/**
	 * @ModuleName searchMovieInImdb
	 * @CreationDate 02-08-2022
	 * @Discription This method will search movie in IMDB search box.
	 * @param movieName
	 * @return void
	 * @version 1.0
	 */
	public void searchMovieInImdb(String movieName) {
		try {
			imdbSearchBox.sendKeys(movieName);
			for (int i = 0; i < allDropDownOption.size(); i++) {
				WebElement oneOption = allDropDownOption.get(i);
				String oneMovie = oneOption.getText();
				if (oneMovie.contains(movieName)) {
					oneOption.click();
				}
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
