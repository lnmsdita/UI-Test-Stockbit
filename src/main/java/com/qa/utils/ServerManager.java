package com.qa.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class ServerManager {
    private static final String SERVER_URL = "http://127.0.0.1:4723"; // default Appium server

    public URL getServerUrl() {
        try {
            return new URL(SERVER_URL);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Appium server URL", e);
        }
    }

    public void startServer() {
        System.out.println("⚡ Assuming Appium server already running at " + SERVER_URL);
    }

    public void stopServer() {
        System.out.println("⚡ Stop server manually if needed.");
    }

}
