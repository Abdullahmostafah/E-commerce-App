package org.example.StepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P03_HomePage;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class D04_currenciesStepDef {
    P03_HomePage homePage = new P03_HomePage();
    @When("user select Euro currency from the dropdown list")
    public void selectEuroCurrency () {
        Select select=new Select(homePage.euroCurrency());
        select.selectByIndex(1);
    }
    @Then("euro symbol displayed for all products")
    public void euroSymbolDisplayedForAllProducts() {
        SoftAssert soft = new SoftAssert();
        String actualCurrency = "";
        String expectedCurrency = "€";
        for (int i = 0 ;i<4;i++)
        {
            actualCurrency = homePage.getAllProducts().get(i).getText();
            soft.assertTrue(actualCurrency.contains(expectedCurrency));
        }
        soft.assertAll();
    }
}