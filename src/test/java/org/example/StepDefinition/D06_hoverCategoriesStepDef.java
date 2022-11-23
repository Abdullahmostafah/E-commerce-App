package org.example.StepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P03_HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class D06_hoverCategoriesStepDef {
    P03_HomePage category = new P03_HomePage();
    String subCategory="";
    @When("user select random one of the three main categories hover and select random one of the three sub categories")
    public void selectRandomCategory()  {
        List<WebElement> actualCategoryList =  category.getCategoryList();
        int randomIndex=new Random().nextInt(3);
        Actions hover = new Actions(Hooks.driver);
        hover.moveToElement(actualCategoryList.get(randomIndex)).perform();
        List<WebElement> actualSubCategoryList = category.getSubCategoryList(randomIndex+1);
        Hooks.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        int randomNumberSub = new Random().nextInt(3);
        subCategory = actualSubCategoryList.get(randomNumberSub).getText();
        actualSubCategoryList.get(randomNumberSub).click();
    }
    @Then("user could find sub-category title is equal or contains the random selected sub-category")
    public void userCouldFindSubCategoryTitleIsEqualOrContainsTheRandomSelectedSubCategory() {
        String expectedSubcategory = subCategory.toLowerCase().trim();
        String actualSubCategory = category.getSubCategoryTitle().getText().toLowerCase().trim();
        Assert.assertTrue(actualSubCategory.contains(expectedSubcategory));
    }
}