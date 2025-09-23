package com.qa.utils;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class CapabilitiesManager {
    TestUtils utils = new TestUtils();

    public DesiredCapabilities getCaps() throws IOException {
        GlobalParams params = new GlobalParams();
        Properties props = new PropertyManager().getProps();

        try{
            utils.log().info("getting capabilities");
            DesiredCapabilities caps = new DesiredCapabilities();

            // Standard W3C capabilities (no prefix needed)
            caps.setCapability("platformName", params.getPlatformName());

            // Appium-specific capabilities (with appium: prefix)
            caps.setCapability("appium:deviceName", params.getDeviceName());
            caps.setCapability("appium:udid", params.getUDID());

            switch(params.getPlatformName()){
                case "Android":
                    // Add appium: prefix to Appium-specific capabilities
                    caps.setCapability("appium:automationName", props.getProperty("androidAutomationName"));
                    caps.setCapability("appium:appPackage", props.getProperty("androidAppPackage"));
                    caps.setCapability("appium:appActivity", props.getProperty("androidAppActivity"));
                    caps.setCapability("appium:systemPort", params.getSystemPort());
                    caps.setCapability("appium:chromeDriverPort", 9222);

                    String androidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                            + File.separator + "resources" + File.separator + "apps" + File.separator + "Android.SauceLabs.Mobile.Sample.app.2.7.1.apk";
                    utils.log().info("appUrl is " + androidAppUrl);
                    caps.setCapability("appium:app", androidAppUrl);
                    break;

                case "iOS":
                    // Add appium: prefix to Appium-specific capabilities
                    caps.setCapability("appium:automationName", props.getProperty("iOSAutomationName"));
                    caps.setCapability("appium:bundleId", props.getProperty("iOSBundleId"));
                    caps.setCapability("appium:wdaLocalPort", params.getWdaLocalPort());
                    caps.setCapability("appium:webkitDebugProxyPort", params.getWebkitDebugProxyPort());

                    String iOSAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                            + File.separator + "resources" + File.separator + "apps" + File.separator + "SwagLabsMobileApp.app";
                    utils.log().info("appUrl is " + iOSAppUrl);
                    caps.setCapability("appium:app", iOSAppUrl);
                    break;
            }

            // Ensure clean capabilities without duplicates
            utils.log().info("Final capabilities: " + caps.toString());
            return caps;
        } catch(Exception e){
            e.printStackTrace();
            utils.log().fatal("Failed to load capabilities. ABORT!!" + e.toString());
            throw e;
        }
    }
}