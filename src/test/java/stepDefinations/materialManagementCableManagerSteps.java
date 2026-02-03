package stepDefinations;


import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import pageobjects.*;
import java.io.IOException;

public class materialManagementCableManagerSteps extends BaseClass {


    @Given("the user launches the Chrome browser")
    public void the_user_launches_the_chrome_browser() throws IOException {
        //For Reusability from The Supplier Steps
        supplier=new MaterialManagementSupplierMasterDataPage(driver);
        //For New Build in the Material management page
        cableManager = new MaterialManagementCableManager(driver);
        material = new MaterialManagementMateialModulePage(driver);
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
//    @Then("click the cable List side menu")
//    public void click_the_cable_list_side_menu() {
//        logger.info("************* Click The Cable List Sub Menu  *****************");
//        cableManager.sharepointCableListSubMenu( );
//    }

    @Then("Click on the Add button and select the cables dropdown")
    public void click_on_the_add_button_and_select_the_cables_dropdown() {
        logger.info("*** Click on the Add '+' button ***");
        cableManager.sharepointcableslSAddIcon( );
        logger.info("*** select the Materials dropdown ***");
        cableManager.sharepointDrpMaterialOption();

    }


    @Then("Click on the Add Button")
    public void click_on_the_add_button() {
        logger.info("************* Click The Cable List ADD Button  *****************");
        cableManager.sharepointCableListAddBtn( );
    }


    @Then("Click The Cable Inward Sub Menu")
    public void Click_The_Cable_Inward_Sub_Menu() {
        logger.info("*** click the Materials Report Sub menu ***");

        cableManager.sharepointCableInward();
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
//  //Bulk Import Operations
//    @Then("Perform The Actions Required for The Bulk Import")
//    public void perform_the_actions_required_for_the_bulk_import() {
//        logger.info("*************  Perform The Bulk Import Operations *****************");
//        cableManager.sharepointCableInwardBulkImport();
//    }

//checking the Select and Deselect of The Radio Button
    @Then("the user clicks the Select Columns Module")
    public void the_user_clicks_the_select_columns_module() {
        logger.info("*************  Click on The Select Columns Button *****************");
        cableManager.sharepointCableSelectColumns();
    }
    @Then("the user verifies that the radio buttons can be selected and deselected")
    public void the_user_verifies_that_the_radio_buttons_can_be_selected_and_deselected() {
        logger.info("*************  Selecting The Columns is Not Selected *****************");
        cableManager.DateofReceviedrbtnCheckBox();
        cableManager.columcableSizeCheckBox();
        cableManager.columDetailsCheckBox();
        cableManager.columDrumNumberCheckBox();
        cableManager.columLengthCheckBox();
        cableManager.columStorageLocationCheckBox();
        cableManager.columVehicleNumberCheckBox();
        cableManager.columLRNumberCheckBox();
        cableManager.columINVNumberCheckBox();
        cableManager.columPONumberCheckBox();
        cableManager.columInvoiceDateCheckBox();
        cableManager.columMaterialCodeCheckBox();
        cableManager.applyColumnSelectionbtn();






    }





}
