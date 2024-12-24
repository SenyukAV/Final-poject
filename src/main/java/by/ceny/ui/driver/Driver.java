package by.ceny.ui.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {
    private static WebDriver webDriver;

    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            webDriver = new ChromeDriver();

        }
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        webDriver.manage().window().maximize();

        return webDriver;
    }

    public static void quit() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
