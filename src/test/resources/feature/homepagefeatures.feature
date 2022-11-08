@regression @homepagefeatures
Feature: Homepage Features

  Background:
    Given user on the landing page

  @Home_TC000
    Scenario: navigation button is working fine
    When user click navigation button
    And user click close navigation button
    Then navigation button should be disappeared


  @Home_TC001
  Scenario: navigation button HOME is working fine
    When user click navigation button HOME
    Then user should be navigated to landing page

  @Home_TC002
  Scenario: navigation button INTERIOR is working fine
    When user click navigation button INTERIOR
    Then user should be scrolled down to INTERIOR section

  @Home_TC003
  Scenario: image navigation button in INTERIOR section is working fine
    Given user is on the INTERIOR section
    When user click image navigation button
    Then images should be moved to left or right

  @Home_TC004
  Scenario: zoom out button of the image is working fine
    Given user is on the INTERIOR section
    When user click on of the images
    Then image should be zoomed out

  @Home_TC005
  Scenario: navigation button AMENITIES is working fine
    When user click navigation button AMENITIES
    Then user should be scrolled down to AMENITIES section

  @Home_TC006
  Scenario: navigation button ROOMS is working fine
    When user click navigation button ROOMS
    Then user should be scrolled down to OUR ROOMS section

  @Home_TC007
  Scenario: BOOK NOW button of general rooms is working fine
    Given user is on the OUR ROOMS section
    When user click BOOK NOW button of general rooms
    Then user should be navigated to general rooms detail page

  @Home_TC008
  Scenario: BOOK NOW button of delux rooms is working fine
    Given user is on the OUR ROOMS section
    When user click BOOK NOW button of delux rooms
    Then user should be navigated to delux rooms detail page

  @Home_TC009
  Scenario: BOOK NOW button of executive rooms is working fine
    Given user is on the OUR ROOMS section
    When user click BOOK NOW button of executive rooms
    Then user should be navigated to executive rooms detail page

  @Home_TC010
  Scenario: BOOK NOW button of luxury rooms is working fine
    Given user is on the OUR ROOMS section
    When user click BOOK NOW button of luxury rooms
    Then user should be navigated to luxury rooms detail page

  @Home_TC011
  Scenario: navigation button TESTIMONIALS is working fine
    When user click TESTIMONIALS navigation button
    Then user should be scrolled down to TESTIMONIALS section

  @Home_TC012
  Scenario: navigation button LEGAL is working fine
    When user click LEGAL navigation button
    Then user should be directed to LEGAL page

  @Home_TC013
  Scenario: navigation button ABOUT US is working fine
    When user click ABOUT US navigation button
    Then user should be directed to ABOUT US page

  @Home_TC014
  Scenario: navigation button CONTACT US is working fine
    When user click CONTACT US navigation button
    Then user should be directed to CONTACT US page

  @Home_TC015
  Scenario: failed order hotel when all input fields empty
    When user directly click SEARCH NOW button
    Then all fields turn into red

  @Home_TC016
  Scenario: failed order hotel when hotel location and room are empty
    When user pick date in, date out
    And click SEARCH NOW button
    Then user should be still in the landing page

  @Home_TC017
  Scenario: failed order hotel when hotel room are empty
    When user pick date in, date out, hotel location
    And click SEARCH NOW button
    Then user should be still in the landing page

  @Home_TC018
  Scenario: failed order hotel when only check out date is empty
    When user pick hotel location, room, date in
    And click SEARCH NOW button
    Then user should be still in the landing page

  @Home_TC019
  Scenario: next and previous button in date field are working fine
    When user click next or previous button on date field
    Then user should be shown month and year accordingly

  @Home_TC020
  Scenario: successfully subscribe through SUBSCRIBE BUTTON
    When user scroll down to end of the page
    And user input email also click SUBSCRIBE button
    Then user should be shown succeed message

  @Home_TC021
  Scenario: failed subscribe through SUBSCRIBE BUTTON because of registered email
    When user scroll down to end of the page
    And user input registered email also click SUBSCRIBE button
    Then user should be shown failed message

  @Home_TC022
  Scenario Outline: failed subscribe through SUBSCRIBE BUTTON because of invalid email
    When user scroll down to end of the page
    And user input invalid <email> also click SUBSCRIBE button
    Then user should be shown failed message of invalid email

    Examples:
    | email |
    | .abc@gmail.com     |
    | abc.def@gmail#archive.com|
    | abc.def@mail..com        |
    | abcdef                   |

  @Home_TC023
  Scenario: successfully direct to Qlo Facebook Page
    When user scroll down to end of the page
    And user click FACEBOOK logo
    Then user should be directed to FACEBOOK page

  @Home_TC024
  Scenario: successfully direct to Qlo Twitter Page
    When user scroll down to end of the page
    And user click TWITTER logo
    Then user should be directed to TWITTER page

  @Home_TC025
  Scenario: successfully direct to POLICIES Page
    When user scroll down to end of the page
    And user click POLICIES button
    Then user should be directed to POLICIES page

  @Home_TC026
  Scenario: successfully direct to TERM AND CONDITION OF USE Page
    When user scroll down to end of the page
    And user click TERM AND CONDITION OF USE button
    Then user should be directed to TERM AND CONDITION OF USE page

  @Home_TC027
  Scenario: successfully direct to SECURE PAYMENT Page
    When user scroll down to end of the page
    And user click SECURE PAYMENT button
    Then user should be directed to SECURE PAYMENT page

  @Home_TC028
  Scenario: successfully direct to ORDER Page
    When user click CART button
    Then user should be directed to ORDER page



