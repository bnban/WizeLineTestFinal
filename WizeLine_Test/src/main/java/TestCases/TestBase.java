package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver = null;

    @BeforeTest
    public void initialize() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver = new ChromeDriver();

        // To maximize browser
        driver.manage().window().maximize();

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(
                10, TimeUnit.SECONDS);

        // To open Gmail site
        driver.get("https://www.utest.com/signup/personal");

        Thread.sleep(5000);
    }

    @AfterTest
    // Test cleanup
    public void TeardownTest() {
        driver.quit();
    }
}
