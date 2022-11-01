Feature: Search Feature

  Scenario: User navigate to Lely website, clicks search icon and search for "happy" and verify that
            all results contain "happy".
    Given Navigate to Lely
    When User clicks on search icon
    Then Search area should appear
    When User enters "happy" in search box
    And clicks search button
    Then Verifies for each result contains happy

