@smoke
Feature: F06_HoverCategories | Users can select different categories

  Scenario: User can select a random category and subcategory
    When user select random one of the three main categories hover and select random one of the three sub categories
    Then user could find sub-category title is equal or contains the random selected sub-category