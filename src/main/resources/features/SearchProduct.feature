@Regression
  Feature: Search for product

  Scenario:  Logged User could search for any product
  Given User launches Google Chrome and navigate to Home Page
  When Go to Search textbox & Type any product name and press enter
  Then Matching product results should be displayed