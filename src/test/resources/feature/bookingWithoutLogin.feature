@regression @bookingflow1
Feature: Booking Flow Without Login

  @BookingWOLgn_TC_001
  Scenario: successful booking through search button on landing page
    Given user on the landing page
    When user has selected preferred accommodation plan
    And user fill out detail information regarding to payment
    And user select preferred payment methods
    Then user should be navigated to order confirmation page


  @BookingWOLgn_TC_002
  Scenario: successful booking through OUR ROOMS on landing page
    Given user on the landing page
    When user has selected a room through OUR ROOMS
    And user arrange accommodation plan
    And user complete detail information required for payment
    Then user should be navigated to booking detail
