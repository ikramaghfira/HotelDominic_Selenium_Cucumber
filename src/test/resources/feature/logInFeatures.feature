@regression @loginfeature

  Feature: Log In Page Feature

    Background:
      Given user on the landing page
      When user click Sign In button
      Then user should be navigated to login page

      @LgnFT_TC_001
      Scenario: back button in the error message is working fine
        When user left all fields empty
        And user click back button on error message
        Then user should be navigated to landing page

      @LgnFT_TC_002
      Scenario: forgot password button is working fine
        When user click forgot password button
        Then user should be direct to FORGOT PASSWORD page