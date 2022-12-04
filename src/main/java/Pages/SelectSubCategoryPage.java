package Pages;

import com.beust.jcommander.IStringConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectSubCategoryPage {
    WebDriver driver;

    public SelectSubCategoryPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement findLoginAnchor()
    {
        return driver.findElement(By.xpath("//a[@href=\"/login\"]"));
    }

    public WebElement findCategoryElement(){
        return driver.findElement(By.xpath("//a[@href=\"/en/products/3#1\"]"));//الأثاث
    }

    public WebElement findSubCategory(){
        return driver.findElement(By.xpath("//a[@href=\"/en/products/7#1\"]"));//كرسي
    }
    public String findCurrentURL(){
        return driver.getCurrentUrl();
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
