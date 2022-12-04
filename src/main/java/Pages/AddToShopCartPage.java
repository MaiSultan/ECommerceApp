package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToShopCartPage {
    WebDriver driver;

    public AddToShopCartPage(WebDriver driver){
        this.driver = driver;
    }

   /* public WebElement EmailElementPOM(){
        return driver.findElement(By.id("input-714"));
    }

    public WebElement PasswordElementPOM(){
        return driver.findElement(By.xpath("//input[@type=\"password\"]"));
    }

    public WebElement LoginButtonElementPOM(){
        return driver.findElement(By.xpath("//button[@class=\"v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default\"]"));
    }*/

    public WebElement DecorCategoryElementPOM(){
        return driver.findElement(By.xpath("//a[@href=\"/products/4#1\"]"));
    }

    public WebElement HomeDecorSubCategoryElementPOM(){
        return driver.findElement(By.xpath("//a[@href=\"/products/48#1\"]"));
    }

    public WebElement ProductDetailsElementPOM(){
        return driver.findElement(By.xpath("//a[@href=\"/product-details/6988.1804-KY7-L-3\"]"));
    }

    public WebElement AddToCartElementPOM(){
        return driver.findElement(By.xpath("//button[@class=\"add-btn\"]"));
    }

    public WebElement LoginAnchorElementPOM(){
        return driver.findElement(By.xpath("href=\"/login\""));
    }

    public WebElement AddedToCartModalElement(){
        return driver.findElement(By.cssSelector("modal-content"));
        //return driver.findElement(By.xpath("//div[@class=\"modal-content\"]"));
    }
}
