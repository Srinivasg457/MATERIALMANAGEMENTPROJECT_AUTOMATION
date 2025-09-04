Feature: Material Management Cable Manager Module

  # Background for common steps
  Background:
    Given the user launches the Chrome browser
    And the user navigates to the login page with the URL "https://limitscaleindia.sharepoint.com/sites/Learning-test2/SitePages/MaterialInward.aspx"

#  @smoke
#  Scenario: Moving to Cable Manager Module And Fill up The Cable Inward Details And Submit The Form
#    When the user enters their email "Srinivas.g@limitscale.io"
#    And the user clicks the Submit button
#    Then the user enters their password "Limitscale@05"
#    And the user clicks the login button
#    Then click the cable manager side menu
#    And click the cable List side menu
#    Then Click on the Add Button
#    Then Fill all the Cable Inward required material details and submit the details
#
#  @regression
#  Scenario: Moving to Cable Manager Module  And Submit The Form And Find The Error Mesage
#    When the user enters their email "Srinivas.g@limitscale.io"
#    And the user clicks the Submit button
#    Then the user enters their password "Limitscale@05"
#    And the user clicks the login button
#    Then click the cable manager side menu
#    And click the cable List side menu
#    Then Click on the Add Button
#    Then Click the Submit button submit Button then check the Error Message details

  @regression
  Scenario: Moving to Cable Manager Module  And get The List
    When the user enters their email "Srinivas.g@limitscale.io"
    And the user clicks the Submit button
    Then the user enters their password "Limitscale@05"
    And the user clicks the login button
    Then click the cable manager side menu
    And click the cable List side menu
    Then Get The List Of Data available
