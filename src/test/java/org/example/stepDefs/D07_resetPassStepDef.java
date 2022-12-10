package org.example.stepDefs;

import org.example.pages.P04_resetPassword;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class D07_resetPassStepDef {
    public WebDriver driver = null;
    P04_resetPassword resetPass = null;

    @Given("User goes to login page for reset password")
    public void user_goes_to_login_page_for_reset_password() throws InterruptedException {
        //Step1 : Set the path for Chrome Drive
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);


        //Step2 : Create object of Chrome driver
        driver = new ChromeDriver();

        //Step3: Naviagte to Google website and maximize screen and sleep 3 seconds
        driver.manage().window().maximize();
        Thread.sleep(3000);

        //Step4: Create objects
        resetPass = new P04_resetPassword(driver);
        driver.navigate().to("https://homzmart.com/en/login");
    }

    @And("clicks Forget password Anchor")
    public void Click_Forget_Password_Anchor() throws InterruptedException {
        resetPass.ForgetPassElementPOM().click();
        Thread.sleep(4000);
        //resetPass.ResetPassElementPOM().sendKeys("mai.capmas@gmail.com");
    }

    @And("Clicks on Reset password Button")
    public void Click_on_Reset_Password_Button() throws InterruptedException {
        resetPass.ResetPassElementPOM().click();
        Thread.sleep(7000);
    }

    @When("User enters own email")
    public void User_Enters_Own_Email() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        resetPass.EmailElementPOM().sendKeys("mai.capmas@gmail.com");
        //resetPass.EmailElementPOM().sendKeys(Keys.ENTER);
    }
    @Then("Success message holder should appear")
    public void CheckSuccessMsgHolder(){
        Assert.assertTrue(resetPass.SuccessMsgHolderElementPOM().isDisplayed());
    }
    @And("Notify message to check email for further info")
    public void CheckNotifyMessage(){
        Assert.assertEquals(" New password has been sent to your email. Please check your mail for further details.",
                resetPass.NotifyMsgElementPOM().getText());
    }

    @After
    public void Close_Browser() throws InterruptedException {
        driver.quit();
        Thread.sleep(2000);
    }


}
