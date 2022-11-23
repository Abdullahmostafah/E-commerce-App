package org.example.StepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P03_HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class D07_homeSlidersStepDef {
    P03_HomePage homeSlider = new P03_HomePage();
    @When("user click on slider {string}")
    public void clickOnFirstSlider(String sliderNumber) {
        Hooks.driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(30));
        WebElement element =
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"nivoSlider\"]/a["+sliderNumber+"] [@style=\"display: block;\"]")));
        if(sliderNumber=="1")
            homeSlider.getHomeSliderList().get(0).click();
        else if (sliderNumber=="2")
            homeSlider.getHomeSliderList().get(1).click();
    }
    @Then("user redirect to slider {string}")
    public void userRedirectToNokiaLumiaPage(String sliderNumber) {
        String expectedurl =  "";
        System.out.println("slider " + sliderNumber);
        if (sliderNumber.contains("1"))
            expectedurl = "https://demo.nopcommerce.com/nokia-lumia-1020";
        else if (sliderNumber.contains("2"))
            expectedurl = "https://demo.nopcommerce.com/iphone-6";
        String actualURL = homeSlider.getCurrentURL();
        Assert.assertEquals(actualURL,expectedurl);
    }
}