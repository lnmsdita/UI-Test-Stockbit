package com.qa.pages;

import com.qa.utils.GlobalParams;
import com.qa.utils.TestUtils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductsPage extends MenuPage {
	TestUtils utils = new TestUtils();

	@AndroidFindBy (id = "com.saucelabs.mydemoapp.android:id/productTV")
	private WebElement titleTxt;

    @AndroidFindBy (accessibility = "Sauce Lab Back Packs")
    private WebElement backPack;

    @AndroidFindBy (accessibility = "Blue color")
    private WebElement blueColor;

    @AndroidFindBy (accessibility = "Increase item quantity")
    private WebElement quantity;

    @AndroidFindBy (accessibility = "Tap to add product to cart")
    private WebElement atcButton;

    @AndroidFindBy (xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/titleTV\" and @text=\"Sauce Lab Back Packs\"]")
    private WebElement productName;

    @AndroidFindBy (xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/priceTV\" and @text=\"$ 29.99\"]")
    private WebElement backpackPrice;


    public String chooseProductItem() throws Exception{
        click(backPack);
        click(blueColor);
        click(quantity);

        return new String();
    }

    public String clickButtonATC() throws Exception{
        click(atcButton);

        return new String();
    }

	public String getTitle() {
		return getText(titleTxt, "product page title is - ");
	}

    public String getProductTitle(String title) throws Exception {
				return getText(productName, "product title is: " + title);
	}


	public String getProductPrice(String price) throws Exception {
        return getText(backpackPrice,"product price is: " + price);
	}

}
