package com.hanrideb.Runner;




import com.hanrideb.driver.DriverManager;
import com.hanrideb.driver.TargetFactory;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import static com.hanrideb.config.ConfigurationManager.configuration;

@Test
@CucumberOptions(
        features = {"src/test/java/com/hanrideb/Feature"},
        glue = {"com.hanrideb.Steps","com.hanrideb.Base"},
        dryRun = false,
        plugin = {
                "pretty",
//                default html report cucumber
                "html:target/cucumber/myhtmlreport.html",
//                default report comes from cucumber
//                Json report must needed for developer and JVM Report
                "json:target/cucumber/myjsonreport.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
        //, tags = "@bing"
)
public class Runner extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public static void beforeClass(@Optional("chrome")String browser)
    {
//        AllureManager.setAllureEnvironmentInformation();
        WebDriver driver = new TargetFactory().createInstance(browser);
        DriverManager.setDriver(driver);
    }

//    @AfterClass
//    public static void writeExtentReport() {
//        Reporter.loadXMLConfig(new File(configuration().reportConfigPath()));
//    }


}
