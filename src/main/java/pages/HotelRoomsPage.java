package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class HotelRoomsPage extends BasePage {
    Date date;


    public HotelRoomsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "hotel_cat_name")
    WebElement searchBoxHotel;
    @FindBy(id = "check_in_time")
    WebElement searchBoxIn;
    @FindBy(id = "check_out_time")
    WebElement searchBoxOut;
    @FindBy(id = "filter_price_silder")
    WebElement priceSlider;
    @FindBy(xpath = "//p[.='General Rooms']")
    WebElement generalRoom;
    @FindBy(xpath = "//p[.='Delux Rooms']")
    WebElement deluxRoom;
    @FindBy(xpath = "//p[.='Executive Rooms']")
    WebElement executiveRoom;
    @FindBy(xpath = "//p[.='luxury Rooms']")
    WebElement luxuryRoom;
    @FindBy(xpath = "//div[@id='category_data_cont']/div[1]//span[.='Book Now']")
    WebElement bookButtonGeneral;
    @FindBy(xpath = "//div[@id='category_data_cont']/div[2]//span[.='Book Now']")
    WebElement bookButtonDelux;
    @FindBy(xpath = "//div[@id='category_data_cont']/div[3]//span[.='Book Now']")
    WebElement bookButtonExecutive;
    @FindBy(xpath = "//div[@id='category_data_cont']/div[4]//span[.='Book Now']")
    WebElement bookButtonLuxury;
    @FindBy(xpath = "//div[@id='category_data_cont']/div[1]//i[@class='icon-plus']")
    WebElement qtyUpGeneral;
    @FindBy(xpath = "//div[@id='category_data_cont']/div[2]//i[@class='icon-plus']")
    WebElement qtyUpDelux;
    @FindBy(xpath = "//div[@id='category_data_cont']/div[3]//i[@class='icon-plus']")
    WebElement qtyUpExecutive;
    @FindBy(xpath = "//div[@id='category_data_cont']/div[4]//i[@class='icon-plus']")
    WebElement qtyUpLuxury;
    @FindBy(xpath = "//h2[normalize-space()='Room successfully added to your cart']")
    WebElement successPopUp;
    @FindBy(id = "layer_cart_product_quantity")
    WebElement qtyBookedRoom;
    @FindBy(id = "layer_cart_product_price")
    WebElement totalPrice;
    @FindBy(xpath = "//span[normalize-space()='Proceed to checkout']")
    WebElement proceedCOBtn;
    @FindBy(xpath = "//div[@id='filter_price_silder']/a[1]")
    WebElement leftSlider;
    @FindBy(xpath = "//div[@id='filter_price_silder']/a[2]")
    WebElement rightSlider;
    @FindBy(id = "filter_price_from")
    WebElement priceLeft;
    @FindBy(id="filter_price_to")
    WebElement priceRight;
    @FindBy(xpath = "//div[@id='filter_results']//div[3]//span[@class='pull-right clear_filter']")
    WebElement priceClearFilter;
    @FindBy(xpath = "//div[@id='filter_results']//div[2]//span[@class='pull-right clear_filter']")
    WebElement amenitiesClearFilter;
    @FindBy(xpath = "//div[@id='filter_results']/div[@class='col-sm-12']/div[1]//span[@class='pull-right clear_filter']")
    WebElement ratingClearFilter;
    @FindBy(xpath = "//div[@class='layered_filt']//input[@data-type='amenities'][@value='1']")
    WebElement wifiCek;
    @FindBy(xpath = "//div[@class='layered_filt']//input[@data-type='amenities'][@value='2']")
    WebElement newsCek;
    @FindBy(xpath = "//div[@class='layered_filt']//input[@data-type='amenities'][@value='3']")
    WebElement powerCek;
    @FindBy(xpath = "//div[@class='layered_filt']//input[@data-type='amenities'][@value='4']")
    WebElement refrigeratorCek;
    @FindBy(xpath = "//div[@class='layered_filt']//input[@data-type='amenities'][@value='5']")
    WebElement restaurantCek;
    @FindBy(xpath = "//div[@class='layered_filt']//input[@data-type='amenities'][@value='6']")
    WebElement roomCek;
    @FindBy(xpath = "//div[@class='layered_filt']//input[@data-type='amenities'][@value='7']")
    WebElement gymCek;
    @FindBy(xpath = "//div[@class='noRoomsAvailAlert']/span")
    WebElement noRoomAlert;
    @FindBy(xpath = "//button[@id='price_ftr']/span[@class='pull-left sort_btn_span']")
    WebElement priceSorting;
    @FindBy(xpath = "//div[@class='layered_filt']//input[@data-type='ratting'][@value='5']")
    WebElement fiveStars;
    @FindBy(xpath = "//div[@class='layered_filt']//input[@data-type='ratting'][@value='4']")
    WebElement fourStars;
    @FindBy(xpath = "//div[@class='layered_filt']//input[@data-type='ratting'][@value='3']")
    WebElement threeStars;
    @FindBy(xpath = "//div[@class='layered_filt']//input[@data-type='ratting'][@value='2']")
    WebElement twoStars;
    @FindBy(xpath = "//div[@class='layered_filt']//input[@data-type='ratting'][@value='1']")
    WebElement oneStars;
    @FindBy(xpath = "//div[@class='layered_filt']//input[@data-type='ratting'][@value='0']")
    WebElement zeroStars;
    @FindBy(xpath = "//a[.='Price : Lowest First']")
    WebElement priceLowest;
    @FindBy(xpath = "//a[contains(.,'Price : Highest first')]")
    WebElement priceHighest;
    @FindBy(xpath = "//span[@class='cat_remain_rm_qty_1']")
    WebElement roomGeneralAvailable;
    @FindBy(xpath = "//div[@id='category_data_cont']/div[1]//input[@class='text-center form-control cat_quantity_wanted']")
    WebElement roomNumContainer;

    List<WebElement> listRooms = driver.findElements(By.xpath("//div[@class='col-sm-12 room_cont']//div[@class='col-sm-8']/p[1]"));
    List actualList = new ArrayList();




    public HotelRoomsPage verifyPageHotelRooms() throws InterruptedException {
        Thread.sleep(1000);
        boolean isTrue = priceSlider.isEnabled();
        Assert.assertTrue(isTrue);
        Thread.sleep(1000);
        return this;
    }

    public HotelRoomsPage verifyCorrectBookingInformation(String hotelName, String dayIn,
                                                          String dayOut, String monthAndYear) throws ParseException, InterruptedException {
        String actualHotelName = searchBoxHotel.getText();
        Assert.assertEquals(hotelName, actualHotelName);

        String actualInDate = searchBoxIn.getAttribute("value");
        date = new SimpleDateFormat("dd-MM-yy").parse(actualInDate);
        String dateInNew = new SimpleDateFormat("dd MMMM yyyy").format(date);
        String expectedInDate = dayIn + " " + monthAndYear;
        Assert.assertEquals(dateInNew, expectedInDate);

        String actualOutDate = searchBoxOut.getAttribute("value");
        date = new SimpleDateFormat("dd-MM-yy").parse(actualOutDate);
        String dateOutNew = new SimpleDateFormat("dd MMMM yyyy").format(date);
        String expectedOutDate = dayOut + " " + monthAndYear;
        Assert.assertEquals(dateOutNew, expectedOutDate);

        Thread.sleep(2000);
        return this;
    }

    public HotelRoomsPage chooseARoom(String roomName, int qtyRoom) throws InterruptedException {
        if(roomName.equals("General Rooms")){
            scrollTo(generalRoom);
            Thread.sleep(1000);
            for(int i=1;i<qtyRoom;i++){
                qtyUpGeneral.click();
            }
            bookButtonGeneral.click();
        } else if (roomName.equals("Delux Rooms")) {
            scrollTo(deluxRoom);
            Thread.sleep(1000);
            for(int i=1;i<qtyRoom;i++){
                qtyUpDelux.click();
            }
            bookButtonDelux.click();
        } else if (roomName.equals("Executive Rooms")) {
            scrollTo(executiveRoom);
            Thread.sleep(1000);
            for(int i=1;i<qtyRoom;i++){
                qtyUpExecutive.click();
            }
            bookButtonExecutive.click();
        } else if (roomName.equals("luxury Rooms")) {
            scrollTo(luxuryRoom);
            Thread.sleep(1000);
            for(int i=1;i<qtyRoom;i++){
                qtyUpLuxury.click();
            }
            bookButtonLuxury.click();
        }
        return this;
    }

    public HotelRoomsPage verifyBookingProcessSucceed(int qtyRoom, String dateIn, String dateOut, int priceRoom){
        verifyTextEqual(successPopUp, "room successfully added to your cart");

        //verify quantity of the Booked Room
        String actualQty = qtyBookedRoom.getText();
        Assert.assertEquals(Integer.toString(qtyRoom),actualQty);

        //verify total price should be paid
        int intDateIn = Integer.parseInt(dateIn);
        int intDateOut = Integer.parseInt(dateOut);

        int qtyNights = intDateOut - intDateIn;
        String expctdTotalPrice = Integer.toString(qtyNights * qtyRoom * priceRoom);
        String actualTotalPrice =
                totalPrice
                        .getText()
                        .replace("$","")
                        .replace(",","")
                        .replace(".00","");
        Assert.assertEquals(expctdTotalPrice,actualTotalPrice);

        return this;
    }

    public RoomSummaryPage goToRoomSummary(){
        proceedCOBtn.click();
        return new RoomSummaryPage(driver);
    }

    public HotelRoomsPage setSliderValue() throws InterruptedException {
        scrollTo(leftSlider);
        Actions action = new Actions(driver);
        //move left slider
        Thread.sleep(3000);
        action.dragAndDropBy(leftSlider,82,0).build().perform();
        String actualPriceLow = priceLeft.getText();
        Assert.assertEquals(actualPriceLow, "1490");
        //move right slider
        Thread.sleep(3000);
        action.dragAndDropBy(rightSlider, -79,0).build().perform();
        String actualPriceHigh = priceRight.getText();
        Assert.assertEquals(actualPriceHigh, "2016");
        Thread.sleep(3000);

        return this;
    }

    public HotelRoomsPage verifyRoomsAvailable() throws InterruptedException {
        Thread.sleep(3000);
        scrollTo(deluxRoom);
        boolean deluxAvail = deluxRoom.isDisplayed();
        Assert.assertTrue(deluxAvail);
        boolean executiveAvail = executiveRoom.isDisplayed();
        Assert.assertTrue(executiveAvail);
        Thread.sleep(2000);
        return this;
    }

    public HotelRoomsPage verifyRoomsAvailable2() throws InterruptedException {
        Thread.sleep(2000);
        boolean generalAvail = generalRoom.isDisplayed();
        Assert.assertTrue(generalAvail);
        boolean luxuryAvail = luxuryRoom.isDisplayed();
        Assert.assertTrue(luxuryAvail);
        Thread.sleep(2000);
        return this;
    }

    public HotelRoomsPage clickClearFilter(String text) throws InterruptedException {
        if(text.equals("price")){
            Thread.sleep(2000);
            priceClearFilter.click();
        } else if (text.equals("amenities")) {
            Thread.sleep(2000);
            amenitiesClearFilter.click();
        } else if (text.equals("rating")) {
            Thread.sleep(2000);
            ratingClearFilter.click();
        }
        return this;
    }

    public HotelRoomsPage clickAmenitiesCheckBox(String text) throws InterruptedException {
        scrollTo(wifiCek);
        if(text.equals("wifi")){
            Thread.sleep(1000);
            wifiCek.click();
        } else if (text.equals("newspaper")) {
            Thread.sleep(1000);
            newsCek.click();
        } else if (text.equals("power")) {
            Thread.sleep(1000);
            powerCek.click();
        } else if (text.equals("refrigerator")) {
            Thread.sleep(1000);
            refrigeratorCek.click();
        } else if (text.equals("restaurant")) {
            Thread.sleep(1000);
            restaurantCek.click();
        } else if (text.equals("room service")) {
            Thread.sleep(1000);
            roomCek.click();
        } else if (text.equals("gym")) {
            Thread.sleep(1000);
            gymCek.click();
        }
        return this;
    }

    public HotelRoomsPage verifyNoRoomAlert() throws InterruptedException {
        Thread.sleep(3000);
        scrollTo(priceSorting);
        String actualAlert = noRoomAlert.getText();
        Assert.assertEquals(actualAlert, "No room available for this hotel!");
        return this;
    }

    public HotelRoomsPage clickFiltersCheckBox(String stars) throws InterruptedException {
        Thread.sleep(2000);
        scrollTo(fiveStars);
        if(stars.equals("5")){
            Thread.sleep(1000);
            fiveStars.click();
        } else if (stars.equals("4")) {
            Thread.sleep(1000);
            fourStars.click();
        } else if (stars.equals("3")) {
            Thread.sleep(1000);
            threeStars.click();
        } else if (stars.equals("2")) {
            Thread.sleep(1000);
            twoStars.click();
        } else if (stars.equals("1")) {
            Thread.sleep(1000);
            oneStars.click();
        } else if (stars.equals("0")) {
            Thread.sleep(1000);
            zeroStars.click();
        }
        return this;
    }

    public HotelRoomsPage sortingRoom(String text) throws InterruptedException {
        Thread.sleep(2000);
        if(text.equals("ascending")){
            priceSorting.click();
            Thread.sleep(1000);
            priceHighest.click();
        } else if(text.equals("descending")){
            priceSorting.click();
            Thread.sleep(1000);
            priceLowest.click();
        }
        return this;
    }

    public HotelRoomsPage verifySortingResult(String text) throws InterruptedException {
        System.out.println(listRooms.size());
        //get all the element into the array after click dropdown
        for(int i=0;i< listRooms.size();i++){
            String data = listRooms.get(i).getText().trim();
            actualList.add(data);
        }
        //another array saving result for camparing
        List temp = new ArrayList();
        temp.addAll(actualList);

        //sorting ascending
        if (text.equals("ascending")){
            Collections.sort(temp);
            Assert.assertTrue(actualList.equals(temp));
        //sorting descending
        } else if (text.equals("descending")) {
            Collections.sort(temp,Collections.reverseOrder());
            Assert.assertTrue(actualList.equals(temp));
        }
        Thread.sleep(3000);
        return this;
    }

    public HotelRoomsPage clickAddQuantityRoom() throws InterruptedException {
        Thread.sleep(2000);
        int maxRoom = Integer.parseInt(roomGeneralAvailable.getText());
        for (int i=1;i<maxRoom;i++){
            qtyUpGeneral.click();
        }
        return this;
    }

    public HotelRoomsPage verifyNumberOfRoomAdded() throws InterruptedException {
        Thread.sleep(2000);
        int maxRoom = Integer.parseInt(roomGeneralAvailable.getText());
        int displayedNumRoom = Integer.parseInt(roomNumContainer.getAttribute("value"));
        Assert.assertTrue(displayedNumRoom==maxRoom);
        return this;
    }


}