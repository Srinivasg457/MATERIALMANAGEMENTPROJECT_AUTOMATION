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

public class MaterialManagementMateialModulePage extends BaseClass {

    public WebDriver ldriver;
    WaitHelper waithelper;

    public static Properties configprop;

    //constructor
    public MaterialManagementMateialModulePage(WebDriver rdriver) throws IOException {
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
    By materialsmenu = By.xpath(configprop.getProperty("materialsmenu"));
    By AddMaterialMasterDataButton = By.xpath(configprop.getProperty("AddMaterialMasterDataButton"));
    By materialsoption = By.xpath(configprop.getProperty("materialsoption"));
    By textboxMaterialNumber = By.xpath(configprop.getProperty("textbox_MaterialNumber"));
    By textBoxMatrialDescription = By.xpath(configprop.getProperty("textBox_MatrialDescription"));
    //Reusability of The save Button Dont Get Confused On the Name As Customer Submit Button
    By submitbutton=By.xpath(configprop.getProperty("customersubmitbutton"));
    By successtext=By.xpath(configprop.getProperty("successtext"));
    By successOkconfirmbuttonn=By.xpath(configprop.getProperty("successOkconfirmbuttonn"));
    //Error message xpath
    By ErrorMessage=By.xpath(configprop.getProperty("ErrorMessage"));
    By materials_List=By.cssSelector(configprop.getProperty("MaterialList"));
    By MaterialTable_Data=By.tagName(configprop.getProperty("CustomerTableData"));
    //Actions Method
    // Here we click on the share point sub menu
    public void sharepointMaterialSideMenu( ) {

        try {
            WebElement materialsubMenu = waithelper.WaitForElement1(materialsmenu, 10);
            materialsubMenu.click();
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }


    // Here we click on The "+" icon
    public void sharepointMaterialSAddIcon( ) {

        try {
            WebElement Addicon = waithelper.WaitForElement1(AddMaterialMasterDataButton, 10);
            Addicon.click();
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }



// here we Click on the Material Option
    public void sharepointDrpMaterialOption( ) {

        try {
            WebElement materialoption = waithelper.WaitForElement1(materialsoption, 10);
            materialoption.click();
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }

    //Here We Click on The Required Fields and Send The Data
    public void sharepointMaterialMasterDataRequiredField( ) {

        try {
            WebElement textMaterialNumber = waithelper.WaitForElement1(textboxMaterialNumber, 10);
            textMaterialNumber.click();
            textMaterialNumber.clear();
            textMaterialNumber.sendKeys(randomNumber());

            WebElement textMatrialDescription = waithelper.WaitForElement1(textBoxMatrialDescription, 10);
            textMatrialDescription.click();
            textMatrialDescription.clear();
            textMatrialDescription.sendKeys(randomNumber());


        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }





    public void sharepointMaterialSubmitBtn() {
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

    public void sharepointMaterialSuccessBtnConfirmation( ) {

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
    public void sharepointMaterialErrorMessage() {
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
            int expectedErrorCount = 2;
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





    //To print The List of materials
    public void sharepointmaterialsGetTableList() {
        try {
            int currentPage = 1;
            int totalPages = getTotalMaterialmasterDataPages(); // This method needs to be implemented
            int totalMaterials = 0;

            System.out.println("=== MATERIALS LIST (ALL PAGES) ===");
            System.out.println("Total pages to process: " + totalPages);
            System.out.println();

            do {
                System.out.println("--- PAGE " + currentPage + " ---");

                // Wait for table to load using explicit wait
                ldriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

                List<WebElement> rows = ldriver.findElements(materials_List);

                if (rows.isEmpty()) {
                    System.out.println("NO Materials found on page " + currentPage);
                } else {
                    // Print table header for each page
                    System.out.println("┌──────────────────────┬──────────────────────┬──────────────────────┬──────────────────────────────┐");
                    System.out.println("│ Material Number      │ Abb Project Number   │ HSN Number           │ Material Description         │");
                    System.out.println("├──────────────────────┼──────────────────────┼──────────────────────┼──────────────────────────────┤");


                    // Print rows for current page
                    for (WebElement row : rows) {
                        List<WebElement> cells = row.findElements(MaterialTable_Data);



                        if (cells.size() >= 4) {
                            String MaterialNumber = formatCellmaterials(cells.get(0).getText(), 20);
                            String AbbProjectNumber = formatCellmaterials(cells.get(1).getText(), 20);
                            String HSNNumber = formatCellmaterials(cells.get(2).getText(), 20);
                            String MaterialDescription = formatCellmaterials(cells.get(3).getText(), 28);

                            System.out.println("│ " + MaterialNumber + " │ " + AbbProjectNumber + " │ " + HSNNumber + " │ " + MaterialDescription + " │");

                        }
                    }
                    // Print footer for current page
                    System.out.println("└──────────────────────┴──────────────────────┴──────────────────────┴──────────────────────────────┘");
                    System.out.println("Page " + currentPage + ": " + rows.size() + " Materials");

                    totalMaterials += rows.size();
                }

                System.out.println();

                // Move to next page if available
                if (currentPage < totalPages) {
                    materialsnavigateToNextPage(); // This method needs to be implemented
                    currentPage++;
                    // Add a small delay for page load
                    Thread.sleep(2000);
                } else {
                    break; // Exit loop when we reach the last page
                }

            } while (currentPage <= totalPages);

            // Print final summary
            System.out.println("==========================================");
            System.out.println("TOTAL MATERIALS ACROSS ALL PAGES: " + totalMaterials);
            System.out.println("==========================================");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }





}
