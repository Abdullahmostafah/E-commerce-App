package Pages;

import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class P03_HomePage extends TestBase {
    @FindBy(name = "customerCurrency")
    private WebElement euroCurrency;

    @FindBy(css = "span[class='price actual-price']")
    private List<WebElement> allProducts;

    @FindBy(id = "small-searchterms")
    private WebElement searchField;

    @FindBy(css = "button[class='button-1 search-box-button']")
    private WebElement searchButton;

    @FindBy(css = "h2[class='product-title']")
    private List<WebElement> relativeResults;

    @FindBy(className = "picture")
    private WebElement productClick;

    @FindBy(className = "product-item")
    private List<WebElement> currentProduct;

    @FindBy(className = "sku")
    private List<WebElement> actualSKU;

    @FindBy(css = "ul[class='top-menu notmobile']>li>a[href]")
    private List<WebElement> categoryList;

    @FindBy(css = "div[class='page-title'] h1")
    private WebElement subCategoryTitle;

    @FindBy(css = "button[class='button-2 add-to-wishlist-button']")
    private List<WebElement> wishButtons;

    @FindBy(css = "p[class='content']")
    private WebElement wishlistSuccessMessage;

    @FindBy(css = "div[class='bar-notification success']")
    private WebElement wishListSuccessMessageColor;

    @FindBy(xpath = "//p[@class='content']")
    private WebElement returnWishlistSuccessMessage;

    @FindBy(className = "wishlist-label")
    private WebElement wishlistButton;

    @FindBy(className = "qty-input")
    private WebElement wishlistQuantity;

    public P03_HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void selectCurrency(String currency) {
        new Select(euroCurrency).selectByVisibleText(currency);
    }

    public List<WebElement> getAllProducts() {
        return allProducts;
    }

    public void clickSearchField() {
        searchField.click();
    }

    public void enterSearchText(String text) {
        searchField.sendKeys(text);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public List<WebElement> getRelativeResults() {
        return relativeResults;
    }

    public void clickProduct() {
        productClick.click();
    }

    public List<WebElement> getCurrentProduct() {
        return currentProduct;
    }

    public List<WebElement> getActualSKU() {
        return actualSKU;
    }

    public List<WebElement> getCategoryList() {
        return categoryList;
    }

    public String getSubCategoryTitle() {
        return subCategoryTitle.getText();
    }

    public void clickWishButton(int index) {
        wishButtons.get(index).click();
    }

    public String getWishlistSuccessMessage() {
        return wishlistSuccessMessage.getText();
    }

    public String getWishlistSuccessMessageColor() {
        return wishListSuccessMessageColor.getCssValue("background-color");
    }

    public boolean isWishlistSuccessMessageInvisible() {
        return new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.invisibilityOf(returnWishlistSuccessMessage));
    }

    public void clickWishlistButton() {
        wishlistButton.click();
    }

    public String getWishlistQuantity() {
        return wishlistQuantity.getAttribute("value");
    }

    public List<WebElement> getSubCategoryList(int indexNumber) {
        return driver.findElements(By.xpath("//ul[@class='top-menu notmobile']/li[" + indexNumber + "]/ul[@class='sublist first-level']/li/a[@href]"));
    }

    public WebElement getFollowUsLink(String linkName) {
        return driver.findElement(By.cssSelector("li[class='" + linkName + "']>a[target='_blank']"));
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public void switchLink() {
        String currentWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}