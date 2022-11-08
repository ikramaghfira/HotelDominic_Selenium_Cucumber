package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CreateAccountPage;
import pages.LogInPage;
import pages.MyAccountPage;
import static stepDef.Hook.driver;


public class SignUpValidCredential {
    LogInPage logInPage ;
    CreateAccountPage createAccountPage;
    MyAccountPage myAccountPage;
    public String userName = ""+(int)(Math.random()*Integer.MAX_VALUE);
    public String email = "fira"+userName+"@gmail.com";


    @When("user fill unregistered email to create an account")
    public void user_fill_unregistered_to_create_an_account() throws Throwable{
        logInPage = new LogInPage(driver);
        logInPage
                .createAccount(email)
                .goToCreateAccountPage()
                .verifyCreateAccountPage();
        Thread.sleep(2000);
    }

    @And("user fill in the following valid credentials: {string}, {string}, {string}")
    public void user_fill_in_the_following_valid_credentials(String string,
                                                             String string2, String string3) throws Throwable {
        createAccountPage = new CreateAccountPage(driver);
        createAccountPage
                .fillCredentials(string, string2, string3)
                .pickGender(1)
                .selectBornDate("17","11","1997")
                .checkList("both");
        Thread.sleep(2000);
    }

    @And("user click register button")
    public void user_click_register_button() throws Throwable {
        createAccountPage = new CreateAccountPage(driver);
        createAccountPage
                .goToMyAccountPage();
    }

    @Then("user should be navigated to the my account page")
    public void user_should_be_navigated_to_the_my_account_page() throws Throwable {
        myAccountPage = new MyAccountPage(driver);
        myAccountPage
                .verifyMyAccountPage()
                .verifySuccessRegisteredAccount();
        Thread.sleep(2000);
    }
}
