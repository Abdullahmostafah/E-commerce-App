package org.example.StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P02_Login;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class D02_loginStepDef {
    P02_Login login = new P02_Login();
    @Given("user go to login page")
    public void userGoToLoginPage ()
    {
        login.loginButton().click();
    }
    @When("^user login with \"(.*)\" \"(.*)\" and \"(.*)\"$")
    public void userLoginWithAnd(String validation,String email, String password) {
        login.email().sendKeys(email);
        login.password().sendKeys(password);
    }
    @And("user press on login button")
    public void userPressOnLoginButton() throws InterruptedException {
        login.pressLogin().click();
        Thread.sleep(3000);
    }
    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {
        SoftAssert soft = new SoftAssert();
        String actualURL = "https://demo.nopcommerce.com/";
        String expectedURL = Hooks.driver.getCurrentUrl();
        soft.assertTrue(actualURL.contains(expectedURL));
        soft.assertTrue(login.myAccount().isDisplayed());
        soft.assertAll();
    }
    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem() {
        SoftAssert soft = new SoftAssert();
        String actualMessage = login.errorMessage().getText();
        String expectedMessage = "Login was unsuccessful.";
        soft.assertTrue(actualMessage.contains(expectedMessage));
        String actualColor = Color.fromString(login.errorMessage().getCssValue("color")).asHex();
        String expectedColor = "#e4434b";
        soft.assertTrue(actualColor.contains(expectedColor));
        soft.assertAll();
    }
}