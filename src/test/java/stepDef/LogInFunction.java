package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LogInPage;
import pages.MyAccountPage;

import static stepDef.Hook.driver;

public class LogInFunction {

    LogInPage logInPage = new LogInPage(driver);
    MyAccountPage myAccountPage = new MyAccountPage(driver);
    @When("user fill email field with valid email and password: {string}, {string}")
    public void user_fill_email_field_with_valid_email_and_password(String email, String password) throws Throwable{
        logInPage
                .inputEmailandPassword(email,password)
                .clickSignInButton();
    }

    @Then("user should be navigated to the MY ACCOUNT page")
    public void user_should_be_navigated_to_the_my_account_page() {
        myAccountPage.verifyMyAccountPage();
    }

    @When("user fill email field with email and incorrect password: {string}, {string}")
    public void user_fill_email_field_with_email_and_incorrect_password(String email, String password) throws Throwable{
        logInPage
                .inputEmailandPassword(email,password)
                .clickSignInButton();
    }

    @Then("user should be shown error log in message")
    public void user_should_be_shown_error_log_in_message() throws Throwable{
        logInPage.verifyErrorLogInMessage();
    }

    @When("user fill email field with incorrect email and password: {string}, {string}")
    public void user_fill_email_field_with_incorrect_email_and_password(String email, String password) throws Throwable {
        logInPage
                .inputEmailandPassword(email, password)
                .clickSignInButton();
    }

    @When("^user fill email field with invalid (.*) and (.*)$")
    public void user_fill_email_field_with_invalid_email_and_password(String email, String password) throws Throwable{
        logInPage
                .inputEmailandPassword(email, password)
                .clickSignInButton();
    }

    @When("user fill email field with email and invalid password: {string}, {string}")
    public void user_fill_email_field_with_email_and_invalid_password(String email, String password) throws Throwable{
        logInPage
                .inputEmailandPassword(email, password)
                .clickSignInButton();
    }

    @When("user fill invalid email and password: {string}, {string}")
    public void user_fill_invalid_email_and_password(String email, String password) throws Throwable {
        logInPage
                .inputEmailandPassword(email, password)
                .clickSignInButton();
    }

    @When("user left the fields empty")
    public void user_left_the_fields_empty() {
        logInPage.clickSignInButton();
    }
}
