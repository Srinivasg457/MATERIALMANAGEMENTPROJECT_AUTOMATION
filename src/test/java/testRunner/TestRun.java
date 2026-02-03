package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
   //             features = "src/test/java/Features",
 //       features = "src/test/java/Features/1_materialManagementCustomer.feature",
//        features="src/test/java/Features/4_materialmanagementMaterials.feature",
//        features="src/test/java/Features/3_materialManagementSubContractor.feature",
 //      features="src/test/java/Features/2_materialManagementSupplierMasterData.feature",
  //      features ="src/test/java/Features/5_materialmanagementCableManager.feature",
//        features="src/test/java/Features/3_materialManagementSubContractor.feature",
//        features="src/test/java/Features/6_SubcontractorPoUnitprice.feature",
          features="src/test/java/Features/7_MaterialSiteManger.feature",

        //"src/test/java/Features/1_materialManagementCustomer.feature",
        //src/test/java/Features/workroomlogin.feature
        glue = {"stepDefinations", "hooks"},
//       dryRun = true,
       dryRun = false,
        // tags ="@sanity or @regression", // Ensure correct tag syntax,
        // tags= "@sanity",  // this will execute only sanity
        //tags= "@regression"  // this will execute only sanity
        //tags="@sanity and @regression" // Executes scenarios with both @sanity and @regression
        //tags="@sanity or @regression"   //Executess sceanrio either sanity or regression//tags="@sanity and not @regression"  // Executes scenarios with @sanity but not @regression
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html", // HTML Report
                "json:target/cucumber-reports/cucumber.json", // JSON Report
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", // Extent Reports
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",  // <-- updated plugin name
        },
        monochrome = true

)
public class TestRun {
}
