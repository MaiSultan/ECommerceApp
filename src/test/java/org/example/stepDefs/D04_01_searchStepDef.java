package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class D04_01_searchStepDef {
    Hooks hooks;
    P03_homePage homePage;
    SoftAssert softAssert  = new SoftAssert();

    @Given("user start typing product by {string}")
    public void userStartTypingProductByName(String name) throws InterruptedException {
        hooks = new Hooks();
        homePage = new P03_homePage(hooks.driver);
        homePage.findSearchBoxPOM().sendKeys(name);
        Thread.sleep(3000);
        homePage.findSearchButtonPOM().click();
        Thread.sleep(10000);

        softAssert.assertTrue(hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q="));
    }

        @Then("Results should be retrieve matching product {string}")
    public void CheckProductNameSearchResults(String name) throws InterruptedException {
            WebElement searchProductsGrid = homePage.findSearchProductGridDivPOM();
            ((JavascriptExecutor) hooks.driver).executeScript("arguments[0].scrollIntoView();", searchProductsGrid);

            Thread.sleep(3000);

            List<WebElement> searchedProductsList = homePage.findSearchedProductsPOM();
            for (int p=0; p< searchedProductsList.size(); p++){
                softAssert.assertTrue(searchedProductsList.get(p).getText().toLowerCase().contains(name));
        }
    }

  /*  @Then("Results should be retrieve matching product {string}")
    public void resultsShouldBeRetrieveMatchingProduct(String arg0) {
    }*/
/*
    @Given("user start typing product by <name>")
    public void userStartTypingProductByName() {
    }*/
}
