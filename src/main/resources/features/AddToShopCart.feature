@Regression
  Feature: Add product item to shopping cart
    Scenario: SC9- Logged user could add different products to Shopping cart
      Given User browses to shopping site
      And Login with valid username & password
      When Click on category and select subcategory
      And Subcategory item is displayed with details
      Then Click on add to cart