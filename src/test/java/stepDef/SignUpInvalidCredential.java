package stepDef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CreateAccountPage;
import static stepDef.Hook.driver;

public class SignUpInvalidCredential {

    CreateAccountPage create = new CreateAccountPage(driver);
    @When("user fill in the following invalid credentials: {string}, {string}, {string}")
    public void user_fill_in_the_following_invalid_credentials(String string, String string2, String string3) {
        create
                .fillCredentials(string, string2,string3)
                .pickGender(2)
                .goToMyAccountPage();
    }

    @Then("user should be shown error messages")
    public void user_should_be_shown_error_messages() {
        create.verifyErrorMessageCreateAccountPage();
    }
}
