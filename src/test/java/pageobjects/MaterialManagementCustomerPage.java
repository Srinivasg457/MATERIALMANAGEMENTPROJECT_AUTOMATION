package pageobjects;

import org.apache.http.auth.InvalidCredentialsException;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinations.BaseClass;
import utilities.EmailReading;
import utilities.WaitHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static stepDefinations.BaseClass.randomNumber;
import static stepDefinations.BaseClass.randomString;


public class MaterialManagementCustomerPage extends BaseClass {

  public EmailReading emailu;
    public WebDriver ldriver;
    WaitHelper waithelper;
    public static Properties configprop;

    //constructor
    public MaterialManagementCustomerPage(WebDriver rdriver) throws IOException {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
        waithelper = new WaitHelper(ldriver);

    }

    //xpath identification

    {
//        try {
//            configprop = new Properties();
//            // Use the classpath to load the properties file
//            InputStream configProfile = getClass().getClassLoader().getResourceAsStream("config.properties");
//
//            if (configProfile == null) {
//                throw new RuntimeException("config.properties file not found in the classpath!");
//            }
//
//            configprop.load(configProfile);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Failed to load properties file!");
//        }


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





//    sharepoint application   Locators
    By Email=By.xpath((configprop.getProperty("sharepointemail")));
    By nextButton=By.xpath(configprop.getProperty("NextButton"));
    By password=By.xpath(configprop.getProperty("sharepointpassword"));
    By signinButton=By.xpath(configprop.getProperty("signinButton"));
    By ConfirmButton=By.xpath(configprop.getProperty("yesButton"));
    By masterdatasidemenu=By.xpath(configprop.getProperty("masterdatasidemenu"));
    By customermasterdata=By.xpath(configprop.getProperty("customermasterdata"));
    By AddMasterDataButton=By.xpath(configprop.getProperty("AddMasterDataButton"));
    By customeroption=By.xpath(configprop.getProperty("customeroption"));
    By cusname=By.xpath(configprop.getProperty("cusname"));
    By cusprojectnumber=By.xpath(configprop.getProperty("cusprojectnumber"));
    By cuscode=By.xpath(configprop.getProperty("cuscode"));
    By cusemail=By.xpath(configprop.getProperty("cusemail"));
    By cusphone=By.xpath(configprop.getProperty("cusphone"));
    By cuscity=By.xpath(configprop.getProperty("cuscity"));
    By cusstate=By.xpath(configprop.getProperty("cusstate"));
    By cuspostalcode=By.xpath(configprop.getProperty("cuspostalcode"));
    By cusAddress=By.xpath(configprop.getProperty("cusAddress"));
    By cusContactperson=By.xpath(configprop.getProperty("cusContactperson"));
    By customersubmitbutton=By.xpath(configprop.getProperty("customersubmitbutton"));
    By successOkconfirmbuttonn=By.xpath(configprop.getProperty("successOkconfirmbuttonn"));
    By successtext=By.xpath(configprop.getProperty("successtext"));
    //Error message xpath
    By ErrorMessage=By.xpath(configprop.getProperty("ErrorMessage"));

    //Customer Location
    By CustomerStorageLocation=By.xpath(configprop.getProperty("CustomerStorageLocation"));
    By SelectCustomerDropDown=By.xpath(configprop.getProperty("SelectCustomerDropDown"));
    By SelectCustomerSite=By.xpath(configprop.getProperty("SelectCustomerSite"));
    By CustomerSitesLocation_Button=By.xpath(configprop.getProperty("CustomerSitesLocation_Button"));
    By txtBoxLocationName=By.xpath(configprop.getProperty("txtBoxLocationName"));
    By SuccessMsgPopUp=By.xpath(configprop.getProperty("SuccessMsgPopUp"));

    By Customer_TableHeader=By.xpath(configprop.getProperty("Customer_TableHeader"));
    public void sharepointEmail(String email) {



        try {
            WebElement SharePointEmail = waithelper.WaitForElement1(Email, 10);
            SharePointEmail.click();
            SharePointEmail.clear();
            SharePointEmail.sendKeys(email);
        }  catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }





    }

    public void sharepointEmailnextButton( ) {


        try {
            WebElement SharePointEmailNextButton = waithelper.WaitForElement1(nextButton, 10);
            SharePointEmailNextButton.click();
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }



    }

    public void sharepointpassword(String pwd) {



        try {
            WebElement SharePointPassword = waithelper.WaitForElement1(password, 10);
            SharePointPassword.click();
            SharePointPassword.clear();
            SharePointPassword.sendKeys(pwd);
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }



    }

    public void sharepointSigninButton( ) {

        try {
            WebElement AccountSigninButton = waithelper.WaitForElement1(signinButton, 10);
            AccountSigninButton.click();
            WebElement confirmMessage=waithelper.WaitForElement1(ConfirmButton,10);
            confirmMessage.click();
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }


    }






//    public void sharepointmasterDataSidemenu() {
//        try {
//            WebElement mastersidemenu = waithelper.WaitForElement1(masterdatasidemenu, 10);
//
//            // First try regular click
//            try {
//                mastersidemenu.click();
//            } catch (Exception e) {
//                // If regular click fails, use JavaScript click as fallback
//                System.out.println("Regular click failed, attempting JavaScript click...");
//                JavascriptExecutor js = (JavascriptExecutor) ldriver;
//                js.executeScript("arguments[0].click();", mastersidemenu);
//            }
//
//        } catch (Exception e) {
//            System.out.println("Unexpected error: " + e.getMessage());
//            // You might want to add screenshot capture here for debugging
//        }
//    }
public void sharepointmasterDataSidemenu() {
    try {
        WebElement masterSideMenu = waithelper.WaitForElement1(masterdatasidemenu, 10);

        // Attempt regular click first
        try {
            masterSideMenu.click();
            System.out.println("Successfully clicked using regular click");
            return; // Exit early if successful
        } catch (ElementNotInteractableException e) {
            System.out.println("Regular click intercepted, attempting JavaScript click...");
        } catch (StaleElementReferenceException e) {
            System.out.println("Element became stale, re-locating and retrying...");
            masterSideMenu =waithelper.WaitForElement1(masterdatasidemenu, 5);
        }

        // JavaScript click as fallback
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", masterSideMenu);
            System.out.println("Successfully clicked using JavaScript");
        } catch (StaleElementReferenceException e) {
            System.out.println("Element stale during JS click, re-locating...");
            masterSideMenu = waithelper.WaitForElement1(masterdatasidemenu, 5);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", masterSideMenu);
        }

    } catch (TimeoutException e) {
        System.out.println("Element not found within timeout: " + e.getMessage());
        // Consider taking screenshot here
    }
}



    public void sharepointcustomermasterdata( ) {

        try {
            WebElement customermenu = waithelper.WaitForElement1(customermasterdata, 10);
            customermenu.click();
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }

    public void sharepointAddMasterDataButton( ) {
       //here we are clicking the '+' icon for adding the master data
        try {
            WebElement AddMasterButton = waithelper.WaitForElement1(AddMasterDataButton, 20);
            AddMasterButton.click();
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }

    public void sharepointcustomeroption( ) {
        //here we are clicking the '+' icon for adding the master data
        try {
            WebElement customerselection = waithelper.WaitForElement1(customeroption, 10);
            customerselection.click();
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }

    public void sharepointcustomerMasterDataRequiredField( ) {
        //here we are clicking the '+' icon for adding the master data
        try {
            WebElement nameofCustomer = waithelper.WaitForElement1(cusname, 10);
            nameofCustomer.click();
            nameofCustomer.clear();
            nameofCustomer.sendKeys(randomString());

            WebElement customerprojectnumber = waithelper.WaitForElement1(cusprojectnumber, 10);
            customerprojectnumber.click();
            customerprojectnumber.clear();
            customerprojectnumber.sendKeys(randomNumber());


            WebElement customerCode = waithelper.WaitForElement1(cuscode, 10);
            customerCode.click();
            customerCode.clear();
            customerCode.sendKeys(randomNumber());


            WebElement customeremail = waithelper.WaitForElement1(cusemail, 10);
            customeremail.click();
            customeremail.clear();
            customeremail.sendKeys(randomString()+"@gmail.com");


            WebElement customerphonenumber = waithelper.WaitForElement1(cusphone, 10);
            customerphonenumber.click();
            customerphonenumber.clear();
            customerphonenumber.sendKeys(randomNumber());


            WebElement customercity = waithelper.WaitForElement1(cuscity, 10);
            customercity.click();
            customercity.clear();
            customercity.sendKeys(randomString());



            WebElement customerstate = waithelper.WaitForElement1(cusstate, 10);
            customerstate.click();
            customerstate.clear();
            customerstate.sendKeys(randomString());



            WebElement customerpostalcode = waithelper.WaitForElement1(cuspostalcode, 10);
            customerpostalcode.click();
            customerpostalcode.clear();
            customerpostalcode.sendKeys(randomNumber());




            WebElement customerAddress = waithelper.WaitForElement1(cusAddress, 10);
            customerAddress.click();
            customerAddress.clear();
            customerAddress.sendKeys(randomString()+ " "+ randomString()+ " "+ randomString()+ " "+ randomString()+ " "+ randomString()+ " "+ randomString()+ " "+ randomString()+ " "+ randomString()+ " "+ randomString()+ " "+ randomString());



            WebElement customerContactperson = waithelper.WaitForElement1(cusContactperson, 10);
            customerContactperson.click();
            customerContactperson.clear();
            customerContactperson.sendKeys(randomString());

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }


    public void sharepointcustomersubmitform( ) {
        //here we are clicking the '+' icon for adding the master data
        try {
            WebElement customersubmitform = waithelper.WaitForElement1(customersubmitbutton, 10);
            customersubmitform.click();
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }


    public void sharepointSuccessConfirmOKButton( ) {
        //here we are clicking the '+' icon for adding the master data
        try {


            WebElement successtextmessage = waithelper.WaitForElement1(successtext, 10);
            String successmsg=successtextmessage.getText();
            System.out.println(successmsg);

                    if(successmsg.equalsIgnoreCase(configprop.getProperty("message"))){
                   Assert.assertTrue(true);
                    }else{
                        Assert.fail();
                    }

            WebElement SuccessConfirmButton = waithelper.WaitForElement1(successOkconfirmbuttonn, 10);
            SuccessConfirmButton.click();
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }


// for Identifying The Error Messages
    public void sharepointcustomerErrorMessage() {
        try {
            // Wait for error messages to appear (using visibility check)
            WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ErrorMessage));

            // Find all error message elements
            List<WebElement> errorMessages = ldriver.findElements(ErrorMessage);
            int count = 0;

            // Count and print each error message
            System.out.println("Validation Errors Found:");
            for (WebElement error : errorMessages) {
                count++;
                System.out.println(count + ") " + error.getText());

                // Additional validation - ensure error is actually displayed
                if (!error.isDisplayed()) {
                    Assert.fail("Error message is present but not visible: " + error.getText());
                }
            }

            // Assert the expected count (10 in this case)
            int expectedErrorCount = 10;
            if (count == expectedErrorCount) {
                System.out.println("Test Passed: Found exactly " + expectedErrorCount + " error messages");
                Assert.assertTrue(true);
            } else {
                System.out.println("Test Failed: Expected " + expectedErrorCount +
                        " errors but found " + count);
                Assert.fail("Expected " + expectedErrorCount +
                        " validation errors but found " + count);
            }

        } catch (TimeoutException e) {
            System.out.println("Timeout waiting for error messages: " + e.getMessage());
            Assert.fail("Error messages did not appear within timeout period");
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
            Assert.fail("Unexpected error occurred while checking error messages");
        }
    }

   // Customer Location


    public void sharepointCustomerLocationOption() {
        // Maximum retry attempts for stale element
        final int MAX_RETRIES = 3;
        int attempts = 0;

        while (attempts < MAX_RETRIES) {
            try {
                // Wait for and locate the element fresh each time
                WebElement customersStorageLocation = waithelper.WaitForElement1(CustomerStorageLocation, 10);

                // Verify element is visible and enabled
                if (customersStorageLocation.isDisplayed() && customersStorageLocation.isEnabled()) {
                    try {
                        customersStorageLocation.click();
                        // If click succeeds, log and return
                        System.out.println("Successfully clicked Customer Storage Location option");
                        return;
                    } catch (StaleElementReferenceException e) {
                        System.out.println("Stale element encountered on attempt " + (attempts + 1));
                        attempts++;
                        continue; // Retry
                    }
                } else {
                    Assert.fail("Customer Storage Location Option is not available or not interactable");
                }
            } catch (NoSuchElementException e) {
                Assert.fail("Customer Storage Location element not found: " + e.getMessage());
            } catch (TimeoutException e) {
                Assert.fail("Timed out waiting for Customer Storage Location element: " + e.getMessage());
            } catch (Exception e) {
                Assert.fail("Unexpected error: " + e.getMessage());
            }
            attempts++;
        }

        // If we exhausted all retries
        Assert.fail("Failed to click Customer Storage Location option after " + MAX_RETRIES + " attempts");
    }


    public void sharepointCustomersDropDown() {
        try {
            // Wait for the dropdown element to be visible and interactable
            WebElement selectCustomersDropDown = waithelper.WaitForElement1(SelectCustomerDropDown, 10);
            selectCustomersDropDown.click();

            // Wait for the dropdown to appear and be clickable
            Thread.sleep(1000);

            // Create a Select object to interact with the dropdown
            Select select = new Select(selectCustomersDropDown);

            // Check if the option exists before trying to select it
            boolean optionFound = false;
            for (WebElement option : select.getOptions()) {
                if (option.getText().equals("aaaa")) {
                    select.selectByVisibleText("aaaa");
                    optionFound = true;

                    closeDropdown();
                    break;

                }
            }

            // If the option is not found, handle the situation (e.g., log a message or select default)
            if (!optionFound) {
                System.out.println("Option 'Example Customer' not found. Selecting a default option.");
                select.selectByIndex(0);  // Select the first option (e.g., "-- Select Customer --")
                closeDropdown();
            }
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }



    public void sharepointSiteDropDown() {
        try {
            // Wait for the dropdown element to be visible and interactable
            WebElement SelectCustomersSite = waithelper.WaitForElement1(SelectCustomerSite, 10);
            SelectCustomersSite.click();

            // Wait for the dropdown to appear and be clickable
            Thread.sleep(1000);

            // Create a Select object to interact with the dropdown
            Select select = new Select(SelectCustomersSite);

            // Check if the option exists before trying to select it
            boolean optionFound = false;
            for (WebElement option : select.getOptions()) {
                if (option.getText().equals("Kormangalaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")) {
                    select.selectByVisibleText("Kormangalaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                    optionFound = true;

                    closeDropdown();
                    break;

                }
            }

            // If the option is not found, handle the situation (e.g., log a message or select default)
            if (!optionFound) {
                System.out.println("Option 'Example Customer' not found. Selecting a default option.");
                select.selectByIndex(0);  // Select the first option (e.g., "-- Select Customer --")
                closeDropdown();
            }
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }



    public void sharepointCustomerSitesLocationButton( ) {
        //checking for The LocatinAdd button
        try {
            WebElement CustomersSitesLocation_Button = waithelper.WaitForElement1(CustomerSitesLocation_Button, 20);

            if(CustomersSitesLocation_Button.isDisplayed() && CustomersSitesLocation_Button.isEnabled()){
                CustomersSitesLocation_Button.click();
            }
            else {
                System.out.println("Location Add Button Is Not Available");
            }

            WebElement txtBoxLocationsName = waithelper.WaitForElement1(txtBoxLocationName, 10);
            txtBoxLocationsName.click();
            txtBoxLocationsName.clear();
            txtBoxLocationsName.sendKeys(" # "+randomNumber()+" "+randomString());

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }



    public void sharepointCustomerStorageLocationSuccessMsgPopUp() {
        try {
            // Wait for initial loading message (with stale element handling)
            WebElement successMsgPopup = waitForElementWithStaleRetry(SuccessMsgPopUp, 20);
            String initialMessage = successMsgPopup.getText();
            System.out.println(initialMessage);
            Assert.assertEquals("Initial message mismatch", "Please wait...", initialMessage.trim());

            // Wait for message to change (with stale element handling)
            WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));
            successMsgPopup = wait.until(driver -> {
                try {
                    WebElement element = driver.findElement(SuccessMsgPopUp);
                    return !element.getText().equals("Please wait...") ? element : null;
                } catch (StaleElementReferenceException e) {
                    return null; // Will cause the wait to retry
                }
            });

            // Verify final message
            String finalMessage = successMsgPopup.getText();
            System.out.println(finalMessage);
            Assert.assertEquals("Final success message mismatch",
                    "1 locations saved successfully",
                    finalMessage.trim());

            // Handle OK button with stale element protection
            WebElement successOkButton = waitForElementWithStaleRetry(successOkconfirmbuttonn, 20);
            Assert.assertTrue("Success OK button not displayed", successOkButton.isDisplayed());
            Assert.assertTrue("Success OK button not enabled", successOkButton.isEnabled());
            successOkButton.click();

        } catch (Exception e) {
            Assert.fail("Error in success message popup: " + e.getMessage());
        }
    }


    public void sharepointcustomerGetTableList( ) {

        try {
            WebElement customersubmitform = waithelper.WaitForElement1(customersubmitbutton, 10);

            WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Customer_TableHeader));

            List<WebElement> HeaderList = ldriver.findElements(Customer_TableHeader);

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }
//    public void sharepointCustomerStorageLocationSuccessMsgPopUp( ) {
//        //checking for The LocatinAdd button
//        try {
//            WebElement SuccessMsgPopUps = waithelper.WaitForElement1(SuccessMsgPopUp, 20);
//
//          String AddedLocationSuccessMsg=  SuccessMsgPopUps.getText();
//          System.out.println(AddedLocationSuccessMsg);
//
//          if(AddedLocationSuccessMsg.equalsIgnoreCase("Please wait...")){
//              Assert.assertTrue(true);
//          }
//          else{
//              Assert.fail("Unxepected Success Message Displyed For The Adding Of The Site Location");
//          }
//
//
//           String finalMsg= SuccessMsgPopUps.getText();
//            if(finalMsg.equalsIgnoreCase("1 locations saved successfully")){
//                Assert.assertTrue(true);
//            }
//            else{
//                Assert.fail("Unxepected Success Message Displyed For The Adding Of The Site Location");
//            }
//
//            WebElement succesOkconfirmbuttonn = waithelper.WaitForElement1(successOkconfirmbuttonn, 20);
//
//            if(succesOkconfirmbuttonn.isDisplayed() && succesOkconfirmbuttonn.isEnabled()){
//                succesOkconfirmbuttonn.click();
//                Assert.assertTrue(true);
//            }
//            else{
//                Assert.fail("Button Not Displayed or Enbled");
//            }
//
//        } catch (Exception e) {
//            System.out.println("Unexpected error: " + e.getMessage());
//        }
//
//    }


































}
