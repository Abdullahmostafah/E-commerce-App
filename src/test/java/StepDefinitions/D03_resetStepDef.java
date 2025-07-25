package StepDefinitions;

import Base.TestBase;
import Pages.P02_Login;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class D03_resetStepDef extends TestBase {
    private final P02_Login reset = new P02_Login();

    @When("user select forgot password")
    public void userSelectForgotPassword() {
        reset.clickForgetPassword();
    }

    @And("user enter the email {string}")
    public void userEnterTheEmail(String email) {
        reset.enterEmailAddress(email);
    }

    @And("user click on recover button")
    public void userClickOnRecoverButton() {
        reset.clickRecoverButton();
    }

    @Then("email sent message is displayed")
    public void emailSentMessageIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("content")));
        String expectedMessage = "Email with instructions has been sent to you.";
        String actualMessage = reset.getResetMessageText();
        Assert.assertTrue(actualMessage.contains(expectedMessage), "Reset password message does not match");
    }
}