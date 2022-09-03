package com.TestVagrant.testCases;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @ModuleName BaseClass
 * @CreationDate 02-08-2022
 * @Discription This Base class has Before after Annotation to load configuration and to destroy after test method
 * @author Abhishek Srivastava
 * 
 */
public class BaseClass {
	
	public static WebDriver driver;
	public static String imdbUrl;
	public static String wikiUrl;
	public static String movieName;
	public static FileInputStream fis;
	public static Properties prop;
	String configFilePath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\TestVagrant\\config\\config.properties";
	
	/**
	 * @ModuleName loadConfiguration
	 * @CreationDate 02-08-2022
	 * @Discription This method will load the configuration and create the instance for ChromeDriver, FileInputStream, Properties file
	 * @return void
	 * @version 1.0
	 */
	@BeforeMethod
	public void loadConfiguration() throws Throwable {
		try {
			fis = new FileInputStream(configFilePath);
			prop = new Properties();
			prop.load(fis);
			imdbUrl = prop.getProperty("imdbUrl");
			wikiUrl = prop.getProperty("wikiUrl");
			movieName = prop.getProperty("movieName");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @ModuleName destroyConfiguration
	 * @CreationDate 02-08-2022
	 * @Discription This method will close the browser
	 * @return void
	 * @version 1.0
	 */
	@AfterMethod
	public void destroyConfiguration() throws Exception {
		try {
			//driver.close();
		} catch (Exception e) {
		} finally {
			driver.quit();;
		}
	}

}
