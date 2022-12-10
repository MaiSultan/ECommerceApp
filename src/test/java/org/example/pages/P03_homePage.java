package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class P03_homePage {
    WebDriver driver;

    public P03_homePage(WebDriver driver) {
        this.driver = driver;
    }
    public Select findCurrenciesListPOM(){

        return new Select(driver.findElement(By.id("customerCurrency")));
    }

    public WebElement findProductsDivPoM(){
        return driver.findElement(By.cssSelector("div[class=\"product-grid home-page-product-grid\"]"));
    }
    public List<WebElement> findProductsWithEuroSymbol(){
        return driver.findElements(By.cssSelector("span[class=\"price actual-price\"]"));
    }

    public WebElement findSearchBoxPOM(){
       return driver.findElement(By.id("small-searchterms"));
    }

    public WebElement findSearchProductGridDivPOM(){
        return driver.findElement(By.cssSelector("div[class=\"product-grid\"]"));
    }

    public List<WebElement> findSearchedProductsPOM(){
        return driver.findElements(By.cssSelector("div[class=\"product-item\"]"));
    }

    public WebElement findSearchButtonPOM(){
        return driver.findElement(By.cssSelector("button[class=\"button-1 search-box-button\"]"));
    }

    public WebElement findSearchedProductBySerialNumber(){
        return driver.findElement(By.cssSelector("div[class=\"product-item\"]"));
    }

    public WebElement findProductSKUElementForSCI_FAITH(){
        return driver.findElement(By.id("sku-36"));
    }

    public WebElement findProductSKUEForAPPLE_CAM(){
        return driver.findElement(By.id("sku-17"));
    }

    public WebElement findProductSKUEForSF_PRO_11(){
        return driver.findElement(By.id("sku-12"));
    }

    public WebElement findComputerCategory(){
        return driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//a[@href=\"/computers\"]"));
    }

    public WebElement findNotebooksSubCategory(){
        return driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//a[@href=\"/notebooks\"]"));
    }

    public WebElement findCategoryPageTitle(){
        return driver.findElement(By.xpath("//div[@class=\"page-title\"]//h1"));
    }

    public WebElement findActiveSliderElement(){
        return driver.findElement(By.cssSelector("a[style=\"display: block;\"]"));

    }

    public WebElement findFirstSliderElement(){
        return driver.findElement(By.xpath("//a[@style=\"display: block;\"]//img[@src=\"https://demo.nopcommerce.com/images/thumbs/0000079_banner_1.jpg\"]"));
    }

    public WebElement findSecondSliderElement(){
        return driver.findElement(By.xpath("//a[@style=\"display: block;\"]//img[@src=\"https://demo.nopcommerce.com/images/thumbs/0000080_banner_2.jpg\"]"));
    }





}
