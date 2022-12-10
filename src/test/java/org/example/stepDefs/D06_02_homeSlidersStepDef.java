package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class D06_02_homeSlidersStepDef {
    Hooks hooks = new Hooks();
    P03_homePage homePage  = new P03_homePage(hooks.driver);
    @Given("User clicks on second slider")
    public void ClickSecondSlider() throws InterruptedException {
        hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        JavascriptExecutor js = (JavascriptExecutor)hooks.driver;
        js.executeScript("arguments[0].click();",homePage.findSecondSliderElement());
        Thread.sleep(3000);

    }

    @Then("URL should change with second slider name")
    public void CheckSecondSliderURL(){
        Assert.assertEquals("https://demo.nopcommerce.com/iphone-6", hooks.driver.getCurrentUrl());
    }
}
