package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import base.BaseTest;
import utils.DriverFactory;
import utils.ReportManager;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        ReportManager.logInfo("Opening SauceDemo website");
        DriverFactory.getDriver().get("https://www.saucedemo.com");

        ReportManager.logInfo("Entering username");
        DriverFactory.getDriver().findElement(By.id("user-name")).sendKeys("standard_user");

        ReportManager.logInfo("Entering password");
        DriverFactory.getDriver().findElement(By.id("password")).sendKeys("secret_sauce");

        ReportManager.logInfo("Clicking login button");
        DriverFactory.getDriver().findElement(By.id("login-button")).click();

        ReportManager.logPass("Login successful");
    }
}