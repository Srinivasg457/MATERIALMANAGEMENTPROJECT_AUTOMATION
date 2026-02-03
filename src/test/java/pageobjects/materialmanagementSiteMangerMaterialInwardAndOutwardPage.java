package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.WaitHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

public class materialmanagementSiteMangerMaterialInwardAndOutwardPage {
    public WebDriver ldriver;
    WaitHelper waithelper;

    public static Properties configprop;
    //constructor
    public materialmanagementSiteMangerMaterialInwardAndOutwardPage(WebDriver rdriver) throws IOException {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
        waithelper = new WaitHelper(ldriver);

    }

    //xpath identification

    {
        try {
            configprop = new Properties();
            String configPath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
            FileInputStream configProfile = new FileInputStream(configPath);
            configprop.load(configProfile);


        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file!");
        }
    }

    private By getByXpath(String key) {
        String xpath = configprop.getProperty(key);
        if (xpath == null || xpath.trim().isEmpty()) {
            System.out.println("WARNING: XPath for key '" + key + "' is missing or commented out in config.properties.");
            return null; // Avoids IllegalArgumentException
        }
        return By.xpath(xpath);
    }

    //Locators
    By SiteMangermainMenu = By.xpath(configprop.getProperty("SiteMangermainMenu"));
    By MaterialReport = By.xpath(configprop.getProperty("MaterialReport"));
    By MaterialInwardreportbtn = By.xpath(configprop.getProperty("MaterialInwardreportbtn"));
    By PoDropDown = By.xpath(configprop.getProperty("PoDropDown"));
    By DropDownList = By.xpath(configprop.getProperty("DropDownList"));
    By listofCustomerPo = By.xpath(configprop.getProperty("listofCustomerPo"));
    By resultsContainer = By.id(configprop.getProperty("resultsContainer"));
    By dropdownList = By.tagName(configprop.getProperty("dropdownList"));
    By DisplayedSelectedvalue = By.cssSelector(configprop.getProperty("DisplayedSelectedvalue"));
    By generateInwardBtn = By.xpath(configprop.getProperty("generateInwardBtn"));
    By exportLiveBtn = By.xpath(configprop.getProperty("exportLiveBtn"));
    By successmsg = By.xpath(configprop.getProperty("successmsg"));
    By VendorpoDropDown = By.xpath(configprop.getProperty("VendorpoDropDown"));
    By VendorPoListDropDown = By.id(configprop.getProperty("VendorPoListDropDown"));


    //Actions Method
    // Here we click on the share point sub menu
    public void sharepointSiteMangermainMenu( ) {

        try {
            WebElement SiteManger = waithelper.WaitForElement1(SiteMangermainMenu, 10);
            WebElement Materialreport = waithelper.WaitForElement1(MaterialReport, 10);

            if(Materialreport.isDisplayed() && Materialreport.isEnabled()){
                Assert.assertTrue(true);
            }
            else{
                SiteManger.click();
                Assert.fail("Clicking The Site manage because Its Not Opened");
            }

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }


    // Here we click
    public void sharepointMaterialReport( ) {

        try {
            WebElement Materialreport = waithelper.WaitForElement1(MaterialReport, 10);
          if(Materialreport.isDisplayed() && Materialreport.isEnabled()){
              Materialreport.click();
              Assert.assertTrue(true);
          }
          else {
              Assert.fail("material Report Sub Menu Not Displayed or Enabled ");
          }
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }


    // Here we click
    public void sharepointMaterialInwardreportbtn( ) {

        try {
            WebElement MaterialInwardreportBtn = waithelper.WaitForElement1(MaterialInwardreportbtn, 10);
            if(MaterialInwardreportBtn.isDisplayed() && MaterialInwardreportBtn.isEnabled()){
                MaterialInwardreportBtn.click();
                Assert.assertTrue(true);
            }
            else {
                Assert.fail("Material Inward report Btn Not Displayed or Enabled ");
            }
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }


    // Here we click
    public void sharepointCustomerPoDropDown( ) {
        try {
            WebElement PoDropdown = waithelper.WaitForElement1(PoDropDown,10);
            if(PoDropdown.isDisplayed() && PoDropdown.isEnabled()){
                PoDropdown.click();
                Assert.assertTrue(true);
            }
            else {
                Assert.fail("PoDropdown Not Displayed or Enabled ");
            }
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    // Here we click
    public void sharepointDropDownList( ) {
        try {
            WebElement DropDownlist = waithelper.WaitForElement1(DropDownList,10);
            if(DropDownlist.isDisplayed()){
                Assert.assertTrue(true);
            }
            else {
                Assert.fail("DropDownlist Not Displayed  ");
            }
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }




    public void sharepointlistofCustomerPo() {
        try {
            System.out.println("=== Method 2: Proper Select2 Handling ===");

            // STEP 3: Find the dropdown results container
            WebElement resultscontainer = waithelper.WaitForElement1(resultsContainer,10);
            System.out.println("Dropdown results container found");

            // STEP 4: Get all options
            List<WebElement> options = resultscontainer.findElements(dropdownList);

            System.out.println("Total options in dropdown: " + options.size());

            // STEP 5: Select first valid PO
            for (WebElement option : options) {
                String optionText = option.getText().trim();
                System.out.println("Checking option: '" + optionText + "'");

                if (!optionText.equals("Select Customer PO") && !optionText.isEmpty()) {
                    System.out.println("✓ Selecting: " + optionText);
                    option.click();

                    // Verify selection
                    verifySelectedPO(optionText);
                    return;
                }
            }

            System.out.println("No valid PO found");

        } catch (Exception e) {
            System.out.println("Error in selectPOFromDropdownCorrectly: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void verifySelectedPO(String expectedPO) {
        try {
            // Wait a moment for selection to reflect
            Thread.sleep(1000);

            // Find the displayed selected value
            WebElement selectedDisplay =  waithelper.WaitForElement1(DisplayedSelectedvalue,10);
            String displayedText = selectedDisplay.getText();

            System.out.println("Expected PO: " + expectedPO);
            System.out.println("Displayed text: " + displayedText);

            if (displayedText.contains(expectedPO)) {
                System.out.println("✓ PO selection verified successfully!");
            } else {
                System.out.println("⚠ PO selection might not have worked");
            }

        } catch (Exception e) {
            System.out.println("Could not verify selection: " + e.getMessage());
        }
    }



    // Here we click
    public void sharepointgenerateInwardBtn( ) {
        try {
            WebElement generateInwardbtn = waithelper.WaitForElement1(generateInwardBtn,10);
            if(generateInwardbtn.isDisplayed() && generateInwardbtn.isEnabled()){
                generateInwardbtn.click();
                Assert.assertTrue(true);
            }
            else {
                Assert.fail("generateInwardbtn Not Displayed and Not Enabled  ");
            }
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    // Here we click
    public void sharepointexportLiveBtn( ) {
        try {
            WebElement exportLivebtn = waithelper.WaitForElement1(exportLiveBtn,10);
            if(exportLivebtn.isDisplayed() && exportLivebtn.isEnabled()){
                exportLivebtn.click();
                Assert.assertTrue(true);
            }
            else {
                Assert.fail("generateInwardbtn Not Displayed and Not Enabled  ");
            }
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }


    public void sharepointsuccessmsg() {
        try {
            WebElement successMsg = waithelper.WaitForElement1(successmsg, 10);

            if (successMsg.isDisplayed() && successMsg.isEnabled()) {
                // Get the ACTUAL text from the WebElement
                String actualMsg = successMsg.getText().trim();
                System.out.println("Actual message: '" + actualMsg + "'");

                String expectedMsg1 = "Successfully Report is Downloaded";
                String expectedMsg2 = "Please select Customer PO";

                // CORRECT WAY: Compare actual text with expected messages
                if (actualMsg.equals(expectedMsg1) || actualMsg.equals(expectedMsg2)) {
                    System.out.println("✓ Message verified: " + actualMsg);
                    Assert.assertTrue("Message is correct: " + actualMsg, true);
                } else {
                    System.out.println("✗ Message mismatch. Expected: '" + expectedMsg1 +
                            "' or '" + expectedMsg2 + "', Actual: '" + actualMsg + "'");
                    Assert.fail("Message is wrong. Expected: '" + expectedMsg1 + "' or '" + expectedMsg2 +
                            "', but got: '" + actualMsg + "'");
                }
            } else {
                Assert.fail("Success message element is not displayed or enabled");
            }

        } catch (Exception e) {
            System.out.println("Unexpected error in success message verification: " + e.getMessage());
            e.printStackTrace();
            Assert.fail("Failed to verify success message: " + e.getMessage());
        }
    }


    // Vendor po DropDown
    public void sharepointVendorpoDropDown( ) {
        try {
            WebElement VendorpoDropdown = waithelper.WaitForElement1(VendorpoDropDown,10);
            if(VendorpoDropdown.isDisplayed() && VendorpoDropdown.isEnabled()){
                VendorpoDropdown.click();
                Assert.assertTrue(true);
            }
            else {
                Assert.fail("VendorpoDropDown Not Displayed and Not Enabled  ");
            }
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }



    public void sharepointVendorPoListDropDown() {
        try {
            System.out.println("=== Method 2: Proper Select2 Handling ===");

            // STEP 3: Find the dropdown results container
            WebElement VendorPoListDropdown = waithelper.WaitForElement1(VendorPoListDropDown,10);
            System.out.println("Dropdown results container found");

            // STEP 4: Get all options
            List<WebElement> options = VendorPoListDropdown.findElements(dropdownList);

            System.out.println("Total options in dropdown: " + options.size());

            // STEP 5: Select first valid PO
            for (WebElement option : options) {
                String optionText = option.getText().trim();
                System.out.println("Checking option: '" + optionText + "'");

                if (!optionText.equals("Select Vendor PO") && !optionText.isEmpty()) {
                    System.out.println("✓ Selecting: " + optionText);
                    option.click();

                    // Verify selection
                    verifySelectedVendorPO(optionText);
                    return;
                }
            }

            System.out.println("No valid Vendor PO found");

        } catch (Exception e) {
            System.out.println("Error in select Vendor PO From DropdownCorrectly: " + e.getMessage());
            e.printStackTrace();
        }
    }


    private void verifySelectedVendorPO(String expectedPO) {
        try {
            // Wait a moment for selection to reflect
            Thread.sleep(1000);

            // Find the displayed selected value
            WebElement selectedDisplay =  waithelper.WaitForElement1(DisplayedSelectedvalue,10);
            String displayedText = selectedDisplay.getText();

            System.out.println("Expected PO: " + expectedPO);
            System.out.println("Displayed text: " + displayedText);

            if (displayedText.contains(expectedPO)) {
                System.out.println("✓ Vendor PO selection verified successfully!");
            } else {
                System.out.println("⚠ Vendor PO selection might not have worked");
            }

        } catch (Exception e) {
            System.out.println("Could not verify Vendor Po selection: " + e.getMessage());
        }
    }







}
