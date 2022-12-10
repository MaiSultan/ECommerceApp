@Regression
Feature: User could log in with valid email and password

  Scenario: User can login with registered email and password
    Given User goes to login URL via Google Chrome browser
    When User enters registered email and password
    And User clicks on login button
    Then Login should successfully done and Home page is displayed