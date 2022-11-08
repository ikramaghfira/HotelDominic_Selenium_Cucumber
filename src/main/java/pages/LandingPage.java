package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LandingPage extends BasePage {

    public LandingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    private String header = "hotel dominic parks";
    JavascriptExecutor js = (JavascriptExecutor) driver;
    private String successSubscribe = "newsletter : you have successfully subscribed to this newsletter.";
    private String failedSubscribe1 = "newsletter : this email address is already registered.";
    private String failedSubscribe2 = "newsletter : invalid email address.";

    @FindBy(className = "hide_xs")
    WebElement signInBtn;
    @FindBy(className = "header-hotel-name")
    WebElement headerLP;
    @FindBy(id = "hotel_location")
    WebElement locationField;
    @FindBy(id = "id_hotel_button")
    WebElement hotelClick;
    @FindBy(xpath = "//ul[@class='dropdown-menu hotel_dropdown_ul']/li[1]")
    WebElement hotelList;
    @FindBy(id = "hotel_cat_name")
    WebElement selectedHotel;
    @FindBy(id = "check_in_time")
    WebElement checkInBtn;
    @FindBy(id = "check_out_time")
    WebElement checkOutBtn;
    @FindBy(className = "ui-datepicker-month")
    WebElement dateMonth;
    @FindBy(className = "ui-datepicker-year")
    WebElement dateYear;
    @FindBy(css = ".ui-datepicker-next.ui-corner-all[title=\"Next\"]" )
    WebElement dateNextBtn;
    @FindBy(css = ".ui-icon-circle-triangle-w")
    WebElement datePrevBtn;
    @FindBy(id = "search_room_submit")
    WebElement searchBtn;
    @FindBy(className = "home_block_heading")
    WebElement header2;
    @FindBy(xpath = "//ul[@class='location_search_results_ul']/li[1]")
    WebElement locationMenu;
    @FindBy(xpath = "//p[normalize-space()='Our Rooms']")
    WebElement ourRooms;
    @FindBy(xpath = "//a[@href='http://qa.cilsy.id:8080/the-hotel-prime/2-super-delux-rooms.html']/span[.='book now']")
    WebElement deluxRoomBtn;
    @FindBy(xpath = "//a[@href='http://qa.cilsy.id:8080/the-hotel-prime/1-super-delux-rooms.html']/span[.='book now']")
    WebElement generalRoomBtn;
    @FindBy(xpath = "//div[@class='hotel_name_block']/span[1]")
    WebElement ourRoomPageHeader;
    @FindBy(xpath = "//a[@href='http://qa.cilsy.id:8080/the-hotel-prime/3-super-delux-rooms.html']/span[.='book now']")
    WebElement executiveRoomBtn;
    @FindBy(xpath = "//a[@href='http://qa.cilsy.id:8080/the-hotel-prime/4-super-delux-rooms.html']/span[.='book now']")
    WebElement luxuryRoomBtn;
    @FindBy(xpath = "//button[@class='nav_toggle']")
    WebElement navigationBtn;
    @FindBy(xpath = "//span[@class='pull-right close_navbar']")
    WebElement xNavBtn;
    @FindBy(xpath = "//ul[@class='nav nav-pills nav-stacked wk-nav-style']/li[1]/a")
    WebElement home;
    @FindBy(xpath = "//ul[@class='nav nav-pills nav-stacked wk-nav-style']/li[2]/a")
    WebElement interior;
    @FindBy(xpath = "//p[@class='home_block_heading'][contains(text(),'Interior')]")
    WebElement interiorHeader;
    @FindBy(className = "icon-angle-left")
    WebElement interiorLeftNav;
    @FindBy(className = "icon-angle-right")
    WebElement interiorRightNav;
    @FindBy(xpath = "//div[@class='interiorbox'][@title='Dummy Image 7']")
    WebElement imageInterior;
    @FindBy(xpath = "//div[@class='owl-item active']//div[@title='Dummy Image 8']//div[@class='interiorHoverSecondaryBlock']")
    WebElement imageInterior2;
    @FindBy(xpath = "//div[@class='owl-item active']//div[@title='Dummy Image 8']")
    WebElement zoomedOutPic;
    @FindBy(xpath = "//ul[@class='nav nav-pills nav-stacked wk-nav-style']/li[3]/a")
    WebElement amenities;
    @FindBy(xpath = "//p[@class='home_block_heading'][contains(text(),'Amenities')]")
    WebElement amenitiesHeader;
    @FindBy(xpath = "//ul[@class='nav nav-pills nav-stacked wk-nav-style']/li[4]/a")
    WebElement rooms;
    @FindBy(xpath = "//p[@class='home_block_heading'][contains(text(),'Our Rooms')]")
    WebElement roomsHeader;
    @FindBy(xpath = "//ul[@class='nav nav-pills nav-stacked wk-nav-style']/li[5]/a")
    WebElement testimonials;
    @FindBy(xpath = "//p[@class='home_block_heading'][contains(text(),'What our Guest say?')]")
    WebElement testiHeader;
    @FindBy(xpath = "//ul[@class='nav nav-pills nav-stacked wk-nav-style']/li[6]/a")
    WebElement legal;
    @FindBy(xpath = "//div[@class='rte']/h2")
    WebElement legalHeader;
    @FindBy(xpath = "//ul[@class='nav nav-pills nav-stacked wk-nav-style']/li[7]/a")
    WebElement about;
    @FindBy(xpath = "//div[@class='rte']/h1")
    WebElement aboutHeader;
    @FindBy(xpath = "//ul[@class='nav nav-pills nav-stacked wk-nav-style']/li[8]/a")
    WebElement contactUs;
    @FindBy(xpath = "//div[@class='row']/p[1]")
    WebElement contactUsHeader;
    @FindBy(xpath = "//button[@name='submitNewsletter']/span")
    WebElement subscribeBtn;
    @FindBy(id = "newsletter-input")
    WebElement inputEmailSub;
    @FindBy(xpath = "//p[@class='alert alert-success']")
    WebElement successSubs;
    @FindBy(xpath = "//p[@class='alert alert-danger']")
    WebElement failedSubs;
    @FindBy(xpath = "//li[@class='facebook']/a")
    WebElement fbBtn;
    @FindBy(xpath = "//li[@class='twitter']/a")
    WebElement twitterBtn;
    @FindBy(xpath = "//li[@class='item'][1]/a")
    WebElement policiesBtn;
    @FindBy(xpath = "//li[@class='item'][3]/a")
    WebElement tncBtn;
    @FindBy(xpath = "//li[@class='item'][5]/a")
    WebElement securepayBtn;
    @FindBy(xpath = "//a[@title='View my booking cart']")
    WebElement bookingCart;


    public LandingPage verifyLandingPage(){
        verifyTextEqual(headerLP, header);
        return this;
    }

    public LogInPage goToLogInPage(){
        click(signInBtn);
        return new LogInPage(driver);
    }

    public LandingPage setLocation(String text) {
        js.executeScript("arguments[0].scrollIntoView();", header2);
        waitVisibility(locationField);
        writeText(locationField, text);
        click(locationMenu);
        return this;
    }

    public LandingPage selectHotel() throws InterruptedException {
        Thread.sleep(2000);
        click(hotelClick);
        click(hotelList);
        return this;
    }

    public LandingPage verifyHotelName(String text){
        String hotelName = selectedHotel.getText();
        Assert.assertEquals(text, hotelName);
        return this;
    }

    public LandingPage setCheckIn(String monthAndYear, String day) throws InterruptedException {
        Thread.sleep(2000);
        click(checkInBtn);
        Thread.sleep(2000);
        while(true){
            String titleText = dateMonth.getText() + " " + dateYear.getText();
            if(titleText.equals(monthAndYear)){
                break;
            } else{
                dateNextBtn.click();
            }
        }
        By dayPick = By.xpath("//tr/td/a[@class='ui-state-default'][contains(text(),"+day+")]");
        driver.findElement(dayPick).click();
        return this;
    }

    public LandingPage setCheckOut(String monthAndYear, String day) throws InterruptedException {
        Thread.sleep(2000);
        click(checkOutBtn);
        Thread.sleep(2000);
        while(true){
            String titleText = dateMonth.getText() + " " + dateYear.getText();
            if(titleText.equals(monthAndYear)){
                break;
            } else{
                dateNextBtn.click();
            }
        }
        By dayPick = By.xpath("//tr/td/a[@class='ui-state-default'][contains(text(),"+day+")]");
        driver.findElement(dayPick).click();
        return this;
    }

    public HotelRoomsPage goToHotelRooms(){
        click(searchBtn);
        return new HotelRoomsPage(driver);
    }

    public LandingPage scrollToOurRooms(){
        scrollTo(ourRooms);
        return this;
    }

    public LandingPage bookARoom(String room){
        if(room.equals("General")){
            scrollTo(generalRoomBtn);
            generalRoomBtn.click();
        } else if(room.equals("Delux")){
            scrollTo(deluxRoomBtn);
            deluxRoomBtn.click();
        } else if(room.equals("Executive")){
            scrollTo(executiveRoomBtn);
            executiveRoomBtn.click();
        } else if (room.equals("luxury")) {
            scrollTo(luxuryRoomBtn);
            luxuryRoomBtn.click();
        }
        return this;
    }

    public OurRoomHotelPage switchToOurRoomTab(){
        driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
        return new OurRoomHotelPage(driver);
    }

    public LandingPage clickNavBtn() throws InterruptedException {
        navigationBtn.click();
        verifyTextEqual(home,"home");
        Thread.sleep(3000);
        return this;
    }

    public LandingPage exitNavBtn() throws InterruptedException {
        xNavBtn.click();
        Thread.sleep(1000);
        return this;
    }

    public LandingPage verifyInvisible(){
        verifyInvisible(xNavBtn);
        return this;
    }

    public LandingPage clickNavigationMenu(String menu) throws InterruptedException {
        if(menu.equals("home")){
            home.click();
            Thread.sleep(2000);
        } else if (menu.equals("interior")) {
            interior.click();
            Thread.sleep(2000);
        } else if (menu.equals("amenities")) {
            amenities.click();
            Thread.sleep(2000);
        } else if (menu.equals("rooms")) {
            rooms.click();
            Thread.sleep(2000);
        } else if (menu.equals("testimonials")) {
            testimonials.click();
            Thread.sleep(1000);
        } else if (menu.equals("legal")) {
            legal.click();
            Thread.sleep(2000);
        } else if (menu.equals("about us")) {
            about.click();
            Thread.sleep(2000);
        } else if (menu.equals("contact us")) {
            contactUs.click();
            Thread.sleep(2000);
        }
        return this;
    }

    public LandingPage verifyMenuResult(String menu) throws InterruptedException {
        if(menu.equals("interior")){
            verifyTextEqual(interiorHeader, "interior");
            Thread.sleep(1000);
        } else if (menu.equals("amenities")) {
            verifyTextEqual(amenitiesHeader, "amenities");
        } else if (menu.equals("rooms")) {
            verifyTextEqual(roomsHeader, "our rooms");
        } else if (menu.equals("testimonials")) {
            verifyTextEqual(testiHeader, "what our guest say?");
        } else if (menu.equals("legal")) {
            verifyTextEqual(legalHeader, "legal");
        } else if (menu.equals("about us")) {
            verifyTextEqual(aboutHeader, "about us");
        } else if (menu.equals("contact us")) {
            verifyTextEqual(contactUsHeader, "contact us");
        }
        return this;
    }


    public LandingPage clickNavImage() throws InterruptedException {
        //click to left
        for (int j=0;j<2;j++){
            interiorLeftNav.click();
        }
        Thread.sleep(500);
        //click to right twice
        for(int i=0; i<2; i++){
            interiorRightNav.click();
        }
        return this;
    }

    public LandingPage verifyImageMove() throws InterruptedException {
        Thread.sleep(500);
        boolean isDisplayed = imageInterior.isDisplayed();
        Assert.assertFalse(isDisplayed);
        return this;
    }

    public LandingPage clickImageInterior() throws InterruptedException {
        Thread.sleep(1000);
        imageInterior2.click();
        return this;
    }

    public LandingPage verifyPicZoomedOut(){
        boolean isZoomOut = zoomedOutPic.isDisplayed();
        Assert.assertTrue(isZoomOut);
        return this;
    }

    public LandingPage clickGeneralBook(){
        generalRoomBtn.click();
        return this;
    }

    public OurRoomHotelPage verifyUserInRoomDetailPage(String room){
        switchToOurRoomTab();
        if(room.equals("general")){
        verifyTextEqual(ourRoomPageHeader, "general rooms - the hotel prime");
        } else if (room.equals("delux")) {
            verifyTextEqual(ourRoomPageHeader, "delux rooms - the hotel prime");
        } else if (room.equals("executive")) {
            verifyTextEqual(ourRoomPageHeader, "executive rooms - the hotel prime");
        } else if (room.equals("luxury")) {
            verifyTextEqual(ourRoomPageHeader, "luxury rooms - the hotel prime");
        }
        return new OurRoomHotelPage(driver);
    }

    public LandingPage clickDeluxBook(){
        deluxRoomBtn.click();
        return this;
    }

    public LandingPage clickExecutiveBook(){
        executiveRoomBtn.click();
        return this;
    }
    public LandingPage clickLuxuryBook(){
        luxuryRoomBtn.click();
        return this;
    }

    public LandingPage verifyFieldsBorderChangeColor(){
        verifyLandingPage();
        verifyColorChange(hotelClick)
                .verifyColorChange(locationField)
                .verifyColorChange(checkInBtn)
                .verifyColorChange(checkOutBtn);
        return this;
    }

    public LandingPage clickDate(String text) throws InterruptedException {
        if(text.equals("in")){
            checkInBtn.click();
        } else if (text.equals("out")) {
            checkOutBtn.click();
        }
        Thread.sleep(1000);
        return this;
    }

    public LandingPage clickMonthButton()  {
        for(int i=0; i<2; i++){
            dateNextBtn.click();
        }
        for(int j=0; j<2; j++){
            datePrevBtn.click();
        }
        return this;
    }

    public LandingPage verifyMonth(String prevMonth){
        String titleText = dateMonth.getText() + " " + dateYear.getText();
        Assert.assertEquals(titleText, prevMonth);
        return this;
    }

    public LandingPage scrollToEndPage(){
        scrollTo(subscribeBtn);
        return this;
    }

    public LandingPage subscribeToSite(String email) throws InterruptedException {
        inputEmailSub.sendKeys(email);
        subscribeBtn.click();
        Thread.sleep(2000);
        return this;
    }

    public LandingPage verifySubscribeMessage(String status){
        if(status.equals("success")){
            verifyTextEqual(successSubs, successSubscribe);
        } else if(status.equals("failed1")){
            verifyTextEqual(failedSubs, failedSubscribe1);
        } else if(status.equals("failed2")){
            verifyTextEqual(failedSubs, failedSubscribe2);
        }
        return this;
    }

    public LandingPage clickSocmedButton(String socmed) throws InterruptedException {
        if (socmed.equals("facebook")) {
            fbBtn.click();
            Thread.sleep(2000);
        } else if (socmed.equals("twitter")) {
            twitterBtn.click();
            Thread.sleep(2000);
        }
        return this;
    }

    public LandingPage verifySocmedResult(String socmed) throws InterruptedException {
        if (socmed.equals("facebook")) {
            Thread.sleep(1000);
            driver.getWindowHandles().forEach(tab -> driver.switchTo().window(tab));
            String titleFB = driver.getTitle();
            Assert.assertEquals(titleFB, "QloApps | Facebook");
        } else if (socmed.equals("twitter")) {
            Thread.sleep(1000);
            driver.getWindowHandles().forEach(tab -> driver.switchTo().window(tab));
            Thread.sleep(3000);
            String titleTW = driver.getTitle();
            Assert.assertEquals(titleTW, "QloApps (@qloapps) / Twitter");
        }
        return this;
    }

    public LandingPage clickExploreButton(String button) throws InterruptedException {
        if (button.equals("policies")) {
            policiesBtn.click();
            Thread.sleep(500);
        } else if (button.equals("tnc")) {
            tncBtn.click();
            Thread.sleep(500);
        } else if (button.equals("payment")) {
            securepayBtn.click();
            Thread.sleep(500);
        }
        return this;
    }

    public LandingPage verifyPage(String page) throws InterruptedException {
        if (page.equals("policies")) {
            String title1 = driver.getTitle();
            Assert.assertEquals(title1, "Policies - Sekolah QA");
            Thread.sleep(1000);
        } else if (page.equals("tnc")) {
            String title2 = driver.getTitle();
            Assert.assertEquals(title2, "Terms and conditions of use - Sekolah QA");
            Thread.sleep(1000);
        } else if (page.equals("payment")) {
            String title3 = driver.getTitle();
            Assert.assertEquals(title3, "Secure payment - Sekolah QA");
            Thread.sleep(1000);
        } else if(page.equals("order")) {
            String title4 = driver.getTitle();
            Assert.assertEquals(title4, "Order - Sekolah QA");
            Thread.sleep(1000);
        }
        return this;
    }
     public LandingPage clickCartButton(){
        bookingCart.click();
        return this;
     }





}
