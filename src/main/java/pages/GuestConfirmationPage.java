package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GuestConfirmationPage extends BasePage{

    public GuestConfirmationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='row margin-btm-10'][1]/div[2]")
    WebElement nameConfirmation;
    @FindBy(xpath = "//div[@class='row margin-btm-10'][2]/div[2]")
    WebElement emailConfirmation;
    @FindBy(xpath = "//div[@class='row margin-btm-10'][3]/div[2]")
    WebElement phoneConfirmation;
    @FindBy(xpath = "//p[@class='cart_total_price']/span[2]")
    WebElement priceBefore;
    @FindBy(xpath = "//p[@class='cart_total_tax']/span[2]")
    WebElement tax;
    @FindBy(xpath = "//p[@class='cart_final_total_block']/span[2]")
    WebElement priceAfter;
    @FindBy(xpath = "//a[@title='Proceed to Payment']//span[contains(text(),'Proceed')]")
    WebElement proceedBtn;

    public GuestConfirmationPage verifyCredentialsCorrect(String name1, String name2, String email, String phone){
        waitVisibility(nameConfirmation);
        String actualName = nameConfirmation.getText();
        String actualEmail = emailConfirmation.getText();
        String actualPhone = phoneConfirmation.getText();
        String expectedName = name1 + " " + name2;
        Assert.assertEquals(expectedName,actualName);
        Assert.assertEquals(email, actualEmail);
        Assert.assertEquals(phone,actualPhone);
        return this;
    }

    public GuestConfirmationPage verifyPriceAfterTax(){
        String priceBfr =
                priceBefore.getText()
                        .replace("$","")
                        .replace(",","")
                        .replace(".00","");
        String taxPrice =
                tax.getText()
                        .replace("$","")
                        .replace(",","")
                        .replace(".00","");
        String priceAftr =
                priceAfter.getText()
                        .replace("$","")
                        .replace(",","")
                        .replace(".00","");

        String expctdPrice =
                Integer.toString((Integer.parseInt(priceBfr) + Integer.parseInt(taxPrice)));
        Assert.assertEquals(expctdPrice,priceAftr);
        return this;
    }

    public PaymentInformationPage goToPayInfoPage(){
        proceedBtn.click();
        return new PaymentInformationPage(driver);
    }
}
