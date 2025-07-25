package StepDefinitions;

import Base.TestBase;
import Pages.P03_HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class D08_followUsStepDef extends TestBase {
    private final P03_HomePage followUs = new P03_HomePage();

    @When("user opens {string} link")
    public void openLink(String linkName) {
        followUs.getFollowUsLink(linkName).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    @Then("{string} is opened in new tab")
    public void isOpenedInNewTab(String expectedUrl) {
        followUs.switchLink();
        String actualURL = followUs.getCurrentURL();
        Assert.assertTrue(actualURL.contains(expectedUrl), "Social media URL does not contain: " + expectedUrl);
    }
}