package StepDefinitions;

import Base.TestBase;
import Pages.P01_Register;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class D01_registerStepDef extends TestBase {
    private final P01_Register register = new P01_Register();

    @Given("user go to register page")
    public void goRegisterPage() {
        register.clickRegisterLink();
    }

    @When("user select gender type")
    public void userSelectGenderType() {
        register.selectGenderMale();
    }

    @And("user enter first name {string} and last name {string}")
    public void userEnterFirstNameAndLastName(String firstName, String lastName) {
        register.enterFirstName(firstName);
        register.enterLastName(lastName);
    }

    @And("user enter email {string} field")
    public void userEnterEmailField(String email) {
        register.enterEmail(email);
    }

    @And("user fills Password fields {string} {string}")
    public void userFillsPasswordFields(String password, String confirmPassword) {
        register.enterPassword(password);
        register.enterConfirmPassword(confirmPassword);
    }

    @And("user clicks on register button")
    public void userClicksOnRegisterButton() {
        register.clickRegisterButton();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("result")));
    }

    @Then("success message is displayed")
    public void successMessageIsDisplayed() {
        SoftAssert soft = new SoftAssert();
        String expectedResult = "Your registration completed";
        String actualResult = register.getSuccessMessageText();
        String expectedColor = "rgba(76, 177, 124, 1)";
        String actualColor = register.getSuccessMessageColor();
        soft.assertTrue(actualResult.contains(expectedResult), "Success message text does not match");
        soft.assertTrue(actualColor.contains(expectedColor), "Success message color does not match");
        soft.assertAll();
    }
}