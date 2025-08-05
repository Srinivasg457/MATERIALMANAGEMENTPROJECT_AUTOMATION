package stepDefinations;

import io.cucumber.java.en.*;
import io.qameta.allure.*;
import pageobjects.MaterialManagementCustomerPage;

import java.io.IOException;

//@Epic("Chataak Platform")
//@Feature("SignUp Feature")
//@Story("User will be on the product page")

/// /@Step("User  will perform on the product page")
//@Severity(SeverityLevel.CRITICAL)
@Epic("Workroom Platform")
@Feature("Create Employee Feature")
@Story("User will be on the Employee page")
@Severity(SeverityLevel.CRITICAL)
public class materialmanagementCustomerSteps extends BaseClass {


    public materialmanagementCustomerSteps() throws IOException {
        AddEmployees = new MaterialManagementCustomerPage(driver);

    }

    @When("the user enters their email {string}")
    public void the_user_enters_their_email(String email) {
        logger.info("*** Enter The Share Point Email Id ***");
        AddEmployees.sharepointEmail(email);
    }
    @When("the user clicks the Submit button")
    public void the_user_clicks_the_submit_button() {
        logger.info("*** click the next button ***");
        AddEmployees.sharepointEmailnextButton();
    }
    @Then("the user enters their password {string}")
    public void the_user_enters_their_password(String pwd) {
        logger.info("*** Enter The Password ***");
        AddEmployees.sharepointpassword(pwd);
    }
    @Then("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        logger.info("*** clicked on the sign in Button ***");
        AddEmployees.sharepointSigninButton();
    }


          //    Adding the Customer Details Master Data

    @Then("click the master side menu")
    public void click_the_master_side_menu() {
        logger.info("*** clicked on the master side menu ***");
        AddEmployees.sharepointmasterDataSidemenu( );
    }
    @Then("click the custmer side menu")
    public void click_the_custmer_side_menu() {
        logger.info("*** clicked on the customer sub menu ***");
        AddEmployees.sharepointcustomermasterdata( );
    }
    @Then("Click on the Add button and select the customer dropdown")
    public void click_on_the_add_button_and_select_the_customer_dropdown() {
        logger.info("*** clicked on the '+' icon ***");
        AddEmployees.sharepointAddMasterDataButton( );
        logger.info("*** Selected the Customer ***");
        AddEmployees.sharepointcustomeroption( );

    }
    @Then("Fill all the required customer details")
    public void fill_all_the_required_customer_details() {
        logger.info("*** Filing up the Customer All the Required field ***");
        AddEmployees.sharepointcustomerMasterDataRequiredField();
        logger.info("*** clicked the submit button ***");
        AddEmployees.sharepointcustomersubmitform( );
        logger.info("*** clicked the Success ok Button ***");
        AddEmployees.sharepointSuccessConfirmOKButton();
    }















//    @Then("user will create new employee by filling the employee form in the employee module")
//    public void user_will_create_new_employee_by_filling_the_employee_form_in_the_employee_module() throws InterruptedException {
//        logger.info("*** Moving to employee page ***");
//        AddEmployees.EmployeesPage();
//        logger.info("*** Clicked Add Employee Button ***");
//        AddEmployees.addEmployeeButton();
////        logger.info("*** Checking and selcting the Department Dropdown ***");
////        AddEmployees.departmentDropDown();
//        logger.info("*** Filling up employee name ***");
//        AddEmployees.employeename();
//        logger.info("*** Filling up employee email ***");
//        AddEmployees.EmployeeEmail();
//        logger.info("*** Filling up employee phonenumber ***");
//        AddEmployees.employeePhoneNumber();
//        logger.info("*** Filling up employee Address ***");
//        AddEmployees.employeeAddress();
//        logger.info("*** Filling up employee City ***");
//        AddEmployees.EmployeeCity();
//        logger.info("*** Selecting the Employee country ***");
//        AddEmployees.employeeCountry();
//        logger.info("*** Clicked show radio button ***");
//        AddEmployees.showRadiobutton();
//        logger.info("*** Upload employee image ***");
//        AddEmployees.uploadEmployeeImage();
//        logger.info("*** Clicked on save button***");
//        AddEmployees.saveButton();
//        logger.info("*** Check for the Toast Message ***");
//        AddEmployees.statusMessage();
//        logger.info("*** Verifying invitation email ***");
//        AddEmployees.verifyInvitationEmail() ;
//
//        logger.info("*** Switched to update password ***");
//        AddEmployees.switchToNewTab();
//    }


//    @Step("user will see the Pop up message saying to create the category First")
//    @When("user will see the Pop up message saying to create the category First")
//    public void user_will_see_the_pop_up_message_saying_to_create_the_category_first() throws InterruptedException {
//        logger.info("*** Creating the Products Without Presents of the Category ***");
//        AddProducts.AddProductsPage();
//        AddProducts.AddProductsWithoutCategory();
//    }
//
//
//    @Step("user will go to the Products and try to print the list of products")
//    @When("user will go to the Products and try to print the list of products")
//    public void user_will_go_to_the_products_and_try_to_print_the_list_of_products() throws InterruptedException {
//        logger.info("*** Print the List of Products ***");
//        AddProducts.ProductList();
//    }
//
//
//    @Step("User will fill the Product Data  for Adding the New Product")
//    @When("User will fill the Product Data  for Adding the New Product")
//    public void user_will_fill_the_product_data_for_adding_the_new_product() throws InterruptedException {
//        logger.info("*** Adding The New products ***");
//        AddProducts.AddProductsPage();
//        AddProducts.AddNewProducts();
//    }
//
//
//    @Step("User will Add The New Product")
//    @When("User will Add The New Product")
//    public void user_will_add_the_new_product() throws InterruptedException {
//        logger.info("*** If the category is Present in the Category Only Then User will create the Products ***");
//        AddProducts.AddProductsPage();
//        AddProducts.CategoryExistAddNewProduct();
//    }
//
//    @Step("user will print the product Active , All and Inactive products in the Console")
//    @When("user will print the product Active , All and Inactive products in the Console")
//    public void user_will_print_the_product_active_all_and_inactive_products_in_the_console() throws InterruptedException {
//        logger.info("*** Print the All Products , Active Products , And In-Active Products Count ***");
//        AddProducts.PrintProductCardDetails();
//    }
//
//    @Step("user will Test Action Active or Inactive")
//    @When("user will Test Action Active or Inactive")
//    public void user_will_test_action_active_or_inactive() throws InterruptedException {
//        logger.info("*** user will Test Action Active or Inactive ***");
//        AddProducts.productEnableOrDisable();
//    }
//
//    @Step("The user will perform the action to edit the product")
//    @When("The user will perform the action to edit the product")
//    public void the_user_will_perform_the_action_to_edit_the_product() throws InterruptedException {
//        logger.info("*** The user will perform the action to edit the product ***");
//        AddProducts.productActionProductEdit();
//    }


}
