@Regression
Feature: F01_Register | users could register with new accounts

#  Background: User opens Google Chrome browser
#    And User goes to register URL


  Scenario: guest user could register with valid data successfully
    Given User opens Google Chrome browser
    And User goes to register URL
    When Valid First name,Last name,Email,Password & matching Retyped password
    And User clicks on Create button
    Then New user account successfully created
