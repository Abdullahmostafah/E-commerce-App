package StepDefinitions;

import Base.TestBase;
import Pages.P03_HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class D09_WishlistStepDef extends TestBase {
    private final P03_HomePage wishList = new P03_HomePage();

    @When("user click on wishlist button for product {string}")
    public void addProductToWishlist(String productIndex) {
        wishList.clickWishButton(Integer.parseInt(productIndex) - 1);
    }

    @Then("success message is displayed with background color is {string}")
    public void successMessageIsDisplayedWithBackgroundColor(String expectedColor) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p[class='content']")));
        SoftAssert soft = new SoftAssert();
        String actualMessage = wishList.getWishlistSuccessMessage();
        String expectedMessage = "The product has been added to your wishlist";
        soft.assertTrue(actualMessage.contains(expectedMessage), "Wishlist success message does not match");
        String actualBgColor = wishList.getWishlistSuccessMessageColor();
        String expectedBgColor = "rgba(75, 176, 122, 1)";
        soft.assertTrue(actualBgColor.contains(expectedBgColor), "Wishlist success message color does not match");
        soft.assertAll();
    }

    @And("click on Wishlist Tab on the top of the page")
    public void clickOnWishlistTabOnTheTopOfThePage() {
        if (wishList.isWishlistSuccessMessageInvisible()) {
            wishList.clickWishlistButton();
        }
    }

    @Then("product is added to wish list with quantity {string}")
    public void productIsAddedToWishListWithQuantity(String expectedQuantity) {
        Assert.assertEquals(wishList.getWishlistQuantity(), expectedQuantity, "Wishlist quantity does not match");
    }
}