package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class D06_01_homeSlidersStepDef {
    Hooks hooks = new Hooks();
    P03_homePage homePage  = new P03_homePage(hooks.driver);

@Given("User clicks on first slider")
    public void ClickFirstSlider() throws InterruptedException {
    hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
    JavascriptExecutor js = (JavascriptExecutor)hooks.driver;
    js.executeScript("arguments[0].click();",homePage.findFirstSliderElement());
    Thread.sleep(3000);

}

@Then("URL should change with first slider name")
    public void CheckFirstSliderURL(){
    Assert.assertEquals("https://demo.nopcommerce.com/nokia-lumia-1020", hooks.driver.getCurrentUrl());
}



}
