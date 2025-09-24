package com.qa.runners;

import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParams;
import com.qa.utils.ServerManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.apache.logging.log4j.ThreadContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber/report.html", "summary"},
        features = {"src/test/resources"},
        glue = {"com.qa.stepdef"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false,
        monochrome = true
)
public class MyRunnerTest {

    @BeforeClass
    public static void initialize() throws Exception {
        GlobalParams params = new GlobalParams();
        params.initializeGlobalParams();

        ThreadContext.put("ROUTINGKEY", params.getPlatformName() + "_" + params.getDeviceName());

        // Start Appium server
        ServerManager serverManager = new ServerManager();
        serverManager.startServer();

        // Init driver
        DriverManager driverManager = new DriverManager();
        driverManager.initializeDriver();
    }

    @AfterClass
    public static void quit() {
        DriverManager driverManager = new DriverManager();
        if (driverManager.getDriver() != null) {
            driverManager.getDriver().quit();
            driverManager.setDriver(null);
        }

        // Stop Appium server
        ServerManager serverManager = new ServerManager();
        serverManager.stopServer();
    }
}
