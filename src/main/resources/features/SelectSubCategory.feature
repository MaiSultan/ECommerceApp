Feature: Logged user can select sub category of products

  Scenario: SC6- Logged user could select different Categories
    Given User opens G.Chrome and navigate to Site Home Page
    And Login with valid credentials
    When User click randomly on any category
    Then Hover and click on one subcategory
    And Subcategory details should be displayed