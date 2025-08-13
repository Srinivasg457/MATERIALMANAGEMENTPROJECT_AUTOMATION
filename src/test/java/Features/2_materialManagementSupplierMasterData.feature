Feature: Material Management Supplier Module

  # Background for common steps
  Background:
    Given the user launches the Chrome browser
    And the user navigates to the login page with the URL "https://limitscaleindia.sharepoint.com/sites/Learning-test2/SitePages/MaterialInward.aspx"

  @smoke
  Scenario: Moving to Supplier Module And Fill up The Required Details And Submit The Form
    When the user enters their email "Srinivas.g@limitscale.io"
    And the user clicks the Submit button
    Then the user enters their password "Limitscale@05"
    And the user clicks the login button
    Then click the master side menu
    And click the Suppliers side menu
    Then Click on the Add button and select the Suppliers dropdown
    Then Fill all the Suppliers required  details and submit the details

  @regression
  Scenario: Moving to Customer Module And Find The Error Mesage
    When the user enters their email "Srinivas.g@limitscale.io"
    And the user clicks the Submit button
    Then the user enters their password "Limitscale@05"
    And the user clicks the login button
    Then click the master side menu
    And click the Suppliers side menu
    Then Click on the Add button and select the Suppliers dropdown
    Then click Supplier submit Button then check the Error Message details





