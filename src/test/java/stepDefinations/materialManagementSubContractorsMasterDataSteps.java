package stepDefinations;

import io.cucumber.java.en.*;
import pageobjects.MaterialManagementSubContractorMasterDataPage;

import java.io.IOException;

public class materialManagementSubContractorsMasterDataSteps extends BaseClass {


    public materialManagementSubContractorsMasterDataSteps( ) throws IOException {
        subcontractor= new MaterialManagementSubContractorMasterDataPage(driver);
    }


    @Then("click the subContractor side menu")
    public void click_the_sub_contractor_side_menu() {
        logger.info("*** click the subContractor side menu ***");
        subcontractor.sharepointSubcontractorsSideMenu();
    }
    @Then("Click on the SubContractor Add button and select the subContractor dropdown")
    public void click_on_the_sub_contractor_add_button_and_select_the_sub_contractor_dropdown() {
        logger.info("*** Click on the SubContractor Add button  ***");
        subcontractor.sharepointSubcontractorsAddIcon( );
        logger.info("***  select the subContractor dropdown ***");
        subcontractor.sharepointDrpSubcontractorsOption( );

    }
    @Then("Fill all the SubContractor required  details and submit the details")
    public void fill_all_the_sub_contractor_required_details_and_submit_the_details() {
        logger.info("***  Fill all the SubContractor required  details  ***");
        subcontractor.sharepointSubcontractorsMasterDataRequiredField( );
        logger.info("***  Click The Submit Button ***");
        subcontractor.sharepointSubContractorSubmitBtn();
        logger.info("***  Click The Success Button ***");
        subcontractor.sharepointSupplierSuccessBtnConfirmation();

    }

   // checking for The Required Fields
    @Then("click Sucontractor submit Button then check the Error Message details")
    public void click_sucontractor_submit_button_then_check_the_error_message_details() {
        logger.info("***  click Sucontractor submit Button  ***");
        subcontractor.sharepointSubContractorSubmitBtn();
        logger.info("***   check the Error Message details ***");
        subcontractor.sharepointSubcontractorErrorMessage();
    }



}
