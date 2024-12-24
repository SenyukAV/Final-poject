package by.ceny.ui.utils;

import by.ceny.ui.domain.SiteData;
import by.ceny.ui.driver.Driver;
import by.ceny.ui.pages.SiteXpath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils {
    private WebDriver webDriver;

    public Utils() {
        webDriver = Driver.getWebDriver();
    }

    public void fillLogin() {
        webDriver.findElement(By.xpath(SiteXpath.INPUT_LOGIN_XPATH)).sendKeys(new SiteData().getEmailData().getEmail());
    }

    public void fillPassword() {
        webDriver.findElement(By.xpath(SiteXpath.INPUT_PASSWORD_XPATH)).sendKeys(new SiteData().getPasswordlData().getPassword());
    }

    public String getErrorMessage() {
        return webDriver.findElement(By.xpath(SiteXpath.ERROR_MESSAGE_XPATH)).getText();
    }

    public void clickEnter() {
        webDriver.findElement(By.xpath(SiteXpath.BUTTON_AUTH_XPATH)).click();
    }
}
