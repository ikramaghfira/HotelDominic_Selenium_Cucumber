package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GuestInformationPage extends BasePage{

    private String expctdPageName = "guest information";

    public GuestInformationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='guest-info-head']//span")
    WebElement pageTitle;
    @FindBy(xpath = "//select[@id='id_gender']")
    WebElement genderField;
    @FindBy(xpath = "//input[@id='customer_firstname']")
    WebElement firstNameField;
    @FindBy(xpath = "//input[@id='customer_lastname']")
    WebElement lastNameField;
    @FindBy(xpath = "//input[@id='email']")
    WebElement emailField;
    @FindBy(xpath = "//input[@id='passwd']")
    WebElement pwField;
    @FindBy(xpath = "//input[@id='phone_mobile']")
    WebElement phoneNum;
    @FindBy(xpath = "//span[normalize-space()='Save']")
    WebElement saveBtn;

    public GuestInformationPage verifyGuestInformationPage(){
        String actualHeader = pageTitle.getText();
        Assert.assertEquals(expctdPageName, actualHeader.toLowerCase());
        return this;
    }

    public GuestInformationPage selectGender(String gender){
        genderField.click();
        selectByValue(genderField, gender);
        return this;
    }

    public GuestInformationPage fillName(String firstNm, String lastNm){
        firstNameField.sendKeys(firstNm);
        lastNameField.sendKeys(lastNm);
        return this;
    }

    public GuestInformationPage fillEmailAndPhone(String email, String pw, String phone){
        emailField.sendKeys(email);
        pwField.sendKeys(pw);
        phoneNum.sendKeys(phone);
        return this;
    }

    public GuestConfirmationPage goToGuestConfirmationPage(){
        saveBtn.click();
        return new GuestConfirmationPage(driver);
    }



}
