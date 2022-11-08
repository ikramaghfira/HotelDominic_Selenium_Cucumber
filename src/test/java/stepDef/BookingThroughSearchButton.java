package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GuestInformationPage;
import pages.LandingPage;
import pages.FinalPage;
import pages.PaymentInformationPage;

import static stepDef.Hook.driver;

public class BookingThroughSearchButton {


    private String location = "Alabama";
    private String hotelName = "The Hotel Prime";
    private String monthAndYear = "December 2022";
    private String dateIn = "3";
    private String dateOut = "4";
    private String roomName = "Delux Rooms";
    private int qtyRoom = 2;
    private int roomPrice = 1500;
    private String userName = ""+(int)(Math.random()*Integer.MAX_VALUE);
    private String email = "fira"+userName+"@gmail.com";
    private String gender = "2";
    private String firstName = "Dian";
    private String lastName = "Sastriwati";
    private String password = "" +(int)(Math.random()*Integer.MAX_VALUE);
    private String phoneName = "" +(int)(Math.random()*Integer.MAX_VALUE);


    @When("user has selected preferred accommodation plan")
    public void user_has_selected_preferred_accommodation_plan() throws Throwable {
        LandingPage landingPage = new LandingPage(driver);
        landingPage
                .setLocation(location)
                .selectHotel()
                .verifyHotelName(hotelName)
                .setCheckIn(monthAndYear, dateIn)
                .setCheckOut(monthAndYear, dateOut)
                .goToHotelRooms()
                .verifyPageHotelRooms()
                .verifyCorrectBookingInformation(hotelName, dateIn, dateOut, monthAndYear)
                .chooseARoom(roomName, qtyRoom)
                .verifyBookingProcessSucceed(qtyRoom, dateIn,dateOut, roomPrice)
                .goToRoomSummary()
                .verifyRoomSummary(roomName, location)
                .goToGuestInfoPage();

    }

    @And("user fill out detail information regarding to payment")
    public void user_fill_out_detail_information_regarding_to_payment() throws Throwable{
        GuestInformationPage guestInfo = new GuestInformationPage(driver);
        guestInfo
                .verifyGuestInformationPage()
                .selectGender(gender)
                .fillName(firstName, lastName)
                .fillEmailAndPhone(email,password,phoneName)
                .goToGuestConfirmationPage()
                .verifyCredentialsCorrect(firstName,lastName,email,phoneName)
                .verifyPriceAfterTax()
                .goToPayInfoPage();
    }

    @And("user select preferred payment methods")
    public void user_select_preferred_payment_methods() throws Throwable{
        PaymentInformationPage payInfo = new PaymentInformationPage(driver);
        payInfo
                .verifyPayInfoPage()
                .accessPaymentMethod()
                .goToOrderSummaryViaBankWire()
                .verifyOrderSummaryPageBW()
                .goToFinalPage();
    }

    @Then("user should be navigated to order confirmation page")
    public void user_should_be_navigated_to_order_confirmation_page() throws Throwable{
        FinalPage finalPage = new FinalPage(driver);
        finalPage
                .verifyOrderSucceed()
                .verifyOrderInfoCorrect(roomName,hotelName,qtyRoom,dateIn,dateOut);
    }

}
