package StepDefinitions;

import Base.TestBase;
import Pages.P02_Login;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class D02_loginStepDef extends TestBase {
    private final P02_Login login = new P02_Login();

    @Given("user go to login page")
    public void userGoToLoginPage() {
        login.clickLoginButton();
    }

    @When("user login with {string} {string} and {string}")
    public void userLoginWith(String validation, String email, String password) {
        login.enterEmail(email);
        login.enterPassword(password);
    }

    @And("user press on login button")
    public void userPressOnLoginButton() {
        login.clickPressLogin();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.or(
                        ExpectedConditions.visibilityOfElementLocated(By.className("ico-account")),
                        ExpectedConditions.visibilityOfElementLocated(By.className("message-error"))
                ));
    }

    @Then("user should {string}")
    public void userShould(String expectedResult) {
        SoftAssert soft = new SoftAssert();
        if (expectedResult.equals("login to the system successfully")) {
            String expectedURL = "https://demo.nopcommerce.com/";
            String actualURL = driver.getCurrentUrl();
            soft.assertEquals(actualURL, expectedURL, "URL after successful login does not match");
            soft.assertTrue(login.isMyAccountDisplayed(), "My Account link is not displayed");
        } else {
            String actualMessage = login.getErrorMessageText();
            String expectedMessage = "Login was unsuccessful.";
            String actualColor = login.getErrorMessageColor();
            String expectedColor = "#e4434b";
            soft.assertTrue(actualMessage.contains(expectedMessage), "Error message does not match");
            soft.assertEquals(actualColor, expectedColor, "Error message color does not match");
        }
        soft.assertAll();
    }
}