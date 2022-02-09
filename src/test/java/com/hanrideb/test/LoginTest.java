package com.hanrideb.test;

import com.hanrideb.Base.BaseWeb;
import com.hanrideb.driver.DriverManager;
import com.hanrideb.page.Login.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseWeb {

    @DataProvider
    public Object[][] userInfo(){
        Object[][] user = new Object[2][2];

        user[0][0]="standard_user";
        user[0][1]="secret_sauce";

        user[1][0]="problem_user";
        user[1][1]="secret_sauce";

        return user;
    }

    @Test(dataProvider = "userInfo")
    public void login(String u, String p){
        LoginPage loginPage = new LoginPage();

        loginPage.fillUserName(u);
        loginPage.fillPassword(p);
        loginPage.clickButton();

        String url = "https://www.saucedemo.com/inventory.html";

        Assert.assertEquals(DriverManager.getDriver().getCurrentUrl(),url,"girilen url doğu değil");
    }

    @Test(enabled = false,priority = 200)
    public void login2(String u, String p){
        LoginPage loginPage = new LoginPage();

        loginPage.fillUserName(u);
        loginPage.fillPassword(p);
        loginPage.clickButton();

        String url = "https://www.saucedemo.com/inventory.html";

        Assert.assertEquals(DriverManager.getDriver().getCurrentUrl(),url,"girilen url doğu değil");
    }




}
