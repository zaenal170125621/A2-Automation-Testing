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
 * Step Definitions for Login feature.
 * Maps Gherkin steps to Java automation code using Page Object Model.
 */
public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    private static final String BASE_URL = "https://polban-space.cloudias79.com/jtk-learn/";

    @Given("User has opened the browser")
    public void userHasOpenedTheBrowser() {
        driver = Hooks.getDriver();
        assertThat(driver).isNotNull();
    }

    @And("User has navigated to the JTK Learn login page")
    public void userHasNavigatedToTheJTKLearnLoginPage() {
        driver.get(BASE_URL);
        loginPage = new LoginPage(driver);
        // Wait for the page to load
        try { Thread.sleep(2000); } catch (InterruptedException e) { /* ignore */ }
        assertThat(loginPage.isLoginPageDisplayed()).isTrue();
    }

    @When("User enters email {string} in the email field")
    public void userEntersEmailInTheEmailField(String email) {
        loginPage.enterEmail(email);
    }

    @And("User enters password {string} in the password field")
    public void userEntersPasswordInThePasswordField(String password) {
        loginPage.enterPassword(password);
    }

    @And("User clicks on the login button")
    public void userClicksOnTheLoginButton() {
        loginPage.clickLoginButton();
        // Wait for page transition or error
        try { Thread.sleep(3000); } catch (InterruptedException e) { /* ignore */ }
    }

    @Then("User should be navigated to the dashboard page")
    public void userShouldBeNavigatedToTheDashboardPage() {
        dashboardPage = new DashboardPage(driver);
        assertThat(driver.getCurrentUrl()).contains("dashboard");
    }

    @And("User should see the dashboard content")
    public void userShouldSeeTheDashboardContent() {
        assertThat(dashboardPage.isDashboardDisplayed()).isTrue();
        assertThat(dashboardPage.getGreetingText()).contains("Hai");
    }

    @Then("User should see an unsuccessful login notification message")
    public void userShouldSeeAnUnsuccessfulLoginNotificationMessage() {
        assertThat(loginPage.isErrorMessageDisplayed()).isTrue();
    }
}
