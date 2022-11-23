package org.example.Pages;

import org.example.StepDefinition.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class P03_HomePage {
    public WebElement euroCurrency()
    {
        return Hooks.driver.findElement(By.name("customerCurrency"));
    }
    public List<WebElement> getAllProducts()
    {
        return Hooks.driver.findElements(By.cssSelector("span[class=\"price actual-price\"]"));
    }
    public  WebElement searchField()
    {
        return Hooks.driver.findElement(By.id("small-searchterms"));
    }
    public WebElement searchButton()
    {
        return Hooks.driver.findElement(By.cssSelector("button[class=\"button-1 search-box-button\"]"));
    }
    public List<WebElement> relativeResults ()
    {
        return Hooks.driver.findElements(By.className("h2[class=\"product-title\"]"));
    }
    public String getCurrentURL()
    {
        return Hooks.driver.getCurrentUrl();
    }
    public WebElement productClick()
    {
        return Hooks.driver.findElement(By.className("picture"));
    }
    public List<WebElement> getCuurentProduct()
    {
        return Hooks.driver.findElements(By.className("product-item"));
    }
    public List<WebElement> getActualSKU ()
    {
        return Hooks.driver.findElements(By.className("sku"));
    }
    public List<WebElement> getCategoryList()
    {
        return Hooks.driver.findElements(By.cssSelector("ul[class=\"top-menu notmobile\"]>li>a[href]"));
    }
    public  List<WebElement> getSubCategoryList(int indexNumber)
    {
        return Hooks.driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li["+indexNumber+"]/ul[@class=\"sublist first-level\"]/li/a[@href]"));
    }
    public WebElement getSubCategoryTitle ()
    {
        return Hooks.driver.findElement(By.cssSelector("div[class=\"page-title\"] h1"));
    }
    public List<WebElement> getHomeSliderList()
    {
        return Hooks.driver.findElements(By.cssSelector("div[class=\"nivoSlider\"]>a[class=\"nivo-imageLink\"]"));
    }
    public WebElement getFollowUsLink (String linkName)
    {
        return Hooks.driver.findElement(By.cssSelector("li[class=\""+linkName+"\"]>a[target=\"_blank\"]"));
    }
    public void switchLink ()
    {
        ArrayList<String> tabs = new ArrayList<String>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(tabs.get(1));
    }
    public List<WebElement> clickOnWishButton()
    {
        return Hooks.driver.findElements(By.cssSelector("button[class=\"button-2 add-to-wishlist-button\"]"));
    }
    public WebElement wishlistSuccessMessage ()
    {
        return Hooks.driver.findElement(By.cssSelector("p[class=\"content\"]"));
    }
    public WebElement wishListSuccessMessageColor()
    {
        return Hooks.driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]"));
    }
    public WebElement returnWishlistSuccessMessage()
    {
        return Hooks.driver.findElement(By.xpath("//p[@class=\"content\"]"));
    }
    public WebElement wishlistButton()
    {
        return Hooks.driver.findElement(By.className("wishlist-label"));
    }
    public WebElement wishlistQuantity()
    {
        return Hooks.driver.findElement(By.className("qty-input"));
    }
}