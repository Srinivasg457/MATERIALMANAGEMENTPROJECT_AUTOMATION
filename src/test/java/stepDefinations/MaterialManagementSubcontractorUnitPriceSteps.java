package stepDefinations;

import io.cucumber.java.en.Then;
import pageobjects.MaterialManagementCustomerPage;
import pageobjects.MaterialManagementSubContractorMasterDataPage;
import pageobjects.MaterialManagementSubcontractorsUnitPricePage;

import java.io.IOException;

import static stepDefinations.BaseClass.driver;
import static stepDefinations.BaseClass.logger;

public class MaterialManagementSubcontractorUnitPriceSteps extends  BaseClass {



    public MaterialManagementSubcontractorUnitPriceSteps() throws IOException {
         SubsUnitPrice = new MaterialManagementSubcontractorsUnitPricePage(driver);
    }


    @Then("click the Reconcillation and reports main Menu")
    public void click_the_reconcillation_and_reports_main_menu() {
        logger.info("*** click the Reconcillation and reports main Menu***");
        SubsUnitPrice.reconcillationAndreportsMenu();
    }
    @Then("click the Subcontractors Po Unit price sub menu")
    public void click_the_subcontractors_po_unit_price_sub_menu() {
        logger.info("*** click the Subs Unit price Sub Menu**");
        SubsUnitPrice.SubcontractorsPoUnitPriceMenu();
    }
    @Then("Click on Add button to add The Subcontractor  unit price")
    public void click_on_add_button_to_add_the_subcontractor_unit_price() {
        logger.info("*** click the Add button of subcontractor unit price**");
        SubsUnitPrice.SubPoUnitPriceADDButton();
    }
    @Then("Fill all the Subcontractors unit price and subbmit the form")
    public void fill_all_the_subcontractors_unit_price_and_subbmit_the_form() {
        logger.info("*** Entering the itemcode**");
        SubsUnitPrice.ItemCode( );
        logger.info("*** Entering the materialName**");
        SubsUnitPrice.materialname();
        logger.info("*** Entering the UOM**");
        SubsUnitPrice.unitofmeasurement();
        logger.info("*** Click The DropDown**");
        SubsUnitPrice.dropsownSubcontractorslist();
        logger.info("*** List of Subcontractorse**");
        SubsUnitPrice.Subcontractorslist();
        logger.info("*** Random sub contractor selecting**");
        SubsUnitPrice.selectRandomSubcontractor();
        logger.info("*** Entering the UnitPrice**");
        SubsUnitPrice.unitprice();
        logger.info("*** Selecting The Date **");
        SubsUnitPrice.createddate();
        logger.info("*** Clicked The saveButton**");
        SubsUnitPrice.SubsSavebtn();
        logger.info("*** Clicked Okay Button**");
        SubsUnitPrice.OkayBtn();
    }
    @Then("Clicks the Okay Button and try to Finds the Error Message or validation message Arrears")
    public void Clicks_the_Okay_Button_and_try_to_Finds_the_Error_Message_or_validation_message_Arrears() {
        logger.info("*** Clicks The Okay Button **");
        SubsUnitPrice.SubsSavebtn( );
        logger.info("*** Find The Count of Error Message **");
        SubsUnitPrice.subsErrorMessage();
    }




    @Then("print The list of Subcontractors and there unit price")
    public void print_the_list_of_subcontractors_and_there_unit_price() {
        logger.info("*** Table List Data  **");
        SubsUnitPrice.sharepointSubcontractorPounitPriceGetTableList( );
        SubsUnitPrice.clickRandomTableItem();
       // SubsUnitPrice.sharepointSubcontractorPounitPriceTableInsideTablePrint();
    }

    @Then("click the Import button")
    public void click_the_import_button() {
        logger.info("*** Bulk Upload Button Clicked **");
        SubsUnitPrice.bulkimportButton();
    }

    @Then("Choose The Empty sheet File for The Bulk upload")
    public void Choose_The_Empty_sheet_File_for_The_Bulk_upload() {
        logger.info("*** Sending File Through The Choose File Area With Empty Data of Excel Sheet **");

        SubsUnitPrice.EmptyFileChooseFileSelectArea();
    }

    @Then("Click The Process import Button")
    public void click_the_process_import_button() {
        logger.info("*** Clicked process import button **");
        SubsUnitPrice.processImportbutton();
        logger.info("*** Checking What is The Validation Message **");
        SubsUnitPrice.validationmessage();
        logger.info("*** After Checking The Validation Message Clicked Okay button **");
        SubsUnitPrice.OkayBtn();
    }


    @Then("Choose The File With Data for The Bulk upload")
    public void Choose_The_File_With_Data_for_The_Bulk_upload() {
        logger.info("*** Sending File Through The Choose File Area With The presence of Data in The Excel Sheet **");
        SubsUnitPrice.WithDataFileChooseFileSelectArea();
    }
}
