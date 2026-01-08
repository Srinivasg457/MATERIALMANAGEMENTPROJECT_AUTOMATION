Feature: Subcontractor Po Unit Price Module

  # Background for common steps
  Background:
    Given the user launches the Chrome browser
    And the user navigates to the login page with the URL "https://limitscaleindia.sharepoint.com/sites/Learning-test2/SitePages/MaterialInward.aspx"

  @smoke
  Scenario: Moving to Subcontractor Po Unit Price  Module And Fill up The Required Details And Submit The Form
    When the user enters their email "Srinivas.g@limitscale.io"
    And the user clicks the Submit button
    Then the user enters their password "Limitscale@05"
    And the user clicks the login button
    Then click the Reconcillation and reports main Menu
    And click the Subcontractors Po Unit price sub menu
    Then Click on Add button to add The Subcontractor  unit price
    Then Fill all the Subcontractors unit price and subbmit the form

  @regression
  Scenario: Moving to Subcontractor Unit Price  Module And Find The Error Message and  count of validation message
    When the user enters their email "Srinivas.g@limitscale.io"
    And the user clicks the Submit button
    Then the user enters their password "Limitscale@05"
    And the user clicks the login button
    Then click the Reconcillation and reports main Menu
    And click the Subcontractors Po Unit price sub menu
    Then Click on Add button to add The Subcontractor  unit price
    Then Clicks the Okay Button and try to Finds the Error Message or validation message Arrears
