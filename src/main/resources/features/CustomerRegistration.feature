Feature: User can register new account to E-Commerce website

  Scenario: User could register with valid data
    Given User opens Google Chrome browser
    And User goes to register URL
    When Valid First name,Last name,Email & Password
    And User clicks on Create button
    Then New user account successfully created