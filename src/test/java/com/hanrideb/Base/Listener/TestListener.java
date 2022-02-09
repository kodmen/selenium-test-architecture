package com.hanrideb.Base.Listener;


import com.hanrideb.driver.DriverManager;
import com.hanrideb.driver.TargetFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


/**
 * konu hakkında link:https://www.guru99.com/listeners-selenium-webdriver.html
 */
public class TestListener implements ITestListener {

    @Override
    public void onFinish(ITestContext Result)
    {
        System.out.println("burası basladı");
    }

    @Override
    public void onStart(ITestContext Result)
    {
        System.out.println("onStrat listener ");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult Result)
    {

    }

    // When Test case get failed, this method is called.
    @Override
    public void onTestFailure(ITestResult Result)
    {

//        AllureManager.takeScreenshotToAttachOnAllureReport();
        System.out.println("The name of the testcase failed is :"+Result.getName());
    }

    // When Test case get Skipped, this method is called.
    @Override
    public void onTestSkipped(ITestResult Result)
    {
        System.out.println("The name of the testcase Skipped is :"+Result.getName());
    }

    // When Test case get Started, this method is called.
    @Override
    public void onTestStart(ITestResult Result)
    {

        Result.setTestName("firefox");

        System.out.println(Result.getName()+" test case started");
    }

    // When Test case get passed, this method is called.
    @Override
    public void onTestSuccess(ITestResult Result)
    {
        System.out.println("The name of the testcase passed is :"+Result.getName());
    }

}
