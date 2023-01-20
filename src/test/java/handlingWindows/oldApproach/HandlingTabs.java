package handlingWindows.oldApproach;

import base.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.security.Key;
import java.time.Duration;
import java.util.ArrayList;

public class HandlingTabs extends Hooks {

    @Test
    public void oldApproach_HandlingTabs() throws InterruptedException {
        driver.get("http://www.webdriveruniversity.com/Page-Object-Model/index.html");

        WebElement contactUsLink = new  WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.linkText("Contact Us")));

        //otwiera nowy tab ale zostaje na starym
        contactUsLink.sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));
        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));

        Thread.sleep(1000 );
        driver.close();
        Thread.sleep(1000);
        driver.switchTo().window(tabs.get(0));

        ((JavascriptExecutor) driver ).executeScript("window.open()");
        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        driver.get("http://www.webdriveruniversity.com/");
        Thread.sleep(1000);

    }

}
