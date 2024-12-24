package by.ceny.ui;

import by.ceny.ui.pages.SiteMessage;
import by.ceny.ui.pages.SiteXpath;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SiteTest {

    @Test
    void test1() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://ceny.by/user/login");

        driver.findElement(By.xpath(SiteXpath.BUTTON_AUTH_XPATH)).click();

    }
    @Test
    void test2() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ceny.by/user/login");
        driver.findElement(By.xpath(SiteXpath.INPUT_LOGIN_XPATH)).sendKeys("aaa@gmail.com");

        driver.findElement(By.xpath(SiteXpath.BUTTON_AUTH_XPATH)).click();
        driver.findElement(By.xpath(SiteXpath.ERROR_MESSAGE_XPATH)).getText();
        Assertions.assertEquals(driver.findElement(By.xpath(SiteXpath.ERROR_MESSAGE_XPATH)).getText(), SiteMessage.NO_DATA);


    }
    @Test
    public  void Test3 () {

          //  System.setProperty("webdriver.chrome.driver", "C:\\bin\\chromedriver.exe");
           WebDriver driver = new ChromeDriver();
        driver.get("https://ceny.by/");



            JavascriptExecutor js = (JavascriptExecutor) driver;


            //blocking google ads
            js.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");

            //js.executeScript("window.scrollBy(0,350)");

        driver.findElement(By.xpath(SiteXpath.BUTTON_INPUT_XPATH)).click();

    }
}
