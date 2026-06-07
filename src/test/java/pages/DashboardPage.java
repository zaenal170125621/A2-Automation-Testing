package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Page Object Model for JTK Learn Dashboard Page (Pengajar)
 * URL: https://polban-space.cloudias79.com/jtk-learn/dashboard-pengajar
 * Uses Page Factory pattern for element initialization
 */
public class DashboardPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // ===== Web Elements using Page Factory =====

    // Greeting text "Hai, Pengajar 5!"
    @FindBy(xpath = "//h3[contains(text(),'Hai')]")
    private WebElement greetingText;

    // Page heading "Kursus"
    @FindBy(xpath = "//h3[contains(text(),'Kursus')]")
    private WebElement kursusHeading;

    // Navigation links
    @FindBy(css = "a.nav-link")
    private List<WebElement> navLinks;

    // Beranda nav link
    @FindBy(xpath = "//a[contains(text(),'Beranda')]")
    private WebElement berandaLink;

    // Pemantauan nav link
    @FindBy(xpath = "//a[contains(text(),'Pemantauan')]")
    private WebElement pemantauanLink;

    // Profile dropdown (contains username like "Pengajar 5")
    @FindBy(xpath = "//li[contains(@class,'dropdown')]/a[contains(.,'Pengajar 5')] | //a[contains(text(),'Pengajar 5')]")
    private WebElement profileDropdown;

    // Logout button (Keluar) in dropdown
    @FindBy(xpath = "//button[contains(text(),'Keluar')]")
    private WebElement logoutButton;

    // Tambah Kursus button
    @FindBy(css = "button.add-course-button")
    private WebElement tambahKursusButton;

    // Navbar brand/logo
    @FindBy(css = "a.navbar-brand")
    private WebElement navbarBrand;

    // ===== Constructor with Page Factory =====

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // ===== Page Actions =====

    /**
     * Check if dashboard page is displayed
     */
    public boolean isDashboardDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(greetingText));
            return greetingText.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Get greeting text content
     */
    public String getGreetingText() {
        wait.until(ExpectedConditions.visibilityOf(greetingText));
        return greetingText.getText();
    }

    /**
     * Check if Kursus heading is visible
     */
    public boolean isKursusHeadingDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(kursusHeading));
            return kursusHeading.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Get all navigation menu items text
     */
    public List<WebElement> getNavLinks() {
        return navLinks;
    }

    /**
     * Check if navigation menu items are present
     */
    public boolean areNavLinksDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(navLinks));
            return navLinks.size() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Click on Beranda nav link
     */
    public void clickBeranda() {
        wait.until(ExpectedConditions.elementToBeClickable(berandaLink));
        berandaLink.click();
    }

    /**
     * Click on Pemantauan nav link
     */
    public void clickPemantauan() {
        wait.until(ExpectedConditions.elementToBeClickable(pemantauanLink));
        pemantauanLink.click();
    }

    /**
     * Click profile dropdown to open menu
     */
    public void clickProfileDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(profileDropdown));
        profileDropdown.click();
    }

    /**
     * Click logout (Keluar) button
     */
    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButton.click();
    }

    /**
     * Perform complete logout action
     */
    public void logout() {
        clickProfileDropdown();
        // Small wait for dropdown animation
        try { Thread.sleep(500); } catch (InterruptedException e) { /* ignore */ }
        clickLogout();
    }

    /**
     * Check if Tambah Kursus button is displayed
     */
    public boolean isTambahKursusButtonDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(tambahKursusButton));
            return tambahKursusButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Click Tambah Kursus button
     */
    public void clickTambahKursus() {
        wait.until(ExpectedConditions.elementToBeClickable(tambahKursusButton));
        tambahKursusButton.click();
    }

    /**
     * Get current page URL
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Get page title
     */
    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Check if URL contains dashboard
     */
    public boolean isOnDashboard() {
        return driver.getCurrentUrl().contains("dashboard");
    }
}
