Feature: Account Registration


  Scenario: Successful Registration
    Given the user navigate to the registration page
    When the user create new account using a valid email
    Then I can access members-only page


