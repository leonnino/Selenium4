package base.browserOptions;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

public class Firefox_Options {
    //ten main daje mozliwosc wykonania kodu wewnatrz main zielona strzalka
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver",
                System.getProperty("user.dir") + "/src/main/java/drivers/geckodriver.exe");

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        firefoxOptions.addArguments("--width=1920");
        firefoxOptions.addArguments("--height=720");

        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.webdriveruniversity.com");
        driver.manage().window().maximize();
        driver.quit();
    }
}
