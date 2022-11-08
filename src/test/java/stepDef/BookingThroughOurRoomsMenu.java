package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FinalPage;
import pages.GuestInformationPage;
import pages.LandingPage;
import pages.OurRoomHotelPage;

import static stepDef.Hook.driver;

public class BookingThroughOurRoomsMenu {

    private String hotelRoom = "General";
    private String hotelName = "The Hotel Prime";
    private String setMandYIn = "December 2022";
    private String dayCI = "1";
    private String dayCO = "3";
    private int roomNum = 2;
    private int priceRoom = 1000;
    private String hotelLoc = "Alabama";
    private String userName = ""+(int)(Math.random()*Integer.MAX_VALUE);
    private String email = "fira"+userName+"@gmail.com";
    private String gender = "2";
    private String firstName = "Dian";
    private String lastName = "Sastriwati";
    private String password = "" +(int)(Math.random()*Integer.MAX_VALUE);
    private String phoneName = "" +(int)(Math.random()*Integer.MAX_VALUE);

    @When("user has selected a room through OUR ROOMS")
    public void user_has_selected_a_room_through_our_rooms() throws Throwable{
        LandingPage landingPage = new LandingPage(driver);
        landingPage
                .scrollToOurRooms()
                .bookARoom(hotelRoom)
                .switchToOurRoomTab();
    }

    @And("user arrange accommodation plan")
    public void user_arrange_accommodation_plan() throws Throwable{
        OurRoomHotelPage ourRoomHotelPage = new OurRoomHotelPage(driver);
        ourRoomHotelPage
                .verifyOurRoomPage()
                .setCheckIn(setMandYIn,dayCI)
                .setCheckOut(setMandYIn,dayCO)
                .roomQuantity(roomNum)
                .clickBook()
                .verifyBookingProcessSucceed(roomNum,dayCI,dayCO,priceRoom)
                .goToRoomSummary()
                .verifyRoomSummary(hotelRoom + " Rooms", hotelLoc)
                .goToGuestInfoPage();
    }

    @And("user complete detail information required for payment")
    public void user_complete_detail_information_required_for_payment() throws Throwable {
        GuestInformationPage guestInfo = new GuestInformationPage(driver);
        guestInfo
                .verifyGuestInformationPage()
                .selectGender(gender)
                .fillName(firstName, lastName)
                .fillEmailAndPhone(email,password,phoneName)
                .goToGuestConfirmationPage()
                .verifyCredentialsCorrect(firstName,lastName,email,phoneName)
                .verifyPriceAfterTax()
                .goToPayInfoPage()
                .verifyPayInfoPage()
                .accessPaymentMethod()
                .goToOrderSummaryViaCheque()
                .verifyOrderSummaryPageCQ()
                .goToFinalPage();
    }

    @Then("user should be navigated to booking detail")
    public void user_should_be_navigated_to_booking_detail() {
        FinalPage finalPage = new FinalPage(driver);
        finalPage
                .verifyOrderSucceed()
                .verifyOrderInfoCorrect(hotelRoom + " Rooms", hotelName, roomNum,dayCI,dayCO);
    }

}
