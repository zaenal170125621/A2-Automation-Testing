package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object Model for JTK Learn Login Page
 * URL: https://polban-space.cloudias79.com/jtk-learn/
 * Uses Page Factory pattern for element initialization
 */
public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // ===== Web Elements using Page Factory =====

    @FindBy(css = "input[placeholder='Masukkan email']")
    private WebElement emailInput;

    @FindBy(css = "input[placeholder='Masukan kata sandi']")
    private WebElement passwordInput;

    @FindBy(css = "button.btn-danger")
    private WebElement loginButton;

    // Error modal elements
    @FindBy(css = ".swal2-html-container")
    private WebElement errorMessage;

    @FindBy(css = "button.swal2-confirm")
    private WebElement closeErrorButton;

    // ===== Constructor with Page Factory initialization =====

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // ===== Page Actions =====

    /**
     * Enter email into the email input field
     */
    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    /**
     * Enter password into the password input field
     */
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    /**
     * Click the login (Masuk) button
     */
    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    /**
     * Perform complete login action
     */
    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    /**
     * Check if error notification message is displayed
     */
    public boolean isErrorMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Get the error message text
     */
    public String getErrorMessageText() {
        try {
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            return errorMessage.getText();
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Close the error modal
     */
    public void closeErrorModal() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(closeErrorButton));
            closeErrorButton.click();
        } catch (Exception e) {
            // Modal may not be present
        }
    }

    /**
     * Check if login page is displayed (email input visible)
     */
    public boolean isLoginPageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(emailInput));
            return emailInput.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Check if email input is empty
     */
    public boolean isEmailFieldEmpty() {
        return emailInput.getAttribute("value").isEmpty();
    }

    /**
     * Check if password input is empty
     */
    public boolean isPasswordFieldEmpty() {
        return passwordInput.getAttribute("value").isEmpty();
    }

    /**
     * Clear the email field
     */
    public void clearEmailField() {
        emailInput.clear();
    }

    /**
     * Clear the password field
     */
    public void clearPasswordField() {
        passwordInput.clear();
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
}
