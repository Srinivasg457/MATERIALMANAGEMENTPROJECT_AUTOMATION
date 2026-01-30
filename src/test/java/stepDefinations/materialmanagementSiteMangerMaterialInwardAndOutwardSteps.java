package stepDefinations;

import io.cucumber.java.en.*;
import pageobjects.MaterialManagementMateialModulePage;
import pageobjects.MaterialManagementSubcontractorsUnitPricePage;
import pageobjects.materialmanagementSiteMangerMaterialInwardAndOutwardPage;

import java.io.IOException;

import static stepDefinations.BaseClass.driver;
import java.io.IOException;

public class materialmanagementSiteMangerMaterialInwardAndOutwardSteps extends BaseClass{


    public materialmanagementSiteMangerMaterialInwardAndOutwardSteps() throws IOException {
        SiteManager = new materialmanagementSiteMangerMaterialInwardAndOutwardPage(driver);
        SubsUnitPrice = new MaterialManagementSubcontractorsUnitPricePage(driver);

    }



    @Then("click the Site Manager main Menu")
    public void click_the_site_manager_main_menu() {
        logger.info("*** click the Materials Manager main menu ***");

        SiteManager.sharepointSiteMangermainMenu();
    }
    @Then("Click The  Material report Sub Menu")
    public void click_the_material_report_sub_menu() {
        logger.info("*** click the Materials Report Sub menu ***");

        SiteManager.sharepointMaterialReport();
    }
    @Then("I am on the page with PO dropdown")
    public void i_am_on_the_page_with_po_dropdown() throws InterruptedException {
        logger.info("*** click the Inward outward button ***");
        SiteManager.sharepointMaterialInwardreportbtn();

        SiteManager.sharepointCustomerPoDropDown();
        Thread.sleep(5000);
    }
    @When("I select PO number  from the dropdown")
    public void i_select_po_number_from_the_dropdown( ) {
        logger.info("*** The DropDown List Availability Checking***");
        SiteManager.sharepointDropDownList();

    }
    @Then("PO number should be selected")
    public void po_number_should_be_selected( ) {
        logger.info("*** Selected the Customer Po from The Dropdown ***");
        SiteManager.sharepointlistofCustomerPo();
        logger.info("*** Click Generate Report for The Inard materials ***");
        SiteManager.sharepointgenerateInwardBtn();
    }


    @Then("Click the Export button")
    public void Click_the_Export_button() {
        logger.info("*** clicked The Export button ***");
        SiteManager.sharepointexportLiveBtn();
        logger.info("*** Checking for The Success Message ***");
        SiteManager.sharepointsuccessmsg();
    }


    @Then("Click The Generate button")
    public void click_the_generate_button() {
        logger.info("*** Click Generate Report for The Inard materials ***");
        SiteManager.sharepointgenerateInwardBtn();
    }
    @Then("Pop up message saying po number shoild be selected message should be displayed")
    public void pop_up_message_saying_po_number_shoild_be_selected_message_should_be_displayed() {
        logger.info("*** Pop Up Message  ***");
        SiteManager.sharepointsuccessmsg();
        logger.info("*** Reusability--->Click the Okay Button  ***");
        SubsUnitPrice.OkayBtn();
    }




}
