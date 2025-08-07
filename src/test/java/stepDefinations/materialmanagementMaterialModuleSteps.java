package stepDefinations;

import io.cucumber.java.en.Then;
import pageobjects.ChataakStoresPage;
import pageobjects.MaterialManagementMateialModulePage;

import java.io.IOException;

public class materialmanagementMaterialModuleSteps extends BaseClass {


    public materialmanagementMaterialModuleSteps() throws IOException {
        material = new MaterialManagementMateialModulePage(driver);
    }

    // # for The Material Module
    @Then("click the Materials side menu")
    public void click_the_materials_side_menu() {
        logger.info("*** click the Materials side menu ***");
        material.sharepointMaterialSideMenu( );
    }
    @Then("Click on the Add button and select the Materials dropdown")
    public void click_on_the_add_button_and_select_the_materials_dropdown() {
        logger.info("*** Click on the Add '+' button ***");
        material.sharepointMaterialSAddIcon( );
        logger.info("*** select the Materials dropdown ***");
        material.sharepointDrpMaterialOption( );

    }
    @Then("Fill all the required material details and submit the details")
    public void fill_all_the_required_material_details() {
        logger.info("*** Fill all the required material details***");
        material.sharepointMaterialMasterDataRequiredField( );
        logger.info("*** Fill all the required material details and Clicked The submit Button***");
        material.sharepointMaterialSubmitBtn( );
        logger.info("*** Checking and Clicked The Success Ok Button***");
        material.sharepointMaterialSuccessBtnConfirmation( );

    }


}
