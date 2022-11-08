package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FinalPage extends BasePage{

    private String expectedScdMsg = "your order on sekolah qa is complete.";
    public FinalPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".alert.alert-success")
    WebElement successMsg;
    @FindBy(xpath = "//p[@class='product-name']/a")
    WebElement roomName;
    @FindBy(xpath = "//tr[@class='table_body']/td[3]")
    WebElement hotelName;
    @FindBy(xpath = "//td[@class='text-center']/p")
    WebElement roomQty;
    @FindBy(xpath = "//td[@class='text-center'][2]/p")
    WebElement inDate;
    @FindBy(xpath = "//td[@class='text-center'][3]/p" )
    WebElement outDate;

    public FinalPage verifyOrderSucceed(){
        verifyTextEqual(successMsg,expectedScdMsg);
        return this;
    }

    public FinalPage verifyOrderInfoCorrect(String room, String hotel, int qty, String in, String out){
        String displayedRoom = roomName.getText();
        Assert.assertEquals(room,displayedRoom);
        String displayedHotel = hotelName.getText();
        Assert.assertEquals(hotel,displayedHotel);
        String displayedQty = roomQty.getText();
        Assert.assertEquals(Integer.toString(qty),displayedQty);
        String displayedIn = inDate.getText();
        Assert.assertTrue(displayedIn.contains(in));
        String displayedOut = outDate.getText();
        Assert.assertTrue(displayedOut.contains(out));
        return this;
    }
}
