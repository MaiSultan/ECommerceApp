package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage {
    WebDriver driver;
    public ResetPasswordPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement ForgetPassElementPOM(){
        return  driver.findElement(By.linkText("Forgot Password"));
    }

    public WebElement EmailElementPOM(){
        return driver.findElement(By.id("input-3809"));
      //return driver.findElement(By.xpath("//div//input[@id=\"input-3809\"]"));
    }
    public WebElement ResetPassElementPOM(){
        return driver.findElement(By.xpath("//span[@class=\"v-btn__content\"]"));
    }

    public WebElement SuccessMsgHolderElementPOM(){
        return driver.findElement(By.xpath("//div[@class=\"v-snack__wrapper v-sheet theme--dark success\"]"));
    }

    public WebElement NotifyMsgElementPOM(){
        return driver.findElement(By.xpath("//p[@class=\"notify-msg\"]"));
    }
}
