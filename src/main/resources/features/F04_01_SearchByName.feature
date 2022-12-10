@Smoke

  Feature: Search Feature by product name
    Scenario Outline: user could search using product name.
      Given user start typing product by "<name>"
      Then Results should be retrieve matching product "<name>"
      Examples:
        | name |
        | book |
        | laptop |
        | nike |