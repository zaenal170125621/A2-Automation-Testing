package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Cucumber Hooks for WebDriver lifecycle management.
 * Before: Initializes ChromeDriver with WebDriverManager.
 * After: Takes screenshot on failure and quits the driver.
 */
public class Hooks {

    private static WebDriver driver;

    @Before
    public void setUp() {
        // Auto-download and setup ChromeDriver
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (driver != null) {
            // Take screenshot on failure for reporting
            if (scenario.isFailed()) {
                try {
                    final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                    scenario.attach(screenshot, "image/png", "Screenshot on Failure");
                } catch (Exception e) {
                    System.out.println("Failed to take screenshot: " + e.getMessage());
                }
            }
            driver.quit();
        }
    }

    /**
     * Get the shared WebDriver instance
     */
    public static WebDriver getDriver() {
        return driver;
    }
}
