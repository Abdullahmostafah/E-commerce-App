package StepDefinitions;

import Base.TestBase;
import Pages.P03_HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class D04_currenciesStepDef extends TestBase {
    private final P03_HomePage homePage = new P03_HomePage();

    @When("user select {string} currency from the dropdown list")
    public void selectCurrency(String currency) {
        homePage.selectCurrency(currency);
    }

    @Then("{string} symbol displayed for all products")
    public void currencySymbolDisplayedForAllProducts(String symbol) {
        SoftAssert soft = new SoftAssert();
        for (WebElement product : homePage.getAllProducts()) {
            String actualCurrency = product.getText();
            soft.assertTrue(actualCurrency.contains(symbol), "Currency symbol not found in product: " + actualCurrency);
        }
        soft.assertAll();
    }
}