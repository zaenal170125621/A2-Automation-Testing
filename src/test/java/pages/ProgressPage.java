package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object Model for Progress Overview Page
 * URL: https://polban-space.cloudias79.com/jtk-learn/summary-progress/{courseId}
 */
public class ProgressPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Table or title showing progress info
    @FindBy(css = "h3.courses-title, table")
    private WebElement progressTableOrTitle;

    public ProgressPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    /**
     * Check if Progress page is displayed
     */
    public boolean isPageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(progressTableOrTitle));
            return progressTableOrTitle.isDisplayed() && driver.getCurrentUrl().contains("summary-progress");
        } catch (Exception e) {
            return false;
        }
    }
}
