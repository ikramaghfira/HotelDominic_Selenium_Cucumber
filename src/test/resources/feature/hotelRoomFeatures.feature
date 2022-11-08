@regression @hotelroomfeature

  Feature: The Hotel Prime Features

    @HR_TC001
    Scenario: price slider button is working fine
      Given user is on THE HOTEL PRIME page
      When user slide slider button to certain value
      Then user should be shown hotel list accordingly

    @HR_TC002
    Scenario: clear filter in the PRICE section is working fine
      Given user is on THE HOTEL PRIME page
      When user slide slider button to certain value
      And user click clear filter
      Then user should be shown all initial lists of hotel

    @HR_TC003
    Scenario: amenities check boxes are working fine
      Given user is on THE HOTEL PRIME page
      When user click all amenities check boxes
      Then user should be shown room error message

    @HR_TC004
    Scenario: clear filter in the AMENITIES section is working fine
      Given user is on THE HOTEL PRIME page
      When user click all amenities check boxes
      And user click clear filter of amenities
      Then user should be shown all initial lists of hotel

    @HR_TC005
    Scenario: rating five to one check boxes are working fine
      Given user is on THE HOTEL PRIME page
      When user click five to one stars rating check boxes
      Then user should be shown room error message

    @HR_TC006
    Scenario: rating zero check box is working fine
      Given user is on THE HOTEL PRIME page
      When user zero star rating check boxes
      Then user should be shown all initial lists of hotel

    @HR_TC007
    Scenario: clear filter in the RATING section is working fine
      Given user is on THE HOTEL PRIME page
      When user click five to one stars rating check boxes
      And user click clear filter of rating
      Then user should be shown all initial lists of hotel

    @HR_TC008
    Scenario: sorting ascending function is working fine
      Given user is on THE HOTEL PRIME page
      When user click price sorting from highest to lowest
      Then user should be shown list room in ascending order

    @HR_TC009
    Scenario: sorting descending function is working fine
      Given user is on THE HOTEL PRIME page
      When user click price sorting from lowest to highest
      Then user should be shown list room in descending order

    @HR_TC010
    Scenario: quantity room additional button is working fine
      Given user is on THE HOTEL PRIME page
      When user click add qty button up to maximum room available
      Then number is displayed in quantity box is as same as maximum room
