@regression @signup
Feature: Sign Up Function

Background:
  Given user on the landing page
  When user click Sign In button
  Then user should be navigated to login page

  @SignUp_TC_001
  Scenario: successful sign up with valid data
    When user fill unregistered email to create an account
    And user fill in the following valid credentials: "Abdul", "Beta", "12345"
    And user click register button
    Then user should be navigated to the my account page

  @SignUp_TC_002
  Scenario: failed sign up with invalid data
    When user fill unregistered email to create an account
    And user fill in the following invalid credentials: "1234", "1112", "12"
    And user click register button
    Then user should be shown error messages

  @SignUp_TC_003
  Scenario: failed sign up with registered email
    When user fill registered "test@gmail.com" to create an account
    Then user should be shown error message

  @SignUp_TC_004
  Scenario Outline: failed sign up with invalid email
    When user input invalid <email> on the email address
    Then user should be shown error messages

    Examples:
      | email |
      | .abc@gmail.com     |
      | abc@gmailcom       |



