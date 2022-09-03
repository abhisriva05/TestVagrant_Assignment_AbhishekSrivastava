package com.TestVagrant.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestVagrant.utility.Utility;

/**
* @ModuleName WikipediaMovieDetailPage
* @CreationDate 02-08-2022
* @Discription This class has Page Factory web elements and POM implementation and extends utility class
* @author Abhishek Srivastava
* 
*/
public class WikipediaMovieDetailPage extends Utility {
	WebDriver driver;
	
	/**
	 * Instantiate WebDriver
	 * @param driver
	 */
	public WikipediaMovieDetailPage (WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//th[.='Directed by']")
	WebElement directedBy;

	@FindBy(xpath = "//th[@scope='row' and .='Release date']/following-sibling::td/div/ul/li")
	WebElement releaseDate;
	
	@FindBy(xpath = "//th[.='Country']/following-sibling::td")
	WebElement countryOrigin;
	
	/**
	 * @ModuleName getMovieReleaseDateInWiki
	 * @CreationDate 03-08-2022
	 * @Discription This method will fetch release date of movie in Wiki.
	 * @return String
	 * @version 1.0
	 */
	public String getMovieReleaseDateInWiki() {
		String date = "";
		try {
			Utility.waitForElementToAppear(directedBy);
			Utility.scrollIntoView(directedBy);
			Utility.waitForElementToAppear(releaseDate);
			date = releaseDate.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * @ModuleName getCountryOfmovieInWiki
	 * @CreationDate 03-08-2022
	 * @Discription This method will fetch country origin of movie in Wiki.
	 * @return String
	 * @version 1.0
	 */
	public String getCountryOfmovieInWiki() {
		String country = "";
		try {
			Utility.waitForElementToAppear(countryOrigin);
			country = countryOrigin.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return country;
	}

}
