package Pages;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P02_Login extends TestBase {
    @FindBy(xpath = "//a[@href='/login?returnUrl=%2F']")
    private WebElement loginButton;

    @FindBy(id = "Email")
    private WebElement email;

    @FindBy(id = "Password")
    private WebElement password;

    @FindBy(css = "button[class='button-1 login-button']")
    private WebElement pressLogin;

    @FindBy(className = "ico-account")
    private WebElement myAccount;

    @FindBy(className = "message-error")
    private WebElement errorMessage;

    @FindBy(xpath = "//a[@href='/passwordrecovery']")
    private WebElement forgetPassword;

    @FindBy(id = "Email")
    private WebElement emailAddress;

    @FindBy(name = "send-email")
    private WebElement recoverButton;

    @FindBy(className = "content")
    private WebElement resetMessage;

    public P02_Login() {
        PageFactory.initElements(driver, this);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void enterEmail(String emailText) {
        email.sendKeys(emailText);
    }

    public void enterPassword(String pwd) {
        password.sendKeys(pwd);
    }

    public void clickPressLogin() {
        pressLogin.click();
    }

    public boolean isMyAccountDisplayed() {
        return myAccount.isDisplayed();
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    public String getErrorMessageColor() {
        return Color.fromString(errorMessage.getCssValue("color")).asHex();
    }

    public void clickForgetPassword() {
        forgetPassword.click();
    }

    public void enterEmailAddress(String emailText) {
        emailAddress.sendKeys(emailText);
    }

    public void clickRecoverButton() {
        recoverButton.click();
    }

    public String getResetMessageText() {
        return resetMessage.getText();
    }
}