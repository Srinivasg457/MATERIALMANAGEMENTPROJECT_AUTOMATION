Feature: Material Management Subcontractor Module

  # Background for common steps
  Background:
    Given the user launches the Chrome browser
    And the user navigates to the login page with the URL "https://limitscaleindia.sharepoint.com/sites/Learning-test2/SitePages/MaterialInward.aspx"

#  @smoke
#  Scenario: Moving to Subcontractor Module And Fill up The Required Details And Submit The Form
#    When the user enters their email "Srinivas.g@limitscale.io"
#    And the user clicks the Submit button
#    Then the user enters their password "Limitscale@05"
#    And the user clicks the login button
#    Then click the master side menu
#    And click the subContractor side menu
#    Then Click on the SubContractor Add button and select the subContractor dropdown
#    Then Fill all the SubContractor required  details and submit the details
#
#  @regression
#  Scenario: Moving to Customer Module And Find The Error Mesage
#    When the user enters their email "Srinivas.g@limitscale.io"
#    And the user clicks the Submit button
#    Then the user enters their password "Limitscale@05"
#    And the user clicks the login button
#    Then click the master side menu
#    And click the subContractor side menu
#    Then Click on the SubContractor Add button and select the subContractor dropdown
#    Then click Sucontractor submit Button then check the Error Message details


    @regression
  Scenario:  Moving to Materials Module And Get The List Of The Materials Details In The Table List
    When the user enters their email "Srinivas.g@limitscale.io"
    And the user clicks the Submit button
    Then the user enters their password "Limitscale@05"
    And the user clicks the login button
    Then click the master side menu
    And click the subContractor side menu
    Then Get The List of Data of subContractor List Data in the Table





