package stepDef;

import io.cucumber.java.en.When;
import pages.LogInPage;

import static stepDef.Hook.driver;

public class SignUpInvalidEmail {
    @When("^user input invalid (.*) on the email address$")
    public void user_input_invalid_email_on_the_email_address(String email) throws Throwable{
        LogInPage logInPage = new LogInPage(driver);
        logInPage
                .createAccount(email)
                .goToCreateAccountPage();
    }
}
