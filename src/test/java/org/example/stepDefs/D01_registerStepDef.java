package org.example.stepDefs;

import org.example.pages.P01_register;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D01_registerStepDef {
    public WebDriver driver=  null;
    P01_register register;

   @Given("User opens Google Chrome browser")
    public void OpenChromeBrowser() throws InterruptedException {
        //Step1 : Set the path for Chrome Drive
       String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
       System.setProperty("webdriver.chrome.driver", chromePath);

       //Step2 : Create object of Chrome driver
       driver= new ChromeDriver();

       driver.manage().window().maximize();
       Thread.sleep(2000);

       register = new P01_register(driver);
    }

   @And("User goes to register URL")
    public void user_goes_to_register_url() throws InterruptedException {
       driver.navigate().to("https://homzmart.com/en/sign-up");
       Thread.sleep(3000);
    }

    @When("Valid First name,Last name,Email,Password & matching Retyped password")
    public void Valid_Data(){
        register.FirstNameElementPOM().sendKeys("Automation");
        register.LastNameElementPOM().sendKeys("Testing Egy");
        //register.EmailElementPOM().sendKeys("snowwhite892008@hotmail.com");
        register.EmailElementPOM().sendKeys("testing@automateEgy.com");
        register.PasswordElementPOM().sendKeys("test@123456");
        register.ReEnterPasswordElementPOM().sendKeys("test@123456");
    }

    @And("User clicks on Create button")
    public void Click_create_button() throws InterruptedException {
        register.SignUpElementPOM(driver).sendKeys(Keys.ENTER);
    //driver.findElement(By.tagName("button")).click();
    Thread.sleep(3000);
    }

    @Then("New user account successfully created")
    public void new_user_account_successfully_created() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://homzmart.com/en/");

        Assert.assertTrue(driver.findElement(By.xpath("//div[@class=\"user-menu__handle\"]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Hi, ')]")).getText().contains("Hi, "));
    }

    @When("Valid First name,Last name,already used Email,Password & matching Retyped password")
    public void Enter_Already_Used_Email(){

        register.FirstNameElementPOM().sendKeys("Mai");
        register.LastNameElementPOM().sendKeys("Sultan");
        register.EmailElementPOM().sendKeys("mai.capmas@gmail.com");
        register.PasswordElementPOM().sendKeys("Ms@123456");
        register.ReEnterPasswordElementPOM().sendKeys("Ms@123456");
    }

    @Then("Message appears Email is already used")
    public void Failed_Register_Email_Used() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(register.ErrorHolderElementPOM().isDisplayed());
        Assert.assertTrue(register.ErrorMsgElementPOM().isDisplayed());
        Assert.assertTrue(register.NotifyMsgElementPOM().isDisplayed());

       /* String actualString =  driver.findElement(By.xpath("//p[text()=\" Email Is Already Exist\"]")).getText();
        System.out.println(actualString);
        Assert.assertTrue( actualString.contains(actualString));*/
    }
    @After
    public void Close_Browser() throws InterruptedException {
        driver.quit();
        Thread.sleep(2000);
    }


}
