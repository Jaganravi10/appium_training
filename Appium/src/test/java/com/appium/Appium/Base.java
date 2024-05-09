package com.appium.Appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Base {
	
	AndroidDriver driver;
	
	@Test
	public void configuration() throws MalformedURLException {
		
	DesiredCapabilities capabilities = new DesiredCapabilities();
	
	capabilities.setCapability("platformName", "android");
	capabilities.setCapability("platformVersion", "13");
	capabilities.setCapability("deviceName", "Pixel 7 pro");
	capabilities.setCapability("app","C:\\Users\\Guest_Jagan\\eclipse-workspace\\Appium\\resources\\ApiDemos-debug.apk");
		
	driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	
	}

}
