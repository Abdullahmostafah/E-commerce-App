package StepDefinitions;

import Base.TestBase;
import Pages.P03_HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import java.util.List;
import java.util.Random;

public class D06_hoverCategoriesStepDef extends TestBase {
    private final P03_HomePage category = new P03_HomePage();
    private String subCategory;

    @When("user select random one of the three main categories hover and select random one of the three sub categories")
    public void selectRandomCategory() {
        int randomIndex = new Random().nextInt(3);
        Actions hover = new Actions(driver);
        hover.moveToElement(category.getCategoryList().get(randomIndex)).perform();
        List<WebElement> actualSubCategoryList = category.getSubCategoryList(randomIndex + 1);
        int randomNumberSub = new Random().nextInt(actualSubCategoryList.size());
        subCategory = actualSubCategoryList.get(randomNumberSub).getText();
        actualSubCategoryList.get(randomNumberSub).click();
    }

    @Then("user could find sub-category title is equal or contains the random selected sub-category")
    public void userCouldFindSubCategoryTitleIsEqualOrContainsTheRandomSelectedSubCategory() {
        String expectedSubcategory = subCategory.toLowerCase().trim();
        String actualSubCategory = category.getSubCategoryTitle().toLowerCase().trim();
        Assert.assertTrue(actualSubCategory.contains(expectedSubcategory), "Subcategory title does not contain: " + expectedSubcategory);
    }
}