package stepDef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LogInPage;

import static stepDef.Hook.driver;

public class SignUpWithRegisteredEmail {
    LogInPage login = new LogInPage(driver);


    @When("user fill registered {string} to create an account")
    public void user_fill_registered_to_create_an_account(String text) throws Throwable {
        login
                .createAccount(text)
                .goToCreateAccountPage();
        Thread.sleep(3000);
    }

    @Then("user should be shown error message")
    public void user_should_be_shown_error_message() throws Throwable{
        login.verifyErrorMessageLoginPage();
    }

}
