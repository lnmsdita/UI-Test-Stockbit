package com.qa.stepdef;

import com.qa.pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductStepDef {

    @Given("I'm logged in")
    public void iMLoggedIn() throws InterruptedException {
    }

    @Then("the product is listed with title {string} and price {string}")
    public void theProductIsListedWithTitleAndPrice(String title, String price) throws Exception {
        Assert.assertEquals(new ProductsPage().getProductTitle(title), title);
        Assert.assertEquals(new ProductsPage().getProductPrice(price), price);

    }

    @When("Choose the product")
    public void chooseProducttoATC () throws Exception {
        new ProductsPage().chooseProductItem();
    }

    @Then("Success add product to cart")
    public void addProducttoCart () throws Exception {
        new ProductsPage().clickButtonATC();
    }
}
