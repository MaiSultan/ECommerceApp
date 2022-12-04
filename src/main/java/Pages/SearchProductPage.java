package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchProductPage {
    WebDriver driver;
     public SearchProductPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement findChangeLanguageKey(){
         return driver.findElement(By.xpath("//span[@class=\"default__change-language\"]"));
    }
    public WebElement findSearchBoxPlaceholder(){
         //return driver.findElement(By.xpath("//input[@placeholder=\"Find everything for your home here\"]"));
        return driver.findElement(By.xpath("//input[@placeholder=\"ابحث هنا عن كل شيء لمنزلك\"]"));
    }

    public WebElement findResultsText(){
         //return driver.findElement(By.xpath("//*[contains(text(),'results for all products')]"));
        return driver.findElement(By.xpath("//*[contains(text(),' نتائج جميع المنتجات ')]"));
    }

    public WebElement findResultsListingContainer(){
         return driver.findElement(By.xpath("//div[@class=\"algolia-listing-container\"]"));
    }

    public WebElement findAnyOfSearchResultValue(){
         return driver.findElement(By.xpath("//*[contains(text(), 'سرير')]"));
    }

}
