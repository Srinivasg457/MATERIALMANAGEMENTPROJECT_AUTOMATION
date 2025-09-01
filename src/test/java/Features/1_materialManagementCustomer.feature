Feature: Material Management Customer Module

  # Background for common steps
  Background:
    Given the user launches the Chrome browser
    And the user navigates to the login page with the URL "https://limitscaleindia.sharepoint.com/sites/Learning-test2/SitePages/MaterialInward.aspx"

#  @sanity
#  Scenario: Login to the share point application
#    When the user enters their email "Srinivas.g@limitscale.io"
#    And the user clicks the Submit button
#    Then the user enters their password "Limitscale@05"
#    And the user clicks the login button
#
#   @smoke
#  Scenario: Moving to Customer Module And Fill up The Required Details And Submit The Form
#    When the user enters their email "Srinivas.g@limitscale.io"
#    And the user clicks the Submit button
#    Then the user enters their password "Limitscale@05"
#    And the user clicks the login button
#    Then click the master side menu
#    And click the custmer side menu
#    Then Click on the Add button and select the customer dropdown
#    Then Fill all the required customer details
#
#     @regression
#     Scenario: Moving to Customer Module And Find The Error Mesage
#       When the user enters their email "Srinivas.g@limitscale.io"
#       And the user clicks the Submit button
#       Then the user enters their password "Limitscale@05"
#       And the user clicks the login button
#       Then click the master side menu
#       And click the custmer side menu
#       Then Click on the Add button and select the customer dropdown
#       Then click the Save Button And Find The Error Message
#
#  @regression
#  Scenario: Moving to Customer Module And ADD the Location
#    When the user enters their email "Srinivas.g@limitscale.io"
#    And the user clicks the Submit button
#    Then the user enters their password "Limitscale@05"
#    And the user clicks the login button
#    Then click the master side menu
#    And click the custmer side menu
#    Then Click on the Add button and select the Storage Location dropdown
#    Then Select The Customer DropDown And Select Option
#    And Select The SiteLocation if available
#    Then Add The Loction And Click The Submit Button

    @regression
  Scenario: Moving to Customer Module And Get The List Of The Customer Details In The Table List
    When the user enters their email "Srinivas.g@limitscale.io"
    And the user clicks the Submit button
    Then the user enters their password "Limitscale@05"
    And the user clicks the login button
    Then click the master side menu
    And click the custmer side menu
    Then Get The List of Data of Customers

