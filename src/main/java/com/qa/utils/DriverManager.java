package com.qa.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Capabilities;

import java.io.IOException;
import java.net.URL;

public class DriverManager {
    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    TestUtils utils = new TestUtils();

    public AppiumDriver getDriver(){
        return driver.get();
    }

    public void setDriver(AppiumDriver driver2){
        driver.set(driver2);
    }

    public void initializeDriver() throws Exception {
        AppiumDriver driver = null;
        GlobalParams params = new GlobalParams();
        PropertyManager props = new PropertyManager();

        if(driver == null){
            try{
                utils.log().info("Initializing Appium driver for platform: " + params.getPlatformName());

                // Debug: Log the server URL
                URL serverUrl = new ServerManager().getServerUrl();
                utils.log().info("Server URL: " + serverUrl.toString());

                // Debug: Log the capabilities
                Capabilities caps = new CapabilitiesManager().getCaps();
                utils.log().info("Capabilities: " + caps.toString());

                switch(params.getPlatformName().toLowerCase()){
                    case "android":
                        utils.log().info("Creating AndroidDriver...");
                        driver = new AndroidDriver(serverUrl, caps);
                        break;
                    case "ios":
                        utils.log().info("Creating IOSDriver...");
                        driver = new IOSDriver(serverUrl, caps);
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported platform: " + params.getPlatformName());
                }

                if(driver == null){
                    throw new RuntimeException("Driver initialization returned null");
                }

                utils.log().info("Driver initialized successfully");
                this.driver.set(driver);

            } catch (Exception e) {
                utils.log().fatal("Driver initialization failure: " + e.getMessage());
                utils.log().fatal("Exception type: " + e.getClass().getName());
                e.printStackTrace();
                throw new RuntimeException("Failed to initialize Appium driver", e);
            }
        }

    }

}
