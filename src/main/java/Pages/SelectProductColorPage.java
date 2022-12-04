package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectProductColorPage {
    WebDriver driver;

    public SelectProductColorPage(WebDriver driver){
        this.driver  = driver;
    }
public WebElement CategoryFurnitureElement(){
        return driver.findElement(By.xpath("//a[@href=\"/products/3#1\"]"));
}

public WebElement CategoryOfficeFurnitureElement(){
        return driver.findElement(By.xpath("//a[@href=\"/en/products/461#1\"]"));
}
    public WebElement SubCategoryChairElement(){
        return driver.findElement(By.xpath("//a[@href=\"/products/7#1\"]"));
    }
public WebElement SubCategoryMetalDeskElement(){
        return driver.findElement(By.xpath("//a[@href=\"/en/products/4321#1\"]"));
}
    public WebElement DropListOfColorsElement(){
        return driver.findElement(By.xpath("//div[@class=\"morgan-drop expanded\"]"));
    }

    public WebElement BlackColorAnchorElement(){
       return  driver.findElement(By.xpath("//a[contains(text(),'Black')]"));
    }
}
