package pages;

import org.openqa.selenium.*;

public class OverviewPage {

    WebDriver driver;

    By finishBtn = By.id("finish");
    By successMsg = By.className("complete-header");

    public OverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFinish() {
        driver.findElement(finishBtn).click();
    }

    public boolean isOrderSuccessful() {
        return driver.findElement(successMsg).isDisplayed();
    }
}