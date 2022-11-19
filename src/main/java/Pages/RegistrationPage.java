package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    WebDriver driver;
    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
public WebElement FirstNameElementPOM(){
    return driver.findElement(By.id("input-25"));
}

public WebElement LastNameElementPOM(){
    return driver.findElement(By.id("input-28"));
}

public WebElement EmailElementPOM(){
    return driver.findElement(By.id("input-31"));
}

public WebElement PasswordElementPOM(){
    return driver.findElement(By.id("input-34"));
}

public WebElement ReEnterPasswordElementPOM(){
    return driver.findElement(By.id("input-37"));
}

public WebElement SignUpElementPOM(WebDriver driver){
    return driver.findElement(By.xpath("//button[@class='v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default']"));
}

public WebElement ErrorHolderElementPOM()
{
    return driver.findElement(By.xpath("//div[@class=\"v-snack__wrapper v-sheet theme--dark error\"]"));
}

public WebElement ErrorMsgElementPOM(){
        return driver.findElement(By.xpath("//p[@class=\"errormsg\"]"));
}

public WebElement NotifyMsgElementPOM(){
        return driver.findElement(By.xpath("//p[@class=\"notify-msg\"]"));
}

}
