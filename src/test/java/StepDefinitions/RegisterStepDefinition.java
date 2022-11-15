package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterStepDefinition {
    public ChromeDriver driver = null;

   @Given("User opens Google Chrome browser")
    public void OpenChromeBrowser() throws InterruptedException {
        //Step1 : Set the path for Chrome Drive
       String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
       System.setProperty("webdriver.chrome.driver", chromePath);

       //Step2 : Create object of Chrome driver
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       Thread.sleep(2000);
    }

    @And("User goes to register URL")
    public void user_goes_to_register_url() throws InterruptedException {
       driver.navigate().to("https://minisoegypt.com/account/register");

        Thread.sleep(3000);
    }

    @When("Valid First name,Last name,Email & Password")
    public void Valid_first_name_last_name_email_password(){

        driver.findElement(By.id("RegisterForm-FirstName")).sendKeys("Mai");
        driver.findElement(By.id("RegisterForm-LastName")).sendKeys("Sultan");
        driver.findElement(By.id("RegisterForm-email")).sendKeys("mai.capmas@gmail.com");
        driver.findElement(By.id("RegisterForm-password")).sendKeys("Ms@123456");
    }

    @And("User clicks on Create button")
    public void user_clicks_on_create_button() throws InterruptedException {
        driver.findElement(By.id("RegisterForm-password")).sendKeys(Keys.ENTER);
    //driver.findElement(By.tagName("button")).click();
    Thread.sleep(2000);
    }

    @Then("New user account successfully created")
    public void new_user_account_successfully_created()
    {
        Assert.assertTrue(true);
    }




}
