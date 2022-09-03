package com.TestVagrant.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestVagrant.utility.Utility;

/**
 * @ModuleName WikipediaHomePage
 * @CreationDate 03-08-2022
 * @Discription This class has Page Factory web elements and POM implementation and extends utility class
 * @author Abhishek Srivastava
 * 
 */
public class WikipediaHomePage extends Utility {
	WebDriver driver;
	
	/**
	 * Instantiate WebDriver
	 * @param driver
	 */
	public WikipediaHomePage (WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(id = "searchInput")
	WebElement wikiSearchBox;

	@FindBy(xpath = "//a[@class='suggestion-link']/div/h3")
	List<WebElement> allDropDownOptions;
	
	/**
	 * @ModuleName searchMovieInWikipedia
	 * @CreationDate 03-08-2022
	 * @Discription This method will search movie in Wiki search box.
	 * @param movieName
	 * @return void
	 * @version 1.0
	 */
	public void searchMovieInWikipedia(String movieName) throws Throwable {
		try {
			wikiSearchBox.sendKeys(movieName);
			for (int i = 0; i < allDropDownOptions.size(); i++) {
				WebElement oneOption = allDropDownOptions.get(i);
				String oneMovie = oneOption.getText();
				if (oneMovie.contentEquals(movieName)) {
					oneOption.click();
				}
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}
