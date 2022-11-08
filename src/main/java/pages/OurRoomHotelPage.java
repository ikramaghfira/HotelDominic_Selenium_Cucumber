package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OurRoomHotelPage extends BasePage{
    public OurRoomHotelPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@class='btn btn-default modify_roomtype_search_btn pull-right']")
    WebElement modifyButton;
    @FindBy(xpath = "//input[@id='room_check_in']")
    WebElement checkInField;
    @FindBy(className = "ui-datepicker-month")
    WebElement datePickerMonth;
    @FindBy(className = "ui-datepicker-year")
    WebElement datePickerYear;
    @FindBy(css = ".ui-datepicker-next.ui-corner-all[title=\"Next\"]")
    WebElement monthNext;
    @FindBy(xpath = "//input[@id='room_check_out']")
    WebElement checkOutField;
    @FindBy(xpath = "//i[@class='icon-plus']")
    WebElement plusQty;
    @FindBy(xpath = "//span[@class='num_searched_avail_rooms']")
    WebElement roomAvailability;
    @FindBy(xpath = "//span[contains(.,'Book Now')]")
    WebElement bookBtn;
    @FindBy(xpath = "//h2[contains(.,'Room successfully added to your cart')]")
    WebElement popUp;
    @FindBy(id = "layer_cart_product_quantity")
    WebElement prodQty;
    @FindBy(id = "layer_cart_product_price")
    WebElement prodPrice;
    @FindBy(xpath = "//span[contains(.,'Proceed to checkout')]")
    WebElement popProceedBtn;

    public OurRoomHotelPage verifyOurRoomPage() throws InterruptedException {
        Thread.sleep(2000);
        boolean isDisplayed = modifyButton.isDisplayed();
        Assert.assertTrue(isDisplayed);
        return this;
    }

    public OurRoomHotelPage setCheckIn(String monthAndYear, String day1) throws InterruptedException {
        Thread.sleep(2000);
        click(checkInField);
        Thread.sleep(2000);
        while(true){
            String titleText = datePickerMonth.getText() + " " + datePickerYear.getText();
            if(titleText.equals(monthAndYear)){
                break;
            } else{
                monthNext.click();
            }
        }
        By dayPick = By.xpath("//tr/td/a[@class='ui-state-default'][contains(text(),"+day1+")]");
        driver.findElement(dayPick).click();
        return this;
    }


    public OurRoomHotelPage setCheckOut(String monthAndYear, String day) throws InterruptedException {
        Thread.sleep(1000);
        click(checkOutField);
        Thread.sleep(1000);
        while(true){
            String titleText = datePickerMonth.getText() + " " + datePickerYear.getText();
            if(titleText.equals(monthAndYear)){
                break;
            } else{
                monthNext.click();
            }
        }
        By dayPick = By.xpath("//tr/td/a[@class='ui-state-default'][contains(text(),"+day+")]");
        driver.findElement(dayPick).click();
        return this;
    }

    public OurRoomHotelPage roomQuantity(int qtyRm) throws Exception {
        Thread.sleep(2000);
        int roomAvl = Integer.parseInt(roomAvailability.getText());
        if(roomAvl>=qtyRm){
            for(int i=1; i<qtyRm; i++){
                plusQty.click();
            }
        }
        return this;
    }

    public OurRoomHotelPage clickBook(){
        bookBtn.click();
        return this;
    }

    public OurRoomHotelPage verifyBookingProcessSucceed(int qtyRoom, String dateIn, String dateOut, int priceRoom) throws NumberFormatException{
        verifyTextEqual(popUp, "room successfully added to your cart");

        //verify quantity of the Booked Room
        String actualQty = prodQty.getText();
        Assert.assertEquals(Integer.toString(qtyRoom),actualQty);

        //verify total price should be paid
        int intDateIn = Integer.parseInt(dateIn);
        int intDateOut = Integer.parseInt(dateOut);

        int qtyNights = intDateOut - intDateIn;
        String expctdTotalPrice = Integer.toString(qtyNights * qtyRoom * priceRoom);
        String actualTotalPrice =
                prodPrice
                        .getText()
                        .replace("$","")
                        .replace(",","")
                        .replace(".00","");
        Assert.assertEquals(expctdTotalPrice,actualTotalPrice);

        return this;
    }

    public RoomSummaryPage goToRoomSummary(){
        popProceedBtn.click();
        return new RoomSummaryPage(driver);
    }


}
