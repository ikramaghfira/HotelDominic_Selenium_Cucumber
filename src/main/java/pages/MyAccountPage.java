package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BasePage{

    private String expectedSuccessMsg = "your account has been created.";
    private String expectedHeader = "my account";

    @FindBy(css = ".alert.alert-success")
    WebElement successMessage;
    @FindBy(className = "page-heading")
    WebElement headerAccPage;


    public MyAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MyAccountPage verifySuccessRegisteredAccount(){
        verifyTextEqual(successMessage, expectedSuccessMsg);
        return this;
    }

    public MyAccountPage verifyMyAccountPage(){
        verifyTextEqual(headerAccPage, expectedHeader);
        return this;
    }


}
