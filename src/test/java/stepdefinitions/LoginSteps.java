
package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.LoginPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    // Run before every scenario
    
    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
    
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");
    
        driver = new ChromeDriver(options);
    }


    // Run after every scenario
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I open the SauceDemo login page")
    public void openLoginPage() {
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @When("I enter username {string}")
    public void enterUsername(String username) {
        loginPage.enterUsername(username);
    }

    @When("I enter a username with {int} characters")
    public void enterLongUsername(int length) {
        String username = "a".repeat(length);
        loginPage.enterUsername(username);
    }

    @When("I enter password {string}")
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("I click the login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void verifySuccessfulLogin() {
        WebDriverWait wait = new WebDriverWait(
                driver, Duration.ofSeconds(20)
        );

        wait.until(
                webDriver -> webDriver.getCurrentUrl()
                        .contains("inventory.html")
        );

        String actualTitle = driver.findElement(
                By.className("title")
        ).getText();

        assertEquals(
                "Products",
                actualTitle,
                "Login failed: Products title was not displayed."
        );

        assertTrue(
                driver.getCurrentUrl().contains("inventory.html"),
                "Login failed: products page was not opened."
        );
    }

    @Then("I should see the login error message {string}")
    public void verifyLoginErrorMessage(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(
                driver, Duration.ofSeconds(10)
        );

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("[data-test='error']")
                )
        );

        String actualMessage = loginPage.getErrorMessage();

        assertEquals(
                expectedMessage,
                actualMessage,
                "Login error message does not match the expected result."
        );
    }
}
