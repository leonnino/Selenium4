package handlingWindows;

import base.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

public class New_Tabs extends Hooks {

    @Test
     public void newTab() throws InterruptedException {
        driver.get("http://www.webdriveruniversity.com/");
        String orginalWindow = driver.getWindowHandle(); //id of orginal tab


        //Nowa metoda przelaczania okien dla selenium 4
        driver.switchTo().newWindow(WindowType.TAB);
        String newWindow = driver.getWindowHandle();

        driver.get("http://www.google.pl/");
        System.out.println("orginal id: " + orginalWindow) ;
        System.out.println("new id: " + newWindow) ;
        driver.close();
        Thread.sleep( 0);

        driver.switchTo().window(orginalWindow);
        WebElement loginPortal_Button = driver.findElement(By.id("login-portal"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(loginPortal_Button)).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        // on sie dalej dla driver.title() odwoluje do pierwszego taba, to zeby zmienic:

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        System.out.println("Title: " + driver.getTitle());

        wait.until(ExpectedConditions.titleIs("WebDriver | Login Portal"));

        //Switch to first orginal tab, then close the most recent tab
       driver.switchTo().window(orginalWindow);

       //switch and close most recent tab
       driver.switchTo().window(tabs.get(tabs.size() - 1));
       driver.close();

       //driver.switchTo().defaultContent(); // to nie zadziala, trzeba przelaczyc recznie na orginal
       driver.switchTo().window(orginalWindow);
       System.out.println("Orginal Tab Title: "+ driver.getTitle());



    }
}
