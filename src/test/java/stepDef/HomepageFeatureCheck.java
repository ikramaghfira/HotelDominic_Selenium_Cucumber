package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LandingPage;

import static stepDef.Hook.driver;

public class HomepageFeatureCheck {

    private String location = "Alabama";
    private String dayIn = "3";
    private String dayOut = "4";
    private String monthAndYear = "November 2022";
    private String registeredEmail = "testgeg@gmail.com";
    private String userName = ""+(int)(Math.random()*Integer.MAX_VALUE);
    private String email = "fira"+userName+"@gmail.com";



    LandingPage landingPage = new LandingPage(driver);

    @When("user click navigation button")
    public void user_click_navigation_button() throws Throwable{
        landingPage.clickNavBtn();
    }

    @And("user click close navigation button")
    public void user_click_close_navigation_button() throws Throwable{
        landingPage.exitNavBtn();
    }

    @Then("navigation button should be disappeared")
    public void navigation_button_should_be_disappeared() throws Throwable{
        landingPage.verifyInvisible();
    }

    @When("user click navigation button HOME")
    public void user_click_navigation_button_home() throws Throwable {
        landingPage
                .clickNavBtn()
                .clickNavigationMenu("home");
    }

    @Then("user should be navigated to landing page")
    public void user_should_be_navigated_to_landing_page() throws Throwable{
        landingPage.verifyLandingPage();
    }

    @When("user click navigation button INTERIOR")
    public void user_click_navigation_button_interior() throws Throwable {
        landingPage
                .clickNavBtn()
                .clickNavigationMenu("interior");
    }

    @Then("user should be scrolled down to INTERIOR section")
    public void user_should_be_scrolled_down_to_interior_section() throws Throwable {
        landingPage.verifyMenuResult("interior");
    }

    @Given("user is on the INTERIOR section")
    public void user_is_on_the_interior_section() throws Throwable {
        landingPage
                .clickNavBtn()
                .clickNavigationMenu("interior")
                .verifyMenuResult("interior")
                .exitNavBtn();
    }

    @When("user click image navigation button")
    public void user_click_image_navigation_button() throws Throwable {
        landingPage.clickNavImage();
    }

    @Then("images should be moved to left or right")
    public void images_should_be_moved_to_left_or_right() throws Throwable {
        landingPage.verifyImageMove();
    }

    @When("user click on of the images")
    public void user_click_on_of_the_images() throws Throwable {
        landingPage.clickImageInterior();
    }

    @Then("image should be zoomed out")
    public void image_should_be_zoomed_out() throws Throwable {
        landingPage.verifyPicZoomedOut();
    }

    @When("user click navigation button AMENITIES")
    public void user_click_navigation_button_amenities() throws Throwable{
        landingPage
                .clickNavBtn()
                .clickNavigationMenu("amenities");
    }

    @Then("user should be scrolled down to AMENITIES section")
    public void user_should_be_scrolled_down_to_amenities_section() throws Throwable {
        landingPage.verifyMenuResult("amenities");
    }

    @When("user click navigation button ROOMS")
    public void user_click_navigation_button_rooms() throws Throwable {
        landingPage
                .clickNavBtn()
                .clickNavigationMenu("rooms");
    }

    @Then("user should be scrolled down to OUR ROOMS section")
    public void user_should_be_scrolled_down_to_our_rooms_section() throws Throwable {
        landingPage
                .verifyMenuResult("rooms");
    }

    @Given("user is on the OUR ROOMS section")
    public void user_is_on_the_our_rooms_section() throws Throwable {
        landingPage
                .clickNavBtn()
                .clickNavigationMenu("rooms")
                .exitNavBtn()
                .verifyMenuResult("rooms");
    }

    @When("user click BOOK NOW button of general rooms")
    public void user_click_book_now_button_of_general_rooms() throws Throwable {
        landingPage.clickGeneralBook();
    }

    @Then("user should be navigated to general rooms detail page")
    public void user_should_be_navigated_to_general_rooms_detail_page() throws Throwable {
        landingPage.verifyUserInRoomDetailPage("general");
    }

    @When("user click BOOK NOW button of delux rooms")
    public void user_click_book_now_button_of_delux_rooms() throws Throwable {
        landingPage.clickDeluxBook();
    }

    @Then("user should be navigated to delux rooms detail page")
    public void user_should_be_navigated_to_delux_rooms_detail_page()  {
        landingPage.verifyUserInRoomDetailPage("delux");
    }

    @When("user click BOOK NOW button of executive rooms")
    public void user_click_book_now_button_of_executive_rooms() {
        landingPage.clickExecutiveBook();
    }

    @Then("user should be navigated to executive rooms detail page")
    public void user_should_be_navigated_to_executive_rooms_detail_page() {
        landingPage.verifyUserInRoomDetailPage("executive");
    }

    @When("user click BOOK NOW button of luxury rooms")
    public void user_click_book_now_button_of_luxury_rooms() {
        landingPage.clickLuxuryBook();
    }

    @Then("user should be navigated to luxury rooms detail page")
    public void user_should_be_navigated_to_luxury_rooms_detail_page() {
        landingPage.verifyUserInRoomDetailPage("luxury");
    }

    @When("user click TESTIMONIALS navigation button")
    public void user_click_testimonials_navigation_button() throws Throwable {
        landingPage
                .clickNavBtn()
                .clickNavigationMenu("testimonials");
    }

    @Then("user should be scrolled down to TESTIMONIALS section")
    public void user_should_be_scrolled_down_to_testimonials_section() throws Throwable{
        landingPage.verifyMenuResult("testimonials");
    }

    @When("user click LEGAL navigation button")
    public void user_click_legal_navigation_button() throws Throwable{
        landingPage
                .clickNavBtn()
                .clickNavigationMenu("legal");
    }

    @Then("user should be directed to LEGAL page")
    public void user_should_be_directed_to_legal_page() throws Throwable{
        landingPage.verifyMenuResult("legal");
    }

    @When("user click ABOUT US navigation button")
    public void user_click_about_us_navigation_button() throws Throwable {
        landingPage
                .clickNavBtn()
                .clickNavigationMenu("about us");
    }

    @Then("user should be directed to ABOUT US page")
    public void user_should_be_directed_to_about_us_page() throws Throwable{
        landingPage.verifyMenuResult("about us");
    }

    @When("user click CONTACT US navigation button")
    public void user_click_contact_us_navigation_button() throws Throwable{
        landingPage
                .clickNavBtn()
                .clickNavigationMenu("contact us");
    }

    @Then("user should be directed to CONTACT US page")
    public void user_should_be_directed_to_contact_us_page() throws Throwable{
        landingPage.verifyMenuResult("contact us");
    }

    @When("user directly click SEARCH NOW button")
    public void user_directly_click_search_now_button() {
        landingPage.goToHotelRooms();
    }

    @Then("all fields turn into red")
    public void all_fields_turn_into_red() {
        landingPage.verifyFieldsBorderChangeColor();
    }

    @When("user pick date in, date out")
    public void user_pick_date_in_date_out() throws Throwable{
        landingPage
                .setCheckIn(monthAndYear, dayIn)
                .setCheckOut(monthAndYear, dayOut);
    }

    @And("click SEARCH NOW button")
    public void click_search_now_button() {
        landingPage.goToHotelRooms();
    }

    @Then("user should be still in the landing page")
    public void user_should_be_still_in_the_landing_page() {
        landingPage.verifyLandingPage();
    }

    @When("user pick date in, date out, hotel location")
    public void user_pick_date_in_date_out_hotel_location() throws Throwable{
        landingPage
                .setLocation(location)
                .setCheckIn(monthAndYear,dayIn)
                .setCheckOut(monthAndYear,dayOut);
    }

    @When("user pick hotel location, room, date in")
    public void user_pick_hotel_location_room_date_in() throws Throwable {
        landingPage
                .setLocation(location)
                .selectHotel()
                .setCheckIn(monthAndYear,dayIn);
    }

    @When("user click next or previous button on date field")
    public void user_click_next_or_previous_button_on_date_field() throws Throwable{
        landingPage
                .clickDate("out")
                .clickMonthButton();
    }

    @Then("user should be shown month and year accordingly")
    public void user_should_be_shown_month_and_year_accordingly() {
        landingPage.verifyMonth(monthAndYear);
    }

    @When("user scroll down to end of the page")
    public void user_scroll_down_to_end_of_the_page() {
        landingPage.scrollToEndPage();
    }

    @And("user input email also click SUBSCRIBE button")
    public void user_input_email_also_click_subscribe_button() throws Throwable{
        landingPage.subscribeToSite(email);
    }

    @Then("user should be shown succeed message")
    public void user_should_be_shown_succeed_message() {
        landingPage.verifySubscribeMessage("success");
    }

    @And("user input registered email also click SUBSCRIBE button")
    public void user_input_registered_email_also_click_subscribe_button() throws Throwable {
        landingPage.subscribeToSite(registeredEmail);
    }

    @Then("user should be shown failed message")
    public void user_should_be_shown_failed_message() {
        landingPage.verifySubscribeMessage("failed1");
    }

    @When("^user input invalid (.*) also click SUBSCRIBE button$")
    public void user_input_invalid_email_also_click_subscribe_button(String email) throws Throwable {
        landingPage.subscribeToSite(email);
    }

    @Then("user should be shown failed message of invalid email")
    public void user_should_be_shown_failed_message_of_invalid_email() {
        landingPage.verifySubscribeMessage("failed2");
    }

    @And("user click FACEBOOK logo")
    public void user_click_facebook_logo() throws Throwable{
        landingPage.clickSocmedButton("facebook");
    }

    @Then("user should be directed to FACEBOOK page")
    public void user_should_be_directed_to_facebook_page() throws Throwable {
        landingPage.verifySocmedResult("facebook");
    }

    @And("user click TWITTER logo")
    public void user_click_twitter_logo() throws Throwable{
        landingPage.clickSocmedButton("twitter");
    }

    @Then("user should be directed to TWITTER page")
    public void user_should_be_directed_to_twitter_page() throws Throwable {
        landingPage.verifySocmedResult("twitter");
    }

    @And("user click POLICIES button")
    public void user_click_policies_button() throws Throwable{
        landingPage.clickExploreButton("policies");
    }

    @Then("user should be directed to POLICIES page")
    public void user_should_be_directed_to_policies_page() throws Throwable {
        landingPage.verifyPage("policies");
    }

    @And("user click TERM AND CONDITION OF USE button")
    public void user_click_term_and_condition_of_use_button() throws Throwable {
        landingPage.clickExploreButton("tnc");
    }

    @Then("user should be directed to TERM AND CONDITION OF USE page")
    public void user_should_be_directed_to_term_and_condition_of_use_page() throws Throwable {
        landingPage.verifyPage("tnc");
    }

    @And("user click SECURE PAYMENT button")
    public void user_click_secure_payment_button() throws Throwable {
        landingPage.clickExploreButton("payment");
    }

    @Then("user should be directed to SECURE PAYMENT page")
    public void user_should_be_directed_to_secure_payment_page() throws Throwable {
        landingPage.verifyPage("payment");
    }

    @When("user click CART button")
    public void user_click_cart_button() {
        landingPage.clickCartButton();
    }

    @Then("user should be directed to ORDER page")
    public void user_should_be_directed_to_order_page() throws Throwable{
        landingPage.verifyPage("order");
    }



}
