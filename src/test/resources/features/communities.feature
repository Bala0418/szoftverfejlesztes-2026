Feature: Communities page

  Scenario: User can see the communities page
    Given the Home page is opened
    When the Communities button is clicked
    Then the "Communities" title is visible
    And the events are visible
    And the title of the first event is "We are Community"

  Scenario: User can search in the list of communities
    Given the Home page is opened
    When the Communities button is clicked
    Then the "Communities" title is visible
    And the search input is visible
    When I enter "We are Community" into the search input
    Then I should see "We are Community" in the search results
    And the number of search results should be 1

  Scenario: User can see the communities page
    Given the Home page is opened
    When the Communities button is clicked
    Then the "Communities" title is visible
    And the events are visible
    And the title of the first event is "FAILING TEST CASE"

  Scenario: User can search in the list of communities
    Given the Home page is opened
    When the Communities button is clicked
    Then the "Communities" title is visible
    And the search input is visible
    When I enter "We are Community" into the search input
    Then I should see "We are Community" in the search results
    And the number of search results should be 999


