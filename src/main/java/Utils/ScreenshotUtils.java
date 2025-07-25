package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class ScreenshotUtils {
    private static final Logger logger = LoggerFactory.getLogger(ScreenshotUtils.class);

    public static String takeScreenshot(WebDriver driver, String testName) {
        if (driver == null) {
            logger.error("WebDriver is null, cannot capture screenshot for test '{}'", testName);
            return "";
        }

        try {
            driver.manage().window().maximize();
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
        } catch (Exception e) {
            logger.warn("Failed to maximize window or wait for body element for test '{}': {}", testName, e.getMessage());
        }

        try {
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timeStamp = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss").format(new Date());
            String fileName = testName.replaceAll("[^a-zA-Z0-9]", "_") + "_" + timeStamp + ".png";
            String destination = System.getProperty("user.dir") + "/target/screenshots/" + fileName;

            File screenshotDir = new File(System.getProperty("user.dir") + "/target/screenshots/");
            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs();
            }

            FileUtils.copyFile(source, new File(destination));
            logger.info("Screenshot saved at: {}", destination);
            return destination;
        } catch (IOException e) {
            logger.error("Failed to capture screenshot for test '{}': {}", testName, e.getMessage());
            return "";
        }
    }
}