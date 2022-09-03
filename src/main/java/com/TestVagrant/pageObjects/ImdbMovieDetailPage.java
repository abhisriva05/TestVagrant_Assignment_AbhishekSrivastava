package com.TestVagrant.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestVagrant.utility.Utility;

/**
 * @ModuleName ImdbMovieDetailPage
 * @CreationDate 02-08-2022
 * @Discription This class has Page Factory web elements and POM implementation and extends utility class
 * @author Abhishek Srivastava
 * 
 */
public class ImdbMovieDetailPage extends Utility {
	WebDriver driver;
	
	/**
	 * Instantiate WebDriver
	 * @param driver
	 */
	public ImdbMovieDetailPage (WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[.='Details']")
	WebElement movieDetails;

	@FindBy(xpath = "//a[.='Release date']/ancestor::li[@data-testid='title-details-releasedate']//li/a")
	WebElement releaseDate;

	@FindBy(xpath = "//span[.='Country of origin']/ancestor::li[@data-testid='title-details-origin']//div//a")
	WebElement originCountry;


	/**
	 * @ModuleName getMovieReleaseDateInImdb
	 * @CreationDate 02-08-2022
	 * @Discription This method will fetch release date of movie in IMDB
	 * @return String
	 * @version 1.0
	 */
	public String getMovieReleaseDateInImdb() {
		String date = "";
		try {
			Utility.waitForElementToAppear(movieDetails);
			Utility.scrollIntoView(movieDetails);
			Utility.waitForElementToAppear(releaseDate);
			date = releaseDate.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * @ModuleName getCountryOfmovieInImdb
	 * @CreationDate 02-08-2022
	 * @Discription This method will fetch country origin of movie in IMDB
	 * @return String
	 * @version 1.0
	 */
	public String getCountryOfmovieInImdb() {
		String country = "";
		try {
			Utility.waitForElementToAppear(originCountry);
			country = originCountry.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return country;
	}
}
