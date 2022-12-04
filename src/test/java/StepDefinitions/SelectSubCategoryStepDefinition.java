package StepDefinitions;

import Pages.LoginPage;
import Pages.SearchProductPage;
import Pages.SelectSubCategoryPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SelectSubCategoryStepDefinition {
    public WebDriver driver = null;
    SelectSubCategoryPage subCategoryPage;
    LoginPage login;

    //Creating object of an Actions class
    Actions action;

    @Given("User opens G.Chrome and navigate to Site Home Page")
    public void user_opens_GChrome_and_navigate_to_home_page() throws InterruptedException {
        //Step1 : Set the path for Chrome Drive
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);

        //Step2 : Create object of Chrome driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(2000);
        subCategoryPage = new SelectSubCategoryPage(driver);
        driver.navigate().to("https://homzmart.com/");
        Thread.sleep(5000);
    }

 /*   @And("Login with valid credentials")
    public void Login_with_valid_credentials() throws InterruptedException {
        subCategoryPage.findLoginAnchor().click();
        Thread.sleep(5000);
        login = new LoginPage(driver);
        Thread.sleep(10000);
        subCategoryPage.EmailElementPOM().sendKeys("beauty.moon.light@hotmail.com\n");
        subCategoryPage.PasswordElementPOM().sendKeys("28101989");
        subCategoryPage.LoginButtonElementPOM().click();
        Thread.sleep(3000);
    }
*/
    @When("User click randomly on any category")
    public void Hover_User_Category() throws InterruptedException {
        action= new Actions(driver);
        Thread.sleep(5000);
        WebElement categoryEle = subCategoryPage.findCategoryElement();
        Thread.sleep(20000);
        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(categoryEle));
        element.click();*/
        action.moveToElement(categoryEle).click(categoryEle).perform();

        Thread.sleep(3000);
    }

    @Then("Hover and click on one subcategory")
    public void HoverAndClickSubCategory() throws InterruptedException {
        action= new Actions(driver);
        WebElement subCategoryEle = subCategoryPage.findSubCategory();
        Thread.sleep(10000);

        action.moveToElement(subCategoryEle).click(subCategoryEle).perform();

        Thread.sleep(5000);
    }

    @And("Subcategory details should be displayed")
    public void SubCategoryDetailsOpen() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals("https://homzmart.com/products/7#1",subCategoryPage.findCurrentURL());
        Thread.sleep(5000);
    }

    @After
    public void Close_Browser() throws InterruptedException {

        driver.quit();
        Thread.sleep(2000);
    }


}
