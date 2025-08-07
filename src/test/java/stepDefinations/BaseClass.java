package stepDefinations;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageobjects.*;
import utilities.EmailReading;

import java.util.Properties;

public class BaseClass {
    //    public WebDriver driver;
    public static WebDriver driver; // Make it static to share across classes
    public WorkroomLoginPage lp;
    public ChataakStoresPage sp;
    public ChataakSignUpPage signUppage;
    public static Logger logger;
    public static Properties configprop;
    public MaterialManagementMateialModulePage catalog;





    //    for work room project here below
    public MaterialManagementCustomerPage AddCustomer;
//    public BaseClass EmailUtils;
    public static EmailReading emailu;

    public MaterialManagementMateialModulePage material;




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


}







