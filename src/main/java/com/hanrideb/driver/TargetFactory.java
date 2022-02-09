package com.hanrideb.driver;

import com.hanrideb.exceptions.TargetNotValidException;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.hanrideb.config.ConfigurationManager.configuration;

public class TargetFactory {

    public WebDriver createInstance(String browser){
        Target target = Target.valueOf(configuration().target().toUpperCase());
        WebDriver webDriver;

        switch (target){
            case LOCAL:
                webDriver = BrowserFactory.valueOf(browser.toUpperCase()).createDriver();
                break;
            case REMOTE:
                webDriver = createRemoteInstance(BrowserFactory.valueOf(browser.toUpperCase()).getOptions());
                break;
            default:
                throw new TargetNotValidException(target.toString());
        }
        return  webDriver;
    }

    private RemoteWebDriver createRemoteInstance(MutableCapabilities capability){
        RemoteWebDriver remoteWebDriver = null;
        try{
            String gridURL   = String.format("http://%s:%s",configuration().gridUrl(),configuration().gridPort());
            remoteWebDriver = new RemoteWebDriver(new URL(gridURL),capability);
        } catch (MalformedURLException e) {
            System.out.println("Grid URL is invalid or Grid is not available");
            System.out.println(String.format("browser: %s",capability.getBrowserName()) + e);
        }catch (IllegalArgumentException e){
            System.out.println(String.format("Browser %s is not valid or recognized", capability.getBrowserName()) + e);
        }

        return remoteWebDriver;
    }

    enum Target{
        LOCAL, REMOTE
    }
}
