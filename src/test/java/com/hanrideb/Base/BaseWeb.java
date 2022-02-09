package com.hanrideb.Base;

import com.hanrideb.Base.Listener.TestListener;
import com.hanrideb.driver.DriverManager;
import com.hanrideb.driver.TargetFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static com.hanrideb.config.ConfigurationManager.configuration;

@Listeners({TestListener.class})
public abstract class BaseWeb {

//    @BeforeSuite
//    public void beforeSuite(){
//        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),10);
////        wait.until(ExceptedConditions.elementToBeClickable(webElement)); // element clik olana kadar bekle
////        wait.until(ExceptedConditions.visibilitiyOf(webElement));// element yüklenene kadar bekle
//
//    }

//    @BeforeMethod(alwaysRun = true)
//    @Parameters("browser")
//    public void preCondition(@Optional("chrome") String browser){
//        WebDriver driver = new TargetFactory().createInstance(browser);
//        DriverManager.setDriver(driver);
//        DriverManager.getDriver().get(configuration().url());
//
//
//    }
//
//    @AfterMethod(alwaysRun = true)
//    public void postCondition(){
//        DriverManager.quit();
//    }
//

    public void getUrl(){
//        DriverManager.getDriver().get(configuration().url());
    }
}
