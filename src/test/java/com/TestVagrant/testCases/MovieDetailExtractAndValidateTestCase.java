package com.TestVagrant.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.TestVagrant.pageObjects.ImdbHomePage;
import com.TestVagrant.pageObjects.ImdbMovieDetailPage;
import com.TestVagrant.pageObjects.WikipediaHomePage;
import com.TestVagrant.pageObjects.WikipediaMovieDetailPage;
import com.TestVagrant.utility.Utility;

/**
 * @ModuleName MovieDetailExtractAndValidate
 * @CreationDate 03-08-2022
 * @Discription This Test class has test method to extract data and perform validation.
 * @author Abhishek Srivastava
 * 
 */
public class MovieDetailExtractAndValidateTestCase extends BaseClass {
	
	ImdbHomePage imdbHomePage;
	ImdbMovieDetailPage imdbMovieDetails;
	WikipediaHomePage wikiHomePage;
	WikipediaMovieDetailPage wikiMovieDetails;
	
	Utility utils;
	
	
	
	/**
	 * @ModuleName Extract_ReleaseDate_Country_And_Validate
	 * @CreationDate 03-08-2022
	 * @Discription This module will extract release date & country of origin from IMDB, Wiki and compares the data.
	 * @version 1.0
	 */
	@Test
	public void Extract_ReleaseDate_Country_And_Validate() throws Throwable {
		
		try {
			imdbHomePage = new ImdbHomePage(driver);
			imdbMovieDetails = new ImdbMovieDetailPage(driver);
			wikiHomePage = new WikipediaHomePage(driver);
			wikiMovieDetails = new WikipediaMovieDetailPage(driver);
			utils = new Utility(driver);
			utils.goTo(imdbUrl);
			imdbHomePage.searchMovieInImdb(movieName);
			String releaseDateInImdb = imdbMovieDetails.getMovieReleaseDateInImdb();
			String movieCountryInImdb = imdbMovieDetails.getCountryOfmovieInImdb();
			System.out.println("IMDB " + "--> " + movieName + " --> " + "Release Date " + "[ " + releaseDateInImdb
					+ " ] " + "&" + " Country Origin " + "[ " + movieCountryInImdb + " ]");
			utils.goTo(wikiUrl);
			wikiHomePage.searchMovieInWikipedia(movieName);
			String releaseDateInWiki = wikiMovieDetails.getMovieReleaseDateInWiki();
			String movieCountryInWiki = wikiMovieDetails.getCountryOfmovieInWiki();
			System.out.println("Wiki " + "--> " + movieName + " --> " + "Release Date " + "[ " + releaseDateInWiki
					+ " ] " + "&" + " Country Origin " + "[ " + movieCountryInWiki + " ]");
			
			Assert.assertEquals(movieCountryInImdb, movieCountryInWiki, 
					" Assert Failed : Country origin of movie " + movieName + " is different in IMDB & Wiki");
			System.out.println("Country origin of movie " + movieName + " is same in IMDB & Wiki");
			
			Assert.assertEquals(releaseDateInImdb, releaseDateInWiki, 
					" Assert Failed : Release date of movie " + movieName + " is different in IMDB & Wiki");
			System.out.println("Release date of movie " + movieName + " is same in IMDB & Wiki");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
