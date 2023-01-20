package base;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class Hooks {
    public WebDriver driver;

    @BeforeTest
    public void setup() throws IOException {
        Properties properties = new Properties();
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/properties/config.properties");
        properties.load(file);

        String browserType = properties.getProperty("browser").toLowerCase().trim();

        switch (browserType) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver",
                        System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver",
                        System.getProperty("user.dir") + "/src/main/java/drivers/geckodriver.exe");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "grid":
                ChromeOptions gridChromeOptions = new ChromeOptions();
                gridChromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                gridChromeOptions.addArguments("start-maximized");
                driver = new RemoteWebDriver(new URL("http://localhost:4444/"), gridChromeOptions);

        }
        driver.manage().window().maximize();

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
