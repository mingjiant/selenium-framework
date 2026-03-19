package tests;

import base.BaseTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.DriverFactory;
import utils.ReportManager;

public class PurchaseTest extends BaseTest {

    @Test
    public void completePurchaseFlow() {

        ReportManager.logInfo("Opening SauceDemo website");
        DriverFactory.getDriver().get("https://www.saucedemo.com");

        ReportManager.logInfo("Entering username");
        DriverFactory.getDriver().findElement(By.id("user-name")).sendKeys("standard_user");

        ReportManager.logInfo("Entering password");
        DriverFactory.getDriver().findElement(By.id("password")).sendKeys("secret_sauce");

        ReportManager.logInfo("Clicking login button");
        DriverFactory.getDriver().findElement(By.id("login-button")).click();

        // Add item
        ProductPage inventory = new ProductPage(DriverFactory.getDriver());
        ReportManager.logInfo("Adding item to cart");
        inventory.addItemToCart();
        ReportManager.logInfo("Navigating to cart");
        inventory.goToCart();

        // Cart
        CartPage cart = new CartPage(DriverFactory.getDriver());
        ReportManager.logInfo("Clicking on checkout");
        cart.clickCheckout();

        // Checkout info
        CheckoutPage checkout = new CheckoutPage(DriverFactory.getDriver());
        ReportManager.logInfo("Entering details");
        checkout.enterCheckoutDetails("John", "Doe", "57000");
        checkout.clickContinue();

        // Overview
        OverviewPage overview = new OverviewPage(DriverFactory.getDriver());
        overview.clickFinish();

        // Assertion
        Assert.assertTrue(overview.isOrderSuccessful());
        ReportManager.logPass("Order successful");

    }
}