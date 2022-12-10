@Smoke
Feature: Hover Categories
  Scenario: user could select subcategory
    Given User hover randomly on any category
    When select any subcategory and click on it
    Then Sub category page should open
    And SubCategory page's title should match clicked sub category
