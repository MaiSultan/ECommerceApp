package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver  = driver;
    }

    public WebElement EmailElementPOM(){
        return driver.findElement(By.id("input-22"));
    }

    public WebElement PasswordElementPOM(){
        return driver.findElement(By.xpath("//input[@type=\"password\"]"));
    }

    public WebElement LoginButtonElementPOM(){
        return driver.findElement(By.xpath("//button[@class=\"v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default\"]"));
    }
}
