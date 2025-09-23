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
//    private static ThreadLocal<AppiumDriverLocalService> server = new ThreadLocal<>();
//    TestUtils utils = new TestUtils();
//
//    public AppiumDriverLocalService getServer(){
//        return server.get();
//    }
//
//    public void startServer(){
//        utils.log().info("starting appium server");
//        AppiumDriverLocalService server = WindowsGetAppiumService();
//        server.start();
//        if(server == null || !server.isRunning()){
//            utils.log().fatal("Appium server not started. ABORT!!!");
//            throw new AppiumServerHasNotBeenStartedLocallyException("Appium server not started. ABORT!!!");
//        }
//        server.clearOutPutStreams(); // -> Comment this if you want to see server logs in the console
//        this.server.set(server);
//        utils.log().info("Appium server started");
//    }
//
//    public AppiumDriverLocalService getAppiumServerDefault() {
//        return AppiumDriverLocalService.buildDefaultService();
//    }
//
//    public AppiumDriverLocalService WindowsGetAppiumService() {
//        GlobalParams params = new GlobalParams();
//        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
//                .usingAnyFreePort()
//                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
//                .withLogFile(new File(params.getPlatformName() + "_"
//                        + params.getDeviceName() + File.separator + "Server.log")));
//    }
//
//    public AppiumDriverLocalService MacGetAppiumService() {
//        GlobalParams params = new GlobalParams();
//        HashMap<String, String> environment = new HashMap<String, String>();
//        environment.put("PATH", "enter_your_path_here" + System.getenv("PATH"));
//        environment.put("ANDROID_HOME", "enter_your_android_home_path");
//        environment.put("JAVA_HOME", "enter_your_java_home_path");
//        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
//                .usingDriverExecutable(new File("/usr/local/bin/node"))
//                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
//                .usingAnyFreePort()
//                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
//                .withEnvironment(environment)
//                .withLogFile(new File(params.getPlatformName() + "_"
//                        + params.getDeviceName() + File.separator + "Server.log")));
//    }
}
