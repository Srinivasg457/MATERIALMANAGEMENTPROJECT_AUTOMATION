package pageobjects;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.WaitHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;
import static stepDefinations.BaseClass.*;

public class MaterialManagementSubcontractorsUnitPricePage {
    public WebDriver ldriver;
    WaitHelper waithelper;

    public static Properties configprop;

    //constructor
    public MaterialManagementSubcontractorsUnitPricePage(WebDriver rdriver) throws IOException {
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
    By ReconcillationandReports = By.xpath(configprop.getProperty("ReconcillationandReports"));
    By SubcontractorsPounitprice = By.xpath(configprop.getProperty("SubcontractorsPounitprice"));
    By SubPoUnitPriceADDButton = By.xpath(configprop.getProperty("SubPoUnitPriceADDButton"));
    By itemcodeup = By.xpath(configprop.getProperty("itemcodeup"));
    By materialname = By.xpath(configprop.getProperty("materialname"));
    By unitofmeasurement=By.xpath(configprop.getProperty("unitofmeasurement"));
    By dropsownSubcontractorslist=By.xpath(configprop.getProperty("dropsownSubcontractorslist"));
//    By AllTheSubcontractors=By.xpath(configprop.getProperty("AllTheSubcontractors"));
    By unitprice=By.xpath(configprop.getProperty("unitprice"));
    By createddate=By.xpath(configprop.getProperty("createddate"));
    By subs=By.id(configprop.getProperty("listsubs"));
    By SubsSavebtn=By.xpath(configprop.getProperty("SubsSavebtn"));
   By OkayBtn=By.xpath(configprop.getProperty("OkayBtn"));

   // error message
   By ErrorMessage=By.xpath(configprop.getProperty("ErrorMessage"));
    By SubcontractorUnitpriceList=By.xpath(configprop.getProperty("SubcontractorUnitpriceList"));
    By Subcontractorunitpricedata=By.xpath(configprop.getProperty("Subcontractorunitpricedata"));
    By SubUnitPriceTableInsideTable=By.xpath(configprop.getProperty("SubUnitPriceTableInsideTable"));
    By Subcunitpricetableinsidetabledata=By.xpath(configprop.getProperty("Subcunitpricetableinsidetabledata"));

    //Bulk Import  Function for The Suncontractor po
    By SUPImportBtn=By.xpath(configprop.getProperty("SUPImportBtn"));
    By SUPChooseFileArea=By.xpath(configprop.getProperty("SUPChooseFileArea"));
    By SUPProcessImportButton=By.xpath(configprop.getProperty("SUPProcessImportButton"));

    By PartialSuccess=By.xpath(configprop.getProperty("PartialSuccess"));

    //to display the cause of error
    By PrintDetails=By.xpath(configprop.getProperty("PrintDetails"));

    //Actions Method
    // Here we click on the Reconcillation and reports
    public void reconcillationAndreportsMenu( ) {

        try {
            WebElement RecreportMenu = waithelper.WaitForElement1(ReconcillationandReports, 10);
            if(RecreportMenu.isDisplayed() && RecreportMenu.isEnabled()){
                RecreportMenu.click();
                Assert.assertTrue(true);
            }
            else {
                Assert.fail("The Menu Didnt fount to be enable or displayed");
            }

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }

    public void SubcontractorsPoUnitPriceMenu( ) {

        try {
            WebElement SubcontractorsPounitpriceMenu = waithelper.WaitForElement1(SubcontractorsPounitprice, 10);
            if(SubcontractorsPounitpriceMenu.isDisplayed() && SubcontractorsPounitpriceMenu.isEnabled()){
                SubcontractorsPounitpriceMenu.click();
                Assert.assertTrue(true);
            }
            else {
                Assert.fail("The Subcontractor po unit Price Menu Not Available");
            }

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }

    public void SubPoUnitPriceADDButton( ) {

        try {
            WebElement SubPoUnitPriceADDBtn = waithelper.WaitForElement1(SubPoUnitPriceADDButton, 10);
            if(SubPoUnitPriceADDBtn.isDisplayed() && SubPoUnitPriceADDBtn.isEnabled()){
                SubPoUnitPriceADDBtn.click();
                Assert.assertTrue(true);
            }
            else {
                Assert.fail("The Subcontractor po Add Button Not Available");
            }

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }

    public void ItemCode( ) {

        try {
            WebElement itemcode = waithelper.WaitForElement1(itemcodeup, 10);
            if(itemcode.isDisplayed() && itemcode.isEnabled()){
                itemcode.click();
                itemcode.clear();
                itemcode.sendKeys(randomString());
                Assert.assertTrue(true);
            }
            else {
                Assert.fail("Item Code Text box not available");
            }

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }

    public void materialname( ) {

        try {
            WebElement materialsname = waithelper.WaitForElement1(materialname, 10);
            if(materialsname.isDisplayed() && materialsname.isEnabled()){
                materialsname.click();
                materialsname.clear();
                materialsname.sendKeys(randomString());
                Assert.assertTrue(true);
            }
            else {
                Assert.fail("Material name  Text box not available");
            }

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }

    public void unitofmeasurement( ) {

        try {
            WebElement uomMeasurement = waithelper.WaitForElement1(unitofmeasurement, 10);
            if(uomMeasurement.isDisplayed() && uomMeasurement.isEnabled()){
                uomMeasurement.click();
                uomMeasurement.clear();
                uomMeasurement.sendKeys(randomString());
                Assert.assertTrue(true);
            }
            else {
                Assert.fail("Material UOM  Text box not available");
            }

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }


    public void dropsownSubcontractorslist( ) {

        try {
            WebElement drpSubcontractorslist = waithelper.WaitForElement1(dropsownSubcontractorslist, 10);
            if(drpSubcontractorslist.isDisplayed() && drpSubcontractorslist.isEnabled()){
                drpSubcontractorslist.click();

                Assert.assertTrue(true);
            }
            else {
                Assert.fail("Dropdown element could not be clicked");
            }

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }


    public void Subcontractorslist( ) {

        try {
            System.out.println("DEBUG: Starting Subcontractorslist method");

            // First, let's check if the dropdown is actually open
            // Try to find the dropdown container with different selectors
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Try multiple selectors to find the dropdown
            List<By> selectors = Arrays.asList(
                    By.cssSelector("span.select2-results"),
                    By.id("select2-subcontractor-results"),
                    By.cssSelector("ul.select2-results__options"),
                    By.cssSelector("div.select2-results")
            );

            WebElement dropdownContainer = null;
            for (By selector : selectors) {
                try {
                    List<WebElement> elements = driver.findElements(selector);
                    if (!elements.isEmpty()) {
                        dropdownContainer = elements.get(0);
                        System.out.println("DEBUG: Found dropdown using selector: " + selector);
                        System.out.println("DEBUG: Dropdown is displayed: " + dropdownContainer.isDisplayed());
                        break;
                    }
                } catch (Exception e) {
                    // Continue trying next selector
                }
            }

            if (dropdownContainer == null) {
                System.out.println("ERROR: Could not find dropdown container!");

                // Check if dropdown trigger needs to be clicked first
                System.out.println("DEBUG: Trying to find and click dropdown trigger...");
                try {
                    WebElement dropdownTrigger = driver.findElement(By.cssSelector("span.select2-selection__rendered"));
                    System.out.println("DEBUG: Found dropdown trigger: " + dropdownTrigger.getText());
                    dropdownTrigger.click();
                    Thread.sleep(2000); // Wait for dropdown to open

                    // Now try to find dropdown again
//                    dropdownContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                            By.id("select2-subcontractor-results")
//                    ));


                    WebElement sub = waithelper.WaitForElement1(subs, 10);
                    System.out.println("DEBUG: Dropdown opened successfully");
                } catch (Exception e) {
                    System.out.println("ERROR: Could not open dropdown: " + e.getMessage());
                }
            }

            if (dropdownContainer != null) {
                // Try different ways to find the options
                System.out.println("DEBUG: Looking for options...");

                // Method 1: Find all li elements
                List<WebElement> allOptions = dropdownContainer.findElements(By.tagName("li"));
                System.out.println("DEBUG: Found " + allOptions.size() + " options using tagName('li')");

                // Method 2: Try with CSS selector
                if (allOptions.isEmpty()) {
                    allOptions = dropdownContainer.findElements(By.cssSelector("li"));
                    System.out.println("DEBUG: Found " + allOptions.size() + " options using cssSelector('li')");
                }

                // Method 3: Try with specific class
                if (allOptions.isEmpty()) {
                    allOptions = driver.findElements(By.cssSelector("li.select2-results__option"));
                    System.out.println("DEBUG: Found " + allOptions.size() + " options using specific class");
                }

                // Print what we found
                if (!allOptions.isEmpty()) {
                    System.out.println("=== Subcontractor Dropdown Options ===");
                    for (int i = 0; i < allOptions.size(); i++) {
                        WebElement option = allOptions.get(i);
                        try {
                            String text = option.getText();
                            String className = option.getAttribute("class");
                            System.out.printf("%2d. %-25s | Class: %s%n", i, text, className);
                        } catch (StaleElementReferenceException e) {
                            System.out.println("Option " + i + " became stale");
                        }
                    }
                } else {
                    System.out.println("DEBUG: No options found. Checking dropdown HTML...");
                    String html = dropdownContainer.getAttribute("outerHTML");
                    System.out.println("DEBUG: Dropdown HTML (first 1000 chars): " +
                            (html.length() > 1000 ? html.substring(0, 1000) + "..." : html));
                }
            }

            System.out.println("DEBUG: Method completed");


        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }

    public void selectRandomSubcontractor() {
        try {
            System.out.println("Selecting random subcontractor...");

            // First get the dropdown container
            WebElement dropdownContainer = driver.findElement(By.cssSelector("span.select2-results"));

            // Find all options
            List<WebElement> allOptions = dropdownContainer.findElements(By.tagName("li"));

            // Skip the first option ("Select Subcontractor") if present
            int startIndex = 0;
            if (allOptions.size() > 0 && allOptions.get(0).getText().equals("Select Subcontractor")) {
                startIndex = 1;
            }

            if (allOptions.size() > startIndex) {
                // Generate random index
                Random random = new Random();
                int randomIndex = startIndex + random.nextInt(allOptions.size() - startIndex);

                String optionText = allOptions.get(randomIndex).getText();
                System.out.println("Randomly selecting: " + optionText + " (index: " + randomIndex + ")");
                allOptions.get(randomIndex).click();
                System.out.println("Successfully selected random subcontractor: " + optionText);

                // Wait for selection to take effect
                Thread.sleep(1000);


                WebElement SelectedOption = waithelper.WaitForElement1(dropsownSubcontractorslist, 10);
               String Currentoption=SelectedOption.getText();
               if (optionText.equals(Currentoption)){
                   System.out.println("Selected option"+optionText+" is equal to Appearing option"+Currentoption);
                   Assert.assertTrue(true);
               }
               else {
                   Assert.fail("Selected option and the showing option is not matching");
               }

            } else {
                System.out.println("No subcontractors available to select");
            }

        } catch (Exception e) {
            System.out.println("Error selecting random subcontractor: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public void unitprice( ) {

        try {
            WebElement subsunitprice = waithelper.WaitForElement1(unitprice, 10);
            if(subsunitprice.isDisplayed() && subsunitprice.isEnabled()){
                subsunitprice.click();
                subsunitprice.clear();
                subsunitprice.sendKeys(randomNumber());

                Assert.assertTrue(true);
            }
            else {
                Assert.fail("Unit price number box not found");
            }

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }

    public void createddate( ) {

        try {
            WebElement date = waithelper.WaitForElement1(createddate, 10);
            if(date.isDisplayed() && date.isEnabled()){
                date.click();
                date.clear();
                date.sendKeys("17-13-2025");

                Assert.assertTrue(true);
            }
            else {
                Assert.fail("Calender Date Was an issue");
            }

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }

    public void SubsSavebtn( ) {

        try {
            WebElement Savebtn = waithelper.WaitForElement1(SubsSavebtn, 10);
            if(Savebtn.isDisplayed() && Savebtn.isEnabled()){
                Savebtn.click();

                Assert.assertTrue(true);
            }
            else {
                Assert.fail("Save btn Not Displayed or Enabled ");
            }

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }

    public void OkayBtn( ) {

        try {
            WebElement OkBtn = waithelper.WaitForElement1(OkayBtn, 10);
            if(OkBtn.isDisplayed() && OkBtn.isEnabled()){
                System.out.println("Okay button is clicking");
                OkBtn.click();
                Assert.assertTrue(true);
            }
            else {
                Assert.fail("Okay btn is not enabled and not clicked ");
            }

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

    }


    //error message
    public void subsErrorMessage() {
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
            int expectedErrorCount = 5;
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

 //to get the list in the table
public void sharepointSubcontractorPounitPriceGetTableList() {
    try {
        int currentPage = 1;
        int totalPages = getTotalPages();
        int totalCustomers = 0;

        System.out.println("=== Subcontractor  LIST (ALL PAGES) ===");
        System.out.println("Total pages to process: " + totalPages);
        System.out.println();

        do {
            System.out.println("--- PAGE " + currentPage + " ---");

            // Wait for table to load
            ldriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            List<WebElement> rows = ldriver.findElements(SubcontractorUnitpriceList);

            if (rows.isEmpty()) {
                System.out.println("No Subcontractors unit Price  found on page " + currentPage);
            } else {
                // Print table header for each page
                System.out.println("┌──────────────────────┬──────────────────────┬──────────────────────┬──────────────────────────────┐");
                System.out.println("│ Item Code            │ Material Name        │ UOM                  │ Subcontractors Count         │");
                System.out.println("├──────────────────────┼──────────────────────┼──────────────────────┼──────────────────────────────┤");

                // Print rows for current page
                for (WebElement row : rows) {
                    List<WebElement> cells = row.findElements(Subcontractorunitpricedata);



                    if (cells.size() >= 4) {
                        String Item_Code  = formatCell(cells.get(0).getText(), 20);
                        String Material_Name  = formatCell(cells.get(1).getText(), 20);
                        String UOM = formatCell(cells.get(2).getText(), 20);
                        String Subcontractors_Count  = formatCell(cells.get(3).getText(), 28);

                        System.out.println("│ " + Item_Code + " │ " + Material_Name + " │ " + UOM + " │ " + Subcontractors_Count + " │");
                    }
                }

                // Print footer for current page
                System.out.println("└──────────────────────┴──────────────────────┴──────────────────────┴──────────────────────────────┘");
                System.out.println("Page " + currentPage + ": " + rows.size() + " Items");

                totalCustomers += rows.size();
            }

            System.out.println();

            // Move to next page if available
            if (currentPage < totalPages) {
                navigateToNextPage();
                currentPage++;
            } else {
                break; // Exit loop when we reach the last page
            }

        } while (currentPage <= totalPages);

        // Print final summary
        System.out.println("==========================================");
        System.out.println("Subcontractors Po Unit Price ACROSS ALL PAGES: " + totalCustomers);
        System.out.println("==========================================");

    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
        e.printStackTrace();
    }
}

    // Helper method to get total number of pages for Customers
    protected int getTotalPages() {
        try {
            // Wait for pagination to be present
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.cssSelector("#Table_SubcontractorsUnitPrice_paginate")

            ));
            List<WebElement> pageButtons = driver.findElements(
                    By.cssSelector("#Table_SubcontractorsUnitPrice_paginate .paginate_button:not(.previous):not(.next)")
            );
            return pageButtons.size();
        } catch (Exception e) {
            System.out.println("Could not determine total pages, assuming 1 page");
            return 1;
        }
    }

    // Helper method to format cell content with fixed width
    protected String formatCell(String text, int width) {
        if (text.length() > width) {
            return text.substring(0, width - 3) + "...";
        } else {
            return String.format("%-" + width + "s", text);
        }
    }
    // Helper method to navigate to next page
    protected void navigateToNextPage() {
        try {
            WebElement nextButton = driver.findElement(By.id("Table_SubcontractorsUnitPrice_next"));
            if (!nextButton.getAttribute("class").contains("disabled")) {
                nextButton.click();
                // Wait for page to load
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            System.out.println("Could not navigate to next page: " + e.getMessage());
        }
    }

    //Debugging
    public void clickRandomTableItem() {
        try {
            System.out.println("Clicking random item from the table...");

            // Find all rows in the table
            List<WebElement> rows = driver.findElements(
                    By.xpath("//div[contains(@class, 'dataTables_wrapper')]//table/tbody/tr")
            );

            if (rows.isEmpty()) {
                System.out.println("No items found in the table");
                Assert.fail("Table is empty - no items to click");
                return;
            }

            System.out.println("Found " + rows.size() + " rows in the table");

            // Generate random index (0 to rows.size()-1)
            Random random = new Random();
            int randomIndex = random.nextInt(rows.size());

            System.out.println("Randomly selected row index: " + randomIndex);

            // Get the random row
            WebElement randomRow = rows.get(randomIndex);

            // Print row info for debugging
            System.out.println("Selected row text: " + randomRow.getText());

            // Click the row (you might need to click a specific cell)
            // Option 1: Click the entire row
            randomRow.click();

            // Option 2: Click the first cell in the row (usually contains a link)
            // WebElement firstCell = randomRow.findElement(By.xpath(".//td[1]"));
            // firstCell.click();

            System.out.println("Successfully clicked random row at index: " + randomIndex);
            sharepointSubcontractorPounitPriceTableInsideTablePrint();
            // Wait for any action to complete
            Thread.sleep(2000);

        } catch (Exception e) {
            System.out.println("Error clicking random table item: " + e.getMessage());
            e.printStackTrace();
            Assert.fail("Failed to click random table item: " + e.getMessage());
        }
    }


public void sharepointSubcontractorPounitPriceTableInsideTablePrint() {
    try {
        int currentPage = 1;
        int totalPages = getTotalPages();
        int totalItems = 0;

        // Use a Set to track unique items to avoid duplicates
        Set<String> uniqueItems = new LinkedHashSet<>();

        System.out.println("=== SUBCONTRACTOR UNIT PRICE DETAILS ===");
        System.out.println("Total pages: " + totalPages);
        System.out.println();

        do {
            System.out.println("Processing page: " + currentPage);

            // Wait for table to load
            WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(SubUnitPriceTableInsideTable));

            List<WebElement> rows = ldriver.findElements(SubUnitPriceTableInsideTable);

            if (rows.isEmpty()) {
                System.out.println("No items found on page " + currentPage);
            } else {
                // Process rows and add to set for uniqueness
                for (WebElement row : rows) {
                    List<WebElement> cells = row.findElements(Subcunitpricetableinsidetabledata);

                    if (cells.size() >= 3) {
                        String rowKey = cells.get(0).getText() + "|" + cells.get(1).getText() + "|" + cells.get(2).getText();
                        if (uniqueItems.add(rowKey)) { // Only add if unique
                            totalItems++;
                        }
                    }
                }
            }

            // Move to next page if available and not the last page
            if (currentPage < totalPages) {
                navigateToNextPage();
                currentPage++;
                Thread.sleep(1000); // Wait for page load
            } else {
                break;
            }

        } while (currentPage <= totalPages);

        // Now print all unique items
        if (!uniqueItems.isEmpty()) {
            System.out.println("┌──────────────────────┬──────────────────────┬──────────────────────┐");
            System.out.println("│ Subcontractor        │ Unit Price           │ Recent Date          │");
            System.out.println("├──────────────────────┼──────────────────────┼──────────────────────┤");

            for (String item : uniqueItems) {
                String[] parts = item.split("\\|");
                if (parts.length >= 3) {
                    String subcontractor = formatCell(parts[0], 20);
                    String unitPrice = formatCell(parts[1], 20);
                    String recentDate = formatCell(parts[2], 20);

                    System.out.println("│ " + subcontractor + " │ " + unitPrice + " │ " + recentDate + " │");
                }
            }

            System.out.println("└──────────────────────┴──────────────────────┴──────────────────────┘");
            System.out.println("Total unique items: " + totalItems);
        } else {
            System.out.println("No unique items found");
        }

    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
        e.printStackTrace();
    }
}


// Bulk operation function


//     SUPProcessImportButton
public void bulkimportButton() {
    try {
        System.out.println("=== DEBUG: Attempting to click bulk import button ===");

        // Use explicit wait for element to be clickable
        WebElement importBtn = waithelper.WaitForElement1(SUPImportBtn, 10);

        if (importBtn != null) {
            System.out.println("Import button found, attempting to click...");

            // Scroll into view if needed
            ((JavascriptExecutor) ldriver).executeScript("arguments[0].scrollIntoView(true);", importBtn);
            Thread.sleep(500);

            // Click using JavaScript as backup
            try {
                importBtn.click();
                System.out.println("Successfully clicked import button using standard click");
            } catch (ElementClickInterceptedException e) {
                System.out.println("Standard click intercepted, trying JavaScript click...");
                ((JavascriptExecutor) ldriver).executeScript("arguments[0].click();", importBtn);
            }

        } else {
            Assert.fail("The Bulk import Button was not found or not clickable");
        }

    } catch (Exception e) {
        System.out.println("ERROR in bulkimportButton: " + e.getMessage());
        e.printStackTrace();
        Assert.fail("Failed to click bulk import button: " + e.getMessage());
    }
}
    public void EmptyFileChooseFileSelectArea() {
        try {
            WebElement ChooseFileArea = waithelper.WaitForElement1(SUPChooseFileArea, 10);

            // Get relative path from config
            String relativeFilePath = configprop.getProperty("BulkUploAdFile");

            // Try different paths
            String[] possiblePaths = {
                    // Docker container path
                    "/home/seluser/automation" + relativeFilePath,
                    // Local path
                    System.getProperty("user.dir") + relativeFilePath,
                    // Alternative Docker path
                    "/tmp" + relativeFilePath
            };

            String uploadedFilePath = null;

            for (String filePath : possiblePaths) {
                try {
                    System.out.println("Trying path: " + filePath);
                    ChooseFileArea.clear();
                    ChooseFileArea.sendKeys(filePath);

                    Thread.sleep(500);
                    String uploadedFile = ChooseFileArea.getAttribute("value");
                    if (uploadedFile != null && !uploadedFile.isEmpty()) {
                        uploadedFilePath = filePath;
                        System.out.println("Successfully uploaded using path: " + filePath);
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Failed with path " + filePath + ": " + e.getMessage());
                    continue;
                }
            }

            if (uploadedFilePath == null) {
                Assert.fail("Failed to upload file with any path. Tried: " + Arrays.toString(possiblePaths));
            }

        } catch (Exception e) {
            System.out.println("ERROR in ChooseFileSelectArea: " + e.getMessage());
            e.printStackTrace();
            Assert.fail("Failed to upload file: " + e.getMessage());
        }
    }
//public void EmptyFileChooseFileSelectArea() {
//    try {
//
//        WebElement ChooseFileArea = waithelper.WaitForElement1(SUPChooseFileArea, 10);
//        System.out.println("Element displayed: " + ChooseFileArea.isDisplayed());
//        System.out.println("Element enabled: " + ChooseFileArea.isEnabled());
//
//        // Get file path from config.properties
//        String relativeFilePath = configprop.getProperty("BulkUploAdFile1");
//        System.out.println("Relative file path from config: " + relativeFilePath);
//
//        // Construct absolute path
//        String projectPath = System.getProperty("user.dir");
//        String absoluteFilePath = projectPath + relativeFilePath;
//        System.out.println("Absolute file path: " + absoluteFilePath);
//
//        // Check if file exists
//        File file = new File(absoluteFilePath);
//        System.out.println("File exists: " + file.exists());
//        System.out.println("File absolute path: " + file.getAbsolutePath());
//
//        if(file.exists()) {
//            System.out.println("Attempting to send keys to file input...");
//
//            // Clear any existing value first (optional)
//            ChooseFileArea.clear();
//
//            // Send the file path
//            ChooseFileArea.sendKeys(absoluteFilePath);
//            System.out.println("SendKeys completed");
//
//            // Add a small delay and verify
//            Thread.sleep(1000);
//            String uploadedFile = ChooseFileArea.getAttribute("value");
//            System.out.println("Uploaded file from value attribute: " + uploadedFile);
//
//            if (uploadedFile.isEmpty()) {
//                System.out.println("WARNING: Value attribute is empty after upload");
//                // Try getting other attributes
//                System.out.println("text: " + ChooseFileArea.getText());
//                System.out.println("innerHTML: " + ChooseFileArea.getAttribute("innerHTML"));
//                System.out.println("outerHTML: " + ChooseFileArea.getAttribute("outerHTML"));
//            }
//
//        } else {
//            System.out.println("ERROR: File not found!");
//            // List files in directory for debugging
//            File dir = new File(projectPath + "/src/test/java/Files/");
//            if(dir.exists()) {
//                System.out.println("Files in directory:");
//                String[] files = dir.list();
//                if(files != null) {
//                    for(String fileName : files) {
//                        System.out.println("  - " + fileName);
//                    }
//                }
//            }
//            Assert.fail("File not found at: " + absoluteFilePath);
//        }
//
//        System.out.println("=== DEBUG: ChooseFileSelectArea completed ===");
//
//    } catch (Exception e) {
//        System.out.println("ERROR in ChooseFileSelectArea: " + e.getMessage());
//        e.printStackTrace();
//        Assert.fail("Failed to upload file: " + e.getMessage());
//    }
//}

//    public void WithDataFileChooseFileSelectArea() {
//        try {
//
//            WebElement ChooseFileArea = waithelper.WaitForElement1(SUPChooseFileArea, 10);
//            System.out.println("Element displayed: " + ChooseFileArea.isDisplayed());
//            System.out.println("Element enabled: " + ChooseFileArea.isEnabled());
//
//            // Get file path from config.properties
//            String relativeFilePath = configprop.getProperty("BulkUploAdFile1");
//            System.out.println("Relative file path from config: " + relativeFilePath);
//
//            // Construct absolute path
//            String projectPath = System.getProperty("user.dir");
//            String absoluteFilePath = projectPath + relativeFilePath;
//            System.out.println("Absolute file path: " + absoluteFilePath);
//
//            // Check if file exists
//            File file = new File(absoluteFilePath);
//            System.out.println("File exists: " + file.exists());
//            System.out.println("File absolute path: " + file.getAbsolutePath());
//
//            if(file.exists()) {
//                System.out.println("Attempting to send keys to file input...");
//
//                // Clear any existing value first (optional)
//                ChooseFileArea.clear();
//
//                // Send the file path
//                ChooseFileArea.sendKeys(absoluteFilePath);
//                System.out.println("SendKeys completed");
//
//                // Add a small delay and verify
//                Thread.sleep(1000);
//                String uploadedFile = ChooseFileArea.getAttribute("value");
//                System.out.println("Uploaded file from value attribute: " + uploadedFile);
//
//                if (uploadedFile.isEmpty()) {
//                    System.out.println("WARNING: Value attribute is empty after upload");
//                    // Try getting other attributes
//                    System.out.println("text: " + ChooseFileArea.getText());
//                    System.out.println("innerHTML: " + ChooseFileArea.getAttribute("innerHTML"));
//                    System.out.println("outerHTML: " + ChooseFileArea.getAttribute("outerHTML"));
//                }
//
//            } else {
//                System.out.println("ERROR: File not found!");
//                // List files in directory for debugging
//                File dir = new File(projectPath + "/src/test/java/Files/");
//                if(dir.exists()) {
//                    System.out.println("Files in directory:");
//                    String[] files = dir.list();
//                    if(files != null) {
//                        for(String fileName : files) {
//                            System.out.println("  - " + fileName);
//                        }
//                    }
//                }
//                Assert.fail("File not found at: " + absoluteFilePath);
//            }
//
//            System.out.println("=== DEBUG: ChooseFileSelectArea completed ===");
//
//        } catch (Exception e) {
//            System.out.println("ERROR in ChooseFileSelectArea: " + e.getMessage());
//            e.printStackTrace();
//            Assert.fail("Failed to upload file: " + e.getMessage());
//        }
//    }

    public void WithDataFileChooseFileSelectArea() {
        try {
            WebElement ChooseFileArea = waithelper.WaitForElement1(SUPChooseFileArea, 10);

            // Get relative path from config
            String relativeFilePath = configprop.getProperty("BulkUploAdFile1");

            // Try different paths
            String[] possiblePaths = {
                    // Docker container path
                    "/home/seluser/automation" + relativeFilePath,
                    // Local path
                    System.getProperty("user.dir") + relativeFilePath,
                    // Alternative Docker path
                    "/tmp" + relativeFilePath
            };

            String uploadedFilePath = null;

            for (String filePath : possiblePaths) {
                try {
                    System.out.println("Trying path: " + filePath);
                    ChooseFileArea.clear();
                    ChooseFileArea.sendKeys(filePath);

                    Thread.sleep(500);
                    String uploadedFile = ChooseFileArea.getAttribute("value");
                    if (uploadedFile != null && !uploadedFile.isEmpty()) {
                        uploadedFilePath = filePath;
                        System.out.println("Successfully uploaded using path: " + filePath);
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Failed with path " + filePath + ": " + e.getMessage());
                    continue;
                }
            }

            if (uploadedFilePath == null) {
                Assert.fail("Failed to upload file with any path. Tried: " + Arrays.toString(possiblePaths));
            }

        } catch (Exception e) {
            System.out.println("ERROR in ChooseFileSelectArea: " + e.getMessage());
            e.printStackTrace();
            Assert.fail("Failed to upload file: " + e.getMessage());
        }
    }


    public void processImportbutton(){
        WebElement ProcessImportButton = waithelper.WaitForElement1(SUPProcessImportButton, 10);
        if(ProcessImportButton.isDisplayed() && ProcessImportButton.isEnabled()){
            ProcessImportButton.click();
            Assert.assertTrue(true);
        }
        else {
            Assert.fail("Process import Button Didnt Found");
        }

    }

    public void validationmessage(){
        WebElement Partialsuccess=waithelper.WaitForElement1(PartialSuccess,10);
        WebElement printDetails=waithelper.WaitForElement1(PrintDetails,10);

        if(Partialsuccess.isDisplayed()){
            Assert.assertTrue(true);
            String message=Partialsuccess.getText();
            System.out.println("message" + message);
            if(message.equals("Partial Import")){
                System.out.println("Partial Import");
                System.out.println("Error Details"+printDetails.getText());
                Assert.assertTrue(true);
            } else if (message.equals("Success")) {
                System.out.println("Success");
                System.out.println("Success Details "+printDetails.getText());
                Assert.assertTrue(true);
            } else if (message.equals("Import Failed")) {
                System.out.println("Import Failed");
                System.out.println("Success Details "+printDetails.getText());
                Assert.assertTrue(true);

            }

        }
        else {
            Assert.fail("Validation Message  Didnt Found");
        }
    }






}
