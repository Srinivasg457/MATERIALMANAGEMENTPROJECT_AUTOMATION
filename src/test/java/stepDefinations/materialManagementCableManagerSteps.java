package stepDefinations;


import io.cucumber.java.en.*;
import pageobjects.*;
import java.io.IOException;

public class materialManagementCableManagerSteps extends BaseClass {


    @Given("the user launches the Chrome browser")
    public void the_user_launches_the_chrome_browser() throws IOException {
        //For Reusability from The Supplier Steps
        supplier=new MaterialManagementSupplierMasterDataPage(driver);
        //For New Build in the Material management page
        cableManager = new MaterialManagementCableManager(driver);

        AddCustomer = new MaterialManagementCustomerPage(driver);
    }
    @Given("the user navigates to the login page with the URL {string}")
    public void the_user_navigates_to_the_login_page_with_the_url(String url) {
        logger.info("************* Get The Application URL  *****************");
        driver.get(url);
    }

    @Then("click the cable manager side menu")
    public void click_the_cable_manager_side_menu() {
        logger.info("************* Click The Cable Manager Side Menu  *****************");
        cableManager.sharepointCablemanagerSideMenu();
    }
    @Then("click the cable List side menu")
    public void click_the_cable_list_side_menu() {
        logger.info("************* Click The Cable List Sub Menu  *****************");
        cableManager.sharepointCableListSubMenu( );
    }
    @Then("Click on the Add Button")
    public void click_on_the_add_button() {
        logger.info("************* Click The Cable List ADD Button  *****************");
        cableManager.sharepointCableListAddBtn( );
    }
    @Then("Fill all the Cable Inward required material details and submit the details")
    public void fill_all_the_cable_inward_required_material_details_and_submit_the_details() {
        logger.info("************* Fill All The Required Fields in the Material inward form *****************");
        cableManager.cableInwardenterRandomDateOfReceived();
        cableManager.cableInwardenterCableDetails();
        cableManager.cableInwardenterCableSize();
        cableManager.cableInwardenterDrumNumber( );
        cableManager.cableInwardenterLength();
        cableManager.cableInwardenterStorageLocation();
        cableManager.cableInwardenterVehicleNumber( );
        cableManager.cableInwardenterLRNumber();
        cableManager.cableInwardenterInvoiceNumber();
        cableManager.cableInwardenterPoNumber( );
        cableManager.cableInwarenterInvoiceDate();
        cableManager.cableInwarenterMaterialCode();
        logger.info("************* Click The Save Button For The Material Inward Form *****************");
        cableManager.cableInwarClickSaveButton();
        logger.info("************* Get The Success message and click on okay Button *****************");
        supplier.sharepointSupplierSuccessBtnConfirmation( );

    }


    @Then("Click the Submit button submit Button then check the Error Message details")
    public void click_the_submit_button_submit_button_then_check_the_error_message_details() {
        logger.info("************* Click The Save Button For The Material Inward Form *****************");
        cableManager.cableInwarClickSaveButton();
        logger.info("************* Click The Save Button For The Material Inward Form *****************");
        cableManager.sharepointCableInwardErrorMessage();
    }


   //
   @Then("Get The List Of Data available")
   public void get_the_list_of_data_available() {
       logger.info("*************  Get The List Of Cable inward Data *****************");
       cableManager.sharepointMaterialInwardGetTableList();
   }
}
