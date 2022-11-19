package StepDefinitions;

import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepDefinition {
    public WebDriver driver = null;
    LoginPage login;

    @Given("User goes to login URL via Google Chrome browser")
    public void OpenChromeBrowser() throws InterruptedException {
        //Step1 : Set the path for Chrome Drive
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);


        //Step2 : Create object of Chrome driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(2000);
        login = new LoginPage(driver);
        driver.navigate().to("https://homzmart.com/en/login");
    }

    @When("User enters registered email and password")
    public void user_enters_registered_email_and_password(){
     login.EmailElementPOM().sendKeys("beauty.moon.light@hotmail.com\n");
     login.PasswordElementPOM().sendKeys("28101989");
    }

    @And("User clicks on login button")
    public void user_clicks_on_login_button() throws InterruptedException {
        login.LoginButtonElementPOM().click();
        Thread.sleep(2000);
    }

    @Then("Login should successfully done and Home page is displayed")
    public void login_should_successfully_done_and_home_page_is_displayed() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://homzmart.com/en/");

        Assert.assertTrue(driver.findElement(By.xpath("//div[@class=\"user-menu__handle\"]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Hi, ')]")).getText().contains("Hi, "));
    }

    @After
    public void Close_Browser() throws InterruptedException {

        driver.quit();
        Thread.sleep(2000);
    }
}
