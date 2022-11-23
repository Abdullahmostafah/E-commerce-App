package org.example.StepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P03_HomePage;
import org.testng.Assert;

public class D08_followUsStepDef {
    P03_HomePage followUs = new P03_HomePage();
    @When("user opens {string} link")
    public void openLink(String linkName) throws InterruptedException {
        followUs.getFollowUsLink(linkName).click();
        Thread.sleep(2000);
    }
    @Then("{string} is opened in new tab")
    public void isOpenedInNewTab(String followUsLink) {
        followUs.switchLink();
        String actualURL = followUs.getCurrentURL();
        String expectedURL = followUsLink;
        Assert.assertTrue(actualURL.contains(expectedURL));
    }
}
