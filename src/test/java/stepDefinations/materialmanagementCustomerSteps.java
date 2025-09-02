package stepDefinations;

import io.cucumber.java.en.*;
import io.qameta.allure.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriverException;
import pageobjects.MaterialManagementCustomerPage;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

//@Epic("Chataak Platform")
//@Feature("SignUp Feature")
//@Story("User will be on the product page")

/// /@Step("User  will perform on the product page")
//@Severity(SeverityLevel.CRITICAL)
@Epic("Material Management Platform")
@Feature("Add Customers Feature")
@Story("User will be on the Customer Module")
@Severity(SeverityLevel.CRITICAL)
public class materialmanagementCustomerSteps extends BaseClass {


    public materialmanagementCustomerSteps() throws IOException {
        AddCustomer = new MaterialManagementCustomerPage(driver);
    }

    @When("the user enters their email {string}")
    public void the_user_enters_their_email(String email) {
        logger.info("*** Enter The Share Point Email Id ***");
        AddCustomer.sharepointEmail(email);
    }
    @When("the user clicks the Submit button")
    public void the_user_clicks_the_submit_button() {
        logger.info("*** click the next button ***");
        AddCustomer.sharepointEmailnextButton();
    }
    @Then("the user enters their password {string}")
    public void the_user_enters_their_password(String pwd) {
        logger.info("*** Enter The Password ***");
        AddCustomer.sharepointpassword(pwd);
    }
    @Then("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        logger.info("*** clicked on the sign in Button ***");
        AddCustomer.sharepointSigninButton();
    }


          //    Adding the Customer Details Master Data

    @Then("click the master side menu")
    public void click_the_master_side_menu() {
        logger.info("*** clicked on the master side menu ***");
        AddCustomer.sharepointmasterDataSidemenu( );
    }
    @Then("click the custmer side menu")
    public void click_the_custmer_side_menu() {
        logger.info("*** clicked on the customer sub menu ***");
        AddCustomer.sharepointcustomermasterdata( );
    }
    @Then("Click on the Add button and select the customer dropdown")
    public void click_on_the_add_button_and_select_the_customer_dropdown() {
        logger.info("*** clicked on the '+' icon ***");
        AddCustomer.sharepointAddMasterDataButton( );
        logger.info("*** Selected the Customer ***");
        AddCustomer.sharepointcustomeroption( );

    }
    @Then("Fill all the required customer details")
    public void fill_all_the_required_customer_details() {
        logger.info("*** Filing up the Customer All the Required field ***");
        AddCustomer.sharepointcustomerMasterDataRequiredField();
        logger.info("*** clicked the submit button ***");
        AddCustomer.sharepointcustomersubmitform( );
        logger.info("*** clicked the Success ok Button ***");
        AddCustomer.sharepointSuccessConfirmOKButton();
    }


    //Here We Will Get The information  For The error Message Present Or Not
    //eg like : This Fiels Is Required
    @Then("click the Save Button And Find The Error Message")
    public void click_the_save_button_and_find_the_error_mesage() {
        try {
            logger.info("*** Clicking the Submit Button ***");
            AddCustomer.sharepointcustomersubmitform();

            logger.info("*** Checking For The Error Message ***");
            AddCustomer.sharepointcustomerErrorMessage();

        } catch (NoSuchElementException e) {
            logger.error("Element not found: " + e.getMessage());
            Assert.fail("Required elements for validation were not found");
        } catch (WebDriverException e) {
            logger.error("WebDriver error occurred: " + e.getMessage());
            Assert.fail("Browser interaction failed: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected error during validation: ", e);
            Assert.fail("Test failed due to unexpected error: " + e.getMessage());
        }

    }



    //  *****    Moving to The Customer Location and Performing The Action    **********

    @Then("Click on the Add button and select the Storage Location dropdown")
    public void click_on_the_add_button_and_select_the_storage_location_dropdown() {
        logger.info("*** Click On The Add Button '+' Icon ***");
        AddCustomer.sharepointAddMasterDataButton( );
        logger.info("*** Selecting The Customer Location Option ***");
        AddCustomer.sharepointCustomerLocationOption( );
    }

    @Then("Select The Customer DropDown And Select Option")
    public void select_the_customer_drop_down_and_select_option() {
        logger.info("*** Selecting The Customer Option  ***");
        AddCustomer.sharepointCustomersDropDown( );

    }

    @Then("Select The SiteLocation if available")
    public void select_the_site_location_if_available() {
        logger.info("*** Select The SiteLocation if available ***");
        AddCustomer.sharepointSiteDropDown();
    }


    @Then("Add The Loction And Click The Submit Button")
    public void add_the_loction_and_click_the_submit_button() {
        logger.info("*** Add The Loction  ***");
        AddCustomer.sharepointCustomerSitesLocationButton( );
        logger.info("***  Click The Submit Button ***");
        AddCustomer.sharepointcustomersubmitform( );
        logger.info("*** Success Message For The Location Validation Done ***");
        AddCustomer.sharepointCustomerStorageLocationSuccessMsgPopUp( );
    }


//Get The Customer Details
    @Then("Get The List of Data of Customers")
    public void get_the_list_of_data_of_customers() {
        logger.info("*** Get The List of Data of Customers  ***");
        AddCustomer.sharepointcustomerGetTableList();
    }


    //For The View Opton of The Customer Data
    @Then("Perform The Check Of View of The Custome Data")
    public void perform_the_check_of_view_of_the_custome_data() {
        logger.info("*** Check The View Of The Customer Data ***");
        AddCustomer.sharepointCustomerListActionView();
    }









}
