@Smoke
Feature: Change currencies

  Scenario: user can change between different currencies
    Given select one currency from currencies list
    Then Price currency for displayed products should change