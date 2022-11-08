@regression @login
Feature: Log In Function

Background:
  Given user on the landing page
  When user click Sign In button
  Then user should be navigated to login page

  @LogIn_TC001
  Scenario: successful log in with valid email
    When user fill email field with valid email and password: "testgeg@gmail.com", "12345"
    Then user should be navigated to the MY ACCOUNT page

  @LogIn_TC002
  Scenario: failed log in with incorrect password
    When user fill email field with email and incorrect password: "testgeg@gmail.com", "23455"
    Then user should be shown error log in message

  @LogIn_TC003
  Scenario: failed log in with incorrect email
    When user fill email field with incorrect email and password: "testg@gmail.com", "12345"
    Then user should be shown error log in message

  @LogIn_TC004
  Scenario Outline: failed log in with invalid email
    When user fill email field with invalid <email> and <password>
    Then user should be shown error log in message

  Examples:
    | email | password |
    | .abc@gmail.com     | 12345  |
    | abc@gmailcom       | 12345  |

  @LogIn_TC005
  Scenario: failed log in with invalid password
    When user fill email field with email and invalid password: "testgeg@gmail.com", "12"
    Then user should be shown error log in message

  @LogIn_TC006
  Scenario: failed log in with invalid email and password
    When user fill invalid email and password: ".abc@gmail.com", "12"
    Then user should be shown error log in message

  @LogIn_TC007
  Scenario: failed log in when required fields are empty
    When user left the fields empty
    Then user should be shown error log in message
