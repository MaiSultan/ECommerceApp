@Smoke

Feature: Search Feature by product serial number
  Scenario Outline: user could search using product SKU.
    Given user start typing product by serialNo "<SKU>"
    Then Results should be retrieve matching product SerialNo "<SKU>"
    Examples:
      | SKU |
      | SCI_FAITH |
      | APPLE_CAM |
      | SF_PRO_11 |