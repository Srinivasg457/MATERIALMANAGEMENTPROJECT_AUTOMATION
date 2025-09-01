package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MaterialManagementSupplierMasterDataPage extends BaseClass {

    public WebDriver ldriver;
    WaitHelper waithelper;

    public static Properties configprop;

    //constructor
    public MaterialManagementSupplierMasterDataPage(WebDriver rdriver) throws IOException {
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
    By SuppliersSideMenu = By.xpath(configprop.getProperty("SuppliersSideMenu"));
    By SupplierAddButton = By.xpath(configprop.getProperty("SupplierAddButton"));
    By Supplieroption = By.xpath(configprop.getProperty("Supplieroption"));
    By txtBoxSupplierName = By.xpath(configprop.getProperty("txtBoxSupplierName"));
    By txtBoxSupplierCode = By.xpath(configprop.getProperty("txtBoxSupplierCode"));
    By txtBoxAbbProjectNumber=By.xpath(configprop.getProperty("txtBoxAbbProjectNumber"));
    By txtBoxVendoePoNumber=By.xpath(configprop.getProperty("txtBoxVendoePoNumber"));
    By txtBoxSupplierEmail=By.xpath(configprop.getProperty("txtBoxSupplierEmail"));
    By txtBoxSupplierPhoneNumber=By.xpath(configprop.getProperty("txtBoxSupplierPhoneNumber"));
    By txtBoxSupplierCity=By.xpath(configprop.getProperty("txtBoxSupplierCity"));
    By txtBoxSupplierState=By.xpath(configprop.getProperty("txtBoxSupplierState"));
    By txtBoxSupplierPostalCode=By.xpath(configprop.getProperty("txtBoxSupplierPostalCode"));
    By txtBoxSupplierContactPerson=By.xpath(configprop.getProperty("txtBoxSupplierContactPerson"));
    By TxtAreaBoxSupplierAddress=By.xpath(configprop.getProperty("TxtAreaBoxSupplierAddress"));
    //Reusability of The save Button Dont Get Confused On the Name As Customer Submit Button
    By submitbutton=By.xpath(configprop.getProperty("customersubmitbutton"));
    By successtext=By.xpath(configprop.getProperty("successtext"));
    By successOkconfirmbuttonn=By.xpath(configprop.getProperty("successOkconfirmbuttonn"));
    //Error message xpath
    By ErrorMessage=By.xpath(configprop.getProperty("ErrorMessage"));

    By Supplier_List=By.cssSelector(configprop.getProperty("SupplierList"));
    By Supplier_Data=By.tagName(configprop.getProperty("CustomerTableData"));

    //Actions Method
    // Here we click on the share point sub menu
    public void sharepointSuppliersSideMenu( ) {

        try {
            WebElement SupplierSideMenu = waithelper.WaitForElement1(SuppliersSideMenu, 10);
            SupplierSideMenu.click();
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }


    // Here we click on The "+" icon
    public void sharepointSuppliersAddIcon( ) {

        try {
            WebElement SuppliersAddButton = waithelper.WaitForElement1(SupplierAddButton, 10);
            SuppliersAddButton.click();
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }



    // here we Click on the Material Option
    public void sharepointDrpSuppliersOption( ) {

        try {
            WebElement Suppliersoption = waithelper.WaitForElement1(Supplieroption, 10);
            Suppliersoption.click();
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }

    //Here We Click on The Required Fields and Send The Data
    public void sharepointSupplierMasterDataRequiredField( ) {

        try {
            WebElement txtBoxSuppliersName = waithelper.WaitForElement1(txtBoxSupplierName, 10);
            txtBoxSuppliersName.click();
            txtBoxSuppliersName.clear();
            txtBoxSuppliersName.sendKeys(randomString());

            WebElement txtBoxSuppliersCode = waithelper.WaitForElement1(txtBoxSupplierCode, 10);
            txtBoxSuppliersCode.click();
            txtBoxSuppliersCode.clear();
            txtBoxSuppliersCode.sendKeys(randomNumber());

            WebElement txtBoxAbbsProjectNumber = waithelper.WaitForElement1(txtBoxAbbProjectNumber, 10);
            txtBoxAbbsProjectNumber.click();
            txtBoxAbbsProjectNumber.clear();
            txtBoxAbbsProjectNumber.sendKeys(randomNumber());

            WebElement txtBoxVendoesPoNumber = waithelper.WaitForElement1(txtBoxVendoePoNumber, 10);
            txtBoxVendoesPoNumber.click();
            txtBoxVendoesPoNumber.clear();
            txtBoxVendoesPoNumber.sendKeys(randomNumber());


            WebElement txtBoxSuppliersEmail = waithelper.WaitForElement1(txtBoxSupplierEmail, 10);
            txtBoxSuppliersEmail.click();
            txtBoxSuppliersEmail.clear();
            txtBoxSuppliersEmail.sendKeys(randomString()+randomNumber()+"@gmail.com");


            WebElement txtBoxSuppliersPhoneNumber = waithelper.WaitForElement1(txtBoxSupplierPhoneNumber, 10);
            txtBoxSuppliersPhoneNumber.click();
            txtBoxSuppliersPhoneNumber.clear();
            txtBoxSuppliersPhoneNumber.sendKeys(randomNumber());

            WebElement txtBoxSuppliersCity = waithelper.WaitForElement1(txtBoxSupplierCity, 10);
            txtBoxSuppliersCity.click();
            txtBoxSuppliersCity.clear();
            txtBoxSuppliersCity.sendKeys(randomString());

            WebElement txtBoxSuppliersState = waithelper.WaitForElement1(txtBoxSupplierState, 10);
            txtBoxSuppliersState.click();
            txtBoxSuppliersState.clear();
            txtBoxSuppliersState.sendKeys(randomString());

            WebElement txtBoxSuppliersPostalCode = waithelper.WaitForElement1(txtBoxSupplierPostalCode, 10);
            txtBoxSuppliersPostalCode.click();
            txtBoxSuppliersPostalCode.clear();
            txtBoxSuppliersPostalCode.sendKeys(randomNumber());

            WebElement txtBoxSuppliersContactPerson = waithelper.WaitForElement1(txtBoxSupplierContactPerson, 10);
            txtBoxSuppliersContactPerson.click();
            txtBoxSuppliersContactPerson.clear();
            txtBoxSuppliersContactPerson.sendKeys(randomString());

            WebElement TxtAreaBoxSuppliersAddress = waithelper.WaitForElement1(TxtAreaBoxSupplierAddress, 10);
            TxtAreaBoxSuppliersAddress.click();
            TxtAreaBoxSuppliersAddress.clear();
            TxtAreaBoxSuppliersAddress.sendKeys("#"+randomNumber()+randomString()+" "+randomString()+randomString()+" "+randomString()+randomString()+" "+randomString()+randomString()+" "+randomString()+randomString()+" "+randomString()+randomString()+" "+randomString());



        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }





    public void sharepointsuppliersSubmitBtn() {
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
    public void sharepointSupplierErrorMessage() {
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


    //To Get The List Of The Supplier Master Data From The List


    public void sharepointSupplierGetTableList() {
        try {
            int currentPage = 1;
            int totalPages = getTotalSuppliermasterDataPages();
            int totalSuppliers = 0;

            System.out.println("=== Suppliers LIST (ALL PAGES) ===");
            System.out.println("Total pages to process: " + totalPages);
            System.out.println();

            do {
                System.out.println("--- PAGE " + currentPage + " ---");

                // Wait for table to load
                ldriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

                List<WebElement> rows = ldriver.findElements(Supplier_List);

                if (rows.isEmpty()) {
                    System.out.println("No Suppliers found on page " + currentPage);
                } else {
                    // Print table header for each page
                    System.out.println("┌──────────────────────┬──────────────────────┬──────────────────────┬──────────────────────────────┐");
                    System.out.println("│ Vendor Code          │ Supplier Name        │ Abb Project Number   │ Contact person               │");
                    System.out.println("├──────────────────────┼──────────────────────┼──────────────────────┼──────────────────────────────┤");

                    // Print rows for current page
                    for (WebElement row : rows) {
                        List<WebElement> cells = row.findElements(Supplier_Data);



                        if (cells.size() >= 4) {
                            String VendorCode = formatCell(cells.get(0).getText(), 20);
                            String SupplierName   = formatCell(cells.get(1).getText(), 20);
                            String AbbProjectNumber  = formatCell(cells.get(2).getText(), 20);
                            String Contactperson  = formatCell(cells.get(3).getText(), 28);

                            System.out.println("│ " + VendorCode + " │ " + SupplierName + " │ " + AbbProjectNumber + " │ " + Contactperson + " │");
                        }
                    }

                    // Print footer for current page
                    System.out.println("└──────────────────────┴──────────────────────┴──────────────────────┴──────────────────────────────┘");
                    System.out.println("Page " + currentPage + ": " + rows.size() + " Subcontractors");

                    totalSuppliers += rows.size();
                }

                System.out.println();

                // Move to next page if available
                if (currentPage < totalPages) {
                    SuppliernavigateToNextPage();
                    currentPage++;
                } else {
                    break; // Exit loop when we reach the last page
                }

            } while (currentPage <= totalPages);

            // Print final summary
            System.out.println("==========================================");
            System.out.println("TOTAL SubContractors ACROSS ALL PAGES: " + totalSuppliers);
            System.out.println("==========================================");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }



}
