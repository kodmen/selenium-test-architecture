package com.hanrideb.Steps;

import com.google.common.io.Files;
import com.hanrideb.Base.BaseWeb;
import com.hanrideb.driver.DriverManager;
import com.hanrideb.driver.TargetFactory;
import com.hanrideb.page.Login.LoginPage;


import com.vimalselvam.cucumber.listener.Reporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import com.cucumber.listener.Reporter;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import static com.hanrideb.config.ConfigurationManager.configuration;

public class LoginSteps extends BaseWeb {

    private LoginPage loginPage ;
    WebDriver driver;

    @Before
    public void before(Scenario scenario){
//        driver = new TargetFactory().createInstance("chrome");
//        DriverManager.setDriver(driver);

        driver = DriverManager.getDriver();
        loginPage = new LoginPage();

    }

    @Given("^siteye git$")
    public void siteye_git() throws Throwable {


        DriverManager.getDriver().get(configuration().url());
    }

    @And("^username doldur \"([^\"]*)\"$")
    public void usernameDoldur(String u) throws Throwable {
        loginPage.fillUserName(u);
    }

    @And("^password doldur \"([^\"]*)\"$")
    public void passwordDoldur(String s) throws Throwable {
        loginPage.fillPassword(s);
    }

    @When("^submit buttonuna tıkla$")
    public void submit_buttonuna_tıkla() throws Throwable {
        loginPage.clickButton();

    }

    @Then("^Url verfy et$")
    public void url_verfy_et() throws Throwable {

        String url = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(DriverManager.getDriver().getCurrentUrl(),url,"girilen url doğu değil");
        //Assert.fail();
     }


    @After
    public void af(Scenario scenario) throws InterruptedException, IOException, IllegalMonitorStateException
    {

        if(scenario.isFailed())
        {

            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
            scenario.attach(fileContent, "image/png", "screenshot");
            //scenario.attach();
         //   scenario.attach(DriverManager.getByteScreenshot(), "image/png", "screenshot name");
//            String screenshotName = scenario.getName().replaceAll(" ", "_");
//            File sourcePath = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
//
//            //Building up the destination path for the screenshot to save
//            //Also make sure to create a folder 'screenshots' with in the cucumber-report folder
//            File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber/" + screenshotName + ".png");
//
//            //Copy taken screenshot from source location to destination location
//            Files.copy(sourcePath, destinationPath);
//
//            Reporter.addScreenCaptureFromPath(destinationPath.toString());

            //Allure.addAttachment("Any text", new ByteArrayInputStream(((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES)));
        }

        DriverManager.quit();
    }


}
