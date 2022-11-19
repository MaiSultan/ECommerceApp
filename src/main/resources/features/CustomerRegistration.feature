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

  Scenario: User couldn't register with already used email
    Given User opens Google Chrome browser
    And User goes to register URL
    When Valid First name,Last name,already used Email,Password & matching Retyped password
    And User clicks on Create button
    Then Message appears Email is already used