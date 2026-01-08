package stepDefinations;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.*;
import utilities.EmailReading;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class BaseClass {
    //    public WebDriver driver;
    public static WebDriver driver; // Make it static to share across classes
    public MaterialManagementSupplierMasterDataPage sp;
    public ChataakSignUpPage signUppage;
    public static Logger logger;
    public static Properties configprop;
    public MaterialManagementMateialModulePage catalog;





    //    for sharepoint project here below
    public MaterialManagementCustomerPage AddCustomer;
//    public BaseClass EmailUtils;
    public static EmailReading emailu;

    public MaterialManagementMateialModulePage material;
    public MaterialManagementSupplierMasterDataPage supplier;

    public MaterialManagementSubContractorMasterDataPage subcontractor;
    public MaterialManagementCableManager cableManager;

    // for The Subcontractors unit price
    public MaterialManagementSubcontractorsUnitPricePage SubsUnitPrice;


    public static String randomString() {
        String generatedString1 = RandomStringUtils.randomAlphanumeric(8);
        return (generatedString1);
    }
    //random numbers

    public static String randomNumber() {
        return RandomStringUtils.randomNumeric(10); // Generates an 8-digit random number
    }

//    public static String getEmailInvitationLink() {
//        return EmailUtils.getInvitationLink(
//                configprop.getProperty("email.host"),
//                configprop.getProperty("email.username"),
//                configprop.getProperty("email.password"),
//                configprop.getProperty("email.subject.keyword"),
//                60 // timeout in seconds
//        );
//    }

    public static String getEmailInvitationLink() {  // Corrected spelling
        return emailu.getInvitationLink(
                configprop.getProperty("email.host"),
                configprop.getProperty("email.username"),
                configprop.getProperty("email.password"),
                configprop.getProperty("email.subject.keyword"),
                60 // timeout in seconds
        );
    }



    protected void closeDropdown() {
        try {
            // Method 1: Click outside the dropdown
            driver.findElement(By.tagName("body")).click();

            // OR Method 2: Send ESC key
            // driver.findElement(SelectCustomerDropDown).sendKeys(Keys.ESCAPE);

            // Wait for dropdown to close
//            new WebDriverWait(driver, Duration.ofSeconds(1))
//                    .until(ExpectedConditions.invisibilityOfElementLocated(
//                            By.xpath("//select[@id='" + SelectCustomerDropDown + "']/option[1]")));
        } catch (Exception e) {
            System.out.println("Warning: Could not properly close dropdown - " + e.getMessage());
        }
    }

    // Helper method to handle stale elements
    protected WebElement waitForElementWithStaleRetry(By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.ignoring(StaleElementReferenceException.class)
                .until(driver -> driver.findElement(locator));
    }

    // Helper method to format cell content with fixed width
    protected String formatCell(String text, int width) {
        if (text.length() > width) {
            return text.substring(0, width - 3) + "...";
        } else {
            return String.format("%-" + width + "s", text);
        }
    }
    // Helper method to get total number of pages for Customers
    protected int getTotalPages() {
        try {
            // Wait for pagination to be present
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.cssSelector("#Table_Customers_paginate")
            ));
            List<WebElement> pageButtons = driver.findElements(
                    By.cssSelector("#Table_Customers_paginate .paginate_button:not(.previous):not(.next)")
            );
            return pageButtons.size();
        } catch (Exception e) {
            System.out.println("Could not determine total pages, assuming 1 page");
            return 1;
        }
    }

    // Helper method to navigate to next page
    protected void navigateToNextPage() {
        try {
            WebElement nextButton = driver.findElement(By.id("Table_Customers_next"));
            if (!nextButton.getAttribute("class").contains("disabled")) {
                nextButton.click();
                // Wait for page to load
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            System.out.println("Could not navigate to next page: " + e.getMessage());
        }
    }



    //helper

    // Helper method to get total number of pages for Material
    protected int getTotalMaterialmasterDataPages() {
        try {
            // Wait for pagination to be present
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.cssSelector("#Table_Materials_paginate")
            ));
            List<WebElement> pageButtons = driver.findElements(
                    By.cssSelector("#Table_Materials_paginate .paginate_button:not(.previous):not(.next)")
            );
            return pageButtons.size();
        } catch (Exception e) {
            System.out.println("Could not determine total pages, assuming 1 page");
            return 1;
        }
    }


    // Helper method to navigate to next page
    protected void materialsnavigateToNextPage() {
        try {
            WebElement nextButton = driver.findElement(By.id("Table_Materials_next"));
            if (!nextButton.getAttribute("class").contains("disabled")) {
                nextButton.click();
                // Wait for page to load
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            System.out.println("Could not navigate to next page: " + e.getMessage());
        }
    }

    // Helper method to format cell content (make sure this exists)
    protected String formatCellmaterials(String text, int width) {
        if (text == null || text.trim().isEmpty()) {
            return String.format("%-" + width + "s", "N/A");
        }
        if (text.length() > width) {
            return text.substring(0, width - 3) + "...";
        } else {
            return String.format("%-" + width + "s", text);
        }
    }





    //for The Subcontractor
    // Helper method to get total number of pages for Material
    protected int getTotalSubContractormasterDataPages() {
        try {
            // Wait for pagination to be present
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.cssSelector("#Table_SubContractors_paginate")
            ));
            List<WebElement> pageButtons = driver.findElements(
                    By.cssSelector("#Table_SubContractors_paginate .paginate_button:not(.previous):not(.next)")
            );
            return pageButtons.size();
        } catch (Exception e) {
            System.out.println("Could not determine total pages, assuming 1 page");
            return 1;
        }
    }


    // Helper method to navigate to next page in subcontractor Page
    protected void SubcontractornavigateToNextPage() {
        try {
            WebElement nextButton = driver.findElement(By.id("Table_SubContractors_next"));
            if (!nextButton.getAttribute("class").contains("disabled")) {
                nextButton.click();
                // Wait for page to load
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            System.out.println("Could not navigate to next page: " + e.getMessage());
        }
    }

    //for The Subcontractor
    // Helper method to get total number of pages for Material
    protected int getTotalSuppliermasterDataPages() {
        try {
            // Wait for pagination to be present
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.cssSelector("#Table_Suppliers_paginate")
            ));


            List<WebElement> pageButtons = driver.findElements(
                    By.cssSelector("#Table_Suppliers_paginate .paginate_button:not(.previous):not(.next)")
            );
            return pageButtons.size();
        } catch (Exception e) {
            System.out.println("Could not determine total pages, assuming 1 page");
            return 1;
        }
    }


    // Helper method to navigate to next page in supplier Page
    protected void SuppliernavigateToNextPage() {
        try {
            WebElement nextButton = driver.findElement(By.id("Table_Suppliers_next"));
            if (!nextButton.getAttribute("class").contains("disabled")) {
                nextButton.click();
                // Wait for page to load
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            System.out.println("Could not navigate to next page: " + e.getMessage());
        }
    }

    public void scrollToElement(WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'});",
                    element
            );
            Thread.sleep(300);
        } catch (Exception e) {
            throw new RuntimeException("Failed to scroll to element: " + e.getMessage());
        }
    }

    protected String generateRandomDate() {
        Random random = new Random();

        // Generate random day (1-28 to avoid month length issues)
        int day = random.nextInt(28) + 1;

        // Generate random month (1-12)
        int month = random.nextInt(12) + 1;

        // Generate random year (e.g., 2020-2025)
        int year = 2020 + random.nextInt(6);

        // Format as dd/MM/yyyy
        return String.format("%02d/%02d/%04d", day, month, year);
    }

    //for The cable Inward
    // Helper method to get total number of pages for Material
    protected int getTotalcableInwardDataPages() {
        try {


            // Wait for pagination to be present
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.cssSelector("#Table_Cable_paginate")
            ));


            List<WebElement> pageButtons = driver.findElements(
                    By.cssSelector("#Table_Cable_paginate .paginate_button:not(.previous):not(.next)")
            );
            return pageButtons.size();
        } catch (Exception e) {
            System.out.println("Could not determine total pages, assuming 1 page");
            return 1;
        }
    }

    // Helper method to navigate to next page in Cable Inward  Page
    protected void CableInwardnavigateToNextPage() {
        try {
            WebElement nextButton = driver.findElement(By.id("Table_Cable_next"));
            if (!nextButton.getAttribute("class").contains("disabled")) {
                nextButton.click();
                // Wait for page to load
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            System.out.println("Could not navigate to next page: " + e.getMessage());
        }
    }


}








