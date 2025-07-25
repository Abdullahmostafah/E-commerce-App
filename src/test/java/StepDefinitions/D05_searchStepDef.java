package StepDefinitions;

import Base.TestBase;
import Pages.P03_HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class D05_searchStepDef extends TestBase {
    private final P03_HomePage search = new P03_HomePage();

    @When("user click on search field")
    public void clickOnSearch() {
        search.clickSearchField();
    }

    @And("user search with {string}")
    public void userSearchWith(String product) {
        search.enterSearchText(product);
    }

    @And("user click on search button")
    public void userClickOnSearchButton() {
        search.clickSearchButton();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2[class='product-title']")));
    }

    @Then("user Could find {string} relative results")
    public void userCouldFindRelativeResults(String expectedProduct) {
        SoftAssert soft = new SoftAssert();
        String expectedURL = "https://demo.nopcommerce.com/search?q=" + expectedProduct.toLowerCase();
        String actualURL = search.getCurrentURL();
        soft.assertTrue(actualURL.contains(expectedProduct.toLowerCase()), "Search URL does not contain product name");
        for (WebElement product : search.getRelativeResults()) {
            String actualProduct = product.getText().toLowerCase();
            soft.assertTrue(actualProduct.contains(expectedProduct.toLowerCase()), "Product result does not contain: " + expectedProduct);
        }
        soft.assertAll();
    }

    @Then("user could find {string} inside product detail page")
    public void userCouldFindInsideProductDetailPage(String expectedSku) {
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(search.getCurrentProduct().size(), 1, "Expected exactly one product in search results");
        search.clickProduct();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("sku")));
        String actualSku = search.getActualSKU().get(0).getText();
        soft.assertTrue(actualSku.contains(expectedSku), "SKU does not match: " + actualSku);
        soft.assertAll();
    }
}