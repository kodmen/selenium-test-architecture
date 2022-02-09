package com.hanrideb.page.Login;

import com.hanrideb.page.AbstractPageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;

public class LoginPage extends AbstractPageObject {

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement pass;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public void fillUserName(String user){
        userName.sendKeys(user);
    }

    public void fillPassword(String password){
        pass.sendKeys(password);
    }


    public void clickButton(){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        loginButton.click();
    }
}
