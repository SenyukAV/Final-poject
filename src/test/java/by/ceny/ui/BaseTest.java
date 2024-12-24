package by.ceny.ui;

import by.ceny.ui.driver.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    @BeforeEach
    public void setUp() {
        WebDriver driver = Driver.getWebDriver();
        driver.get("https://ceny.by/user/login");
    }

    @AfterEach
    public void toQuit() {
        Driver.quit();
    }
}
