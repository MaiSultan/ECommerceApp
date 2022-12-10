package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class D03_currenciesStepDef {
    P03_homePage homePage;
    Hooks hooks;

@Given("select one currency from currencies list")
public void SelectCurrency() throws InterruptedException {
    hooks = new Hooks();
    homePage = new P03_homePage(hooks.driver);
    Thread.sleep(5000);
    homePage.findCurrenciesListPOM().selectByVisibleText("Euro");
    Thread.sleep(3000);
}

@Then("Price currency for displayed products should change")
    public void checkProductsPriceSymbolChanged() throws InterruptedException {
    WebElement divProducts = homePage.findProductsDivPoM();
    List<WebElement> pricesList;
    pricesList = homePage.findProductsWithEuroSymbol();
    ((JavascriptExecutor) hooks.driver).executeScript("arguments[0].scrollIntoView();", divProducts);

    Thread.sleep(10000);
    for(int i=0; i<pricesList.size(); i++){
        Assert.assertTrue(pricesList.get(i).getText().contains("€"));
    }
}


}
