package StepDefinitions;

import Pages.LoginPage;
import Pages.SearchProductPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchProductStepDefinition {

    public WebDriver driver = null;
    SearchProductPage search;

    @Given("User launches Google Chrome and navigate to Home Page")
    public void user_launches_google_chrome_and_navigate_to_home_page() throws InterruptedException {
        //Step1 : Set the path for Chrome Drive
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);


        //Step2 : Create object of Chrome driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(2000);
        search = new SearchProductPage(driver);
        driver.navigate().to("https://homzmart.com/");
        Thread.sleep(2000);
        //search.findChangeLanguageKey().click();
        //Thread.sleep(6000);
    }

    @When("Go to Search textbox & Type any product name and press enter")
    public void go_to_search_textbox_type_any_product_name_and_press_enter() throws InterruptedException {
        Thread.sleep(15000);
        search.findSearchBoxPlaceholder().sendKeys("سرير");

        search.findSearchBoxPlaceholder().sendKeys(Keys.ENTER);
        Thread.sleep(5000);
    }

    @Then("Matching product results should be displayed")
    public void matching_product_results_should_be_displayed() throws InterruptedException {
        Assert.assertTrue(search.findResultsText().isDisplayed());
        Assert.assertTrue(search.findResultsListingContainer().isDisplayed());
        //Assert.assertTrue(search.findAnyOfSearchResultValue().isDisplayed());
        //search.findAnyOfSearchResultValue().click();
        Thread.sleep(2000);
        //Assert.assertTrue(driver.getCurrentUrl().contains("/product-details/"));
    }

    @After
    public void Close_Browser() throws InterruptedException {

        driver.quit();
        Thread.sleep(2000);
    }
}
