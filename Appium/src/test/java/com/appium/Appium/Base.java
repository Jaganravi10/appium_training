package com.appium.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class Base {
	
	public static AppiumDriverLocalService service;
	public static String nodeExePath = "C:\\Program Files\\nodejs\\node.exe";
	public static String nodeMainJsPath = "C:\\Users\\Guest_Jagan\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"; 
	public static String serverAddress = "127.0.0.1";	
	
	@BeforeTest
	public void startServer() throws MalformedURLException {
		
		service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File("nodeExePath"))
				.withAppiumJS(new File("nodeMainJsPath"))
				.withIPAddress("serverAddress")
				.withArgument(GeneralServerFlag.BASEPATH, "/wd/hub")
				.usingPort(4723).withLogFile(new File("C:\\Users\\Guest_Jagan\\Desktop\\AppiumServerLog.txt")));
				
		System.out.println("Starting server");
		
		service.start();
		
	}
		
	@Test
	public void startSession() throws MalformedURLException {
	
	DesiredCapabilities capabilities = new DesiredCapabilities();
				
	capabilities.setCapability("platformName", "android");
	capabilities.setCapability("platformVersion", "13");
	capabilities.setCapability("deviceName", "emulator-5554");
	capabilities.setCapability("app","C:\\Users\\Guest_Jagan\\git\\repository\\Appium\\resources\\ApiDemos-debug.apk");
	
	AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub/"),capabilities);
	
	}
	
	@AfterTest
	public void stopService() {
		
		if(service.isRunning()==true) {
			
			service.stop();
			
			System.out.println("Service stopped");
		}
		
		
	}
		
}
