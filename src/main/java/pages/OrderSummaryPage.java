package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage extends BasePage{

    private String expctdHeaderBW = "bank-wire payment";
    private String expctdHeaderCQ = "check payment";
    public OrderSummaryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='box cheque-box']/h3")
    WebElement headerTitle;
    @FindBy(xpath = "//button[@class='btn pull-right button button-medium']")
    WebElement iConfirmBtn;

    public OrderSummaryPage verifyOrderSummaryPageBW(){
        verifyTextEqual(headerTitle, expctdHeaderBW);
        return this;
    }

    public OrderSummaryPage verifyOrderSummaryPageCQ(){
        verifyTextEqual(headerTitle, expctdHeaderCQ);
        return this;
    }

    public FinalPage goToFinalPage(){
        iConfirmBtn.click();
        return new FinalPage(driver);
    }
}
