package stepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LandingPage;
import pages.LogInPage;

public class Hook  {
    static WebDriver driver;
    static LandingPage landingpage;
    static LogInPage loginpage;


    @Before(order=1)
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        ChromeOptions o = new ChromeOptions();
        o.addArguments("--incognito");
        driver = new ChromeDriver(o);
        driver.get("http://qa.cilsy.id:8080/");
        driver.manage().window().maximize();
    }

    @Before(order=2, value = "@regression and @signup")
    @Given("user on the landing page")
    public void user_on_the_landing_page() throws Throwable{
        landingpage= new LandingPage(driver);
        landingpage.verifyLandingPage();
    }
    @When("user click Sign In button")
    public void user_click_sign_in_button() throws Throwable {
        landingpage.goToLogInPage();
    }

    @Then("user should be navigated to login page")
    public void user_should_be_navigated_to_login_page() throws Throwable {
        loginpage = new LogInPage(driver);
        loginpage.verifyLoginPage();
        Thread.sleep(5000);
    }

    @After
    public void teardown(){
        driver.quit();
    }
}
