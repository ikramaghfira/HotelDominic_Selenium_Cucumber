package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LandingPage;
import pages.LogInPage;

import static stepDef.Hook.driver;

public class LogInFeatures {

    LogInPage logInPage = new LogInPage(driver);
    LandingPage landingPage = new LandingPage(driver);

    @When("user left all fields empty")
    public void user_left_all_fields_empty() {
        logInPage.clickSignInButton();
    }

    @And("user click back button on error message")
    public void user_click_back_button_on_error_message() throws Throwable {
        logInPage.clickBackOnError();
    }

    @When("user click forgot password button")
    public void user_click_forgot_password_button() {
        logInPage.clickForgotPasswordButton();
    }

    @Then("user should be direct to FORGOT PASSWORD page")
    public void user_should_be_direct_to_forgot_password_page() throws Throwable{
        logInPage.verifyForgotPasswordPage();
    }
}
