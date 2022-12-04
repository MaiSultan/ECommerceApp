@Regression
Feature: User can create a new account

#  Background: User opens Google Chrome browser
#    And User goes to register URL


  Scenario: User could register with valid data
    Given User opens Google Chrome browser
    And User goes to register URL
    When Valid First name,Last name,Email,Password & matching Retyped password
    And User clicks on Create button
    Then New user account successfully created
