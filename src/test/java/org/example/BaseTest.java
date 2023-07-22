package org.example;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseTest {

    public static WebDriver driver;

    @BeforeScenario
    public void setUp() {
        String Browser = "https://www.avansas.com";
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(Browser);
        driver.manage().window().maximize();
    }

    @AfterScenario
    public void tearDown() {
        driver.quit();
    }
}