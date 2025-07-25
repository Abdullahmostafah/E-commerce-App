package Base;

import Utils.ConfigReaderWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * Base class for test setup, browser configuration, and common WebDriver utilities.
 */
public class TestBase {
    private static final Logger logger = LoggerFactory.getLogger(TestBase.class);
    protected static WebDriver driver;
    protected static SoftAssert softAssert = new SoftAssert();
    private static final String browser = ConfigReaderWriter.getPropKey("browser");

    protected static void initializeDriver() {
        if (driver != null) {
            logger.info("WebDriver already initialized, skipping initialization");
            return;
        }

        logger.info("Initializing WebDriver for browser: {}", browser);
        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-save-password-bubble");
                chromeOptions.addArguments("--disable-password-generation");
                chromeOptions.addArguments("--password-store=basic");
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("--incognito");
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                chromeOptions.setExperimentalOption("prefs", prefs);
                chromeOptions.addArguments("user-data-dir=" + System.getProperty("java.io.tmpdir") + "/chrome-temp-profile");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("-private");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                logger.error("Unsupported browser: {}", browser);
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        initiateBrowser();
    }

    private static void initiateBrowser() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logger.info("Browser window maximized and implicit wait set to 10 seconds");
    }

    protected void openWebSite() {
        if (driver == null) {
            logger.error("WebDriver is not initialized. Call initializeDriver() first.");
            throw new IllegalStateException("WebDriver is not initialized");
        }
        String url = ConfigReaderWriter.getPropKey("url");
        logger.info("Navigating to URL: {}", url);
        driver.get(url);
    }

    protected static void tearDown() {
        if (driver != null) {
            logger.info("Closing browser and quitting WebDriver");
            driver.quit();
            driver = null;
        }
    }

}