Feature: Google Search

  Scenario: Successful search
    Given I am on the Google search page
    When I enter the search text "Selenium WebDriver"
    And I click on the search button
    Then I should see the search results
