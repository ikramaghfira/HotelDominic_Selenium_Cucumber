package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RoomSummaryPage extends BasePage {

    public RoomSummaryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='room-xs-info']//a[1]")
    WebElement roomName;
    @FindBy(className = "hotel-location")
    WebElement hotelLoc;
    @FindBy(xpath = "//a[@class='btn btn-default button button-medium pull-right']")
    WebElement proceedBtn;

    public RoomSummaryPage verifyRoomSummary(String room, String location){
        String actualRoom = roomName.getText();
        Assert.assertEquals(room,actualRoom);

        String actualLocation = hotelLoc.getText();
        boolean isTrue = actualLocation.contains(location);
        Assert.assertTrue(isTrue);

        return this;
    }

    public GuestInformationPage goToGuestInfoPage(){
        click(proceedBtn);
        return new GuestInformationPage(driver);
    }
}
