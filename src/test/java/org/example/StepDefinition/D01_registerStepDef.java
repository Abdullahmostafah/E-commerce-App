package org.example.StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P01_Register;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class D01_registerStepDef {
    P01_Register register = new P01_Register();
    @Given("user go to register page")
    public void goRegisterPage()
    {
        register.RegisterLink().click();
    }
    @When("user select gender type")
    public void userSelectGenderType() {
        register.GenderType().click();
    }
    @And("^user enter first name \"(.*)\" and last name \"(.*)\"$")
    public void userEnterFirstNameAndLastName(String firstName, String lastName) {
        register.FirstName().sendKeys(firstName);
        register.LastName().sendKeys(lastName);
    }
    @And("user enter date of birth")
    public void userEnterDateOfBirth() {
        Select select = new Select(register.BirthDay());
        select.selectByIndex(10);
        select = new Select(register.BirthMonth());
        select.selectByValue("3");
        select= new Select(register.BirthYear());
        select.selectByVisibleText("1998");
    }
    @And("^user enter email \"(.*)\" field$")
    public void userEnterEmailField(String email) {
        register.email().sendKeys(email);
    }
    @And("^user fills Password fields \"(.*)\" \"(.*)\"$")
    public void userFillsPasswordFields(String password, String confirmPassword) {
        register.pasword().sendKeys(password);
        register.confirmPassword().sendKeys(confirmPassword);
    }
    @And("user clicks on register button")
    public void userClicksOnRegisterButton() throws InterruptedException {
        register.registerButton().click();
        Thread.sleep(3000);
    }
    @Then("success message is displayed")
    public void successMessageIsDisplayed() {
        SoftAssert soft=new SoftAssert();
        String expectedResult = "Your registration completed";
        String actualResult = register.successMessage().getText();
        String expectedColor = "rgba(76, 177, 124, 1)";
        String actualColor = register.successMessage().getCssValue("color");
        soft.assertTrue(actualResult.contains(expectedResult));
        soft.assertTrue(actualColor.contains(expectedColor));
        soft.assertAll();
    }
}