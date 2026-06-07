package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object Model for Pemantauan Page
 * URL: https://polban-space.cloudias79.com/jtk-learn/users
 */
public class PemantauanPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Heading of the page: "Pemantauan Progres Belajar"
    @FindBy(css = "h3.courses-title")
    private WebElement pageHeading;

    public PemantauanPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    /**
     * Check if Pemantauan page is displayed
     */
    public boolean isPageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(pageHeading));
            return pageHeading.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Get aggregate data for a specific course by its name.
     * Columns:
     * - Col 1: No
     * - Col 2: Nama Kursus
     * - Col 3: Jumlah Pelajar
     * - Col 4: Jumlah Materi
     * - Col 5: Jumlah Kuis
     */
    public int getStudentCount(String courseName) {
        WebElement cell = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//tr[td[contains(text(),'" + courseName + "')]]/td[3]")
        ));
        return Integer.parseInt(cell.getText().trim());
    }

    public int getMaterialCount(String courseName) {
        WebElement cell = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//tr[td[contains(text(),'" + courseName + "')]]/td[4]")
        ));
        return Integer.parseInt(cell.getText().trim());
    }

    public int getQuizCount(String courseName) {
        WebElement cell = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//tr[td[contains(text(),'" + courseName + "')]]/td[5]")
        ));
        return Integer.parseInt(cell.getText().trim());
    }

    /**
     * Click on Progres button for a specific course
     */
    public void clickProgresButton(String courseName) {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//tr[td[contains(text(),'" + courseName + "')]]//button[contains(text(),'Progres')]")
        ));
        btn.click();
    }
}
