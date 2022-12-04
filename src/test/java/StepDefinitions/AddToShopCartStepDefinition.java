package StepDefinitions;

import Pages.AddToShopCartPage;
import Pages.LoginPage;
import Pages.SelectSubCategoryPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToShopCartStepDefinition {
    public WebDriver driver = null;
    AddToShopCartPage shopCartPage;
    LoginPage login;

    SelectSubCategoryPage subCategoryPage;

    @Given("User browses to shopping site")
    public void user_opens_GChrome_and_navigate_to_home_page() throws InterruptedException {
        //Step1 : Set the path for Chrome Drive
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);

        //Step2 : Create object of Chrome driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(2000);
        login = new LoginPage(driver);
        subCategoryPage = new SelectSubCategoryPage(driver);
        shopCartPage = new AddToShopCartPage(driver);
        //driver.navigate().to("https://homzmart.sa/");
        //driver.navigate().to("https://homzmart.sa/login");
        Thread.sleep(5000);
    }

    @And("Login with valid username & password")
    public void Login_with_valid_User() throws InterruptedException {
     /*   subCategoryPage.findLoginAnchor().click();
        Thread.sleep(5000);
        login = new LoginPage(driver);
        Thread.sleep(10000);*/
        driver.navigate().to("https://homzmart/login");
        Thread.sleep(5000);
        //shopCartPage.LoginAnchorElementPOM().click();
        //Thread.sleep(3000);
        login.EmailElementPOM().sendKeys("beauty.moon.light@hotmail.com\n");
        login.PasswordElementPOM().sendKeys("28101989");
        login.LoginButtonElementPOM().click();
        Thread.sleep(3000);
    }

    @When("Click on category and select subcategory")
    public void Click_On_Category_Select_SubCategory() throws InterruptedException {
        Thread.sleep(3000);
        subCategoryPage.findCategoryElement().click();
        //shopCartPage.DecorCategoryElementPOM().click();
        Thread.sleep(3000);
        subCategoryPage.findSubCategory().click();
        shopCartPage.HomeDecorSubCategoryElementPOM().click();
        Thread.sleep(3000);
    }

    @And("Subcategory item is displayed with details")
    public void SubCategory_Details_Displayed() throws InterruptedException {
        shopCartPage.ProductDetailsElementPOM().click();
        Thread.sleep(3000);
        Assert.assertEquals("https://homzmart.com/product-details/6988.1804-KY7-L-3",driver.getCurrentUrl());
        Thread.sleep(3000);
        Assert.assertTrue(shopCartPage.AddToCartElementPOM().isDisplayed());

    }

    @Then("Click on add to cart")
    public void Click_Add_To_Cart() throws InterruptedException {
        shopCartPage.AddToCartElementPOM().click();
        Thread.sleep(5000);
    }

    @After
    public void Close_Browser() throws InterruptedException {

        driver.quit();
        Thread.sleep(2000);
    }

}
