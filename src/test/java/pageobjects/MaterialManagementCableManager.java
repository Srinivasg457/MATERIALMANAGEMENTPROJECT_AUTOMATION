package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinations.BaseClass;
import utilities.ExcelUtil;
import utilities.WaitHelper;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class MaterialManagementCableManager extends BaseClass {
    public WebDriver ldriver;
    WaitHelper waithelper;

    public static Properties configprop;

    //constructor
    public MaterialManagementCableManager(WebDriver rdriver) throws IOException {
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
    By cablemanager_SideMenu = By.xpath(configprop.getProperty("cablemanagerSideMenu"));
    By cablemanager_CableList_SubMenu = By.xpath(configprop.getProperty("CableListSubMenu"));
    By CableList_AddBtn = By.xpath(configprop.getProperty("CableListAddBtn"));
    By Cable_Dateof_Received = By.xpath(configprop.getProperty("CableDateofReceived"));
    By txt_Cable_Details = By.xpath(configprop.getProperty("CableDetails"));
    By txt_cable_Size=By.xpath(configprop.getProperty("cableSize"));
    By txt_Drum_Number=By.xpath(configprop.getProperty("DrumNumber"));
    By txt_Length=By.xpath(configprop.getProperty("Length"));
    By txt_Storage_Location=By.xpath(configprop.getProperty("StorageLocation"));
    By txt_Vehicle_Number=By.xpath(configprop.getProperty("VehicleNumber"));
    By txt_LRNumber=By.xpath(configprop.getProperty("LRNumber"));
    By txt_Invoice_Number=By.xpath(configprop.getProperty("InvoiceNumber"));
    By txt_PoNumber=By.xpath(configprop.getProperty("PoNumber"));
    By date_Invoice_Date=By.xpath(configprop.getProperty("InvoiceDate"));
    By txt_Material_Code=By.xpath(configprop.getProperty("MaterialCode"));



    By cablesave_btn=By.xpath(configprop.getProperty("cablesavebtn"));
    By CableInward_List=By.cssSelector(configprop.getProperty("CableInwardList"));
    By Cable_Data=By.tagName(configprop.getProperty("CustomerTableData"));
    By successtext=By.xpath(configprop.getProperty("successtext"));
    By successOkconfirmbuttonn=By.xpath(configprop.getProperty("successOkconfirmbuttonn"));
    By txt_successOkconfirmbuttonn=By.xpath(configprop.getProperty("successOkconfirmbuttonn"));
    //Error message xpath
    By ErrorMessage=By.xpath(configprop.getProperty("ErrorMessage"));

    By Supplier_List=By.cssSelector(configprop.getProperty("SupplierList"));
    By Supplier_Data=By.tagName(configprop.getProperty("CustomerTableData"));

    //Actions Method
    // Here we click on the share point cable Manager side menu
    public void sharepointCablemanagerSideMenu( ) {
        try {
            WebElement cablemanagerSideMenu = waithelper.WaitForElement1(cablemanager_SideMenu, 10);

            // Attempt regular click first
            try {
                cablemanagerSideMenu.click();
                System.out.println("Successfully clicked using regular click");
                return; // Exit early if successful
            } catch (ElementNotInteractableException e) {
                System.out.println("Regular click intercepted, attempting JavaScript click...");
            } catch (StaleElementReferenceException e) {
                System.out.println("Element became stale, re-locating and retrying...");
                cablemanagerSideMenu =waithelper.WaitForElement1(cablemanager_SideMenu, 5);
            }

            // JavaScript click as fallback
            try {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", cablemanagerSideMenu);
                System.out.println("Successfully clicked using JavaScript");
            } catch (StaleElementReferenceException e) {
                System.out.println("Element stale during JS click, re-locating...");
                cablemanagerSideMenu = waithelper.WaitForElement1(cablemanager_SideMenu, 5);
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", cablemanagerSideMenu);
            }

        } catch (TimeoutException e) {
            System.out.println("Element not found within timeout: " + e.getMessage());
            // Consider taking screenshot here
        }
//        try {
//            WebElement CableManagerSideMenu = waithelper.WaitForElement1(cablemanager_SideMenu, 10);
//            scrollToElement(CableManagerSideMenu);
//            CableManagerSideMenu.click();
//        } catch (Exception e) {
//            System.out.println("Unexpected error: " + e.getMessage());
//        }

    }


    // Here we click on the share point Cable  Manager--> Cable List Sub Menu
    public void sharepointCableListSubMenu( ) {

        try {
            WebElement CableListSubMenu = waithelper.WaitForElement1(cablemanager_CableList_SubMenu, 10);
            scrollToElement(CableListSubMenu);
            CableListSubMenu.click();
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }


    // Here we click on the share point Cable  Manager--> Cable List -->ADD Button
    public void sharepointCableListAddBtn( ) {

        try {
            WebElement CableListAddBtn = waithelper.WaitForElement1(CableList_AddBtn, 10);
            scrollToElement(CableListAddBtn);
            CableListAddBtn.click();
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }




















   //  ✅  for maintainability, readability, and reusability.

//    1. Enter Random Date of Received
    public void cableInwardenterRandomDateOfReceived() {

        try {


            WebElement Dateof_Received = waithelper.WaitForElement1(Cable_Dateof_Received, 10);
            // Generate random date
            String randomDate = generateRandomDate();
            scrollToElement(Dateof_Received);
            Dateof_Received.sendKeys(randomDate);

        } catch (Exception e) {
            System.out.println("Failed to Find The Field: " + e.getMessage());
        }

    }

//2. Enter Cable Details
    public void cableInwardenterCableDetails() {
        try {
            WebElement Cable_Details = waithelper.WaitForElement1(txt_Cable_Details, 10);
            Cable_Details.click();
            Cable_Details.clear();
            Cable_Details.sendKeys(randomString());
        } catch (Exception e) {
            System.out.println("Failed to Find The Field: " + e.getMessage());
        }
    }

//3. Enter Cable Size
    public void cableInwardenterCableSize() {

        try {
            WebElement cable_Size = waithelper.WaitForElement1(txt_cable_Size, 10);
            cable_Size.click();
            cable_Size.clear();
            cable_Size.sendKeys(randomNumber()+"C");
        } catch (Exception e) {
            System.out.println("Failed to Find The Field: " + e.getMessage());
        }

    }

//4. Enter Drum Number
    public void cableInwardenterDrumNumber( ) {
        try {
            WebElement DrumNumber = waithelper.WaitForElement1(txt_Drum_Number, 10);
            DrumNumber.click();
            DrumNumber.clear();
            DrumNumber.sendKeys(randomNumber());
        } catch (Exception e) {
            System.out.println("Failed to Find The Field: " + e.getMessage());
        }
    }

//5. Enter Length
    public void cableInwardenterLength() {
        try {
            WebElement Length = waithelper.WaitForElement1(txt_Length, 10);
            Length.click();
            Length.clear();
            Length.sendKeys(randomNumber());
        } catch (Exception e) {
            System.out.println("Failed to Find The Field: " + e.getMessage());
        }
    }

//6. Enter Storage Location
    public void cableInwardenterStorageLocation() {
        try {
            WebElement Storage_Location = waithelper.WaitForElement1(txt_Storage_Location, 10);
            Storage_Location.click();
            Storage_Location.clear();
            Storage_Location.sendKeys(" # "+ randomNumber()+" "+ randomString()+" "+ randomString());
        } catch (Exception e) {
            System.out.println("Failed to Find The Field: " + e.getMessage());
        }
    }

//7. Enter Vehicle Number
    public void cableInwardenterVehicleNumber( ) {
        try {
            WebElement Vehicle_Number = waithelper.WaitForElement1(txt_Vehicle_Number, 10);
            Vehicle_Number.click();
            Vehicle_Number.clear();
            Vehicle_Number.sendKeys(" 22 " + "  BH "+ randomNumber());
        } catch (Exception e) {
            System.out.println("Failed to Find The Field: " + e.getMessage());
        }

    }

//8. Enter LR Number
    public void cableInwardenterLRNumber() {

        try {
            WebElement LRNumber = waithelper.WaitForElement1(txt_LRNumber, 10);
            LRNumber.click();
            LRNumber.clear();
            LRNumber.sendKeys(randomNumber());
        } catch (Exception e) {
            System.out.println("Failed to Find The Field: " + e.getMessage());
        }

    }

//9. Enter Invoice Number
    public void cableInwardenterInvoiceNumber() {
        try {
            WebElement Invoice_Number = waithelper.WaitForElement1(txt_Invoice_Number, 10);
            Invoice_Number.click();
            Invoice_Number.clear();
            Invoice_Number.sendKeys(randomNumber());
        } catch (Exception e) {
            System.out.println("Failed to Find The Field: " + e.getMessage());
        }


    }

//10. Enter PO Number
    public void cableInwardenterPoNumber( ) {
        try {
            WebElement PoNumber = waithelper.WaitForElement1(txt_PoNumber, 10);
            PoNumber.click();
            PoNumber.clear();
            PoNumber.sendKeys(randomNumber());
        } catch (Exception e) {
            System.out.println("Failed to Find The Field: " + e.getMessage());
        }
    }

//11. Enter Invoice Date
    public void cableInwarenterInvoiceDate() {

        try {
            WebElement Invoice_Date = waithelper.WaitForElement1(date_Invoice_Date, 10);
            // Generate random date
            String randomDate = generateRandomDate();
            scrollToElement(Invoice_Date);
            Invoice_Date.sendKeys(randomDate);
        } catch (Exception e) {
            System.out.println("Failed to Find The Field: " + e.getMessage());
        }

    }

//12. Enter Material Code
    public void cableInwarenterMaterialCode() {
        try {
            WebElement Material_Code = waithelper.WaitForElement1(txt_Material_Code, 10);
            Material_Code.click();
            Material_Code.clear();
            Material_Code.sendKeys(randomNumber());
        } catch (Exception e) {
            System.out.println("Failed to Find The Field: " + e.getMessage());
        }
    }


    //13. Save Button
    public void cableInwarClickSaveButton() {
        try {
            WebElement cablesavebtn = waithelper.WaitForElement1(cablesave_btn, 10);
            JavascriptExecutor js = (JavascriptExecutor) ldriver;
            js.executeScript("arguments[0].click();", cablesavebtn);
        } catch (Exception e) {
            System.out.println("Failed to click Save button via JS: " + e.getMessage());
        }
    }


    // for Identifying The Error Messages
    public void sharepointCableInwardErrorMessage() {
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


    public void sharepointMaterialInwardGetTableList() {
        try {
            int currentPage = 1;
            int totalPages = getTotalcableInwardDataPages();
            int totalCustomers = 0;

            System.out.println("=== CableInward  LIST (ALL PAGES) ===");
            System.out.println("Total pages to process: " + totalPages);
            System.out.println();

            do {
                System.out.println("--- PAGE " + currentPage + " ---");

                // Wait for table to load
                ldriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

                List<WebElement> rows = ldriver.findElements(CableInward_List);

                if (rows.isEmpty()) {
                    System.out.println("No Cable Inward found on page " + currentPage);
                } else {
                    // Print table header for each page
                    System.out.println("┌──────────────────────┬──────────────────────┬──────────────────────┬──────────────────────────────┐──────────────────────────────┐");
                    System.out.println("│ Date of Recevied     │ Cable Details        │ Cable Size           │ Drum Number                  │ Assignment Status            │");
                    System.out.println("├──────────────────────┼──────────────────────┼──────────────────────┼──────────────────────────────┤──────────────────────────────┤");

                    // Print rows for current page
                    for (WebElement row : rows) {
                        List<WebElement> cells = row.findElements(Cable_Data);



                        if (cells.size() >= 5) {
                            String DateofRecevied = formatCell(cells.get(0).getText(), 20);
                            String CableDetails = formatCell(cells.get(1).getText(), 20);
                            String CableSize = formatCell(cells.get(2).getText(), 20);
                            String DrumNumber  = formatCell(cells.get(3).getText(), 28);
                           String AssignmentStatus=formatCell(cells.get(4).getText(), 28);
                            System.out.println("│ " + DateofRecevied + " │ " + CableDetails + " │ " + CableSize + " │ " + DrumNumber + " │" + AssignmentStatus + "  │");
                        }
                    }

                    // Print footer for current page
                    System.out.println("└──────────────────────┴──────────────────────┴──────────────────────┴──────────────────────────────┘──────────────────────────────┘");
                    System.out.println("Page " + currentPage + ": " + rows.size() + " Cable Inward");

                    totalCustomers += rows.size();
                }

                System.out.println();

                // Move to next page if available
                if (currentPage < totalPages) {
                    CableInwardnavigateToNextPage();
                    currentPage++;
                } else {
                    break; // Exit loop when we reach the last page
                }

            } while (currentPage <= totalPages);

            // Print final summary
            System.out.println("==========================================");
            System.out.println("TOTAL Material  Inward ACROSS ALL PAGES: " + totalCustomers);
            System.out.println("==========================================");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }














}
