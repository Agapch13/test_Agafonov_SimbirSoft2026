package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class TestBase {

    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver()
                .setup();
        driver = new ChromeDriver();
        driver.manage()
                .window()
                .maximize();
        driver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(20));
        driver.manage()
                .timeouts()
                .pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage()
                .timeouts()
                .scriptTimeout(Duration.ofSeconds(20));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
