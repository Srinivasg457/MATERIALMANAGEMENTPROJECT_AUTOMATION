Feature: Site manager  Materials Inward and outward
 # Background for common steps
  Background:
    Given the user launches the Chrome browser
    And the user navigates to the login page with the URL "https://limitscaleindia.sharepoint.com/sites/Learning-test2/SitePages/MaterialInward.aspx"


  Scenario: Select available PO number from dropdown
    When the user enters their email "Srinivas.g@limitscale.io"
    And the user clicks the Submit button
    Then the user enters their password "Limitscale@05"
    And the user clicks the login button
    Then click the Site Manager main Menu
    And Click The  Material report Sub Menu
    Then I am on the page with PO dropdown
    When I select PO number  from the dropdown
    Then PO number should be selected
    And Click the Export button
#
#
#  Scenario: click Generate The Report Without Selecting The Customer po
#    When the user enters their email "Srinivas.g@limitscale.io"
#    And the user clicks the Submit button
#    Then the user enters their password "Limitscale@05"
#    And the user clicks the login button
#    Then click the Site Manager main Menu
#    And Click The  Material report Sub Menu
#    Then I am on the page with PO dropdown
#    And Click The Generate button
#    Then Pop up message saying po number shoild be selected message should be displayed

  Scenario: click Generate The Report Wit Selecting The Customer Po And Vendor Po
    When the user enters their email "Srinivas.g@limitscale.io"
    And the user clicks the Submit button
    Then the user enters their password "Limitscale@05"
    And the user clicks the login button
    Then click the Site Manager main Menu
    And Click The  Material report Sub Menu
    Then I am on the page with PO dropdown
    When I select PO number  from the dropdown
    Then customer PO number should be selected
    And Click the Vendor po dropdown
    Then Select the Vendor Po Number
    And Finally Click the Export button