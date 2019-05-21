package com.automationpractice.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	
	//declare WebDriver and Properties files as public static so that classes in other packages can inherit them
	public static WebDriver driver;
	public static Properties prop;

	public BaseClass() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("/home/dhawal/eclipse-workspace/GitPOM/POM/src/main/java/com/automationpractice/config/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void init() { //To initialize the driver and fetch values stored in properties file
		String browserName = prop.getProperty("browser"); //This will store "chrome" in browserName variable
		if(browserName.equals("chrome")) {
			 System.setProperty("webdriver.chrome.driver", "/home/dhawal/selenium jars/chromedriver");
			 driver = new ChromeDriver(); //driver value is initialized here
		}
		
		driver.manage().window().maximize(); //maximize the browser
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS); //define default page time out. Till this time selenium will wait for the element
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
