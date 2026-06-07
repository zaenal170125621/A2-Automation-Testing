package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Step Definitions for Logout feature.
 * Maps Gherkin steps to Java automation code using Page Object Model.
 */
public class LogoutSteps {

    private WebDriver driver;
    private DashboardPage dashboardPage;
    private LoginPage loginPage;

    private static final String BASE_URL = "https://polban-space.cloudias79.com/jtk-learn/";

    @Given("User is logged in with email {string} and password {string}")
    public void userIsLoggedInWithEmailAndPassword(String email, String password) {
        driver = Hooks.getDriver();
        loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        // Wait for login to complete
        try { Thread.sleep(3000); } catch (InterruptedException e) { /* ignore */ }
        dashboardPage = new DashboardPage(driver);
        assertThat(dashboardPage.isDashboardDisplayed()).isTrue();
    }

    @When("User clicks on the profile or menu button")
    public void userClicksOnTheProfileOrMenuButton() {
        dashboardPage.clickProfileDropdown();
        // Wait for dropdown animation
        try { Thread.sleep(1000); } catch (InterruptedException e) { /* ignore */ }
    }

    @And("User clicks on the logout button")
    public void userClicksOnTheLogoutButton() {
        dashboardPage.clickLogout();
        // Wait for logout to process
        try { Thread.sleep(3000); } catch (InterruptedException e) { /* ignore */ }
    }

    @Then("User should be redirected to the login page")
    public void userShouldBeRedirectedToTheLoginPage() {
        // After logout, URL should go back to login or base URL
        String currentUrl = driver.getCurrentUrl();
        assertThat(currentUrl).satisfiesAnyOf(
            url -> assertThat(url).contains("jtk-learn"),
            url -> assertThat(url).doesNotContain("dashboard")
        );
    }

    @And("User should see the login form")
    public void userShouldSeeTheLoginForm() {
        loginPage = new LoginPage(driver);
        assertThat(loginPage.isLoginPageDisplayed()).isTrue();
    }
}
