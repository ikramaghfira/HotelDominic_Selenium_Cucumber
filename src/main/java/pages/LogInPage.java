package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LogInPage extends BasePage {

    private String expectedHeader = "authentication";

    @FindBy(css = ".page-heading")
    WebElement loginHeader;
    @FindBy(id = "email_create")
    WebElement emailAddress;
    @FindBy(id = "SubmitCreate")
    WebElement createAccountBtn;
    @FindBy(id = "create_account_error")
    WebElement errorMsgLogin;
    @FindBy(xpath="//div[@id='center_column']/div[@class='alert alert-danger']")
    WebElement errorLogIn;
    @FindBy(id = "email")
    WebElement emailLogIn;
    @FindBy(id="passwd")
    WebElement pwLogIn;
    @FindBy(id="SubmitLogin")
    WebElement signInBtn;
    @FindBy(xpath = "//a[@title='Back']")
    WebElement errorBackBtn;
    @FindBy(xpath = "//a[@title='Recover your forgotten password']")
    WebElement forgotBtn;

    public LogInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LogInPage verifyLoginPage(){
        verifyTextEqual(loginHeader,expectedHeader);
        return this;
    }

    public LogInPage createAccount(String text) throws InterruptedException {
        writeText(emailAddress, text);
        return this;
    }

    public void verifyErrorMessageLoginPage() throws InterruptedException {
        Thread.sleep(1000);
        boolean isAppeared = errorMsgLogin.isDisplayed();
        Assert.assertTrue(isAppeared);
    }

    public CreateAccountPage goToCreateAccountPage() throws InterruptedException {
        click(createAccountBtn);
        Thread.sleep(3000);
        return new CreateAccountPage(driver);
    }

    public LogInPage inputEmailandPassword(String text1, String text2) throws InterruptedException {
        emailLogIn.click();
        emailLogIn.sendKeys(text1);
        Thread.sleep(1000);
        pwLogIn.click();
        pwLogIn.sendKeys(text2);
        return this;
    }

    public MyAccountPage clickSignInButton(){
        signInBtn.click();
        return new MyAccountPage(driver);
    }

    public LogInPage verifyErrorLogInMessage() throws InterruptedException {
        Thread.sleep(2000);
        boolean isAppeared = errorLogIn.isDisplayed();
        Assert.assertTrue(isAppeared);
        return this;
    }

    public LandingPage clickBackOnError() throws InterruptedException {
        Thread.sleep(2000);
        errorBackBtn.click();
        return new LandingPage(driver);
    }

    public LogInPage clickForgotPasswordButton(){
        forgotBtn.click();
        return this;
    }

    public LogInPage verifyForgotPasswordPage() throws InterruptedException {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Forgot your password - Sekolah QA");
        Thread.sleep(1000);
        return this;
    }

}
