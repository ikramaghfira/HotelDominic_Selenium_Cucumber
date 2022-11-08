package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.implementation.bytecode.Throw;
import pages.HotelRoomsPage;
import pages.LandingPage;

import static stepDef.Hook.driver;

public class HotelRoomsFeature {

    LandingPage landingPage = new LandingPage(driver);
    HotelRoomsPage hotelRoomsPage = new HotelRoomsPage(driver);

    private String location = "Alabama";
    private String dayIN = "1";
    private String dayOUT = "3";
    private String monthNYear = "December 2022";


    @Given("user is on THE HOTEL PRIME page")
    public void user_is_on_the_hotel_prime_page() throws Throwable {
        landingPage
                .verifyLandingPage()
                .setLocation(location)
                .selectHotel()
                .setCheckIn(monthNYear,dayIN)
                .setCheckOut(monthNYear,dayOUT)
                .goToHotelRooms()
                .verifyPageHotelRooms();
    }

    @When("user slide slider button to certain value")
    public void user_slide_slider_button_to_certain_value() throws Throwable {
        hotelRoomsPage.setSliderValue();
    }

    @Then("user should be shown hotel list accordingly")
    public void user_should_be_shown_hotel_list_accordingly() throws Throwable{
        hotelRoomsPage.verifyRoomsAvailable();
    }

    @And("user click clear filter")
    public void user_click_clear_filter() throws Throwable{
        hotelRoomsPage.clickClearFilter("price");
    }

    @Then("user should be shown all initial lists of hotel")
    public void user_should_be_shown_all_initial_lists_of_hotel() throws Throwable{
        hotelRoomsPage.verifyRoomsAvailable().verifyRoomsAvailable2();
    }

    @When("user click all amenities check boxes")
    public void user_click_all_amenities_check_boxes() throws Throwable {
        hotelRoomsPage
                .clickAmenitiesCheckBox("wifi")
                .clickAmenitiesCheckBox("newspaper")
                .clickAmenitiesCheckBox("power")
                .clickAmenitiesCheckBox("refrigerator")
                .clickAmenitiesCheckBox("restaurant")
                .clickAmenitiesCheckBox("room service")
                .clickAmenitiesCheckBox("gym");
    }

    @Then("user should be shown room error message")
    public void user_should_be_shown_room_error_message() throws Throwable{
        hotelRoomsPage.verifyNoRoomAlert();
    }

    @And("user click clear filter of amenities")
    public void user_click_clear_filter_of_amenities() throws Throwable {
        hotelRoomsPage.clickClearFilter("amenities");
    }

    @When("user click five to one stars rating check boxes")
    public void user_click_five_to_one_stars_rating_check_boxes() throws Throwable{
        hotelRoomsPage
                .clickFiltersCheckBox("5")
                .clickFiltersCheckBox("4")
                .clickFiltersCheckBox("3")
                .clickFiltersCheckBox("2")
                .clickFiltersCheckBox("1");

    }

    @When("user zero star rating check boxes")
    public void user_zero_star_rating_check_boxes() throws Throwable{
        hotelRoomsPage.clickFiltersCheckBox("0");
    }

    @And("user click clear filter of rating")
    public void user_click_clear_filter_of_rating() throws Throwable {
        hotelRoomsPage.clickClearFilter("rating");
    }

    @When("user click price sorting from highest to lowest")
    public void user_click_price_sorting_from_highest_to_lowest() throws Throwable{
        hotelRoomsPage.sortingRoom("ascending");
    }

    @Then("user should be shown list room in ascending order")
    public void user_should_be_shown_list_room_in_ascending_order() throws Throwable{
        hotelRoomsPage.verifySortingResult("ascending");
    }

    @When("user click price sorting from lowest to highest")
    public void user_click_price_sorting_from_lowest_to_highest() throws Throwable{
        hotelRoomsPage.sortingRoom("descending");
    }

    @Then("user should be shown list room in descending order")
    public void user_should_be_shown_list_room_in_descending_order() throws Throwable{
        hotelRoomsPage.verifySortingResult("descending");
    }

    @When("user click add qty button up to maximum room available")
    public void user_click_add_qty_button_up_to_maximum_room_available() throws Throwable {
        hotelRoomsPage.clickAddQuantityRoom();
    }

    @Then("number is displayed in quantity box is as same as maximum room")
    public void number_is_displayed_in_quantity_box_is_as_same_as_maximum_room() throws Throwable{
        hotelRoomsPage.verifyNumberOfRoomAdded();
    }
}
