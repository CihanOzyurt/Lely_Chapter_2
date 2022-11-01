Feature: Download Catalog Feature

  Scenario: User navigate to lely.com/techdocs, selects "LUNA EUR" from dropdown and verify the document can be seen
            and click it to view document on a new tab and verify, then return to main tab download document and verify
            that document is downloaded.
    Given Navigate to lely-techdocs
    When Select "LUNA EUR" from dropdown menu
    And Verify that catalog can be seen
    Then click to view this document
    And verify that document opened on a new tab
    Then return to previous tab and download the document
    And Verifies document is downloaded