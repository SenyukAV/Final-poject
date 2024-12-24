package by.ceny.ui;

import by.ceny.ui.domain.SiteData;
import by.ceny.ui.driver.Driver;
import by.ceny.ui.pages.SiteMessage;
import by.ceny.ui.pages.SiteXpath;
import by.ceny.ui.utils.Utils;
import jdk.jfr.Description;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SiteTest extends BaseTest {
    private static final Logger logger = (Logger) LogManager.getLogger(SiteTest.class);

    @Test
    @DisplayName("NO DATA")
    @Description("Don't input data")
    void test1() {
        logger.info("App test1 log message." );
        Utils utils=new Utils();
        utils.clickEnter();
        Assertions.assertEquals( SiteMessage.WRONG_FORMAT_EMAIL, utils.getErrorMessage());
    }

    @Test
    @DisplayName("NO PASSWORD")
    @Description("Don't input password")
    void test2() {
        logger.info("App test2 log message." );
        Utils utils=new Utils();
        utils.fillLogin();
        utils.clickEnter();
        Assertions.assertEquals( SiteMessage.NO_DATA, utils.getErrorMessage());
    }

    @Test
    @DisplayName("NO EMAIL")
    @Description("Don't input email")
    public  void Test3 () {
        logger.info("App test3 log message." );
        Utils utils=new Utils();
        utils.fillPassword();
        utils.clickEnter();
        Assertions.assertEquals( SiteMessage.WRONG_FORMAT_EMAIL, utils.getErrorMessage());
    }

    @Test
    @DisplayName("UNREGISTERED USER")
    @Description("Input email and password, but user unregister")
    public  void Test4 () {

        WebDriver driver= Driver.getWebDriver();
        driver.get("https://ceny.by/user/login");
        driver.findElement(By.xpath(SiteXpath.INPUT_PASSWORD_XPATH)).sendKeys(new SiteData().getPasswordlData().getPassword());
        driver.findElement(By.xpath(SiteXpath.INPUT_LOGIN_XPATH)).sendKeys(new SiteData().getEmailData().getEmail());
        driver.findElement(By.xpath(SiteXpath.BUTTON_AUTH_XPATH)).click();
       //System.out.println( driver.findElement(By.xpath(SiteXpath.ERROR_MESSAGE_XPATH));


    }

    @Test
    @DisplayName("UNREGISTERED USER")
    @Description("Input email and password, but user unregister")
    public  void Test5() {
        Utils utils=new Utils();
        utils.fillPassword();
        utils.fillLogin();
        utils.clickEnter();
        System.out.println(utils.getErrorMessage());
        //Assertions.assertEquals( SiteMessage.WRONG_FORMAT_EMAIL, utils.getErrorMessage());
    }

}
