package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentInformationPage extends BasePage{

    private String headerTitle = "payment information";
    public PaymentInformationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "cgv")
    WebElement checkBox;
    @FindBy(className = "bankwire")
    WebElement bankWireMtd;
    @FindBy(xpath = "//div[@id='order-payment-head']//span")
    WebElement header;
    @FindBy(className = "cheque")
    WebElement chequeMtd;
    @FindBy(xpath = "//a[@title='Pay with PayPal']")
    WebElement payPalMtd;

    public PaymentInformationPage verifyPayInfoPage(){
        verifyTextEqual(header, headerTitle);
        return this;
    }

    public PaymentInformationPage accessPaymentMethod() throws InterruptedException {
        checkBox.click();
        Thread.sleep(4000);
        return this;
    }

    public OrderSummaryPage goToOrderSummaryViaBankWire(){
        bankWireMtd.click();
        return new OrderSummaryPage(driver);
    }

    public OrderSummaryPage goToOrderSummaryViaCheque(){
        chequeMtd.click();
        return new OrderSummaryPage(driver);
    }


}
