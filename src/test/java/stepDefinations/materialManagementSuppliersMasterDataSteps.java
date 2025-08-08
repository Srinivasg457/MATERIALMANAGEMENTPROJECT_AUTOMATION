package stepDefinations;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageobjects.MaterialManagementSupplierMasterDataPage;

import java.io.IOException;

public class materialManagementSuppliersMasterDataSteps extends BaseClass {



    public materialManagementSuppliersMasterDataSteps   ( ) throws IOException {
        supplier=new MaterialManagementSupplierMasterDataPage(driver);
    }

    @Then("click the Suppliers side menu")
    public void click_the_suppliers_side_menu() {
        logger.info("*** click the Suppliers side menu ***");
        supplier.sharepointSuppliersSideMenu( );
    }
    @Then("Click on the Add button and select the Suppliers dropdown")
    public void click_on_the_add_button_and_select_the_suppliers_dropdown() {
        logger.info("*** Click on the Add button  ***");
        supplier.sharepointSuppliersAddIcon( );
        logger.info("***  select the Suppliers dropdown ***");
        supplier.sharepointDrpSuppliersOption( );

    }
    @Then("Fill all the Suppliers required  details and submit the details")
    public void fill_all_the_suppliers_required_details_and_submit_the_details() {
        logger.info("***  Fill all the Suppliers required  details and submit the details ***");
        supplier.sharepointSupplierMasterDataRequiredField( );
        logger.info("***  Click The Submit Button ***");
        supplier.sharepointsuppliersSubmitBtn();
        logger.info("***  Click The Success Button ***");
        supplier.sharepointSupplierSuccessBtnConfirmation( );

    }

    //checking the Error fields
    @Then("click Supplier submit Button then check the Error Message details")
    public void click_supplier_submit_button_then_check_the_error_message_details() {
        logger.info("***  click Supplier submit Button then check the Error Message details ***");
        supplier.sharepointsuppliersSubmitBtn();
        logger.info("***  check the Error Message details ***");
        supplier.sharepointSupplierErrorMessage();
    }

}
