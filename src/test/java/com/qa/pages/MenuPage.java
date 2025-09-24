package com.qa.pages;

import com.qa.utils.TestUtils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class MenuPage extends BasePage{
	TestUtils utils = new TestUtils();
	
	@AndroidFindBy (xpath="//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView\n" + 
			"")
	private WebElement settingsBtn;
	
	public SettingsPage pressSettingsBtn() {
		click(settingsBtn, "press Settings button");
		return new SettingsPage();
	}

    @AndroidFindBy (accessibility = "View menu")
    private WebElement burgerButton;
    public SettingsPage pressBurgerButton(){
        click(burgerButton, "press Settings button");
        return new SettingsPage();
    }

}
