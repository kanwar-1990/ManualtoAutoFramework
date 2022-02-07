package com.qa.opencart.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {

	private ChromeOptions co;
	private FirefoxOptions fo;

	public ChromeOptions getChromeOptions(Properties prop) {
		co = new ChromeOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless")))// Boxing
			co.addArguments("--headless");
		if (Boolean.parseBoolean(prop.getProperty("incognito")))
			co.addArguments("--incognito");

		return co;

	}

	public FirefoxOptions getFireFoxOptions(Properties prop) {
		fo = new FirefoxOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless")))
			fo.addArguments("--headless");
		if (Boolean.parseBoolean(prop.getProperty("incognito")))
			fo.addArguments("--incognito");

		return fo;

	}

}
