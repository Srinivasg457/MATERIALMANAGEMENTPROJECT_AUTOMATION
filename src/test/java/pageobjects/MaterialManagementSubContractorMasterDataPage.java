package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinations.BaseClass;
import utilities.WaitHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import static stepDefinations.BaseClass.randomNumber;
import static stepDefinations.BaseClass.randomString;

public class MaterialManagementSubContractorMasterDataPage extends BaseClass {

    public WebDriver ldriver;
    WaitHelper waithelper;

    public static Properties configprop;

    //constructor
    public MaterialManagementSubContractorMasterDataPage(WebDriver rdriver) throws IOException {
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
    By SubContractorsMenu = By.xpath(configprop.getProperty("SubContractorsMenu"));
    By SubContractorAddButton = By.xpath(configprop.getProperty("SubContractorAddButton"));
    By SubContractorOption = By.xpath(configprop.getProperty("SubContractorOption"));
    By txtBoxSubcontractorName = By.xpath(configprop.getProperty("txtBoxSubcontractorName"));
    By txtBoxSubcontractorCode = By.xpath(configprop.getProperty("txtBoxSubcontractorCode"));
    By txtBoxSubContractorProjectNumber=By.xpath(configprop.getProperty("txtBoxSubContractorProjectNumber"));
    By txtBoxSubcontractorPONumber=By.xpath(configprop.getProperty("txtBoxSubcontractorPONumber"));
    By txtBoxSubcontractorEmail=By.xpath(configprop.getProperty("txtBoxSubcontractorEmail"));
    By txtBoxSubcontractorPhoneNumber=By.xpath(configprop.getProperty("txtBoxSubcontractorPhoneNumber"));
    By txtBoxSubcontractorCity=By.xpath(configprop.getProperty("txtBoxSubcontractorCity"));
    By txtBoxSubcontractorState=By.xpath(configprop.getProperty("txtBoxSubcontractorState"));
    By txtBoxSubcontractorPostalCode=By.xpath(configprop.getProperty("txtBoxSubcontractorPostalCode"));
    By txtBoxSubcontractorContactPerson=By.xpath(configprop.getProperty("txtBoxSubcontractorContactPerson"));
    By txtBoxSubcontractorAddress=By.xpath(configprop.getProperty("txtBoxSubcontractorAddress"));
    //Reusability of The save Button Dont Get Confused On the Name As Customer Submit Button
    By submitbutton=By.xpath(configprop.getProperty("customersubmitbutton"));
    By successtext=By.xpath(configprop.getProperty("successtext"));
    By successOkconfirmbuttonn=By.xpath(configprop.getProperty("successOkconfirmbuttonn"));
    //Error message xpath
    By ErrorMessage=By.xpath(configprop.getProperty("ErrorMessage"));
    //Actions Method
    // Here we click on the share point sub menu
    public void sharepointSubcontractorsSideMenu( ) {

        try {
            WebElement SubContractorMenu = waithelper.WaitForElement1(SubContractorsMenu, 10);
            SubContractorMenu.click();
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }


    // Here we click on The "+" icon
    public void sharepointSubcontractorsAddIcon( ) {

        try {
            WebElement SubContractorsAddButton = waithelper.WaitForElement1(SubContractorAddButton, 10);
            SubContractorsAddButton.click();
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }



    // here we Click on the Material Option
    public void sharepointDrpSubcontractorsOption( ) {

        try {
            WebElement SubContractorsOption = waithelper.WaitForElement1(SubContractorOption, 10);
            SubContractorsOption.click();
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }

    //Here We Click on The Required Fields and Send The Data
    public void sharepointSubcontractorsMasterDataRequiredField( ) {

        try {
            WebElement txtBoxSubcontractorsName = waithelper.WaitForElement1(txtBoxSubcontractorName, 10);
            txtBoxSubcontractorsName.click();
            txtBoxSubcontractorsName.clear();
            txtBoxSubcontractorsName.sendKeys(randomString());

            WebElement txtBoxSubcontractorsCode = waithelper.WaitForElement1(txtBoxSubcontractorCode, 10);
            txtBoxSubcontractorsCode.click();
            txtBoxSubcontractorsCode.clear();
            txtBoxSubcontractorsCode.sendKeys(randomNumber());

            WebElement txtBoxSubContractorsProjectNumber = waithelper.WaitForElement1(txtBoxSubContractorProjectNumber, 10);
            txtBoxSubContractorsProjectNumber.click();
            txtBoxSubContractorsProjectNumber.clear();
            txtBoxSubContractorsProjectNumber.sendKeys(randomNumber());

            WebElement txtBoxSubcontractorsPONumber = waithelper.WaitForElement1(txtBoxSubcontractorPONumber, 10);
            txtBoxSubcontractorsPONumber.click();
            txtBoxSubcontractorsPONumber.clear();
            txtBoxSubcontractorsPONumber.sendKeys(randomNumber());


            WebElement txtBoxSubcontractorsEmail = waithelper.WaitForElement1(txtBoxSubcontractorEmail, 10);
            txtBoxSubcontractorsEmail.click();
            txtBoxSubcontractorsEmail.clear();
            txtBoxSubcontractorsEmail.sendKeys(randomString()+randomNumber()+"@gmail.com");


            WebElement txtBoxSubcontractorsPhoneNumber = waithelper.WaitForElement1(txtBoxSubcontractorPhoneNumber, 10);
            txtBoxSubcontractorsPhoneNumber.click();
            txtBoxSubcontractorsPhoneNumber.clear();
            txtBoxSubcontractorsPhoneNumber.sendKeys(randomNumber());

            WebElement txtBoxSubcontractorsCity = waithelper.WaitForElement1(txtBoxSubcontractorCity, 10);
            txtBoxSubcontractorsCity.click();
            txtBoxSubcontractorsCity.clear();
            txtBoxSubcontractorsCity.sendKeys(randomString());

            WebElement txtBoxSubcontractorsState = waithelper.WaitForElement1(txtBoxSubcontractorState, 10);
            txtBoxSubcontractorsState.click();
            txtBoxSubcontractorsState.clear();
            txtBoxSubcontractorsState.sendKeys(randomString());

            WebElement txtBoxSubcontractorsPostalCode = waithelper.WaitForElement1(txtBoxSubcontractorPostalCode, 10);
            txtBoxSubcontractorsPostalCode.click();
            txtBoxSubcontractorsPostalCode.clear();
            txtBoxSubcontractorsPostalCode.sendKeys(randomNumber());

            WebElement txtBoxSubcontractorsContactPerson = waithelper.WaitForElement1(txtBoxSubcontractorContactPerson, 10);
            txtBoxSubcontractorsContactPerson.click();
            txtBoxSubcontractorsContactPerson.clear();
            txtBoxSubcontractorsContactPerson.sendKeys(randomString());

            WebElement txtBoxSubcontractorsAddress = waithelper.WaitForElement1(txtBoxSubcontractorAddress, 10);
            txtBoxSubcontractorsAddress.click();
            txtBoxSubcontractorsAddress.clear();
            txtBoxSubcontractorsAddress.sendKeys("#"+randomNumber()+randomString()+" "+randomString()+randomString()+" "+randomString()+randomString()+" "+randomString()+randomString()+" "+randomString()+randomString()+" "+randomString()+randomString()+" "+randomString());



        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }





    public void sharepointSubContractorSubmitBtn() {
        try {
            // Wait for the submit button to be visible and enabled within 10 seconds
            WebElement submitBtn = waithelper.WaitForElement1(submitbutton, 10);

            // Check if the button is displayed and enabled before clicking
            if (submitBtn.isDisplayed() && submitBtn.isEnabled()) {
                submitBtn.click();
                logger.info("Submit button clicked successfully.");
            } else {
                String errorMessage = "Submit button is either not displayed or not enabled.";
                logger.error(errorMessage);
                Assert.fail(errorMessage);
            }

        } catch (Exception e) {
            // Log the unexpected error with stack trace
            logger.error("Unexpected error occurred while clicking the submit button: " + e.getMessage(), e);
            Assert.fail("Test failed due to unexpected error: " + e.getMessage());
        }
    }

    public void sharepointSupplierSuccessBtnConfirmation( ) {


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
    public void sharepointSubcontractorErrorMessage() {
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

            // Assert the expected count (2 in this case)
            int expectedErrorCount = 11;
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




}
