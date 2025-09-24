package com.qa.pages;

import com.qa.utils.TestUtils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class SettingsPage extends BasePage {
	TestUtils utils = new TestUtils();
	
	@AndroidFindBy (xpath="//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/itemTV\" and @text=\"Log In\"]")
	private WebElement loginButton;
	
	public LoginPage pressLoginBtn() {
		click(loginButton, "press login button");
		return new LoginPage();
	}

}
