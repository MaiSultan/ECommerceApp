package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class D04_02_SearchProductBySUK {
    Hooks hooks;
    P03_homePage homePage;
    SoftAssert softAssert  = new SoftAssert();

    @Given("user start typing product by serialNo {string}")
    public void userStartTypingProductBySUK(String serialNo) throws InterruptedException {
        hooks = new Hooks();
        homePage = new P03_homePage(hooks.driver);
        homePage.findSearchBoxPOM().sendKeys(serialNo);
        Thread.sleep(3000);
        homePage.findSearchButtonPOM().click();
        Thread.sleep(10000);

        softAssert.assertTrue(hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q="));
    }


    @Then("Results should be retrieve matching product SerialNo {string}")
    public void resultsShouldBeRetrieveMatchingProductSerialNo(String serialNo) throws InterruptedException {
        WebElement searchedProductBySerialNumber = homePage.findSearchedProductBySerialNumber();
        ((JavascriptExecutor) hooks.driver).executeScript("arguments[0].scrollIntoView();", searchedProductBySerialNumber);

        Thread.sleep(3000);
        searchedProductBySerialNumber.click();
        //hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebDriverWait wait=new WebDriverWait(hooks.driver, Duration.ofMillis(30));
        if(serialNo == "SCI_FAITH"){
            Assert.assertTrue(homePage.findProductSKUElementForSCI_FAITH().isDisplayed());
            Assert.assertEquals(serialNo, homePage.findProductSKUElementForSCI_FAITH().getText());
        }
        else if(serialNo =="APPLE_CAM"){
            Assert.assertTrue(homePage.findProductSKUEForAPPLE_CAM().isDisplayed());
            Assert.assertEquals(serialNo, homePage.findProductSKUEForAPPLE_CAM().getText());
        }
        else if(serialNo == "SF_PRO_11"){
            Assert.assertTrue(homePage.findProductSKUEForSF_PRO_11().isDisplayed());
            Assert.assertEquals(serialNo, homePage.findProductSKUEForSF_PRO_11().getText());
        }

    }
}
