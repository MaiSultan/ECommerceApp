package StepDefinitions;

import Pages.SelectProductColorPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ProductColorStepDefinition {
    public WebDriver driver = null;
    SelectProductColorPage productColorPage;


    @Given("User navigates to Home page")
    public void user_navigate_to_home_page() throws InterruptedException {
        //Step1 : Set the path for Chrome Drive
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);

        //Step2 : Create object of Chrome driver
        ChromeOptions o= new ChromeOptions();
        o.addArguments("−−incognito");
        DesiredCapabilities c = new DesiredCapabilities();
        c.setBrowserName("Google Chrome");
        c.setCapability(ChromeOptions.CAPABILITY, o);

        driver = new ChromeDriver(o);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        productColorPage = new SelectProductColorPage(driver);
        driver.navigate().to("https://homzmart.com/en/");
        Thread.sleep(5000);
    }

    @When("Click on one SubCategory Product")
    public void Click_On_SubCategory_Product() throws InterruptedException {
        Thread.sleep(5000);
        productColorPage.CategoryOfficeFurnitureElement().click();
        Thread.sleep(10000);
        productColorPage.SubCategoryMetalDeskElement().click();
        Thread.sleep(5000);
    }

    @Then("Click on colors list")
    public void click_on_colors_list() throws InterruptedException {
        productColorPage.DropListOfColorsElement().click();
        Thread.sleep(5000);
    }

    @And("Select one color of interest")
    public void Select_One_Color() throws InterruptedException {
        productColorPage.BlackColorAnchorElement().click();
        Thread.sleep(3000);
    }

    @After
    public void Close_Browser() throws InterruptedException {

        driver.quit();
        Thread.sleep(2000);
    }




}
