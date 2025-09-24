package com.qa.pages;

import com.qa.utils.TestUtils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
	TestUtils utils = new TestUtils();

    @AndroidFindBy (id = "com.saucelabs.mydemoapp.android:id/nameET")
	private WebElement usernameTxtFld;

	@AndroidFindBy (id = "com.saucelabs.mydemoapp.android:id/passwordET")
	private WebElement passwordTxtFld;
	
	@AndroidFindBy (id = "com.saucelabs.mydemoapp.android:id/loginBtn")
	private WebElement loginBtn;

	public LoginPage(){
	}

public LoginPage enterUserName(String username) throws InterruptedException {
	clear(usernameTxtFld);	
	sendKeys(usernameTxtFld, username, "login with " + username);
	return this;
}

public LoginPage enterPassword(String password) {
	clear(passwordTxtFld);
	sendKeys(passwordTxtFld, password, "password is " + password);
	return this;
}

public ProductsPage pressLoginBtn() {
	click(loginBtn, "press login button");
	return new ProductsPage();
}

public ProductsPage login(String username, String password) throws InterruptedException {
	enterUserName(username);
	enterPassword(password);
	return pressLoginBtn();
}

}
