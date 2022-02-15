package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public Properties prop;
	public WebDriver driver;
	OptionsManager om = new OptionsManager();
	public static String highlight;

	// ThreadLocal class gives two method to set and get the value
	ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();

	/**
	 * this method is to open browser and returns driver
	 * 
	 * @param prop
	 * @return driver
	 */
	public WebDriver init_driver(Properties prop) {

		String BrowserName = prop.getProperty("browser");
		highlight = prop.getProperty("highlight");

		System.out.println("The browser value is " + BrowserName);
		if (BrowserName.equals("chrome")) {
			
 WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver(om.getChromeOptions(prop)));
		} else if (BrowserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver(om.getFireFoxOptions(prop)));
		} else if (BrowserName.equals("safari")) {
			WebDriverManager.safaridriver().setup();
			tldriver.set(new SafariDriver());
		} else {
			System.out.println("Please check the Browser Name" + BrowserName);
		}
		getDriver().manage().window().fullscreen();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));
		return getDriver();
	}

	public synchronized WebDriver getDriver() {
		return tldriver.get();
	}

	/*
	 *
	 * this returns the property reference
	 * 
	 * @return
	 */
	public Properties init_prop() {
		prop = new Properties();
		String env = System.getProperty("env");

		FileInputStream io = null;

		if (env == null) {
			try {
				System.out.println("Running in prod environment.........");
				io = new FileInputStream("./src/main/java/com/qa/opencart/config/config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		} else {

			switch (env.toLowerCase()) {
			case "build":
				try {
					io = new FileInputStream("./src/main/java/com/qa/opencart/config/build.properties");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				break;

			case "dev":
				try {
					io = new FileInputStream("./src/main/java/com/qa/opencart/config/dev.properties");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				break;

			default:
				System.out.println("Please check the enviroment :" + env);
				break;
			}

		}

		try {
			prop.load(io);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

	/*
	 * get Screenshot method
	 */

	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;

	}
	}
