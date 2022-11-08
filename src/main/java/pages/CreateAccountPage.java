package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CreateAccountPage extends BasePage {

    private String expectedHeaderCreatePg = "your personal information";

    @FindBy(id = "customer_firstname")
    WebElement inputFirstName;
    @FindBy(id = "customer_lastname")
    WebElement inputLastName;
    @FindBy(id = "passwd")
    WebElement inputPsw;
    @FindBy(id = "days")
    WebElement dayBirth;
    @FindBy(id = "months")
    WebElement monthBirth;
    @FindBy(id = "years")
    WebElement yearBirth;
    @FindBy(id = "email")
    WebElement inputEmail;
    @FindBy(id = "submitAccount")
    WebElement registerBtn;
    @FindBy(css = ".page-subheading.htl-reservation-page-sub-heading")
    WebElement headerCreatePage;
    @FindBy(css = ".alert.alert-danger")
    WebElement errorMsg;
    @FindBy(css="#id_gender1")
    WebElement mr;
    @FindBy(css="#id_gender2")
    WebElement mrs;
    @FindBy(id="newsletter")
    WebElement news;
    @FindBy(id="optin")
    WebElement offer;


    public CreateAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CreateAccountPage verifyCreateAccountPage(){
        verifyTextEqual(headerCreatePage, expectedHeaderCreatePg);
        return this;
    }

    public CreateAccountPage fillCredentials(String firstName, String lastName, String pw){
        writeText(inputFirstName, firstName)
                .writeText(inputLastName, lastName)
                .writeText(inputPsw, pw);
        return this;
    }

    public CreateAccountPage selectBornDate(String day, String month, String year){
        selectByValue(dayBirth, day)
                .selectByValue(monthBirth, month)
                .selectByValue(yearBirth, year);
        return this;
    }

    public CreateAccountPage pickGender(int number){
        clickRadioButton(mr,mrs,number);
        return this;
    }

    public CreateAccountPage checkList(String text){
        clickCheckButton(news, offer, text);
        return this;
    }

    public MyAccountPage goToMyAccountPage(){
        click(registerBtn);
        return new MyAccountPage(driver);
    }

    public void verifyErrorMessageCreateAccountPage(){
        boolean isTrue = errorMsg.isDisplayed();
        Assert.assertTrue(isTrue);
    }

    public CreateAccountPage getInputEmailAcc(){
        String inEmail = readInputEmail(inputEmail);
        return this;
    }

}
