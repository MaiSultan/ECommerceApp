package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class D05_hoverCategoriesStepDef {
    Hooks hooks;
    P03_homePage homePage;

    @Given("User hover randomly on any category")
    public void SelectAndHoverCategory() throws InterruptedException {
        hooks = new Hooks();
        homePage = new P03_homePage(hooks.driver);
        Actions action = new Actions(hooks.driver);
        WebElement computersCategory = homePage.findComputerCategory();
        action.moveToElement(computersCategory).perform();
        Thread.sleep(3000);
    }

    @When("select any subcategory and click on it")
    public void SelectAndClickSubCategory() throws InterruptedException {
        homePage.findNotebooksSubCategory().click();
        Thread.sleep(3000);
    }

    @Then("Sub category page should open")
    public void SubCategoryPageOpen(){
    Assert.assertEquals("https://demo.nopcommerce.com/notebooks", hooks.driver.getCurrentUrl());
    }

    @And("SubCategory page's title should match clicked sub category")
    public void AssureSubCategoryPageTitle() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(homePage.findCategoryPageTitle().
                getText().toLowerCase().trim()
                .contains("notebooks"));
    }
}
